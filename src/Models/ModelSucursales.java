/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author beto
 */
public class ModelSucursales {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String idSucursal;
    private String nombreSucursal;
    private String calleSucursal;
    private String coloniaSucursal;
    private String numeroexteriorSucursal;
    private String ciudadSucursal;
    private String telefonoSucursal;
    private String codigopostalSucursal;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCalleSucursal() {
        return calleSucursal;
    }

    public void setCalleSucursal(String calleSucursal) {
        this.calleSucursal = calleSucursal;
    }

    public String getColoniaSucursal() {
        return coloniaSucursal;
    }

    public void setColoniaSucursal(String coloniaSucursal) {
        this.coloniaSucursal = coloniaSucursal;
    }

    public String getCiudadSucursal() {
        return ciudadSucursal;
    }

    public void setCiudadSucursal(String ciudadSucursal) {
        this.ciudadSucursal = ciudadSucursal;
    }

    public String getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(String telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }

    public String getCodigopostalSucursal() {
        return codigopostalSucursal;
    }

    public void setCodigopostalSucursal(String codigopostalSucursal) {
        this.codigopostalSucursal = codigopostalSucursal;
    }

    public String getNumeroexteriorSucursal() {
        return numeroexteriorSucursal;
    }

    public void setNumeroexteriorSucursal(String numeroexteriorSucursal) {
        this.numeroexteriorSucursal = numeroexteriorSucursal;
    }

    public void modificarDatos() {
        try {
            this.setIdSucursal(rs.getString(1));
            this.setNombreSucursal(rs.getString(2));
            this.setCalleSucursal(rs.getString(3));
            this.setColoniaSucursal(rs.getString(4));
            this.setNumeroexteriorSucursal(rs.getString(5));
            this.setCiudadSucursal(rs.getString(6));
            this.setTelefonoSucursal(rs.getString(7));
            this.setCodigopostalSucursal(rs.getString(8));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ModelSucursal 001: \n" + e.getMessage());
        }
    }

    /**
     * Método que realiza las siguietnes acciones: 1.- Conecta con la base 2.-
     * Consulta todo los registros .
     */
    public void conectarDB() {
        ModelConexion sucursalConexion = new ModelConexion();
        sucursalConexion.getConexion();
        try {
            String consultaString = "select * from sucursal";
            ps = (PreparedStatement) sucursalConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
                System.out.println(rs.getString(1));
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla clientes" + e);
        }
    }

    public void insertarNuevoSucursal() {
        ModelConexion sucursalConexion = new ModelConexion();
        //Se obtiene la conexion para la clase

        String sqlInsertarSucursal = "insert into sucursal (id_sucursal, nombre_sucursal, calle_sucursal, colonia_sucursal,"
                + "numero_sucursal, ciudad_sucursal, telefono_sucursal, codigo_postal_sucursal) VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) sucursalConexion.getConexion().prepareStatement(sqlInsertarSucursal); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getIdSucursal());
            ps.setString(1, getIdSucursal());
            ps.setString(2, getNombreSucursal());
            ps.setString(3, getCalleSucursal());
            ps.setString(4, getColoniaSucursal());
            ps.setString(5, getNumeroexteriorSucursal());
            ps.setString(6, getCiudadSucursal());
            ps.setString(7, getTelefonoSucursal());
            ps.setString(8, getCodigopostalSucursal());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo cliente" + ex);
        }
    }

    public void modificarDatosSucursal() {
        ModelConexion sucursalConexion = new ModelConexion();
        //Se obtiene la conexion para la clase

        String sqlModificarSucursal = "update sucursal set "
                + "nombre_sucursal=?, calle_sucursal=?, colonia_sucursal=?, numero_sucursal=?, ciudad_sucursal=?, "
                + "telefono_sucursal=?, codigo_postal_sucursal=? where codigo_sucursal=?,";

        try {

            ps = (com.mysql.jdbc.PreparedStatement) sucursalConexion.getConexion().prepareStatement(sqlModificarSucursal);

            System.out.println(getIdSucursal());

            ps.setString(8, getIdSucursal());
            ps.setString(1, getNombreSucursal());
            ps.setString(2, getCalleSucursal());
            ps.setString(3, getColoniaSucursal());
            ps.setString(4, getNumeroexteriorSucursal());
            ps.setString(5, getCiudadSucursal());
            ps.setString(6, getTelefonoSucursal());
            ps.setString(7, getCodigopostalSucursal());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos cliente" + ex);
        }
    }

    //Metodo que permite insertar los datos de la tabla de la base de datos en un jTable en java
    public void consultajTableSucursal() {
        ModelConexion sucursalConexion = new ModelConexion();
        sucursalConexion.getConexion();
        try {
            String consultaString = "select * from sucursal";
            ps = (PreparedStatement) sucursalConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 06: tabla clientes" + e);
        }
    }

}
