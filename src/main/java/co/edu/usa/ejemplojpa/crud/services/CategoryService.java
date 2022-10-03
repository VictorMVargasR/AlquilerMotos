/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Category;

import co.edu.usa.ejemplojpa.crud.repository.CategoryRepository;
import co.edu.usa.ejemplojpa.crud.repository.CtgRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Victor
 */
@Service
public class CategoryService {
    
    @Autowired
    private CtgRepository cr;
    
    public List<Category> getAll(){
        return (List<Category>)cr.getAll();
    }
   public Optional<Category> getCategory(int id){
   return  cr.getCategory(id);
   }
   
   public Category save(Category c){
       if(c.getId()==null){
   return cr.save(c);
   }else{
           Optional<Category> caux=cr.getCategory(c.getId());
            if(caux.isPresent()){return c;}else{return cr.save(c);}
   }}   
}
