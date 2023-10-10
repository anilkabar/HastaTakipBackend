package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.UserDetailDto;
import com.hastatakip.services.imp.UserDetailServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserDetail")
@CrossOrigin
public class UserDetailRestController {
    @Autowired
    private UserDetailServiceImpl userDetailService;

     @GetMapping("userCompanyGetAll/{id}")
    public ResponseEntity<Result> userCompanyIdGetAll(@PathVariable Long id){
         return ResponseEntity.ok(userDetailService.userGetAllCompanyId(id));
     }

     @PostMapping("userisActiveUpdate")
    public ResponseEntity<Result> userisActiveUpdate(@RequestBody UserDetailDto userDetailDto){
         return ResponseEntity.ok(userDetailService.update(userDetailDto));
     }

}
