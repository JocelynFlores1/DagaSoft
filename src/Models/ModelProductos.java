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

/**
 *
 * @author beto
 */
public class ModelProductos {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String id_producto;
    private String nombre_producto;
    private String tipo_producto;
    private String descripcion_producto;
    private String marca_producto;
    private Double precio_venta;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    private String c = "";

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

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void modificarDatos() {
        try {
            setId_producto(rs.getString(1));
            setNombre_producto(rs.getString(2));
            setTipo_producto(rs.getString(3));
            setDescripcion_producto(rs.getString(4));
            setMarca_producto(rs.getString(5));
            setPrecio_venta(rs.getDouble(6));
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }

    /**
     * Método que realiza las siguietnes acciones: 1.- Conecta con la base 2.-
     * Consulta todo los registros .
     */
    public void conectarDB(ModelConexion productosConexion) {
        try {
            System.out.println("consulta 2 productos");
            String consultaString = "select * from productos";
            ps = (PreparedStatement) productosConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla productos" + e);
        }
    }

    public void insertarNuevoProducto(ModelConexion productosConexion) {
        System.out.println("nuevo  3 productos");
        String sqlInsertarProducto = "insert into productos (id_producto, nombre_producto,tipo_producto,descripcion_producto,marca_producto, precio_venta_producto)"
                + " VALUES(?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) productosConexion.getConexion().prepareStatement(sqlInsertarProducto); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_producto());
            ps.setString(1, getId_producto());
            ps.setString(2, getNombre_producto());
            ps.setString(3, getTipo_producto());
            ps.setString(4, getDescripcion_producto());
            ps.setString(5, getMarca_producto());
            ps.setDouble(6, getPrecio_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo producto" + ex);
        }
    }

    public void modificarDatosProducto(ModelConexion productosConexion) {
        System.out.println("modificar 4 productos");
        String sqlModificarProducto = "update productos set "
                + "nombre_producto=?,  "
                + "tipo_producto=?, descripcion_producto=?"
                + "marca_producto=?, precio_venta_producto where id_producto = ?";
        try {

            ps = (PreparedStatement) productosConexion.getConexion().prepareStatement(sqlModificarProducto);

            System.out.println(getId_producto());

            ps.setString(1, getNombre_producto());
            ps.setString(2, getTipo_producto());
            ps.setString(3, getDescripcion_producto());
            ps.setString(4, getMarca_producto());
            ps.setDouble(5, getPrecio_venta());
            ps.setString(6, getId_producto());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos producto" + ex);
        }
    }
    public void borrarDatosProducto(ModelConexion productosConexion) {
        System.out.println("eliminar 5 productos");
        String sqlBorrarProducto = "delete from productos where id_producto = ?";
        try {

            ps = (PreparedStatement) productosConexion.getConexion().prepareStatement(sqlBorrarProducto);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el producto.
            ps.setString(1, getId_producto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 05: Borrar datos producto" + ex);
        }
    }
    /**
     * *
     * Metodo que permite insertar los datos de la tabla de la base de datos en
     * un jTable en java
     */
    public void consultajTableProductos(ModelConexion productosConexion) {
        try {
            System.out.println("tabla 6 productos");
            String consultaString = "select * from productos";
            ps = (PreparedStatement) productosConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla productos" + e);
        }
    }
    public void consultaGenerarCodigos(ModelConexion productosConexion) {
        System.out.println("codigos 7 productos");
        String SQL = "select max(id_producto) from productos";

        try {
            ps = (PreparedStatement) productosConexion.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                c = rs.getString(1);
                System.out.println("madx" + rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

    }


}
