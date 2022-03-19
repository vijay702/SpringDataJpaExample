package com.fastxpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastxpo.bean.People;

public interface PeopleRepo extends JpaRepository<People, Long> {

}
