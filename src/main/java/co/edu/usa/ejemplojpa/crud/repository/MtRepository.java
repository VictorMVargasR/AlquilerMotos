/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Moto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moto
 */
@Repository
public class MtRepository
{
    @Autowired
    private MotoRepository mtr;
    public List<Moto> getAll(){
    return (List<Moto>)mtr.findAll();
    }
    public Optional<Moto> getMoto(int id){
    return mtr.findById(id);}
    public Moto save(Moto m){
    return mtr.save(m);}
}
