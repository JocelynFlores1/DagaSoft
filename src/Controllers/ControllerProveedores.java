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
            if (e.getSource() == viewProveedores.jb_primero) {
                jb_primero_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_anterior) {
                jb_anterior_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_siguiente) {
                jb_siguiente_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_ultimo) {
                jb_ultimo_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_nuevo) {
                jb_nuevo_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_insertar) {
                jb_insertar_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_modificar) {
                jb_modificar_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_eliminar) {
                jb_eliminar_actionPerformed();
            }
        }
    };
    /**
     * Constructor de Controlador para unir el ModelProveedores y ViewProveedores
     *
     * @param modelProveedores objeto de tipo ModelAgenda
     * @param viewProveedores objeto de tipo ViewAgenda
     */
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        initComponents();
        setActionListener();
        initDB();
    }
    
    /**
     * Método que llama al método conectarBD del modelo 
     */
    public void initDB() {
        modelProveedores.conectarDB();
        viewProveedores.jtf_id_proveedor.setText(String.valueOf(modelProveedores.getId_proveedor().toString()));
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior().toString());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal().toString());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());       
    }
    
    /**
     * Metodo para inicializar la ViewProveedores
     */
    public void initComponents() {
        viewProveedores.setTitle("DAGASOFT");
        viewProveedores.setResizable(false);
        viewProveedores.setLocationRelativeTo(null);
        viewProveedores.setVisible(true);
        viewProveedores.jb_insertar.setEnabled(false);
        viewProveedores.jtf_id_proveedor.setEnabled(false);
    }
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewProveedores.jb_primero.addActionListener(actionListener);
        viewProveedores.jb_anterior.addActionListener(actionListener);
        viewProveedores.jb_siguiente.addActionListener(actionListener);
        viewProveedores.jb_ultimo.addActionListener(actionListener);
        viewProveedores.jb_nuevo.addActionListener(actionListener);
        viewProveedores.jb_insertar.addActionListener(actionListener);
        viewProveedores.jb_modificar.addActionListener(actionListener);
        viewProveedores.jb_eliminar.addActionListener(actionListener);
    }
    /**
     * Método para ver el primer registro de la tabla proveedores.
     */
    private void jb_primero_actionPerformed() {
        System.out.println("Action del boton jb_primero");
        modelProveedores.moverPrimerRegistro();
        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior().toString());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal().toString());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        //Invoca al metodo moverPrimerRegistro
    }
    /**
     * Método para ver el registro anterior de la tabla proveedores.
     */
    private void jb_anterior_actionPerformed() {
        System.out.println("Action del boton jb_anterior");
        modelProveedores.moverAnteriorRegistro();
        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior().toString());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal().toString());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        //Invoca al metodo moverAnteriorRegistro
    }
    /**
     * Método para ver el último registro de la tabla proveedores.
     */
    private void jb_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelProveedores.moverUltimoRegistro();
        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior().toString());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal().toString());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        //Invoca al metodo moverUltimoRegistro 
    }
     /**
     * Método para ver el siguiente registro de la tabla proveedores.
     */
    private void jb_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelProveedores.moverSiguienteRegistro();
        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre_proveedor.setText(modelProveedores.getNombre_proveedor());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_exterior.setText(modelProveedores.getNumero_exterior().toString());
        viewProveedores.jtf_codigo_postal.setText(modelProveedores.getCodigo_postal().toString());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        //Invoca al metodo moverSiguienteRegistro
    }
    /**
     * Método para ver insertar nuevo registro en la tabla de proveedores.
     */
    private void jb_nuevo_actionPerformed() {
        System.out.println("Accion de boton nuevo registro");
        viewProveedores.jb_insertar.setEnabled(true);
        viewProveedores.jb_modificar.setEnabled(false);
        viewProveedores.jb_eliminar.setEnabled(false);
        viewProveedores.jb_nuevo.setEnabled(false);
        viewProveedores.jb_primero.setEnabled(false);
        viewProveedores.jb_siguiente.setEnabled(false);
        viewProveedores.jb_anterior.setEnabled(false);
        viewProveedores.jb_ultimo.setEnabled(false);
        viewProveedores.jtf_id_proveedor.setText("");
        viewProveedores.jtf_nombre_proveedor.setText("");
        viewProveedores.jtf_calle.setText("");
        viewProveedores.jtf_colonia.setText("");
        viewProveedores.jtf_numero_exterior.setText("");
        viewProveedores.jtf_codigo_postal.setText("");
        viewProveedores.jtf_ciudad.setText("");
        viewProveedores.jtf_telefono.setText("");
        }
    /**
     * Método para guardar nuevo registro en la tabla de proveedores.
     */
    private void jb_insertar_actionPerformed() {
        System.out.println("Accion de boton insertar registro");
        modelProveedores.setId_proveedor(viewProveedores.jtf_id_proveedor.getText());
        modelProveedores.setNombre_proveedor(viewProveedores.jtf_nombre_proveedor.getText());
        modelProveedores.setCalle(viewProveedores.jtf_calle.getText());
        modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
        modelProveedores.setNumero_exterior(Integer.parseInt(viewProveedores.jtf_numero_exterior.getText()));
        modelProveedores.setCodigo_postal(Integer.parseInt(viewProveedores.jtf_codigo_postal.getText()));
        modelProveedores.setCiudad(viewProveedores.jtf_ciudad.getText());
        modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText());
        modelProveedores.nuevoRegistro();

        viewProveedores.jtf_id_proveedor.setText("");
        viewProveedores.jtf_nombre_proveedor.setText("");
        viewProveedores.jtf_calle.setText("");
        viewProveedores.jtf_colonia.setText("");
        viewProveedores.jtf_numero_exterior.setText("");
        viewProveedores.jtf_codigo_postal.setText("");
        viewProveedores.jtf_ciudad.setText("");
        viewProveedores.jtf_telefono.setText("");

        viewProveedores.jb_insertar.setEnabled(false);
        viewProveedores.jb_modificar.setEnabled(true);
        viewProveedores.jb_eliminar.setEnabled(true);
        viewProveedores.jb_nuevo.setEnabled(true);
        viewProveedores.jb_primero.setEnabled(true);
        viewProveedores.jb_siguiente.setEnabled(true);
        viewProveedores.jb_anterior.setEnabled(true);
        viewProveedores.jb_ultimo.setEnabled(true);
        
        JOptionPane.showMessageDialog(null, "El regisro se guardo exitosamente");
    }
    /**
     * Método para modificar un registro en la tabla de proveedores.
     */
    private void jb_modificar_actionPerformed() {
        System.out.println("Accion de boton modificar registro");
        modelProveedores.modificarRegistro(modelProveedores.getId_proveedor(), modelProveedores.getNombre_proveedor(),modelProveedores.getCalle(),modelProveedores.getColonia(),modelProveedores.getNumero_exterior(),modelProveedores.getCodigo_postal(),modelProveedores.getCiudad(),modelProveedores.getTelefono());
        JOptionPane.showMessageDialog(null, "El registro fue modificado correctamente");
    }
    /**
     * Método para eliminar registro en la tabla de proveedores.
     */
    private void jb_eliminar_actionPerformed() {
        System.out.println("Accion de boton eliminar registro");
        modelProveedores.borrarRegistro(Integer.parseInt(viewProveedores.jtf_id_proveedor.getText()));
        jb_primero_actionPerformed();
        JOptionPane.showMessageDialog(null, "El registro se borro correctamente");
    }
    
}
