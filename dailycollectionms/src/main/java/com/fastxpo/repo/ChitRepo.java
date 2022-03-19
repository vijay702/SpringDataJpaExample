package com.fastxpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastxpo.bean.Chit;

public interface ChitRepo extends JpaRepository<Chit, Long> {

}
