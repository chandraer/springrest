package com.eureka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.eureka.dto.DataTransferObject;
import com.eureka.entity.HospitalEntity;
import com.eureka.model.HospitalModel;
import com.eureka.repository.HospitalRepository;

public interface HospitalServiceIn {
	public HospitalEntity save(HospitalModel model);
//	 public HospitalEntity get(DataTransferObject retrieve);
	public List<HospitalEntity> saveAllHospitalDetails(List<HospitalModel> hospitalDetails);
	 public HospitalEntity updateHospital(Long id,HospitalModel hospitalUpdates);
	 public HospitalEntity patchHospital(Long id, HospitalModel hospitalDetails);
	 public HospitalEntity getHospitalByName(String name);
	 public List<HospitalEntity> findByNames(List<String> hospitalNames);
	 public List<HospitalEntity> getAllHospitalsSorted();
	 public List<HospitalEntity> getHospitalsWithNameStartingWith(String prefix);
	 public List<HospitalEntity> getHospitalswithNameStartsWith(String name);
	

}
