package com.example.ApiSpringBoot.models;

import javax.persistence.*;


//that shows to spring-boot that will define a entity(Table Model of the database) to use JPA
@Entity
// This is to indicate that the name of table will be "Users"
@Table(name = "Users")
public class UserModel {
    
    // this specifies that the "Id" field be automatically and unique key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;

    //this not use but spring-boot it use to the JPA and it is designated as protected.
    protected UserModel() {}

    //this is basic contructor for instance UserModel to be saved to the database.
    public UserModel(String nombre, String email, Integer prioridad){
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

}
