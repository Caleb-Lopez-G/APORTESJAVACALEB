/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface operaciones {
    public boolean insertar(Object obj);
    public boolean eliminar(Object obj);
    public boolean modificar(Object obj);
    public ArrayList<Object[]>consultar();
    
    
}
