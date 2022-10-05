/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Reservation;
import co.edu.usa.ejemplojpa.crud.repository.RsvRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Victor
 */
@Service
public class ReservationService {
    
    
    @Autowired
    private RsvRepository rvsr;
    
    public List<Reservation> getAll(){
        return (List<Reservation>)rvsr.getAll();
    }
   public Optional<Reservation> getReservation(int id){
   return  rvsr.getReservation(id);
   }
   
   public Reservation save(Reservation m){
   if(m.getIdReservation()==null){
   return rvsr.save(m);
   }else{
       Optional<Reservation> e=rvsr.getReservation(m.getIdReservation());
   if(e.isPresent()){return m;
   }else{
       return rvsr.save(m);}
   }
   }
   }
