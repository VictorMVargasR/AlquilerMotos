/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Motorbike;
import co.edu.usa.ejemplojpa.crud.repository.MotoRepository;
import co.edu.usa.ejemplojpa.crud.repository.MtRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Victor
 */
@Service
public class MotorbikeService {
    
    
    @Autowired
    private MtRepository mr;
    
    public List<Motorbike> getAll(){
        return (List<Motorbike>)mr.getAll();
    }
   public Optional<Motorbike> getMoto(int id){
   return  mr.getMoto(id);
   }
   
   public Motorbike save(Motorbike m){
   if(m.getId()==null){
   return mr.save(m);
   }else{
       Optional<Motorbike> e=mr.getMoto(m.getId());
   if(e.isPresent()){return m;
   }else{
       return mr.save(m);}
   }
   }
   }
