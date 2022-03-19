package com.fastxpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastxpo.model.Due;

@Repository
public interface DueRepository extends JpaRepository<Due, Long> {

}
