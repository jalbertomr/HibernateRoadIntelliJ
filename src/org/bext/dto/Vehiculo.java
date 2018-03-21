package org.bext.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo {
    @Id @GeneratedValue(generator = "gen_vehiculo",strategy = GenerationType.AUTO)
    @GenericGenerator(name="gen_vehiculo",strategy = "sequence",
    parameters = {@Parameter(name="sequence_name", value="sec_vehiculo")})
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
