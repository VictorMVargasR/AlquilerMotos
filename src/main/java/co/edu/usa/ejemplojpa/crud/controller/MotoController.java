/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.controller;

import co.edu.usa.ejemplojpa.crud.models.Motorbike;
import co.edu.usa.ejemplojpa.crud.services.MotoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor
 */
@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/Motorbike")
public class MotoController {
    
    @Autowired
    private MotoService ms;
    
    @GetMapping("all")
    public List<Motorbike> getAll(){
        return ms.getAll();
    }
    @GetMapping("{id}")
 public Optional<Motorbike> getMoto(@PathVariable("id")int id) {
        return ms.getMoto(id);
    }
 
@PostMapping("save")
@ResponseStatus(HttpStatus.CREATED)

public Motorbike save(@RequestBody Motorbike m){
    return ms.save(m);
}
}
