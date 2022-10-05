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
@Table(name="client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
   
    @Column(name="email", length = 250, nullable = false, unique = false)
    private String email;
    
    @Column(name="password", length = 250, nullable = false, unique = false)
    private String password;
    
    @Column(name="name", length = 250, nullable = false, unique = false)
    private String name;
    
    @Column(name="age", nullable = false, unique = false)
    private Integer age;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    public List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    public List<Reservation> reservations; 
      
}
