/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Message;
import co.edu.usa.ejemplojpa.crud.repository.MsgRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Victor
 */
@Service
public class MessageService {
    
    
    @Autowired
    private MsgRepository mr;
    
    public List<Message> getAll(){
        return (List<Message>)mr.getAll();
    }
   public Optional<Message> getMessage(int id){
   return  mr.getMessage(id);
   }
   
   public Message save(Message m){
   if(m.getIdMessage()==null){
   return mr.save(m);
   }else{
       Optional<Message> e=mr.getMessage(m.getIdMessage());
   if(e.isPresent()){return m;
   }else{
       return mr.save(m);}
   }
   }
   }
