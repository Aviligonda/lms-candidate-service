package com.bridgelabz.lmscandidateservice.service;

import com.bridgelabz.lmscandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidateservice.exception.LMSException;
import com.bridgelabz.lmscandidateservice.model.CandidateModel;
import com.bridgelabz.lmscandidateservice.repository.CandidateRepository;
import com.bridgelabz.lmscandidateservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    CandidateRepository candidateRepository;
//    @Autowired
//    AdminRepository adminRepository;
//    @Autowired
//    TechStackRepository techStackRepository;

    /*
     * Purpose : Implement the Logic of Creating Candidate Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token ,candidateDTO and techStackId
     * */
    @Override
    public CandidateModel addCandidate(CandidateDTO candidateDTO, Long techStackId) {
        CandidateModel candidateModel = new CandidateModel(candidateDTO);
        candidateModel.setRegisterDate(LocalDate.now());
        candidateRepository.save(candidateModel);
        String body = "Candidate Details Added With Id is : " + candidateModel.getId();
        String subject = "Candidate Registration Successfully ...";
        mailService.send(candidateModel.getEmail(), body, subject);
        return candidateModel;
    }

    /*
     * Purpose : Implement the Logic of Get All  Candidates Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token
     * */
    @Override
    public List<CandidateModel> getAllCandidates() {
        List<CandidateModel> isCandidates = candidateRepository.findAll();
        if (isCandidates.size() > 0) {
            return isCandidates;
        } else {
            throw new LMSException(400, "No candidates found");
        }
    }

    /*
     * Purpose : Implement the Logic of Update Candidate Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token and candidateDTO,id,techstackId
     * */
    @Override
    public CandidateModel updateCandidateDetails(CandidateDTO candidateDTO, Long id, Long techStackId) {
        Optional<CandidateModel> isCandidate = candidateRepository.findById(id);
        if (isCandidate.isPresent()) {
            isCandidate.get().setCicId(candidateDTO.getCicId());
            isCandidate.get().setFullName(candidateDTO.getFullName());
            isCandidate.get().setMobileNum(candidateDTO.getMobileNum());
            isCandidate.get().setCandidateStatus(candidateDTO.getCandidateStatus());
            isCandidate.get().setCity(candidateDTO.getCity());
            isCandidate.get().setEmail(candidateDTO.getEmail());
            isCandidate.get().setHiredDate(candidateDTO.getHiredDate());
            isCandidate.get().setDegree(candidateDTO.getDegree());
            isCandidate.get().setAggregatePercentage(candidateDTO.getAggregatePercentage());
            isCandidate.get().setState(candidateDTO.getState());
            isCandidate.get().setPassedOutYear(candidateDTO.getPassedOutYear());
            isCandidate.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
            isCandidate.get().setUpdatedDate(LocalDate.now());
            candidateRepository.save(isCandidate.get());
            String body = "Candidate Details Updated With Id is : " + isCandidate.get().getId();
            String subject = "Candidate Details Updated Successfully ...";
            mailService.send(isCandidate.get().getEmail(), body, subject);
            return isCandidate.get();
        } else {
            throw new LMSException(400, "No candidates found");
        }
    }

    /*
     * Purpose : Implement the Logic of Delete Candidate Details
     * @author : Aviligonda Sreenivasulu
     * @Param :  token and id
     * */
    @Override
    public CandidateModel deleteCandidate(Long id) {
            Optional<CandidateModel> isCandidate = candidateRepository.findById(id);
            if (isCandidate.isPresent()) {
                candidateRepository.delete(isCandidate.get());
                String body = "Admin Details Deleted With Id is : " + isCandidate.get().getId();
                String subject = "Admin Details Deleted Successfully ...";
                mailService.send(isCandidate.get().getEmail(), body, subject);
                return isCandidate.get();
            } else {
                throw new LMSException(400, "No candidates found");
            }
        }

    /*
     * Purpose : Implement the Logic of Get Candidate by Status
     * @author : Aviligonda Sreenivasulu
     * @Param :  token and status
     * */
    @Override
    public List<CandidateModel> getCandidatesByStatus(String status) {
            List<CandidateModel> isCandidate = candidateRepository.findAllByStatus(status);
            if (isCandidate.size() > 0) {
                return isCandidate;
            } else {
                throw new LMSException(400, "No candidates found");
            }
        }

    /*
     * Purpose : Implement the Logic of Update Candidate Status
     * @author : Aviligonda Sreenivasulu
     * @Param :  token,id and status
     * */
    @Override
    public CandidateModel changeStatus(Long id, String status) {
            Optional<CandidateModel> isCandidate = candidateRepository.findById(id);
            if (isCandidate.isPresent()) {
                isCandidate.get().setStatus(status);
                candidateRepository.save(isCandidate.get());
                return isCandidate.get();
            } else {
                throw new LMSException(400, "No candidates found");
            }
        }

    /*
     * Purpose : Implement the Logic of Get Count By Candidate Status
     * @author : Aviligonda Sreenivasulu
     * @Param :  token and status
     * */
    @Override
    public Long getCountByStatus(String status) {
            Long isCandidate = candidateRepository.getCountByStatus(status);
            return isCandidate;
    }
}
