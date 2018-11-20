/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelProveedores;
import Views.ViewProveedores;
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
 * @author Jocelyn
 */
public class ControllerProveedores {

    public Models.ModelProveedores modelProveedores;
    public Views.ViewProveedores viewProveedores;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedores.jb_insertar) {
                jmi_insertarP_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_modificar_proveedor) {
                jmi_modificarP_actionPerformed();
            }
        }
    };

    /**
     * Constructor de Controlador para unir el ModelProveedores y
     * ViewProveedores
     *
     * @param modelProveedores objeto de tipo ModelAgenda
     * @param viewProveedores objeto de tipo ViewAgenda
     */
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        initComponents();
        setActionListener();
        jtfCambiarCampos();

    }

    public void initComponents() {
        viewProveedores.setVisible(true);
        modelProveedores.conectarDB();
        tablaConsulta();
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewProveedores
     */
    public void jtfCambiarCampos() {
        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle_proveedor());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior_proveedor());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia_proveedor());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal_proveedor());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono_proveedor());
        viewProveedores.jtf_email.setText(modelProveedores.getEmail_proveedor());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad_proveedor());
        viewProveedores.jtf_estado.setText(modelProveedores.getEstado_proveedor());
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewProveedores.jb_nuevo.addActionListener(actionListener);
        viewProveedores.jb_insertar.addActionListener(actionListener);
        viewProveedores.jb_cancelar.addActionListener(actionListener);
        viewProveedores.jb_modificar_proveedor.addActionListener(actionListener);
        viewProveedores.jb_eliminar_proveedor.addActionListener(actionListener);
        viewProveedores.jtable_proveedores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                insertarCamposTabla();
            }
        });
    }

    /**
     * *
     * Modelo que permite insertar el texto obenido en los jTextField de
     * ViewClientes e inserta los valores en las variables de ModelProveedores
     */
    public void jmi_insertarP_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo proveedor?", "Guardar proveedor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelProveedores.setId_proveedor(viewProveedores.jtf_id_proveedor.getText());
            modelProveedores.setNombre_proveedor(viewProveedores.jtf_nombre_proveedor.getText());
            modelProveedores.setCalle_proveedor(viewProveedores.jtf_calle.getText());
            modelProveedores.setNumero_exterior_proveedor(viewProveedores.jtf_numero_exterior.getText());
            modelProveedores.setColonia_proveedor(viewProveedores.jtf_colonia.getText());
            modelProveedores.setCodigo_postal_proveedor(viewProveedores.jtf_codigo_postal.getText());
            modelProveedores.setTelefono_proveedor(viewProveedores.jtf_telefono.getText());
            modelProveedores.setEmail_proveedor(viewProveedores.jtf_email.getText());
            modelProveedores.setCiudad_proveedor(viewProveedores.jtf_ciudad.getText());
            modelProveedores.setEstado_proveedor(viewProveedores.jtf_estado.getText());

            modelProveedores.insertarNuevoProveedor();

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningún registro");
        }
    }

    public void jmi_modificarP_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del proveedor?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelProveedores.setId_proveedor(viewProveedores.jtf_id_proveedor.getText());
            modelProveedores.setNombre_proveedor(viewProveedores.jtf_nombre_proveedor.getText());
            modelProveedores.setCalle_proveedor(viewProveedores.jtf_calle.getText());
            modelProveedores.setNumero_exterior_proveedor(viewProveedores.jtf_numero_exterior.getText());
            modelProveedores.setColonia_proveedor(viewProveedores.jtf_colonia.getText());
            modelProveedores.setCodigo_postal_proveedor(viewProveedores.jtf_codigo_postal.getText());
            modelProveedores.setTelefono_proveedor(viewProveedores.jtf_telefono.getText());
            modelProveedores.setEmail_proveedor(viewProveedores.jtf_email.getText());
            modelProveedores.setCiudad_proveedor(viewProveedores.jtf_ciudad.getText());
            modelProveedores.setEstado_proveedor(viewProveedores.jtf_estado.getText());

            modelProveedores.modificarDatosProveedor();

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewProveedores.jtable_proveedores.setModel(modelo);
            modelProveedores.consultajTableProveedores();

            ResultSetMetaData rsMd = modelProveedores.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Calle");
            modelo.addColumn("Número exterior");
            modelo.addColumn("Colonia");
            modelo.addColumn("Codigo postal");
            modelo.addColumn("Telefono");
            modelo.addColumn("Email");
            modelo.addColumn("Ciudad");
            modelo.addColumn("Estado");
            while (modelProveedores.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = modelProveedores.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void insertarCamposTabla() {
        try {
            if (viewProveedores.jtable_proveedores.getSelectedRow() != -1) {
                int fila = viewProveedores.jtable_proveedores.getSelectedRow();

                viewProveedores.jtf_id_proveedor.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 0).toString());
                viewProveedores.jtf_nombre_proveedor.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 1).toString());
                viewProveedores.jtf_calle.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 2).toString());
                viewProveedores.jtf_numero_exterior.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 3).toString());
                viewProveedores.jtf_colonia.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 4).toString());
                viewProveedores.jtf_codigo_postal.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 5).toString());
                viewProveedores.jtf_telefono.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 6).toString());
                viewProveedores.jtf_email.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 7).toString());
                viewProveedores.jtf_ciudad.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 8).toString());
                viewProveedores.jtf_estado.setText(viewProveedores.jtable_proveedores.getValueAt(fila, 9).toString());

            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
}
