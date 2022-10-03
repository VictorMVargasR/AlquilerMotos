/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author USER2022
 */

@Getter
@Setter
@Entity
@Table(name="category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @Column(name="name", length = 255, nullable = false, unique = false)
    private String name;
    @Column(name="description", length = 255, nullable = false, unique = false)
    private String description;
   
   //@JoinColumn(name="category")
  
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    public List<Moto> motorbikes;

    
   
    
}
