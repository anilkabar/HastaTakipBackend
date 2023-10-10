package com.hastatakip.restcontrollers;


import com.hastatakip.services.IPageAdminService;
import com.hastatakip.services.imp.PageAdminServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/PageAdmin")
public class PageAdminRestController  {

    @Autowired
    PageAdminServiceImpl pageAdminService;

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(pageAdminService.getAll());
    }

}
