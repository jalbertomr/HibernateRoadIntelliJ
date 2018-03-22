package org.bext.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
    @Id @GeneratedValue(generator = "gen_persona",strategy = GenerationType.AUTO)
    @GenericGenerator(name="gen_persona",strategy = "sequence",
    parameters = {@Parameter(name="sequence_name",value = "seq_persona")})
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
