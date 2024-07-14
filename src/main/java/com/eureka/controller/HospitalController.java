package com.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.entity.HospitalEntity;
import com.eureka.model.HospitalModel;
import com.eureka.service.HospitalService;
import com.eureka.service.HospitalServiceIn;

@RestController
public class HospitalController {
	@Autowired
public	HospitalServiceIn hospitalservice;
	
@PostMapping("/save")
public HospitalEntity saveData(@RequestBody HospitalModel model) {
	return hospitalservice.save(model);	
}

@PostMapping("/hospitals")
public List<HospitalEntity> saveAllHospitalDetails(@RequestBody List<HospitalModel> hospitalDetails) {
    return hospitalservice.saveAllHospitalDetails(hospitalDetails);
}
@PutMapping("/update/{id}")
public HospitalEntity updatingDetails(@PathVariable Long id,@RequestBody HospitalModel model) {
	
	HospitalEntity hospitalEntity= hospitalservice.updateHospital(id, model);
	return hospitalEntity;
}
@PatchMapping("/patch/{id}")
public HospitalEntity patchHospital(@PathVariable Long id, @RequestBody HospitalModel hospitalUpdates) {

	return hospitalservice.patchHospital(id, hospitalUpdates);
}

@GetMapping("/gethospital/{name}")
public HospitalEntity getHospitalByName(@PathVariable String name)
{
	return hospitalservice.getHospitalByName(name);
}
@GetMapping("/getallhospitals")
public List<HospitalEntity> findByNames(@RequestBody List<String> hospitalNames) {
        // Use the hospital repository to find hospitals by their names
	return hospitalservice.findByNames(hospitalNames);
}   

@GetMapping("/getallsortedhospitals")
public List<HospitalEntity> getAllHospitalsSorted()
{
	return hospitalservice.getAllHospitalsSorted();
}
@GetMapping("/gethospitalByNamestartswith/{alphabet}")
public List<HospitalEntity> getHospitalByAlphabet(@PathVariable String alphabet ){
	return hospitalservice.getHospitalsWithNameStartingWith(alphabet);
	
}
@GetMapping("/findByLocation/{location}")
public List<HospitalEntity> getHospitalLocationStartsWith(@PathVariable String location){
	return hospitalservice.getHospitalswithNameStartsWith(location);
	
}
}

