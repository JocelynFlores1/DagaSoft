/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelConexion;
import Models.ModelGenerarCodigos;
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
    ModelConexion proveedorConexion = new ModelConexion();
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
            } else if (e.getSource() == viewProveedores.jb_eliminar_proveedor) {
                jmi_borrarC_actionListener();
            } else if (e.getSource() == viewProveedores.jb_nuevo) {
                jmi_nuevoP_actionPerformed();
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
        modelProveedores.conectarDB(proveedorConexion);
        jtfCambiarCampos();
        tablaConsulta();
        System.out.println("Solo se inicia si se abre proveedores");
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

            modelProveedores.insertarNuevoProveedor(proveedorConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningún proveedor");
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

            modelProveedores.modificarDatosProveedor(proveedorConexion);
            //Este comando realiza la accion de utlilzar el metodo de modificarDatosCliente usando el objeto construido en de modelProveedores
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableProveedores
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }
    public void jmi_borrarC_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del proveedor?", "Borrar datos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelProveedores.setId_proveedor(viewProveedores.jtf_id_proveedor.getText());
            modelProveedores.borrarDatosCliente(proveedorConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Los datos del proveedor han sido eliminados");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se borro ningun registro");
        }
      }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewProveedores.jtable_proveedores.setModel(modelo);
            modelProveedores.consultajTableProveedores(proveedorConexion);

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

    public void jmi_nuevoP_actionPerformed() {
        codigos();
        viewProveedores.jtf_id_proveedor.setText("");
        viewProveedores.jtf_nombre_proveedor.setText("");
        viewProveedores.jtf_calle.setText("");
        viewProveedores.jtf_numero_exterior.setText("");
        viewProveedores.jtf_colonia.setText("");
        viewProveedores.jtf_codigo_postal.setText("");
        viewProveedores.jtf_telefono.setText("");
        viewProveedores.jtf_email.setText("");
        viewProveedores.jtf_ciudad.setText("");
        viewProveedores.jtf_estado.setText("");
    }
    
    /**
     * Este metodo permite generar codigos automaticamente con una consulta en
     * la base de datos desde models.ModelProveedores.GenerarCodigos
     */
    public void codigos() {

        int j;
        int cont = 1;
        String num = "";
        modelProveedores.consultaGenerarCodigos(proveedorConexion);

        if (modelProveedores.getC() == null) {
            viewProveedores.jtf_id_proveedor.setText("ACME-P0000001");
        } else {
            char r1 = modelProveedores.getC().charAt(6);
            char r2 = modelProveedores.getC().charAt(7);
            char r3 = modelProveedores.getC().charAt(8);
            char r4 = modelProveedores.getC().charAt(9);
            char r5 = modelProveedores.getC().charAt(10);
            char r6 = modelProveedores.getC().charAt(11);
            char r7 = modelProveedores.getC().charAt(12);

            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
            j = Integer.parseInt(r);
            System.out.println(j);
            ModelGenerarCodigos gen = new ModelGenerarCodigos();
            gen.generar(j);
            viewProveedores.jtf_id_proveedor.setText("ACME-P" + gen.serie());
            System.out.println("ACME-P" + gen.serie());
            
        }
    }
}
