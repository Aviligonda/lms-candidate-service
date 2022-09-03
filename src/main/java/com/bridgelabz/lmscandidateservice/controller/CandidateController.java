package com.bridgelabz.lmscandidateservice.controller;

import com.bridgelabz.lmscandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidateservice.model.CandidateModel;
import com.bridgelabz.lmscandidateservice.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    ICandidateService candidateService;

    /*
     * Purpose : Create Candidate Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token,techStackId and candidateDTO
     * */
    @PostMapping("/addCandidate")
    public CandidateModel addCandidate(@Valid @RequestBody CandidateDTO candidateDTO,
                                       @RequestParam Long techStackId) {
        return candidateService.addCandidate(candidateDTO, techStackId);
    }

    /*z
     * Purpose : Retrieve all Candidates Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token
     * */
    @GetMapping("/getAllCandidates")
    public List<CandidateModel> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    /*
     * Purpose : Update Existing Candidate Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token,candidateDTO,id and techStackId
     * */
    @PutMapping("/updateCandidateDetails/{id}")
    public CandidateModel updateCandidateDetails(@Valid @RequestBody CandidateDTO candidateDTO,
                                                 @PathVariable Long id,
                                                 @RequestParam Long techStackId) {
        return candidateService.updateCandidateDetails(candidateDTO, id, techStackId);
    }

    /*
     * Purpose : Delete Existing Candidate Details
     * @author : Aviligonda Sreenivasulu
     * @Param : token and id
     * */
    @DeleteMapping("/deleteCandidateDetails/{id}")
    public CandidateModel deleteCandidate(@PathVariable Long id) {
        return candidateService.deleteCandidate(id);
    }

    /*
     * Purpose : Retrieve the Candidate By Status
     * @author : Aviligonda Sreenivasulu
     * @Param :  token and status
     * */
    @GetMapping("/getCandidatesByStatus")
    public List<CandidateModel> getCandidatesByStatus(@RequestParam String status) {
        return candidateService.getCandidatesByStatus(status);
    }

    /*
     * Purpose : Chane the Candidate Status
     * @author : Aviligonda Sreenivasulu
     * @Param :  id,token and status
     * */
    @PutMapping("/changeCandidateStatus/{id}")
    public CandidateModel changeCandidateStatus(@PathVariable Long id,
                                                @RequestParam String status) {
        return candidateService.changeStatus(id, status);
    }

    /*
     * Purpose : Retrieve the Count By Candidate Status
     * @author : Aviligonda Sreenivasulu
     * @Param :  token and status
     * */
    @GetMapping("/getCountByStatus")
    public Long getCountByStatus(@RequestParam String status) {
        return candidateService.getCountByStatus(status);
    }


}

