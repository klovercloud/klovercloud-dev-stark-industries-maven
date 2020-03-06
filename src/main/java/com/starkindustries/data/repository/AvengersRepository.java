package com.starkindustries.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starkindustries.data.Avengers;

@Repository
public interface AvengersRepository extends JpaRepository<Avengers, String>{

}
