package com.hastatakip.services.imp;


import com.hastatakip.entites.dto.MeetingDto;
import com.hastatakip.entites.mappers.impl.MeetingMapperImpl;
import com.hastatakip.entites.model.Meeting;
import com.hastatakip.repositories.IMeetingRepository;
import com.hastatakip.services.IMeetingService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeetingServiceImpl implements IMeetingService {

    @Autowired
    MeetingMapperImpl meetingMapper;

    @Autowired
    IMeetingRepository meetingRepository;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @Override
    public Result<MeetingDto> save(MeetingDto meetingDto) {
        Date date =new Date();
        Meeting meeting=meetingMapper.meetingDtoToMeeting(meetingDto);
        meeting.setDate(date);
        meetingRepository.save(meeting);
        return new Result<>(true,messageSourceAccessor.getMessage("result.saveSuccess"));
    }

    @Override
    public Result<MeetingDto> update(MeetingDto meetingDto) {
        return null;
    }

    @Override
    public Result<MeetingDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<MeetingDto>> getAll() {
        List<Meeting> meetingList=meetingRepository.findAll();
        List<MeetingDto> meetingDtoList=meetingMapper.listMeetingToMeetingDto(meetingList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),meetingDtoList);
    }

    @Override
    public Result<MeetingDto> deleteById(Long id) {
        return null;
    }
}
