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

    }

    public void initComponents() {
        viewClientes.setVisible(true);
        viewClientes.jb_insertar.setEnabled(false);
        viewClientes.jtf_id_cliente.setEnabled(false);
        modelClientes.conectarDB();
        jtfCambiarCampos();
    }

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
    }
}
