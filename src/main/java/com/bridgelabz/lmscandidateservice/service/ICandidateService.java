package com.bridgelabz.lmscandidateservice.service;

import com.bridgelabz.lmscandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidateservice.model.CandidateModel;

import java.util.List;

public interface ICandidateService {
    CandidateModel addCandidate(CandidateDTO candidateDTO, Long techStackId);

    List<CandidateModel> getAllCandidates();

    CandidateModel updateCandidateDetails(CandidateDTO candidateDTO, Long id, Long techStackId);

    CandidateModel deleteCandidate(Long id);

    List<CandidateModel> getCandidatesByStatus(String status);

    CandidateModel changeStatus(Long id, String token);

    Long getCountByStatus(String token);


}

