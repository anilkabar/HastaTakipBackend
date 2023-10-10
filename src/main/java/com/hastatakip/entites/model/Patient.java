package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hastatakip.utils.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Base {


    private String identificationNumber;
    private String name;
    private String surname;

    @Column(name = "dateofBirth")
    @CreatedDate
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date dateofBirth;
    private String phone;
    private String email;
    private String adress;
    private String imagePath;
    //cinsiyet
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    List<PatientDocument> documentList;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    List<PatientNote> patientNote;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    List<PatientExamination> examinations;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    List<StockPayment> stockPaymentList;


    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    @JsonIgnore
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "district_id",referencedColumnName = "id")
    @JsonIgnore
    private District district;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    List<StockSale> stockSaleList;




}
