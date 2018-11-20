/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelEmpleados;
import Views.ViewEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author beto
 */
public class ControllerEmpleados {

    public Models.ModelEmpleados modelEmpleados;
    public Views.ViewEmpleados viewEmpleados;

    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
        jtfCambiarCampos();
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewClientes
     */
    public void jtfCambiarCampos() {
        viewEmpleados.jtf_id_empleado.setText(modelEmpleados.getId_empleado());
        viewEmpleados.jtf_nombre_empleado.setText(modelEmpleados.getNombre_empleado());
        viewEmpleados.jtf_apellido_paterno_empleado.setText(modelEmpleados.getApellido_paterno());
        viewEmpleados.jtf_apellido_materno_empleado.setText(modelEmpleados.getApellido_materno());
        viewEmpleados.jtf_telefono_empleado.setText(modelEmpleados.getTelefono());
        viewEmpleados.jtf_calle_empleado.setText(modelEmpleados.getCalle());
        viewEmpleados.jtf_colonia_empleado.setText(modelEmpleados.getColonia());
        viewEmpleados.jtf_numero_exterior_empleado.setText(modelEmpleados.getNumero_exterior());
        viewEmpleados.jtf_no_interior_empleado.setText(modelEmpleados.getNumero_interior());
        viewEmpleados.jtf_rfc_empleado.setText(modelEmpleados.getRfc());
        viewEmpleados.jtf_no_cueta_empleado.setText(modelEmpleados.getNo_cueta());
        viewEmpleados.jtf_no_seguro_empleado.setText(modelEmpleados.getNo_seguro());
        viewEmpleados.jtf_banco_empleado.setText(modelEmpleados.getBanco());
        viewEmpleados.jtf_curp.setText(modelEmpleados.getCurp());
        viewEmpleados.jtf_tipo_empleado.setText(modelEmpleados.getTipo_empleado());
        viewEmpleados.jtf_usuario_empleado.setText(modelEmpleados.getUsuario());
        viewEmpleados.jtf_contrasena.setText(modelEmpleados.getContrasena());
        viewEmpleados.jtf_no_interior_empleado.setText(modelEmpleados.getCodigo_postal());
    }
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewEmpleados.jb_nuevo) {
                jmi_nuevo();
            }
            if (e.getSource() == viewEmpleados.jb_modificar) {
                jmi_modificar();
            }
            if (e.getSource() == viewEmpleados.jb_insertar) {
                jmi_insertarE();
            }
            if (e.getSource() == viewEmpleados.jb_eliminar) {
                jmi_eliminar();
            } else if (e.getSource() == viewEmpleados.jb_cancelar) {

            }
        }
    };

    public void setActionListener() {
        viewEmpleados.jb_nuevo.addActionListener(actionListener);
        viewEmpleados.jb_cancelar.addActionListener(actionListener);
        viewEmpleados.jb_modificar.addActionListener(actionListener);
        viewEmpleados.jb_insertar.addActionListener(actionListener);
        viewEmpleados.jb_eliminar.addActionListener(actionListener);
    }
}
