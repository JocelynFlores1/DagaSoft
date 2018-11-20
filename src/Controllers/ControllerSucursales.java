/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelSucursales;
import Views.ViewSucursales;
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
public class ControllerSucursales {

    public Models.ModelSucursales modelSucursales;
    public Views.ViewSucursales viewSucursales;

    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        setActionListener();
        initComponents();
        tablaConsulta();
        
    }

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewSucursales.jb_insertar) {
                jmi_insertarC_actionPerformed();
            } else if (e.getSource() == viewSucursales.jb_modificar) {
                jmi_modificarC_actionPerformed();
            }
        }
    };

    /**
     * Constructor de Controlador para unir el ModelProveedores y
     * ViewProveedores
     *
     */
    public void initComponents() {
        viewSucursales.setVisible(true);
        modelSucursales.conectarDB();
        jtfCambiarCampos();
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewClientes
     */
    public void jtfCambiarCampos() {
        viewSucursales.jtf_id_sucursal.setText(modelSucursales.getIdSucursal());
        viewSucursales.jtf_nombre_sucursal.setText(modelSucursales.getNombreSucursal());
        viewSucursales.jtf_calle_sucursal.setText(modelSucursales.getCalleSucursal());
        viewSucursales.jtf_colonia_sucursal.setText(modelSucursales.getColoniaSucursal());
        viewSucursales.jtf_numero_exterior_sucursal.setText(modelSucursales.getNumeroexteriorSucursal());
        viewSucursales.jtf_ciudad_sucursal.setText(modelSucursales.getCiudadSucursal());
        viewSucursales.jtf_telefono_sucursal.setText(modelSucursales.getTelefonoSucursal());
        viewSucursales.jtf_codigo_postal_sucursal.setText(modelSucursales.getCodigopostalSucursal());

    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewSucursales.jb_insertar.addActionListener(actionListener);
        viewSucursales.jb_nuevo.addActionListener(actionListener);
        viewSucursales.jb_eliminar.addActionListener(actionListener);
        viewSucursales.jb_modificar.addActionListener(actionListener);
        viewSucursales.jt_sucursales.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar una nuevo sucursal?", "Guardar sucursal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {

            modelSucursales.setIdSucursal(viewSucursales.jtf_id_sucursal.getText());
            modelSucursales.setNombreSucursal(viewSucursales.jtf_nombre_sucursal.getText());
            modelSucursales.setCalleSucursal(viewSucursales.jtf_calle_sucursal.getText());
            modelSucursales.setColoniaSucursal(viewSucursales.jtf_colonia_sucursal.getText());
            modelSucursales.setNumeroexteriorSucursal(viewSucursales.jtf_numero_exterior_sucursal.getText());
            modelSucursales.setCiudadSucursal(viewSucursales.jtf_ciudad_sucursal.getText());
            modelSucursales.setTelefonoSucursal(viewSucursales.jtf_telefono_sucursal.getText());
            modelSucursales.setCodigopostalSucursal(viewSucursales.jtf_codigo_postal_sucursal.getText());

            modelSucursales.insertarNuevoSucursal();

            tablaConsulta();
            JOptionPane.showMessageDialog(null, "La nueva sucursal se ha almacenado");

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ninguna sucursal");
        }
    }

    public void jmi_modificarC_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos de la sucursal?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelSucursales.setIdSucursal(viewSucursales.jtf_id_sucursal.getText());
            modelSucursales.setNombreSucursal(viewSucursales.jtf_nombre_sucursal.getText());
            modelSucursales.setCalleSucursal(viewSucursales.jtf_calle_sucursal.getText());
            modelSucursales.setColoniaSucursal(viewSucursales.jtf_colonia_sucursal.getText());
            modelSucursales.setNumeroexteriorSucursal(viewSucursales.jtf_numero_exterior_sucursal.getText());
            modelSucursales.setCiudadSucursal(viewSucursales.jtf_ciudad_sucursal.getText());
            modelSucursales.setTelefonoSucursal(viewSucursales.jtf_telefono_sucursal.getText());
            modelSucursales.setCodigopostalSucursal(viewSucursales.jtf_codigo_postal_sucursal.getText());

            modelSucursales.modificarDatosSucursal();

            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Se actualizaron los datos");

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewSucursales.jt_sucursales.setModel(modelo);
            modelSucursales.consultajTableSucursal();

            ResultSetMetaData rsMd = modelSucursales.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Calle");
            modelo.addColumn("Colonia");
            modelo.addColumn("No. Exterior");
            modelo.addColumn("Ciudad");
            modelo.addColumn("Telefono");
            modelo.addColumn("C. postal");

            while (modelSucursales.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = modelSucursales.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void insertarCamposTabla() {
        try {
            if (viewSucursales.jt_sucursales.getSelectedRow() != -1) {
                int fila = viewSucursales.jt_sucursales.getSelectedRow();

                viewSucursales.jtf_id_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 0).toString());
                viewSucursales.jtf_nombre_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 1).toString());
                viewSucursales.jtf_calle_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 2).toString());
                viewSucursales.jtf_colonia_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 3).toString());
                viewSucursales.jtf_numero_exterior_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 4).toString());
                viewSucursales.jtf_ciudad_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 5).toString());
                viewSucursales.jtf_telefono_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 6).toString());
                viewSucursales.jtf_codigo_postal_sucursal.setText(viewSucursales.jt_sucursales.getValueAt(fila, 7).toString());

            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }

}
