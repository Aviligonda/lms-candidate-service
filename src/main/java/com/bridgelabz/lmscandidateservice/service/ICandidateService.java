package com.bridgelabz.lmscandidateservice.service;

import com.bridgelabz.lmscandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidateservice.model.CandidateModel;
import com.bridgelabz.lmscandidateservice.util.Response;

import java.util.List;

public interface ICandidateService {
    Response addCandidate(String token, CandidateDTO candidateDTO, Long techStackId);

    List<CandidateModel> getAllCandidates(String token);

    Response updateCandidateDetails(String token, CandidateDTO candidateDTO, Long id, Long techStackId);

    Response deleteCandidate(String token, Long id);

    List<CandidateModel> getCandidatesByStatus(String status, String s);

    Response changeStatus(String status, Long id, String token);

    Long getCountByStatus(String token, String status);


}

