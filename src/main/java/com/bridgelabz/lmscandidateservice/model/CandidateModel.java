package com.bridgelabz.lmscandidateservice.model;

import com.bridgelabz.lmscandidateservice.dto.CandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "candidates")
@Data
public class CandidateModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNum;
    private String hiredDate;
    private String degree;
    private Double aggregatePercentage;
    private String city;
    private String state;
    private String preferredJobLocation;
    private String status;
    private String passedOutYear;
    private String candidateStatus;
    private LocalDate registerDate;
    private LocalDate updatedDate;
    private  long techStackId;

    public CandidateModel() {
    }

    public CandidateModel(CandidateDTO candidateDTO) {
        this.cicId = candidateDTO.getCicId();
        this.fullName = candidateDTO.getFullName();
        this.email = candidateDTO.getEmail();
        this.mobileNum = candidateDTO.getMobileNum();
        this.hiredDate = candidateDTO.getHiredDate();
        this.degree = candidateDTO.getDegree();
        this.aggregatePercentage = candidateDTO.getAggregatePercentage();
        this.city = candidateDTO.getCity();
        this.state = candidateDTO.getState();
        this.preferredJobLocation = candidateDTO.getPreferredJobLocation();
        this.status = candidateDTO.getStatus();
        this.passedOutYear = candidateDTO.getPassedOutYear();
        this.candidateStatus = candidateDTO.getCandidateStatus();
    }
}

