package com.hastatakip.entites.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MeetingDto extends BaseDto implements IDto {
    String name;
    String surname;
    Date meetingDate;
    String information;
    DoctorDto doctorDto;

}
