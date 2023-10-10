package com.hastatakip.restcontrollers;


import com.hastatakip.services.IUserService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserRestController {

    @Autowired
    private IUserService userService;


    @GetMapping("userCompanyGetAll/{id}")
    public ResponseEntity<Result> userCompanyGetAll(@PathVariable Long id){
        return ResponseEntity.ok(userService.userCompanyGetAll(id));
    }

}
