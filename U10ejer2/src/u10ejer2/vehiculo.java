/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u10ejer2;

/**
 *
 * @author 1erDAM
 */
public class vehiculo {
    
    private String tipo, color;
    private int puertas, velmax;
    
    public vehiculo(){
        
    }
    
    public vehiculo(int puertas, int velmax, String tipo, String color){
        
        this.tipo=tipo;
        this.color=color;
        this.puertas=puertas;
        this.velmax=velmax;
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getVelmax() {
        return velmax;
    }

    public void setVelmax(int velmax) {
        this.velmax = velmax;
    }
    
    
    
}
