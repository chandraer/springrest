package com.eureka.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.stereotype.Service;

import com.eureka.entity.HospitalEntity;
import com.eureka.model.HospitalModel;
import com.eureka.repository.HospitalRepository;
@Ser
public class HospitalService implements HospitalServiceIn {
	@Autowired
	HospitalRepository repository;
	public HospitalEntity save(HospitalModel model) {
	HospitalEntity entity=new HospitalEntity();
	entity.setName(model.getName());
	entity.setLocation(model.getLocation());
	entity.setRating(model.getRating());
	entity.setEmail(model.getEmail());
	entity.setPhoneNumber(model.getPhoneNumber());
	entity.setCreatedAt(LocalDateTime.now());
	entity.setCreatedBy(System.getProperty("user.name"));
	return repository.save(entity);

}

public List<HospitalEntity> saveAllHospitalDetails(List<HospitalModel> hospitalDetails) {
    List<HospitalEntity> savedHospitals = new ArrayList<>();
    
    if (hospitalDetails != null && !hospitalDetails.isEmpty()) {
        for (HospitalModel details : hospitalDetails) {
            HospitalEntity hospital = new HospitalEntity();
            hospital.setName(details.getName());
            hospital.setRating(details.getRating());
            hospital.setCreatedAt(LocalDateTime.now());
            hospital.setLocation(details.getLocation());
            hospital.setCreatedBy(System.getProperty("user.name"));
            hospital.setEmail(details.getEmail());
            hospital.setPhoneNumber(details.getPhoneNumber());
            savedHospitals.add(repository.save(hospital));
        }
    }
    
    return savedHospitals;

	}
public HospitalEntity updateHospital( Long id,HospitalModel hospitalUpdates) {
    
	 HospitalEntity hospital = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hospital not found with id " + id));
       
       hospital.setName(hospitalUpdates.getName());
       hospital.setRating(hospitalUpdates.getRating());
       hospital.setLocation(hospitalUpdates.getLocation());
       hospital.setCreatedAt(LocalDateTime.now());
		hospital.setCreatedBy(System.getProperty("user.name"));
       
       return repository.save(hospital);
}
public HospitalEntity patchHospital(Long id, HospitalModel hospitalDetails) {
    HospitalEntity hospital = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hospital not found with id " + id));

    if (hospitalDetails.getName() != null) {
        hospital.setName(hospitalDetails.getName());
    }
    if (hospitalDetails.getRating() != null) {
        hospital.setRating(hospitalDetails.getRating());
    }
    if (hospitalDetails.getLocation() != null) {
        hospital.setLocation(hospitalDetails.getLocation());
    }
    if(hospitalDetails.getEmail()!=null) {
    	hospital.setEmail(hospitalDetails.getEmail());
    }
    hospital.setCreatedAt(LocalDateTime.now());
    hospital.setCreatedBy(System.getProperty("user.name"));
    return repository.save(hospital);
}
//@RestController
//@RequestMapping("/api/hospitals")
//public class HospitalController {
//
//    @Autowired
//    private HospitalRepository hospitalRepository;
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Hospital> patchHospital(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
//        Hospital hospital = hospitalRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Hospital not found with id " + id));
//
//        updates.forEach((key, value) -> {
//            switch (key) {
//                case "name":
//                    hospital.setName((String) value);
//                    break;
//                case "rating":
//                    hospital.setRating((Double) value);
//                    break;
//                case "location":
//                    hospital.setLocation((String) value);
//                    break;
//                default:
//                    // Ignore unknown fields
//                    break;
//            }
//        });
//
//        Hospital updated = hospitalRepository.save(hospital);
//        return ResponseEntity.ok(updated);
//    }
//}
public HospitalEntity getHospitalByName(String name) {

	return repository.findByName(name);
}
public List<HospitalEntity> findByNames(List<String> hospitalNames) {
	// TODO Auto-generated method stub
	return repository.findByNameIn(hospitalNames);
}
public List<HospitalEntity> getAllHospitalsSorted() {
org.springframework.data.domain.Sort sort=org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.ASC, "name");
	return repository.findAll(sort);
	
//	Sort sort = Sort.by(Direction.ASC,"name");
//	return hospitalRepository.findAll(sort);
}
public List<HospitalEntity> getHospitalsWithNameStartingWith(String prefix) {
    return repository.findByNameStartingWith(prefix);
}
public List<HospitalEntity> getHospitalswithNameStartsWith(String name){
	return repository.findByLocationStartsWith(name);
	
}




}