/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
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
   
     @Column(name="name", length = 255, nullable = false, unique = false)
    private String name;
    
    @Column(name="brand", length = 255, nullable = false, unique = false)
    private String brand;
    
     @Column(name="year", nullable = false, unique = false)
    private Integer year;
    
    @Column(name="description", length = 255, nullable = false, unique = false)
    private String description;
    
   
    
   // @Column(name="category", nullable = false, unique = false)
    
    @ManyToOne
    @JsonIgnoreProperties("motorbikes")
    //(fetch = FetchType.LAZY)
    @JoinColumn(name="category")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    public List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    public List<Reservation> reservations; 
    
    
    
    
    
    
}
