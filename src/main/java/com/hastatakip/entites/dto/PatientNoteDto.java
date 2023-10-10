package com.hastatakip.entites.dto;
import com.hastatakip.entites.model.Patient;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class PatientNoteDto extends BaseDto implements IDto {

    String content;
    PatientDto patientDto;
}
