/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelProductos;
import Views.ViewProductos;
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
public class ControllerProductos {

    public Models.ModelProductos modelProductos;
    public Views.ViewProductos viewProductos;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProductos.jb_insertar) {
                jmi_insertarP_actionPerformed();
            } else if (e.getSource() == viewProductos.jb_modificar_producto) {
                jmi_modificarP_actionPerformed();
            }
        }
    };

    /**
     * Constructor de Controlador para unir el ModelProveedores y
     * ViewProveedores
     *
     * @param modelProductos objeto de tipo ModelProductos
     * @param viewProductos objeto de tipo ViewProductos
     */
    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        initComponents();
        setActionListener();
        tablaConsulta();
    }

    public void initComponents() {
        viewProductos.setVisible(true);
        modelProductos.conectarDB();
        jtfCambiarCampos();
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewClientes
     */
    public void jtfCambiarCampos() {
        viewProductos.jtf_id_producto.setText(modelProductos.getId_producto());
        viewProductos.jtf_nombre_producto.setText(modelProductos.getNombre_producto());
        viewProductos.jtf_tipo_producto.setSelectedItem(modelProductos.getTipo_producto());
        viewProductos.jta_Descripcion.setText(modelProductos.getDescripcion_producto());
        viewProductos.jtf_marca.setText(modelProductos.getMarca_producto());
        viewProductos.jtf_precio_venta.setText(modelProductos.getPrecio_venta().toString());
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewProductos.jb_nuevo.addActionListener(actionListener);
        viewProductos.jb_insertar.addActionListener(actionListener);
        viewProductos.jb_cancelar.addActionListener(actionListener);
        viewProductos.jb_modificar_producto.addActionListener(actionListener);
        viewProductos.jb_eliminar_producto.addActionListener(actionListener);
        viewProductos.jtable_productos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                insertarCamposTabla();
            }
        });
    }

    /**
     * *
     * Modelo que permite insertar el texto obenido en los jTextField de
     * ViewClientes e inserta los valores en las variables de ModelProductos
     */
    public void jmi_insertarP_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo producto?", "Guardar producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelProductos.setId_producto(viewProductos.jtf_id_producto.getText());
            modelProductos.setNombre_producto(viewProductos.jtf_nombre_producto.getText());
            modelProductos.setTipo_producto(viewProductos.jtf_tipo_producto.getSelectedItem().toString());
            modelProductos.setDescripcion_producto(viewProductos.jta_Descripcion.getText());
            modelProductos.setMarca_producto(viewProductos.jtf_marca.getText());
            modelProductos.setPrecio_venta(Double.parseDouble(viewProductos.jtf_precio_venta.getText()));

            modelProductos.insertarNuevoCliente();
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "");

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun producto");
        }
    }

    public void jmi_modificarP_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del producto?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelProductos.setId_producto(viewProductos.jtf_id_producto.getText());
            modelProductos.setNombre_producto(viewProductos.jtf_nombre_producto.getText());
            modelProductos.setTipo_producto(viewProductos.jtf_tipo_producto.getSelectedItem().toString());
            modelProductos.setDescripcion_producto(viewProductos.jta_Descripcion.getText());
            modelProductos.setMarca_producto(viewProductos.jtf_marca.getText());
            modelProductos.setPrecio_venta(Double.parseDouble(viewProductos.jtf_precio_venta.getText()));

            modelProductos.modificarDatosProducto();

            tablaConsulta();
            JOptionPane.showMessageDialog(null, "");

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewProductos.jtable_productos.setModel(modelo);
            modelProductos.consultajTableProductos();

            ResultSetMetaData rsMd = modelProductos.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre producto");
            modelo.addColumn("Tipo producto");
            modelo.addColumn("Descripción");
            modelo.addColumn("Marca");
            modelo.addColumn("Precio");
            while (modelProductos.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = modelProductos.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void insertarCamposTabla() {
        try {
            if (viewProductos.jtable_productos.getSelectedRow() != -1) {
                int fila = viewProductos.jtable_productos.getSelectedRow();

                viewProductos.jtf_id_producto.setText(viewProductos.jtable_productos.getValueAt(fila, 0).toString());
                viewProductos.jtf_nombre_producto.setText(viewProductos.jtable_productos.getValueAt(fila, 1).toString());
                viewProductos.jtf_tipo_producto.setSelectedItem(viewProductos.jtable_productos.getValueAt(fila, 2).toString());
                viewProductos.jta_Descripcion.setText(viewProductos.jtable_productos.getValueAt(fila, 3).toString());
                viewProductos.jtf_marca.setText(viewProductos.jtable_productos.getValueAt(fila, 4).toString());
                viewProductos.jtf_precio_venta.setText(viewProductos.jtable_productos.getValueAt(fila, 5).toString());

            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
}
