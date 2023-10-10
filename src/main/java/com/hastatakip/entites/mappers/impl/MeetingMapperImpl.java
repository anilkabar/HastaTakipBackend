package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.MeetingDto;
import com.hastatakip.entites.mappers.IMeetingDto;
import com.hastatakip.entites.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeetingMapperImpl implements IMeetingDto {

    @Autowired
    DoctorMapperImpl doctorMapper;

    @Override
    public MeetingDto meetingToMeetingDto(Meeting meeting) {

        if (meeting==null){
            return null;
        }

        MeetingDto meetingDto=new MeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setDate(meeting.getDate());
        meetingDto.setName(meeting.getName());
        meetingDto.setSurname(meeting.getSurname());
        meetingDto.setMeetingDate(meeting.getMeetingDate());
        meetingDto.setInformation(meeting.getInformation());
        meetingDto.setDoctorDto(doctorMapper.doctorToDoctorDto(meeting.getDoctor()));
        return meetingDto;
    }

    @Override
    public Meeting meetingDtoToMeeting(MeetingDto meetingDto) {
        if (meetingDto==null){
            return null;
        }
        Meeting meeting=new Meeting();
        meeting.setId(meetingDto.getId());
        meeting.setDate(meetingDto.getDate());
        meeting.setName(meetingDto.getName());
        meeting.setSurname(meetingDto.getSurname());
        meeting.setMeetingDate(meetingDto.getMeetingDate());
        meeting.setInformation(meetingDto.getInformation());
        meeting.setDoctor(doctorMapper.doctorDtoTodoctor(meetingDto.getDoctorDto()));
        return meeting;
    }

    @Override
    public List<Meeting> listMeetingDtoToMeeting(List<MeetingDto> meetingDtoList) {
        List<Meeting> meetingList=new ArrayList<>(meetingDtoList.size());
        meetingDtoList.forEach(item->{
            Meeting meeting=meetingDtoToMeeting(item);
            meetingList.add(meeting);
        });
        return meetingList;
    }

    @Override
    public List<MeetingDto> listMeetingToMeetingDto(List<Meeting> meetingList) {
        List<MeetingDto> meetingDtoList=new ArrayList<>(meetingList.size());
        meetingList.forEach(item->{
            MeetingDto meetingDto=meetingToMeetingDto(item);
            meetingDtoList.add(meetingDto);
        });
        return meetingDtoList;
    }
}
