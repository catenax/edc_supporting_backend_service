package com.csds.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csds.entity.EDCCallbackDataEntity;

public interface EDCCallbackDataRepository extends JpaRepository<EDCCallbackDataEntity, Long> {
	
	@Query("SELECT te FROM EDCCallbackDataEntity te INNER JOIN te.properties p WHERE KEY(p) = 'cid' \n"
	+ "AND VALUE(p) = :id")
	Optional<EDCCallbackDataEntity> getAuthTokenBaseonCId(@Param("id") String id);

}
