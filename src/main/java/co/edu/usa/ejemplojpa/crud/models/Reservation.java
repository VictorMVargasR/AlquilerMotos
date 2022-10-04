/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
@Table(name="reservation")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    
    @Column(name="starDate", nullable = false, unique = false)
    private Date starDate;
    
    @Column(name="devolutionDate", nullable = false, unique = false)
    private Date devolutionDate;
    
    @Column(name="status", nullable = false, unique = false)
    private Integer status;
    
    @ManyToOne
    @JsonIgnoreProperties("reservations")
    @JoinColumn(name="motorbike")
    private Moto motorbike;
    
   
    
}
