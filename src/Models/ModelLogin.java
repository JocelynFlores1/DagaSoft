/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Norberto
 */
public class ModelLogin {

    private String user;
    private String password;
    private String tipoUsuario;
    private String sucursal;

    private java.sql.Connection conexion;
    private Statement st;
    private ResultSet rs;
    private java.sql.PreparedStatement ps;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Connection getConexion() {
        return conexion;
    }

    public void setConexion(java.sql.Connection conexion) {
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

    public java.sql.PreparedStatement getPs() {
        return ps;
    }

    public void setPs(java.sql.PreparedStatement ps) {
        this.ps = ps;
    }

    public boolean login() { //Se valida si un Usuario existe para negar el registro

        ModelConexion loginConexion = new ModelConexion();
        loginConexion.getConexion();

        String sql = "SELECT usuario_empleado, contrasena_empleado, id_sucursal, tipo_empleado FROM empleados WHERE usuario_empleado  = ?";
        String sqlDos = "SELECT nombre_sucursal FROM sucursal WHERE id_sucursal  = ?";
        try {

            ps = (PreparedStatement) loginConexion.getConexion().prepareStatement(sql);

            ps.setString(1, getUser());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (getPassword().equals(rs.getString(2))) {
                    setUser(rs.getString(1));
                    setTipoUsuario(rs.getString(4));
                    setSucursal(rs.getString(3));

                    PreparedStatement psDos = (PreparedStatement) loginConexion.getConexion().prepareStatement(sqlDos);
                    psDos.setString(1, getSucursal());
                    ResultSet rsDos = psDos.executeQuery();

                    if (rsDos.next()) {
                        setSucursal(rsDos.getString(1));
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 01: Login user" + ex);
            return false;
        }
    }
}
