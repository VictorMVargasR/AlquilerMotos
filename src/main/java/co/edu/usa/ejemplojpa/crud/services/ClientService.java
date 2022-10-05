/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Client;
import co.edu.usa.ejemplojpa.crud.repository.CltRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Victor
 */
@Service
public class ClientService {
    
    
    @Autowired
    private CltRepository mr;
    
    public List<Client> getAll(){
        return (List<Client>)mr.getAll();
    }
   public Optional<Client> getClient(int id){
   return  mr.getClient(id);
   }
   
   public Client save(Client m){
   if(m.getIdClient()==null){
   return mr.save(m);
   }else{
       Optional<Client> e=mr.getClient(m.getIdClient());
   if(e.isPresent()){return m;
   }else{
       return mr.save(m);}
   }
   }
   }
