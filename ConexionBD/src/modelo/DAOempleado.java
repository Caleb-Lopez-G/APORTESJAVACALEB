/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DAOempleado implements operaciones{
    Database db=new Database();
    Empleado emp=new Empleado();
    
    //reducir la cantidad de codigo de todos los metodos haciendo un metodo ejecutar
    
    
    @Override
    public boolean insertar(Object obj) {
     
      this.emp=(Empleado)obj;
      Connection con;//
      PreparedStatement pst;
      String sql="insert into empleado values(?,?,?,?,?)";//consulta preparada el servidor ya sabe que va recibir
      
      
      try{
      Class.forName(db.getDriver());
      con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContraseña());
     
      
      //seteo las variables que lleva el signo de interrogacion
     pst=con.prepareStatement(sql);//pst:manda a llamar al driver manager,getconection,settea los valoes
     pst.setInt(1,emp.getNcarnet());
     pst.setString(2,emp.getNombres());
     pst.setString(3,emp.getApellidos());
     pst.setInt(4,emp.getEdad());
     pst.setDouble(5,emp.getSalario());
      //PORQUE ESTABAMOS EN EL METODO INSERTAR EXECUTEupdate
      int filas =pst.executeUpdate();
      if(filas>0){
      con.close();
      return false;
      }else{
      con.close();
      return false;
      }
      }catch(SQLException |ClassNotFoundException e){//para que nos muestre un mensaje especifico
      JOptionPane.showMessageDialog(null,"ocurrio este error:"+e.getMessage());
      return false;
      }
    }


    @Override
    public boolean eliminar(Object obj) {
        
            this.emp=(Empleado)obj;
      Connection con;//
      PreparedStatement pst;
      String sql="delete  from empleado where carnet=?";//consulta preparada el servidor ya sabe que va recibir
      
      
      try{
      Class.forName(db.getDriver());
      con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContraseña());
   
      
      //seteo las variables que lleva el signo de interrogacion
    
      pst=con.prepareStatement(sql);//pst:manda a llamar al driver manager,getconection,settea los valores
     pst.setInt(1,emp.getNcarnet());
   
     
      //PORQUE ESTABAMOS EN EL METODO INSERTAR EXECUTEupdate
      int filas =pst.executeUpdate();
      
      if(filas>0){
      con.close();
      return false;
      }else{
      con.close();
      return false;
      }
      }catch(SQLException |ClassNotFoundException e){//para que nos muestre un mensaje especifico
      JOptionPane.showMessageDialog(null,"ocurrio este error:"+e.getMessage());
      return false;
      }
        
    }
    
    

    
    
    
    
    @Override
    public boolean modificar(Object obj) {
         this.emp=(Empleado)obj;
      Connection con;//
      PreparedStatement pst;
      String sql="update  empleado set nombres=?,apellidos=?,edad=?,salario=?,precio=? where carnet=?";//consulta preparada el servidor ya sabe que va recibir
      
      
      try{
      Class.forName(db.getDriver());
      con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContraseña());
   
      
      //seteo las variables que lleva el signo de interrogacion
     pst=con.prepareStatement(sql);//pst:manda a llamar al driver manager,getconection,settea los valoes
    
     pst.setInt(1,emp.getNcarnet());
     pst.setString(2,emp.getNombres());
     pst.setString(3,emp.getApellidos());
     pst.setInt(4,emp.getEdad());
     pst.setDouble(5,emp.getSalario());
     
      //PORQUE ESTABAMOS EN EL METODO INSERTAR EXECUTEupdate
      int filas =pst.executeUpdate();
      
      if(filas>0){
      con.close();
      return false;
      }else{
      con.close();
      return false;
      }
      }catch(SQLException |ClassNotFoundException e){//para que nos muestre un mensaje especifico
      JOptionPane.showMessageDialog(null,"ocurrio este error:"+e.getMessage());
      return false;
      }
    }

    
    
    
    
    
    
    
    @Override
    public ArrayList<Object[]> consultar() {
        
        ArrayList<Object[]>data=new ArrayList<>();//para colocar una variable en el return
         Connection con;
        PreparedStatement pst;
        ResultSet rs;//almecenar el resultado de la consulta
        ResultSetMetaData meta;
          String sql ="select * from empleado";
          
              try{
           Class.forName(db.getDriver());
           con=DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContraseña());
           
            
           pst= con.prepareStatement(sql);//ejecutar una sentencia
           rs = pst.executeQuery();//solo para consultar, para eliminar,modificar e insertar es update
           //se puede meter aqui para cerrar la conexion con.close();
           
           meta=rs.getMetaData();//vaariable de metadatos para recibir los datos de la variable rs
           
           while(rs.next()){//iteraciones por cada registro que realiza
               Object[] fila = new Object[meta.getColumnCount()];//array de object porque son de tipos diferente las variables, se cololoca meta.get... cuando no se sabe cuantos datos tiene la base de datos
             
               for(int i=0; i<fila.length; i++){//se pone i<por que uso length
                   fila[i]=rs.getObject(i+1);//tendre un resultado desde el valor 1 si partieran del cero no llevaria +1
               }
              data.add(fila);
           }
           con.close();
            
            
        }catch(SQLException |ClassNotFoundException e){        //para que nos muestre un mensaje especifico
      JOptionPane.showMessageDialog(null,"ocurrio este error:"+e.getMessage());
      
      }finally{
            return data;//si todo sale bien se ejecutara una linea de codigo
        }
    }
}
