package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.UserAuthorityDto;
import com.hastatakip.services.imp.UserAuthorityServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/UserAuthority")
@CrossOrigin
public class UserAuthorityRestController {
    @Autowired
    UserAuthorityServiceImpl authorityService;

    @GetMapping("/getAllUserId/{id}")
    public ResponseEntity<Result> getAllUserId(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(authorityService.getAllByUserId(id));
    }

    @PostMapping("/saveAndFlush")
    public ResponseEntity<Result> saveAndFlush(@RequestBody List<UserAuthorityDto> userAuthorityDtoList){
        return ResponseEntity.ok(authorityService.saveAndFlush(userAuthorityDtoList));

    }

}
