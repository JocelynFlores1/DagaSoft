/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelClientes;
import Views.ViewClientes;
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
public class ControllerClientes {

    public Models.ModelClientes modelClientes;
    public Views.ViewClientes viewClientes;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewClientes.jb_insertar) {
                jmi_insertarC_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_modificar_cliente) {
                jmi_modificarC_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_eliminar_cliente) {
                jmi_borrarC_actionListener();
            }
        }
    };

    /**
     * Constructor de Controlador para unir el ModelProveedores y
     * ViewProveedores
     *
     * @param modelClientes objeto de tipo ModelAgenda
     * @param viewClientes objeto de tipo ViewAgenda
     */
    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        initComponents();
        setActionListener();
        tablaConsulta();
    }

    public void initComponents() {
        viewClientes.setVisible(true);
        modelClientes.conectarDB();
        jtfCambiarCampos();
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewClientes
     */
    public void jtfCambiarCampos() {
        viewClientes.jtf_id_cliente.setText(modelClientes.getId_cliente());
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre_cliente());
        viewClientes.jtf_apellido_paterno.setText(modelClientes.getApellido_paterno());
        viewClientes.jtf_apellido_materno.setText(modelClientes.getApellido_materno());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_numero_exterior.setText(modelClientes.getNumero_exterior());
        viewClientes.jtf_numero_interior.setText(modelClientes.getNumero_interior());
        viewClientes.jtf_codigo_postal.setText(modelClientes.getCodigo_postal());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewClientes.jb_nuevo.addActionListener(actionListener);
        viewClientes.jb_insertar.addActionListener(actionListener);
        viewClientes.jb_cancelar.addActionListener(actionListener);
        viewClientes.jb_modificar_cliente.addActionListener(actionListener);
        viewClientes.jb_eliminar_cliente.addActionListener(actionListener);
        viewClientes.jtable_clientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
    public void jmi_insertarC_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo cliente?", "Guardar cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelClientes.setId_cliente(viewClientes.jtf_id_cliente.getText());
            modelClientes.setNombre_cliente(viewClientes.jtf_nombre_cliente.getText());
            modelClientes.setApellido_paterno(viewClientes.jtf_apellido_paterno.getText());
            modelClientes.setApellido_materno(viewClientes.jtf_apellido_materno.getText());
            modelClientes.setTelefono(viewClientes.jtf_telefono.getText());
            modelClientes.setRfc(viewClientes.jtf_rfc.getText());
            modelClientes.setCalle(viewClientes.jtf_calle.getText());
            modelClientes.setColonia(viewClientes.jtf_colonia.getText());
            modelClientes.setNumero_exterior(viewClientes.jtf_numero_exterior.getText());
            modelClientes.setNumero_interior(viewClientes.jtf_numero_interior.getText());
            modelClientes.setCodigo_postal(viewClientes.jtf_codigo_postal.getText());
            modelClientes.setEmail(viewClientes.jtf_email.getText());
            modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
            modelClientes.setEstado(viewClientes.jtf_estado.getText());

            modelClientes.insertarNuevoCliente();
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cliente");
        }
    }

    public void jmi_modificarC_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del cliente?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelClientes.setId_cliente(viewClientes.jtf_id_cliente.getText());
            modelClientes.setNombre_cliente(viewClientes.jtf_nombre_cliente.getText());
            modelClientes.setApellido_paterno(viewClientes.jtf_apellido_paterno.getText());
            modelClientes.setApellido_materno(viewClientes.jtf_apellido_materno.getText());
            modelClientes.setTelefono(viewClientes.jtf_telefono.getText());
            modelClientes.setRfc(viewClientes.jtf_rfc.getText());
            modelClientes.setCalle(viewClientes.jtf_calle.getText());
            modelClientes.setColonia(viewClientes.jtf_colonia.getText());
            modelClientes.setNumero_exterior(viewClientes.jtf_numero_exterior.getText());
            modelClientes.setNumero_interior(viewClientes.jtf_numero_interior.getText());
            modelClientes.setCodigo_postal(viewClientes.jtf_codigo_postal.getText());
            modelClientes.setEmail(viewClientes.jtf_email.getText());
            modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
            modelClientes.setEstado(viewClientes.jtf_estado.getText());

            modelClientes.modificarDatosCliente();
            //Este comando realiza la accion de utlilzar el metodo de modificarDatosCliente usando el objeto construido en de modelClientes
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableClientes

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }

    public void jmi_borrarC_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del cliente?", "Borrar cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelClientes.setId_cliente(viewClientes.jtf_id_cliente.getText());
            modelClientes.borrarDatosCliente();
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Los datos del cliente han sido eliminados");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se borro ningun registro");
        }
    }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewClientes.jtable_clientes.setModel(modelo);
            modelClientes.consultajTableClientes();

            ResultSetMetaData rsMd = modelClientes.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Ap. Paterno");
            modelo.addColumn("Ap. Materno");
            modelo.addColumn("Telefono");
            modelo.addColumn("RFC");
            modelo.addColumn("Calle");
            modelo.addColumn("Colonia");
            modelo.addColumn("No. exterior");
            modelo.addColumn("No. Interior");
            modelo.addColumn("C. postal");
            modelo.addColumn("Email");
            modelo.addColumn("Ciudad");
            modelo.addColumn("Estado");
            while (modelClientes.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = modelClientes.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    //Metodo que permite insertar todos los datos de la tabla en 
    public void insertarCamposTabla() {
        try {
            if (viewClientes.jtable_clientes.getSelectedRow() != -1) {
                int fila = viewClientes.jtable_clientes.getSelectedRow();

                viewClientes.jtf_id_cliente.setText(viewClientes.jtable_clientes.getValueAt(fila, 0).toString());
                viewClientes.jtf_nombre_cliente.setText(viewClientes.jtable_clientes.getValueAt(fila, 1).toString());
                viewClientes.jtf_apellido_paterno.setText(viewClientes.jtable_clientes.getValueAt(fila, 2).toString());
                viewClientes.jtf_apellido_materno.setText(viewClientes.jtable_clientes.getValueAt(fila, 3).toString());
                viewClientes.jtf_telefono.setText(viewClientes.jtable_clientes.getValueAt(fila, 4).toString());
                viewClientes.jtf_rfc.setText(viewClientes.jtable_clientes.getValueAt(fila, 5).toString());
                viewClientes.jtf_calle.setText(viewClientes.jtable_clientes.getValueAt(fila, 6).toString());
                viewClientes.jtf_colonia.setText(viewClientes.jtable_clientes.getValueAt(fila, 7).toString());
                viewClientes.jtf_numero_exterior.setText(viewClientes.jtable_clientes.getValueAt(fila, 8).toString());
                viewClientes.jtf_numero_interior.setText(viewClientes.jtable_clientes.getValueAt(fila, 9).toString());
                viewClientes.jtf_codigo_postal.setText(viewClientes.jtable_clientes.getValueAt(fila, 10).toString());
                viewClientes.jtf_email.setText(viewClientes.jtable_clientes.getValueAt(fila, 11).toString());
                viewClientes.jtf_ciudad.setText(viewClientes.jtable_clientes.getValueAt(fila, 12).toString());
                viewClientes.jtf_estado.setText(viewClientes.jtable_clientes.getValueAt(fila, 13).toString());
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
}
