package com.eidiko.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.entity.MailTransferDetails;

public interface MailTransferDetailsRepository extends JpaRepository<MailTransferDetails, Long> {


	List<MailTransferDetails> findAllByToAddr(String mail);
//	@Query("SELECT NEW com.eidiko.dto.MailTransferDTO(m.id, m.toAddr, m.subject1, m.date, f.fileName) " +
//	        "FROM MailTransferDetails m " +
//	        "LEFT JOIN m.fileNames f " +
//	        "WHERE m.toAddr = :mail")
//	List<MailTransferDTO> find(@Param("mail") String mail);
//    
}
