/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.repository;

import co.edu.usa.ejemplojpa.crud.models.Category;
import co.edu.usa.ejemplojpa.crud.models.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Category
 */
@Repository
public class CtgRepository
{
    @Autowired
    private CategoryRepository catr;
    
    public List<Category>  getAll(){
    return (List<Category>) catr.findAll();
    }
    public Optional<Category> getCategory(int id){
    return catr.findById(id);}
    public Category save(Category c){
    return catr.save(c);}
}

    

