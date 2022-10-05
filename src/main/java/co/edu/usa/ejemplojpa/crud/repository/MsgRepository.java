/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor
 */
@Repository
public class MsgRepository
{
    @Autowired
    private MessageCrudRepository msgr;
    
    public List<Message> getAll(){
    return (List<Message>)msgr.findAll();}
    
    public Optional<Message> getMessage(int id){
    return msgr.findById(id);}
    
    public Message save(Message m){
    return msgr.save(m);}
}
