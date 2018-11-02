/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelMain;
import Views.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Zeo
 */
public class ControllerMain {

    private final ModelMain modelMain;
    private final ViewMenu viewMenu;

    /**
     * Esta variable almacena los controladores controllerAgenda y
     * controllerDetalleContacto para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];

    private ControllerProveedores controllerProveedores;
    private ControllerClientes controllerClientes;

    /**
     * Controlador principal del proyecto que un el modelMain y viewMain, ademas
     * recibe los controladores controllerAgenda y controllerDetalleContacto
     * dentro del arreglo controllers, con esto se puede tener acceso a toda la
     * programación desarrollada dentro de cada controller.
     *
     * @param modelMain
     * @param viewMenu
     * @param controllers arreglo con todos los controladores del proyecto.
     */
    public ControllerMain(ModelMain modelMain, ViewMenu viewMenu, Object[] controllers) {
        this.modelMain = modelMain;
        this.viewMenu = viewMenu;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponets();
    }

    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos de
     * cada uno.
     */
    private void setControllers() {
        controllerProveedores = (ControllerProveedores) controllers[0];
        controllerClientes = (ControllerClientes) controllers[1];
    }

    /**
     * Muesta la vista principal ViewMain.
     */
    private void initComponets() {
        viewMenu.setTitle("Proveedores");
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setVisible(true);
    }

    /**
     * Asigna el actionListener a cada uno de los JMenuItems de la vista
     * ViewMain.
     */
    private void setActionListener() {
        viewMenu.jmProveedores.addActionListener(actionListener);
        viewMenu.jmClientes.addActionListener(actionListener);
    }

    /**
     * Evalua el componente que genero el evento y llama a un método en
     * particular.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMenu.jmProveedores) {
                jmi_proveedores_actionPerformed();
            } else if (e.getSource() == viewMenu.jmClientes) {
                jmi_clientes_actionPerformed();
            }
        }
    };

    /**
     * 1.- Obtiene los valores de nombre y email del modelAgenda y
     * posteriormente los asigna a las variables nombre y email del
     * modelDetalleContacto,
     *
     * 2.- Muestra en la vista viewDetalleContacto el nombre y email almacenados
     * en el modelDetalleContacto,
     *
     * 3.- Muestra el JPanel ViewDetalleContacto dentro del JFrame ViewMain
     * (incluido todo el funcionamiento programado).
     */
    private void jmi_proveedores_actionPerformed() {
        viewMenu.setContentPane(controllerProveedores.viewProveedores);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Proveedores");
    }

    private void jmi_clientes_actionPerformed() {
        viewMenu.setContentPane(controllerClientes.viewClientes);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Clientes");
    }

    /**
     * Muestra el JPanel ViewAgenda dentro del JFrame ViewMain, (incluido todo
     * el funcionamiendo programado).
     */
    /**
     * Cierra la aplicacion.
     */
    private void jmi_salir_actionPerformed() {
        System.exit(0);
    }
}
