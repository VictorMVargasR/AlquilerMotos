/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;


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
@Table(name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
   
    @Column(name="messageText", length = 255, nullable = false, unique = false)
    private String messageText;
     
    @ManyToOne
    @JsonIgnoreProperties({"messages","reservations"})
    @JoinColumn(name="motorbike")
    private Moto motorbike;
    
    
    @ManyToOne
    @JsonIgnoreProperties({"messages","reservations"})
    @JoinColumn(name="client")
    private Client client;
    
    
}
