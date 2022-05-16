/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableviewexample;

import java.util.Objects;

/**
 *
 * @author Salva
 */
public class Animal {
    private String nombre;
    private String especie;
    private Integer edad;

    public Animal(String nombre, String especie, Integer edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        
        Animal other = (Animal) o;
        
        if(this == other)
            return true;
        if(other == null) 
            return false;
        
        if(this.nombre.equals(other.nombre) &&
                this.especie.equals(other.especie) &&
                this.edad.equals(other.edad)) 
        {
            return true;
        }
        else {
            return false;
        }    
    }
    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        return Objects.equals(this.edad, other.edad);
    }
    */
    
}
