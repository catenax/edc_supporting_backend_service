package com.csds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csds.entity.EDCCallbackDataEntity;
import com.csds.entity.OfferFileMetadata;
import com.csds.repository.EDCCallbackDataRepository;
import com.csds.repository.FileStoreMetaDataRepository;

@Service
public class EDCBackendService {

	@Autowired
	private EDCCallbackDataRepository objEDCCallbackDataRepository;

	private final StorageService storageService;
	private final FileStoreMetaDataRepository fileStoreMetaDataRepository;

	@Autowired
	public EDCBackendService(StorageService storageService, FileStoreMetaDataRepository fileStoreMetaDataRepository) {
		this.storageService = storageService;
		this.fileStoreMetaDataRepository = fileStoreMetaDataRepository;
	}

	public long saveFile(MultipartFile file) {
		storageService.store(file);
		OfferFileMetadata offerFilemetadata = OfferFileMetadata.builder().fileName(file.getOriginalFilename()).build();
		return fileStoreMetaDataRepository.save(offerFilemetadata).getId();
	}

	public String saveData(EDCCallbackDataEntity request) {
		objEDCCallbackDataRepository.save(request);
		return request.getId();
	}

	public EDCCallbackDataEntity getData(Long id) {
		return Optional.ofNullable(objEDCCallbackDataRepository.findById(id)).orElse(null).get();
	}

	public EDCCallbackDataEntity getAuthTokenBaseonCId(String id) {
		return Optional.ofNullable(objEDCCallbackDataRepository.getAuthTokenBaseonCId(id)).orElse(null).get();
	}

	public List<EDCCallbackDataEntity> getAllData() {
		return Optional.ofNullable(objEDCCallbackDataRepository.findAll()).orElse(null);
	}

	public OfferFileMetadata getFileMetaData(Long id) {
		return Optional.ofNullable(fileStoreMetaDataRepository.findById(id)).orElse(null).get();
	}

}
