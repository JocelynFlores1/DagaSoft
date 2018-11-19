/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelLogin;
import Models.ModelMain;
import Views.ViewLogin;
import Views.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.Main;

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
    private ControllerCompras controllerCompras;
    private ControllerEmpleados controllerEmpleados;
    private ControllerProductos controllerProductos;
    private ControllerSucursales controllerSucursales;
    private ControllerInicio controllerInicio;

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
        setMouseListener();
        initComponets();
    }

    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos de
     * cada uno.
     */
    private void setControllers() {
        controllerInicio = (ControllerInicio) controllers[0];
        controllerProveedores = (ControllerProveedores) controllers[1];
        controllerClientes = (ControllerClientes) controllers[2];
        controllerCompras = (ControllerCompras) controllers[3];
        controllerEmpleados = (ControllerEmpleados) controllers[4];
        controllerProductos = (ControllerProductos) controllers[5];
        controllerSucursales = (ControllerSucursales) controllers[6];

    }

    /**
     * Muesta la vista principal ViewMain.
     */
    private void initComponets() {
        viewMenu.setTitle("Ferreteria   A C M E");
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setVisible(true);
        jmi_inicio_actionPerformed();
    }

    /**
     * Asigna el actionListener a cada uno de los JMenuItems de la vista
     * ViewMain.
     */
    private void setActionListener() {
        viewMenu.jmProveedores.addActionListener(actionListener);
        viewMenu.jmClientes.addActionListener(actionListener);
        viewMenu.jmCompras.addActionListener(actionListener);
        viewMenu.jmAlmacen.addActionListener(actionListener);
        viewMenu.jmSucursales.addActionListener(actionListener);
        viewMenu.jmEmpleados.addActionListener(actionListener);
        viewMenu.jmCerrarSesion.addActionListener(actionListener);
    }

    private void setMouseListener() {
        viewMenu.jmInicio.addMouseListener(mouseListener);
    }

    private final MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewMenu.jmInicio) {
                jmi_inicio_actionPerformed();
            } 
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

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
            } else if (e.getSource() == viewMenu.jmCompras) {
                jmi_compras_actionPerformed();
            } else if (e.getSource() == viewMenu.jmAlmacen) {
                jmi_almacen_actionPerformed();
            } else if (e.getSource() == viewMenu.jmSucursales) {
                jmi_sucursales_actionPerformed();
            } else if (e.getSource() == viewMenu.jmEmpleados) {
                jmi_empleados_actionPerformed();
            }else if (e.getSource() == viewMenu.jmCerrarSesion) {
                jmi_cerrarSesion_actionPerformed();
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
    public void jmi_inicio_actionPerformed() {
        viewMenu.setContentPane(controllerInicio.viewInicio);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Inicio");
    }

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

    private void jmi_compras_actionPerformed() {
        viewMenu.setContentPane(controllerCompras.viewCompras);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Compras");
    }

    private void jmi_almacen_actionPerformed() {
        viewMenu.setContentPane(controllerProductos.viewProductos);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Almacen");
    }

    private void jmi_sucursales_actionPerformed() {
        viewMenu.setContentPane(controllerSucursales.viewSucursales);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Sucursales");
    }

    private void jmi_empleados_actionPerformed() {
        viewMenu.setContentPane(controllerEmpleados.viewEmpleados);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Empleados");
    }

    public void jmi_cerrarSesion_actionPerformed() {
        viewMenu.dispose();
        
        ModelLogin modelLogin = new ModelLogin();
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
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
