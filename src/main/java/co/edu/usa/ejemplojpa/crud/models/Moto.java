/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name="moto")
public class Moto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(name="brand", length = 255, nullable = false, unique = false)
    private String brand;
    
    @Column(name="description", length = 255, nullable = false, unique = false)
    private String description;
    
    @Column(name="year", nullable = false, unique = false)
    private Integer year;
    
   // @Column(name="category", nullable = false, unique = false)
    
    @ManyToOne
    @JsonIgnoreProperties("motorbikes")
    //(fetch = FetchType.LAZY)
    @JoinColumn(name="category")
    private Category category;

    

   


    

    
    
}
