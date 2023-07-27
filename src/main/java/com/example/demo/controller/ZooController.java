package com.example.demo.controller;

import com.example.demo.entity.Soigneur;
import com.example.demo.entity.Tigre;
import com.example.demo.entity.Zoo;
import com.example.demo.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ZooController {

    @Autowired
    ZooService zooService;

    @PostMapping("zoos")
    public void createZoo(@RequestBody Zoo zoo){

        zooService.addZoo(zoo);
    }

    @PostMapping("soigneurs")
    public void createSoigneur(@RequestBody Soigneur soigneur){

        zooService.addSoigneur(soigneur);
    }

    @PostMapping("tigres")
    public void createTigre(@RequestBody Tigre tigre){

        zooService.addTigre(tigre);
    }

    @GetMapping("tigres")
    public List<Tigre> getTigres(){
        return zooService.findAllTigres();
    }

    @PutMapping("tigres/{id}")
    public ResponseEntity<String> updateTigre(@RequestBody Tigre tigre, @PathVariable("id") Integer id){

        boolean ok = zooService.updateTigre(tigre, id);
        if(ok){
            return ResponseEntity.ok("update OK");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("tigres/{id}")
    public void patchTigre(@RequestBody Tigre tigre, @PathVariable("id") Integer id){
        zooService.patchTigre(tigre, id);
    }

}
