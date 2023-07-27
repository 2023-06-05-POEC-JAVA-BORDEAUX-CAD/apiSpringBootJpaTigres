package com.example.demo.service;


import com.example.demo.dao.SoigneurRepository;
import com.example.demo.dao.TigreRepository;
import com.example.demo.dao.ZooRepository;
import com.example.demo.entity.Soigneur;
import com.example.demo.entity.Tigre;
import com.example.demo.entity.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

    @Autowired
    ZooRepository zooRepository;

    @Autowired
    SoigneurRepository soigneurRepository;

    @Autowired
    TigreRepository tigreRepository;

    public void addZoo(Zoo zoo) {
        zooRepository.save(zoo);
    }

    public void addSoigneur(Soigneur soigneur) {
        soigneurRepository.save(soigneur);
    }

    public void addTigre(Tigre tigre) {
        tigreRepository.save(tigre);
    }

    public List<Tigre> findAllTigres() {
        return tigreRepository.findAll();
    }

    public boolean updateTigre(Tigre tigre, Integer id) {
        Optional<Tigre> optional = tigreRepository.findById(id);
        if(optional.isPresent()){
            tigreRepository.save(tigre);
            return true;
        }
        else {
            return false;
        }
    }

    public void patchTigre(Tigre tigrePatch, Integer id) {

        System.out.println(tigrePatch);
        System.out.println(id);

        Optional<Tigre> optional = tigreRepository.findById(id);
        if(optional.isPresent()){

            Tigre tigre = optional.get();
            System.out.println(tigre);
            tigre.updateNotNull(tigrePatch);

            tigreRepository.save(tigre);
        }
    }
}
