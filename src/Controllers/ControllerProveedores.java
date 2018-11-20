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
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Norberto
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
        tablaConsulta();
    }

    public void initComponents() {
        viewProveedores.setVisible(true);
        modelProveedores.conectarDB();
        jtfCambiarCampos();
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewProveedores
     */
    public void jtfCambiarCampos() {
        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle_proveedor());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior_proveedor().toString());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia_proveedor());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal_proveedor().toString());
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
            modelProveedores.setNumero_exterior_proveedor(Integer.parseInt(viewProveedores.jtf_numero_exterior.getText()));
            modelProveedores.setColonia_proveedor(viewProveedores.jtf_colonia.getText());
            modelProveedores.setCodigo_postal_proveedor(Integer.parseInt(viewProveedores.jtf_codigo_postal.getText()));
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
            modelProveedores.setNumero_exterior_proveedor(Integer.parseInt(viewProveedores.jtf_numero_exterior.getText()));
            modelProveedores.setColonia_proveedor(viewProveedores.jtf_colonia.getText());
            modelProveedores.setCodigo_postal_proveedor(Integer.parseInt(viewProveedores.jtf_codigo_postal.getText()));
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
}
