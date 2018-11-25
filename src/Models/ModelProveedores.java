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
 * @author Jocelyn
 */
public class ModelProveedores {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String id_proveedor;
    private String nombre_proveedor;
    private String calle_proveedor;
    private String numero_exterior_proveedor;
    private String colonia_proveedor;
    private String codigo_postal_proveedor;
    private String telefono_proveedor;
    private String email_proveedor;
    private String ciudad_proveedor;
    private String estado_proveedor;
    private String c = "";

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }


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

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getCalle_proveedor() {
        return calle_proveedor;
    }

    public void setCalle_proveedor(String calle_proveedor) {
        this.calle_proveedor = calle_proveedor;
    }

    public String getNumero_exterior_proveedor() {
        return numero_exterior_proveedor;
    }

    public void setNumero_exterior_proveedor(String numero_exterior_proveedor) {
        this.numero_exterior_proveedor = numero_exterior_proveedor;
    }

    public String getColonia_proveedor() {
        return colonia_proveedor;
    }

    public void setColonia_proveedor(String colonia_proveedor) {
        this.colonia_proveedor = colonia_proveedor;
    }

    public String getCodigo_postal_proveedor() {
        return codigo_postal_proveedor;
    }

    public void setCodigo_postal_proveedor(String codigo_postal_proveedor) {
        this.codigo_postal_proveedor = codigo_postal_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public String getCiudad_proveedor() {
        return ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }

    public String getEstado_proveedor() {
        return estado_proveedor;
    }

    public void setEstado_proveedor(String estado_proveedor) {
        this.estado_proveedor = estado_proveedor;
    }

    public void modificarDatos() {
        try {
            setId_proveedor(rs.getString(1));
            setNombre_proveedor(rs.getString(2));
            setCalle_proveedor(rs.getString(3));
            setNumero_exterior_proveedor(rs.getString(4));
            setColonia_proveedor(rs.getString(5));
            setCodigo_postal_proveedor(rs.getString(6));
            setTelefono_proveedor(rs.getString(7));
            setEmail_proveedor(rs.getString(8));
            setCiudad_proveedor(rs.getString(9));
            setEstado_proveedor(rs.getString(10));

            System.out.println(rs.getString(1));
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }

    /**
     * Método que realiza las siguietnes acciones: 1.- Conecta con la base 2.-
     * Consulta todo los registros .
     */
    public void conectarDB(ModelConexion proveedorConexion) {
        try {
            System.out.println("consulta 2 proveedores");
            String consultaString = "select * from proveedores";
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla proveedores" + e);
        }
    }

    public void insertarNuevoProveedor(ModelConexion proveedorConexion) {
       System.out.println(" 3 nuevo proveedor");
        String sqlInsertarProveedor = "insert into proveedores (id_proveedor, nombre_proveedor,calle_proveedor,numero_exterior_proveedor,colonia_proveedor,codigo_postal_proveedor, telefono_proveedor, email_proveedor,ciudad_proveedor,estado_proveedor) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
           ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(sqlInsertarProveedor); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_proveedor());
            ps.setString(1, getId_proveedor());
            ps.setString(2, getNombre_proveedor());
            ps.setString(3, getCalle_proveedor());
            ps.setString(4, getNumero_exterior_proveedor());
            ps.setString(5, getColonia_proveedor());
            ps.setString(6, getCodigo_postal_proveedor());
            ps.setString(7, getTelefono_proveedor());
            ps.setString(8, getEmail_proveedor());
            ps.setString(9, getCiudad_proveedor());
            ps.setString(10, getEstado_proveedor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo proveedor" + ex);
        }
    }

    public void modificarDatosProveedor(ModelConexion proveedorConexion) {
        System.out.println("modificar 4 proveedores");
        String sqlModificarProveedor = "update proveedores set "
                + "nombre_proveedor=?, calle_proveedor=?, numero_exterior_proveedor=?, colonia_proveedor=?, codigo_postal_proveedor=?, "
                + "telefono_proveedor=?, email_proveedor=?, ciudad_proveedor=?," + "estado_proveedor=? where id_cliente = ?";
        try {

            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(sqlModificarProveedor);

            System.out.println(getId_proveedor());

            ps.setString(1, getNombre_proveedor());
            ps.setString(2, getCalle_proveedor());
            ps.setString(3, getNumero_exterior_proveedor());
            ps.setString(4, getColonia_proveedor());
            ps.setString(5, getCodigo_postal_proveedor());
            ps.setString(6, getTelefono_proveedor());
            ps.setString(7, getEmail_proveedor());
            ps.setString(8, getCiudad_proveedor());
            ps.setString(9, getEstado_proveedor());
            ps.setString(10, getId_proveedor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos proveedores" + ex);
        }
    }

    public void borrarDatosCliente(ModelConexion proveedorConexion) {
       System.out.println("eliminar 5 proveedores");
        String sqlBorrarProveedor = "delete from proveedores where id_proveedor = ?";
        try {

            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(sqlBorrarProveedor);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el cliente.
            ps.setString(1, getId_proveedor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 05: Borrar datos proveedor" + ex);
        }
    }

    //Metodo que permite insertar los datos de la tabla de la base de datos en un jTable en java
    public void consultajTableProveedores(ModelConexion proveedorConexion) {
         try {
            System.out.println("tabla 6 proveedores");
            String consultaString = "select * from proveedores";
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla proveedores" + e);
        }
    }
    public void consultaGenerarCodigos(ModelConexion proveedorConexion) {
        System.out.println("codigos 7 proveedores");
        String SQL = "select max(id_proveedor) from proveedores";

        try {
            ps = (PreparedStatement) proveedorConexion.getConexion().prepareStatement(SQL);
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
