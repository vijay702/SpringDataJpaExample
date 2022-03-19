package com.fastxpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastxpo.model.Borrower;


@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
