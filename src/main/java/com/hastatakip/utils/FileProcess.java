package com.hastatakip.utils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;


public class FileProcess {

    public String fileGet(String fileName, String folderName, ServletContext servletContext)  {
        String img=null;
        System.out.println(folderName);
        String filesPath=servletContext.getRealPath("/"+folderName+"/");
        //System.out.println(filesPath);
        File fileFolder=new File(filesPath+"/"+fileName);
        if (fileFolder!=null){
            if (!fileFolder.isDirectory()){
                String encodeBase64=null;
                try{
                    String extension= FilenameUtils.getExtension(fileFolder.getName());
                    FileInputStream fileInputStream=new FileInputStream(fileFolder);
                    byte[] bytes=new byte[(int)fileFolder.length()];
                    fileInputStream.read(bytes);
                    encodeBase64= Base64.getEncoder().encodeToString(bytes);
                    img="data:image/"+extension+";base64,"+encodeBase64;
                    fileInputStream.close();

                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        return img;
    }





}
