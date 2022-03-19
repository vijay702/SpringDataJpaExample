package com.fastxpo.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fastxpo.bean.People;
import com.fastxpo.repo.PeopleRepo;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleRepo peopleRepo;
	
	@Override
	@Transactional
	public People savePeople(@NotNull @Valid final People people) {
		return peopleRepo.save(people);
	}

	@Override
	@Transactional
	public People updatePeople(People people) {
		
		People	existingPeople = peopleRepo.findById(people.getPeopleid()).orElse(null);
		existingPeople.setName(people.getName());
		existingPeople.setMobile(people.getMobile());
		
		return peopleRepo.save(existingPeople);
	}

	
	public String deletePeople(Long id) {
		
		 peopleRepo.deleteById(id);
		 return "Deleted" + id;
		
	}

	

}