package com.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.entity.HospitalEntity;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
public HospitalEntity  findByName(String name);
//public 	List<HospitalEntity> findByNameIn(List<String> hospitalNames);
public default List<HospitalEntity> findByNameStartingWith(String prefix) {
    List<HospitalEntity> hospitals = findAll();
    return hospitals.stream()
            .filter(hospital -> hospital.getName().startsWith(prefix))
            .collect(Collectors.toList());
}
public default List<HospitalEntity> findByLocationStartsWith(String alphabet){
	List<HospitalEntity> hospitals=findAll();
	return hospitals.stream().filter(hos->hos.getLocation().startsWith(alphabet)).collect(Collectors.toList());	
}
}
