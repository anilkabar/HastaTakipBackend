package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.MeetingDto;
import com.hastatakip.services.IMeetingService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/Meeting")
public class MeetingRestController {

    @Autowired
    IMeetingService meetingService;


    @PostMapping("/save")
    public ResponseEntity<Result> save(@RequestBody MeetingDto meetingDto){
        return ResponseEntity.ok(meetingService.save(meetingDto));

    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(meetingService.getAll());
    }

}
