/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User2022
 */
@Repository
public class CltRepository
{
    @Autowired
    private ClientCrudRepository cltr;
    
    public List<Client>  getAll(){
    return (List<Client>) cltr.findAll();
    }
    public Optional<Client> getClient(int id){
    return cltr.findById(id);}
    public Client save(Client c){
    return cltr.save(c);}
}

    

