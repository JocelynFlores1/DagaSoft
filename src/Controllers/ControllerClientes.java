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
import javax.swing.JOptionPane;

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
            if (e.getSource() == viewClientes.jb_primero) {
                jb_primero_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_anterior) {
                jb_anterior_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_siguiente) {
                jb_siguiente_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_ultimo) {
                jb_ultimo_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_nuevo) {
                jb_nuevo_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_insertar) {
                jb_insertar_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_modificar) {
                jb_modificar_actionPerformed();
            } else if (e.getSource() == viewClientes.jb_eliminar) {
                jb_eliminar_actionPerformed();
            }
        }
    };
    /**
     * Constructor de Controlador para unir el ModelProveedores y ViewProveedores
     *
     * @param modelClientes objeto de tipo ModelAgenda
     * @param viewClientes objeto de tipo ViewAgenda
     */
    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        initComponents();
        setActionListener();
        initDB();
    }
    /**
     * Método que llama al método conectarBD del modelo 
     */
    public void initDB() {
        modelClientes.conectarDB();
        viewClientes.jtf_id_cliente.setText(String.valueOf(modelClientes.getId_cliente().toString()));
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre_cliente());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_exterior.setText(modelClientes.getNumero_exterior().toString());
        viewClientes.jtf_codigo_postal.setText(modelClientes.getCodigo_postal().toString());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());       
    }
    /**
     * Metodo para inicializar la ViewProveedores
     */
    public void initComponents() {
        viewClientes.setTitle("DAGASOFT");
        viewClientes.setResizable(false);
        viewClientes.setLocationRelativeTo(null);
        viewClientes.setVisible(true);
        viewClientes.jb_insertar.setEnabled(false);
        viewClientes.jtf_id_cliente.setEnabled(false);
    }
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewClientes.jb_primero.addActionListener(actionListener);
        viewClientes.jb_anterior.addActionListener(actionListener);
        viewClientes.jb_siguiente.addActionListener(actionListener);
        viewClientes.jb_ultimo.addActionListener(actionListener);
        viewClientes.jb_nuevo.addActionListener(actionListener);
        viewClientes.jb_insertar.addActionListener(actionListener);
        viewClientes.jb_modificar.addActionListener(actionListener);
        viewClientes.jb_eliminar.addActionListener(actionListener);
    }
    /**
     * Método para ver el primer registro de la tabla clientes.
     */
    private void jb_primero_actionPerformed() {
        System.out.println("Action del boton jb_primero");
        modelClientes.moverPrimerRegistro();
        viewClientes.jtf_id_cliente.setText(modelClientes.getId_cliente());
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre_cliente());
        viewClientes.jtf_apellido_paterno.setText(modelClientes.getApellido_paterno());
        viewClientes.jtf_apellido_materno.setText(modelClientes.getApellido_materno());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_interior.setText(modelClientes.getNumero_interior().toString());
        viewClientes.jtf_numero_exterior.setText(modelClientes.getNumero_exterior().toString());
        viewClientes.jtf_codigo_postal.setText(modelClientes.getCodigo_postal().toString());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        //Invoca al metodo moverPrimerRegistro
    }
    /**
     * Método para ver el registro anterior de la tabla clientes.
     */
    private void jb_anterior_actionPerformed() {
        System.out.println("Action del boton jb_anterior");
        modelClientes.moverAnteriorRegistro();
        viewClientes.jtf_id_cliente.setText(modelClientes.getId_cliente());
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre_cliente());
        viewClientes.jtf_apellido_paterno.setText(modelClientes.getApellido_paterno());
        viewClientes.jtf_apellido_materno.setText(modelClientes.getApellido_materno());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_interior.setText(modelClientes.getNumero_interior().toString());
        viewClientes.jtf_numero_exterior.setText(modelClientes.getNumero_exterior().toString());
        viewClientes.jtf_codigo_postal.setText(modelClientes.getCodigo_postal().toString());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        //Invoca al metodo moverAnteriorRegistro
    }
    /**
     * Método para ver el último registro de la tabla clientes.
     */
    private void jb_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelClientes.moverUltimoRegistro();
        viewClientes.jtf_id_cliente.setText(modelClientes.getId_cliente());
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre_cliente());
        viewClientes.jtf_apellido_paterno.setText(modelClientes.getApellido_paterno());
        viewClientes.jtf_apellido_materno.setText(modelClientes.getApellido_materno());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_interior.setText(modelClientes.getNumero_interior().toString());
        viewClientes.jtf_numero_exterior.setText(modelClientes.getNumero_exterior().toString());
        viewClientes.jtf_codigo_postal.setText(modelClientes.getCodigo_postal().toString());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        //Invoca al metodo moverUltimoRegistro 
    }
    /**
     * Método para ver el siguiente registro de la tabla proveedores.
     */
    private void jb_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelClientes.moverSiguienteRegistro();
        viewClientes.jtf_id_cliente.setText(modelClientes.getId_cliente());
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre_cliente());
        viewClientes.jtf_apellido_paterno.setText(modelClientes.getApellido_paterno());
        viewClientes.jtf_apellido_materno.setText(modelClientes.getApellido_materno());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_interior.setText(modelClientes.getNumero_interior().toString());
        viewClientes.jtf_numero_exterior.setText(modelClientes.getNumero_exterior().toString());
        viewClientes.jtf_codigo_postal.setText(modelClientes.getCodigo_postal().toString());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        //Invoca al metodo moverSiguienteRegistro
    }
    /**
     * Método para ver insertar nuevo registro en la tabla de proveedores.
     */
    private void jb_nuevo_actionPerformed() {
        System.out.println("Accion de boton nuevo registro");
        viewClientes.jb_insertar.setEnabled(true);
        viewClientes.jb_modificar.setEnabled(false);
        viewClientes.jb_eliminar.setEnabled(false);
        viewClientes.jb_nuevo.setEnabled(false);
        viewClientes.jb_primero.setEnabled(false);
        viewClientes.jb_siguiente.setEnabled(false);
        viewClientes.jb_anterior.setEnabled(false);
        viewClientes.jb_ultimo.setEnabled(false);
        viewClientes.jtf_id_cliente.setText("");
        viewClientes.jtf_nombre_cliente.setText("");
        viewClientes.jtf_apellido_paterno.setText("");
        viewClientes.jtf_apellido_materno.setText("");
        viewClientes.jtf_telefono.setText("");
        viewClientes.jtf_rfc.setText("");
        viewClientes.jtf_calle.setText("");
        viewClientes.jtf_colonia.setText("");
        viewClientes.jtf_numero_interior.setText("");
        viewClientes.jtf_numero_exterior.setText("");
        viewClientes.jtf_codigo_postal.setText("");
        viewClientes.jtf_email.setText("");
        viewClientes.jtf_ciudad.setText("");
        viewClientes.jtf_estado.setText("");
        }
    /**
     * Método para guardar nuevo registro en la tabla de proveedores.
     */
    private void jb_insertar_actionPerformed() {
        System.out.println("Accion de boton insertar registro");
        modelClientes.setId_cliente(viewClientes.jtf_id_cliente.getText());
        modelClientes.setNombre_cliente(viewClientes.jtf_nombre_cliente.getText());
        modelClientes.setApellido_paterno(viewClientes.jtf_apellido_paterno.getText());
        modelClientes.setApellido_materno(viewClientes.jtf_apellido_materno.getText());
        modelClientes.setTelefono(viewClientes.jtf_telefono.getText());
        modelClientes.setRfc(viewClientes.jtf_rfc.getText());
        modelClientes.setCalle(viewClientes.jtf_calle.getText());
        modelClientes.setColonia(viewClientes.jtf_colonia.getText());
        modelClientes.setNumero_interior(Integer.parseInt(viewClientes.jtf_numero_interior.getText()));
        modelClientes.setNumero_exterior(Integer.parseInt(viewClientes.jtf_numero_exterior.getText()));
        modelClientes.setCodigo_postal(Integer.parseInt(viewClientes.jtf_codigo_postal.getText()));
        modelClientes.setEmail(viewClientes.jtf_email.getText());
        modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
        modelClientes.setEstado(viewClientes.jtf_estado.getText());
        
        modelClientes.nuevoRegistro();
        
        viewClientes.jtf_id_cliente.setText("");
        viewClientes.jtf_nombre_cliente.setText("");
        viewClientes.jtf_apellido_paterno.setText("");
        viewClientes.jtf_apellido_materno.setText("");
        viewClientes.jtf_telefono.setText("");
        viewClientes.jtf_rfc.setText("");
        viewClientes.jtf_calle.setText("");
        viewClientes.jtf_colonia.setText("");
        viewClientes.jtf_numero_interior.setText("");
        viewClientes.jtf_numero_exterior.setText("");
        viewClientes.jtf_codigo_postal.setText("");
        viewClientes.jtf_email.setText("");
        viewClientes.jtf_ciudad.setText("");
        viewClientes.jtf_estado.setText("");

        viewClientes.jb_insertar.setEnabled(false);
        viewClientes.jb_modificar.setEnabled(true);
        viewClientes.jb_eliminar.setEnabled(true);
        viewClientes.jb_nuevo.setEnabled(true);
        viewClientes.jb_primero.setEnabled(true);
        viewClientes.jb_siguiente.setEnabled(true);
        viewClientes.jb_anterior.setEnabled(true);
        viewClientes.jb_ultimo.setEnabled(true);
        
        JOptionPane.showMessageDialog(null, "El regisro se guardo exitosamente");
    }
    /**
     * Método para modificar un registro en la tabla de proveedores.
     */
    private void jb_modificar_actionPerformed() {
        System.out.println("Accion de boton modificar registro");
        modelClientes.modificarRegistro(modelClientes.getId_cliente(), modelClientes.getNombre_cliente(),modelClientes.getApellido_paterno(),modelClientes.getApellido_materno(),modelClientes.getTelefono(),modelClientes.getRfc(),modelClientes.getCalle(),modelClientes.getColonia(),modelClientes.getNumero_interior(),modelClientes.getNumero_exterior(),modelClientes.getCodigo_postal(),modelClientes.getEmail(),modelClientes.getCiudad(),modelClientes.getEstado());
        JOptionPane.showMessageDialog(null, "El registro fue modificado correctamente");
    }
    /**
     * Método para eliminar registro en la tabla de proveedores.
     */
    private void jb_eliminar_actionPerformed() {
        System.out.println("Accion de boton eliminar registro");
        modelClientes.borrarRegistro(viewClientes.jtf_id_cliente.getText());
        jb_primero_actionPerformed();
        JOptionPane.showMessageDialog(null, "El registro se borro correctamente");
    }
    
}
