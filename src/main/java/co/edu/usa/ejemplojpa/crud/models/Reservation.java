/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jaque
 */
@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "startDate", length = 255, nullable = false, unique = false)
    private String startDate;

    @Column(name = "devolutionDate", length = 255, nullable = false, unique = false)
    private String devolutionDate;

    @Column(name = "status", length = 255, nullable = false, unique = false)
    private String status;
    
    @Column(name = "score", length = 255, nullable = false, unique = false)
    private Integer score;
    
    @ManyToOne
    @JsonIgnoreProperties("reservations")
    @JoinColumn(name="motorbike")
    private Moto motorbike;
}
