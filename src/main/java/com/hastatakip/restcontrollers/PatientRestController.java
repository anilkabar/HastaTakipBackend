package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.services.IPatientNoteService;
import com.hastatakip.services.IPatientService;
import com.hastatakip.utils.Result;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.constraints.Positive;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Patient")
public class PatientRestController {

    //dosya yükleme işlemi için gerekli olmazsa olmaz
    @Autowired
    ServletContext servletContext;

    final IPatientService patientService;
     final IPatientNoteService patientNoteService;

    public PatientRestController(IPatientService patientService, IPatientNoteService patientNoteService) {
        this.patientService = patientService;
        this.patientNoteService = patientNoteService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Result> save(@RequestPart(required = true) PatientDto patientDto,@RequestParam("file") MultipartFile file) throws IOException{
        System.out.println("Dosya İsmi"+file.getOriginalFilename());
        return ResponseEntity.ok(patientService.saveUpload(patientDto,file));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("getAllById/{name}")
    public ResponseEntity<Result> getAllById(@PathVariable String name){
        return ResponseEntity.ok(patientService.getAllById(name));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Result> getById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(patientService.getById(id));
    }

    @PostMapping(value = "upload")
    @ResponseBody
    public ResponseEntity<String> upload(@RequestPart("formParams") MultipartFile file, @RequestPart(required = false) PatientDto patientDto) throws IOException{
        /*
        System.out.println(patientDto);
        Path uploadDirectory= Paths.get("assets/images/");
        try{
            InputStream inputStream=file.getInputStream();
            Path filePath=uploadDirectory.resolve(file.getOriginalFilename());
            Files.copy(inputStream,filePath,REPLACE_EXISTING);
        }
        catch (Exception e){
            System.out.println(e);

        }
        return ResponseEntity.ok("başarılı");

         */
        boolean isExit=new File(servletContext.getRealPath("/images/")).exists();
        if (!isExit){
            new File(servletContext.getRealPath("/images/")).mkdir();
        }
        String fileName=file.getOriginalFilename();
        String newFileName= FilenameUtils.getBaseName(fileName)+"."+FilenameUtils.getExtension(fileName);
        File serverFile=new File(servletContext.getRealPath("/images/")+File.separator+newFileName);
        FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        System.out.println(serverFile.getName());
       return null;
    }

    /*
    @GetMapping("/getimage")
    public ResponseEntity<List<String>> getimage(){

        List<String> images=new ArrayList<>();
        String filesPath=servletContext.getRealPath("/images/");
        //System.out.println(filesPath);
        File fileFolder=new File(filesPath);
        System.out.println(fileFolder+"/resim.jpeg");
        if (fileFolder!=null){
            for (File file:fileFolder.listFiles()){
                if (!file.isDirectory()){
                    String encodeBase64=null;
                    try{
                        String extension=FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream=new FileInputStream(file);
                        byte[] bytes=new byte[(int)file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64= Base64.getEncoder().encodeToString(bytes);
                        images.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();
                    }
                    catch (Exception e){

                    }
                }
            }
        }

        return new ResponseEntity<List<String>>(images,HttpStatus.OK);

    }
    }
 */

}






