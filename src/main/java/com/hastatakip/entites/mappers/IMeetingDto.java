package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.MeetingDto;
import com.hastatakip.entites.model.Meeting;

import java.util.List;

public interface IMeetingDto {
    MeetingDto meetingToMeetingDto(Meeting meeting);
    Meeting meetingDtoToMeeting(MeetingDto meetingDto);
    List<Meeting> listMeetingDtoToMeeting(List<MeetingDto> meetingDtoList);
    List<MeetingDto> listMeetingToMeetingDto(List<Meeting> meetingList);

}
