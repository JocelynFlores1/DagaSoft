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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
        initComponents();
        tablaConsulta();
        setActionListener();
    }

    public void initComponents() {
        viewEmpleados.setVisible(true);
        modelEmpleados.conectarDB();
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
        viewEmpleados.jtf_codigo_postal_empleado.setText(modelEmpleados.getCodigo_postal());
        viewEmpleados.jtf_sucursal_empleado.setText(modelEmpleados.getId_sucursal());
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
        viewEmpleados.jt_Empleados.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                insertarCamposTabla();
            }
        });
    }

    /**
     * *
     * Modelo que permite insertar el texto obenido en los jTextField de
     * ViewClientes e inserta los valores en las variables de ModelClientes
     */
    public void jmi_insertarE() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo empleado?", "Guardar empleado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelEmpleados.setId_empleado(viewEmpleados.jtf_id_empleado.getText());
            modelEmpleados.setNombre_empleado(viewEmpleados.jtf_nombre_empleado.getText());
            modelEmpleados.setApellido_paterno(viewEmpleados.jtf_apellido_paterno_empleado.getText());
            modelEmpleados.setApellido_materno(viewEmpleados.jtf_apellido_materno_empleado.getText());
            modelEmpleados.setTelefono(viewEmpleados.jtf_telefono_empleado.getText());
            modelEmpleados.setCalle(viewEmpleados.jtf_calle_empleado.getText());
            modelEmpleados.setColonia(viewEmpleados.jtf_colonia_empleado.getText());
            modelEmpleados.setNumero_exterior(viewEmpleados.jtf_numero_exterior_empleado.getText());
            modelEmpleados.setNumero_interior(viewEmpleados.jtf_no_interior_empleado.getText());
            modelEmpleados.setRfc(viewEmpleados.jtf_rfc_empleado.getText());
            modelEmpleados.setNo_cueta(viewEmpleados.jtf_no_cueta_empleado.getText());
            modelEmpleados.setNo_seguro(viewEmpleados.jtf_no_seguro_empleado.getText());
            modelEmpleados.setBanco(viewEmpleados.jtf_banco_empleado.getText());
            modelEmpleados.setCurp(viewEmpleados.jtf_curp.getText());
            modelEmpleados.setTipo_empleado(viewEmpleados.jtf_tipo_empleado.getText());
            modelEmpleados.setUsuario(viewEmpleados.jtf_usuario_empleado.getText());
            modelEmpleados.setContrasena(viewEmpleados.jtf_contrasena.getText());
            modelEmpleados.setCodigo_postal(viewEmpleados.jtf_codigo_postal_empleado.getText());

            modelEmpleados.insertarNuevoEmpleado();

            JOptionPane.showMessageDialog(null, "Nuevo empleado registrado");
            tablaConsulta();
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun empleado");
        }
    }

    public void jmi_modificar() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del empleado?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelEmpleados.setId_empleado(viewEmpleados.jtf_id_empleado.getText());
            modelEmpleados.setNombre_empleado(viewEmpleados.jtf_nombre_empleado.getText());
            modelEmpleados.setApellido_paterno(viewEmpleados.jtf_apellido_paterno_empleado.getText());
            modelEmpleados.setApellido_materno(viewEmpleados.jtf_apellido_materno_empleado.getText());
            modelEmpleados.setTelefono(viewEmpleados.jtf_telefono_empleado.getText());
            modelEmpleados.setCalle(viewEmpleados.jtf_calle_empleado.getText());
            modelEmpleados.setColonia(viewEmpleados.jtf_colonia_empleado.getText());
            modelEmpleados.setNumero_exterior(viewEmpleados.jtf_numero_exterior_empleado.getText());
            modelEmpleados.setNumero_interior(viewEmpleados.jtf_no_interior_empleado.getText());
            modelEmpleados.setRfc(viewEmpleados.jtf_rfc_empleado.getText());
            modelEmpleados.setBanco(viewEmpleados.jtf_banco_empleado.getText());
            modelEmpleados.setCurp(viewEmpleados.jtf_curp.getText());
            modelEmpleados.setNo_cueta(viewEmpleados.jtf_no_cueta_empleado.getText());
            modelEmpleados.setNo_seguro(viewEmpleados.jtf_no_seguro_empleado.getText());
            modelEmpleados.setTipo_empleado(viewEmpleados.jtf_tipo_empleado.getText());
            modelEmpleados.setUsuario(viewEmpleados.jtf_usuario_empleado.getText());
            modelEmpleados.setContrasena(viewEmpleados.jtf_contrasena.getText());
            modelEmpleados.setCodigo_postal(viewEmpleados.jtf_codigo_postal_empleado.getText());

            modelEmpleados.modificarDatosEmpleado();

            JOptionPane.showMessageDialog(null, "Datos del empleado modificados");
            tablaConsulta();

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewEmpleados.jt_Empleados.setModel(modelo);
            modelEmpleados.consultajt_empleado();

            ResultSetMetaData rsMd = modelEmpleados.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Ap. Paterno");
            modelo.addColumn("Ap. Materno");
            modelo.addColumn("Calle");
            modelo.addColumn("Colonia");
            modelo.addColumn("No. exterior");
            modelo.addColumn("No. Interior");
            modelo.addColumn("RFC");
            modelo.addColumn("Telefono");
            modelo.addColumn("CURP");
            modelo.addColumn("No. cueta");
            modelo.addColumn("No. seguro ");
            modelo.addColumn("Banco");
            modelo.addColumn("Tipo. empleado");
            modelo.addColumn("Usuario");
            modelo.addColumn("Contrasena");
            modelo.addColumn("Sucursal");
            modelo.addColumn("C. postal");
            
            while (modelEmpleados.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = modelEmpleados.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void insertarCamposTabla() {
        try {
            if (viewEmpleados.jt_Empleados.getSelectedRow() != -1) {
                int fila = viewEmpleados.jt_Empleados.getSelectedRow();

                viewEmpleados.jtf_id_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 0).toString());
                viewEmpleados.jtf_nombre_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 1).toString());
                viewEmpleados.jtf_apellido_paterno_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 2).toString());
                viewEmpleados.jtf_apellido_materno_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 3).toString());
                viewEmpleados.jtf_calle_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 4).toString());
                viewEmpleados.jtf_colonia_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 5).toString());
                viewEmpleados.jtf_numero_exterior_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 6).toString());
                viewEmpleados.jtf_no_interior_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 7).toString());
                viewEmpleados.jtf_rfc_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 8).toString());
                viewEmpleados.jtf_telefono_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 9).toString());
                viewEmpleados.jtf_curp.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 10).toString());
                viewEmpleados.jtf_no_cueta_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 11).toString());
                viewEmpleados.jtf_no_seguro_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 12).toString());
                viewEmpleados.jtf_banco_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 13).toString());
                viewEmpleados.jtf_tipo_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 14).toString());
                viewEmpleados.jtf_usuario_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 15).toString());
                viewEmpleados.jtf_contrasena.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 16).toString());
                viewEmpleados.jtf_sucursal_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 18).toString());
                viewEmpleados.jtf_codigo_postal_empleado.setText(viewEmpleados.jt_Empleados.getValueAt(fila, 17).toString());
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }

    public void jmi_nuevo() {
        viewEmpleados.jtf_id_empleado.setText("");
        viewEmpleados.jtf_nombre_empleado.setText("");
        viewEmpleados.jtf_apellido_paterno_empleado.setText("");
        viewEmpleados.jtf_apellido_materno_empleado.setText("");
        viewEmpleados.jtf_telefono_empleado.setText("");
        viewEmpleados.jtf_calle_empleado.setText("");
        viewEmpleados.jtf_colonia_empleado.setText("");
        viewEmpleados.jtf_numero_exterior_empleado.setText("");
        viewEmpleados.jtf_no_interior_empleado.setText("");
        viewEmpleados.jtf_rfc_empleado.setText("");
        viewEmpleados.jtf_no_cueta_empleado.setText("");
        viewEmpleados.jtf_no_seguro_empleado.setText("");
        viewEmpleados.jtf_banco_empleado.setText("");
        viewEmpleados.jtf_curp.setText("");
        viewEmpleados.jtf_tipo_empleado.setText("");
        viewEmpleados.jtf_usuario_empleado.setText("");
        viewEmpleados.jtf_contrasena.setText("");
        viewEmpleados.jtf_codigo_postal_empleado.setText("");
        viewEmpleados.jtf_sucursal_empleado.setText("");

    }

    public void jmi_eliminar() {

    }
}
