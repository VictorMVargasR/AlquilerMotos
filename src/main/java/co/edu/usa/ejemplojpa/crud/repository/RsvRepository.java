/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reservation
 */
@Repository
public class RsvRepository
{
    @Autowired
    private ReservationCrudRepository rsv;
    public List<Reservation> getAll(){
    return (List<Reservation>)rsv.findAll();
    }
    public Optional<Reservation> getReservation(int id){
    return rsv.findById(id);}
    public Reservation save(Reservation m){
    return rsv.save(m);}
}
