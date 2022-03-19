package com.fastxpo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fastxpo.bean.People;

public interface PeopleService {
	
	public People savePeople(@NotNull @Valid final People people);
	public People updatePeople(People people) ;
	//public void save();
	
	public String deletePeople(Long id);
}
