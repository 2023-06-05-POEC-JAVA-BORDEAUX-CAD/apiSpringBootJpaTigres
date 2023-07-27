package com.example.demo.dao;

import com.example.demo.entity.Tigre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TigreRepository extends JpaRepository<Tigre, Integer> {

}
