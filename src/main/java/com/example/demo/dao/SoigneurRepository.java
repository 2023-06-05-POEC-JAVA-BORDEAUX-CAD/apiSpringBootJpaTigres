package com.example.demo.dao;

import com.example.demo.entity.Soigneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoigneurRepository extends JpaRepository<Soigneur, Integer> {

}
