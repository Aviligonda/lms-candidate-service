package com.bridgelabz.lmscandidateservice.repository;

import com.bridgelabz.lmscandidateservice.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<CandidateModel, Long> {
    @Query(value = "select * from candidates where status=:status", nativeQuery = true)
    List<CandidateModel> findAllByStatus(String status);

    @Query(value = "select count(status) from candidates  where status=:isStatus", nativeQuery = true)
    Long getCountByStatus(@Param("isStatus") String status);
}
