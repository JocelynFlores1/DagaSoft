/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private String  rfc;
    private String calle;
    private String colonia;
    private Integer numero_exterior;
    private Integer numero_interior;
    private Integer codigo_postal;
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

    public Integer getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(Integer numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public Integer getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(Integer numero_interior) {
        this.numero_interior = numero_interior;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
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
            this.setId_cliente(rs.getString("id_cliente"));
            this.setNombre_cliente(rs.getString("nombre_cliente"));
            this.setApellido_paterno(rs.getString("apellido_paterno"));
            this.setApellido_materno(rs.getString("apellido_materno"));
            this.setTelefono(rs.getString("telefono"));
            this.setRfc(rs.getString("rfc"));
            this.setCalle(rs.getString("calle"));
            this.setColonia(rs.getString("colonia"));
            this.setNumero_interior(rs.getInt("numero_interior"));
            this.setNumero_exterior(rs.getInt("numero_exterior"));
            this.setCodigo_postal(rs.getInt("codigo_postal"));
            this.setEmail(rs.getString("email"));
            this.setCiudad(rs.getString("ciudad"));
            this.setEstado(rs.getString("estado"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 001: \n" + e.getMessage());
        }
    }
    /**
     * Método que realiza las siguietnes acciones: 
     * 1.- Conecta con la base
     * 2.- Consulta todo los registros .
     */
    public void conectarDB() {
        try {
            conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dagasoft", "daga", "daga.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            id_cliente = rs.getString("id_proveedor");
            nombre_cliente = rs.getString("nombre_proveedor");
            apellido_paterno = rs.getString("apellido_paterno");
            apellido_materno = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            rfc = rs.getString("rfc");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            numero_interior = rs.getInt("numero_interior");
            numero_exterior = rs.getInt("numero_exterior");
            codigo_postal = rs.getInt("codigo_postal");
            email = rs.getString("email");
            ciudad = rs.getString("ciudad");
            estado = rs.getString("estado");
            this.setId_cliente(id_cliente);
            this.setNombre_cliente(nombre_cliente);
            this.setApellido_paterno(apellido_paterno);
            this.setApellido_materno(apellido_materno);
            this.setTelefono(telefono);
            this.setRfc(rfc);
            this.setCalle(calle);
            this.setColonia(colonia);
            this.setNumero_interior(numero_interior);
            this.setNumero_exterior(numero_exterior);
            this.setCodigo_postal(codigo_postal);
            this.setEmail(email);
            this.setCiudad(ciudad);
            this.setEstado(estado);
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 002: " + sql.getMessage());
        }
    }
    public void moverPrimerRegistro() {
        System.out.print(" accion moverPrimerRegistro");
        try {
            rs.first();
            modificarDatos();
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 004: " + sql.getMessage());
        }
    }
    public void moverSiguienteRegistro() {

        try {
            if (!rs.isLast()) {
                rs.next();
                modificarDatos();
                System.out.print("accion moverSiguienteRegistro");
            }

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 005: " + sql.getMessage());
        }
    }
    public void moverAnteriorRegistro() {

        try {
            if (!rs.isFirst()) {
                rs.previous();
                modificarDatos();
                System.out.print("accion moverAnteriorRegistro");

            }

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 006: " + sql.getMessage());
        }
    }
    public void moverUltimoRegistro() {
        System.out.print("Programa accion moverUltimoRegistro");
        try {
            rs.last();
            modificarDatos();
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 007: " + sql.getMessage());
        }
    }
    public void nuevoRegistro() {
        System.out.println("Insertar nuevo cliente");
        try {
            String sql = "INSERT INTO clientes(id_cliente,nombre_cliente,apellido_paterno,apellido_materno,calle,telefono,rfc,colonia,numero_interior,numero_exterior,codigo_postal,ciudad,estado) VALUES " + "('" +id_cliente + "','" + nombre_cliente + "','" + apellido_paterno + "','" + apellido_materno + "','" + telefono + "','" + rfc + "','" + calle + "','" + colonia + "','" + numero_interior + "','" + numero_exterior + "','" + codigo_postal + "','" + ciudad + "','" + estado + "');";
            st.executeUpdate(sql);
            this.conectarDB();
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 008: " + sql.getMessage());
      }
    }
    public void modificarRegistro(String id_cliente, String nombre_cliente, String apellido_paterno, String apellido_materno, String telefono, String rfc, String calle, String colonia, Integer numero_interior, Integer numero_exterior, Integer codigo_postal, String email, String ciudad, String estado) {
        System.out.println("Modificar cliente");
        try {
            String sql = "UPDATE clientes SET nombre_clientes= '" + nombre_cliente + "',apellido_paterno='"+ apellido_paterno +"',apellido_materno='"+apellido_materno+ "',telefono='"+telefono+"',rfc='"+rfc+"',calle='" + calle + "',colonia='" + colonia + "',numero_interior='"+numero_interior+"',numero_exterior='" + numero_exterior + "',codigo_postal='" + codigo_postal + "',email='"+email+"',ciudad='" + ciudad + "',estado='" + estado+"' WHERE id_cliente='" + id_cliente + "';";
            st.executeUpdate(sql);
            this.conectarDB();
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelProveedores 009: " + sql.getMessage());
        }
    }
    public void borrarRegistro(String id_cliente) {
        System.out.println("Eliminar clientes");
        try {
            st.executeUpdate("DELETE FROM clientes WHERE id_cliente = '" + id_cliente + "';");
            this.conectarDB();
        } catch (SQLException sql) {
             JOptionPane.showMessageDialog(null, "Error ModelAgenda 010: " + sql.getMessage());
        }
    }
}
