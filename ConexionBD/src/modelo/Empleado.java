/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Administrador
 */
public class Empleado {
private int ncarnet;
private String nombres;
private String apellidos;
private int edad;
private double salario;


public Empleado(){

}
public Empleado(int ncarnet,String nombres, String apellidos, int edad, double salario){

this.ncarnet=ncarnet;
this.nombres=nombres;
this.apellidos=apellidos;
this.edad=edad;
this.salario=salario;


}

    public int getNcarnet() {
        return ncarnet;
    }

    public void setNcarnet(int ncarnet) {
        this.ncarnet = ncarnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
