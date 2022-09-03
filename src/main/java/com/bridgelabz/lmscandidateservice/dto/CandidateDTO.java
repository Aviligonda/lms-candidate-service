package com.bridgelabz.lmscandidateservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CandidateDTO {
    @NotNull(message = "cicId can't be empty")
    private String cicId;
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid fullName")
    private String fullName;
    @Pattern(regexp = "(\\w+[.+-]?)*@\\w+(\\.+[a-zA-Z]{2,4})*", message = "Invalid Email, Enter correct Email")
    private String email;
    @Pattern(regexp = "[6789][0-9]{9}", message = "Invalid mobile number")
    private String mobileNum;
    @JsonFormat(pattern = "dd/mm/yyyy")
    @NotNull(message = "hiredDate can't be null")
    private String hiredDate;
    @NotNull(message = "Degree can't be null")
    private String degree;
    @NotNull(message = "percentage can't be empty")
    private Double aggregatePercentage;
    @NotNull(message = "city can't be empty")
    private String city;
    @NotNull(message = "state can't be empty")
    private String state;
    @NotNull(message = "preferredJobLocation can't be empty")
    private String preferredJobLocation;
    @NotNull(message = "passedOutYear can't be empty")
    private String passedOutYear;
    @NotNull(message = "candidateStatus can't be empty")
    private String candidateStatus;
    @NotNull(message = "Status can't be empty")
    private String status;

}

