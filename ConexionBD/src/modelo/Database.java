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
public class Database {
    
    private String url;
    private String driver;
    private String usuario;
    private String contraseña;

    public Database() {
        this.url="jdbc:mysql://localhost:3306/sisv11";
        this.driver = "com.mysql.jdbc.Driver";
        this.usuario = "root";
        this.contraseña = "";
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
     
   
    
    
    
    
    
    
    
}
