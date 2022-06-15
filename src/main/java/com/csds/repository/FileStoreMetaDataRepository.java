package com.csds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csds.entity.OfferFileMetadata;

public interface FileStoreMetaDataRepository  extends JpaRepository<OfferFileMetadata, Long> {

}
