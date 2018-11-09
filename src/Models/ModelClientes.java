/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jocelyn
 */
public class ModelClientes {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String id_cliente;
    private String nombre_cliente;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;
    private String rfc;
    private String calle;
    private String colonia;
    private String numero_exterior;
    private String numero_interior;
    private String codigo_postal;
    private String email;
    private String ciudad;
    private String estado;

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

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(String numero_interior) {
        this.numero_interior = numero_interior;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void modificarDatos() {
        try {
            setId_cliente(rs.getString(1));
            setNombre_cliente(rs.getString(2));
            setApellido_paterno(rs.getString(3));
            setApellido_materno(rs.getString(4));
            setTelefono(rs.getString(5));
            setRfc(rs.getString(6));
            setCalle(rs.getString(7));
            setColonia(rs.getString(8));
            setNumero_interior(rs.getString(9));
            setNumero_exterior(rs.getString(10));
            setCodigo_postal(rs.getString(11));
            setEmail(rs.getString(12));
            setCiudad(rs.getString(13));
            setEstado(rs.getString(14));
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }

    /**
     * Método que realiza las siguietnes acciones: 1.- Conecta con la base 2.-
     * Consulta todo los registros .
     */
    public void conectarDB() {
        ModelConexion loginConexion = new ModelConexion();
        loginConexion.getConexion();
        try {
            String consultaString = "select * from clientes";
            ps = (PreparedStatement) loginConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla clientes" + e);
        }
    }

    public void insertarNuevoCliente() {
        ModelConexion loginConexion = new ModelConexion();
        //Se obtiene la conexion para la clase

        String sqlInsertarCliente = "insert into clientes (id_cliente, nombre_cliente, apellido_paterno_cliente, apellido_materno_cliente, telefono_cliente, rfc_cliente, calle_cliente, colonia_cliente, numero_exterior_cliente, numero_interior_cliente, codigo_postal_cliente, email_cliente, ciudad_cliente, estado_cliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) loginConexion.getConexion().prepareStatement(sqlInsertarCliente); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_cliente());
            ps.setString(1, getId_cliente());
            ps.setString(2, getNombre_cliente());
            ps.setString(3, getApellido_paterno());
            ps.setString(4, getApellido_materno());
            ps.setString(5, getTelefono());
            ps.setString(6, getRfc());
            ps.setString(7, getCalle());
            ps.setString(8, getColonia());
            ps.setString(9, getNumero_exterior());
            ps.setString(10, getNumero_interior());
            ps.setString(11, getCodigo_postal());
            ps.setString(12, getEmail());
            ps.setString(13, getCiudad());
            ps.setString(14, getEstado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo cliente" + ex);
        }
    }

    public void modificarDatosCliente() {
        ModelConexion loginConexion = new ModelConexion();
        //Se obtiene la conexion para la clase

        String sqlModificarCliente = "update clientes set "
                + "nombre_cliente=?, apellido_paterno_cliente=?, apellido_materno_cliente=?, telefono_cliente=?, rfc_cliente=?, "
                + "calle_cliente=?, colonia_cliente=?, numero_exterior_cliente=?, numero_interior_cliente=?, codigo_postal_cliente=?, email_cliente=?, ciudad_cliente=?, "
                + "estado_cliente=? where id_cliente = ?";
        try {

            ps = (com.mysql.jdbc.PreparedStatement) loginConexion.getConexion().prepareStatement(sqlModificarCliente);

            System.out.println(getId_cliente());

            ps.setString(1, getNombre_cliente());
            ps.setString(2, getApellido_paterno());
            ps.setString(3, getApellido_materno());
            ps.setString(4, getTelefono());
            ps.setString(5, getRfc());
            ps.setString(6, getCalle());
            ps.setString(7, getColonia());
            ps.setString(8, getNumero_exterior());
            ps.setString(9, getNumero_interior());
            ps.setString(10, getCodigo_postal());
            ps.setString(11, getEmail());
            ps.setString(12, getCiudad());
            ps.setString(13, getEstado());
            ps.setString(14, getId_cliente());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos cliente" + ex);
        }
    }

    //Metodo que permite insertar los datos de la tabla de la base de datos en un jTable en java
    public void consultajTableClientes() {
        ModelConexion loginConexion = new ModelConexion();
        loginConexion.getConexion();
        try {
            String consultaString = "select * from clientes";
            ps = (PreparedStatement) loginConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla clientes" + e);
        }
    }
    
}
