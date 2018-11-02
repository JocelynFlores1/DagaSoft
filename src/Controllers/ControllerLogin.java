/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelLogin;
import Views.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Norberto
 */
public class ControllerLogin implements ActionListener {

    Models.ModelLogin modelLogin;
    Views.ViewLogin viewLogin;

    public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        initComponents();
        viewLogin.jbLogin.addActionListener(this);
    }

    private void initComponents() {
        JOptionPane.showMessageDialog(null, "Ferreteria Acme: Inicie Sesión");
        viewLogin.setVisible(true);
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setTitle("Inicio de sesión Ferreteria Acme");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewLogin.jbLogin) {
            iniciarSesion();
        }
    }

    private void iniciarSesion() {
        String pass = new String(viewLogin.jpfPassword.getPassword());
        if (viewLogin.jtfUser.getText().equals(modelLogin.getUser()) && pass.equals(modelLogin.getPassword())) {
            viewLogin.dispose();

            Models.ModelProveedores modelProveedores = new Models.ModelProveedores();
            Views.ViewProveedores viewProveedores = new Views.ViewProveedores();
            Controllers.ControllerProveedores controllerProveedores = new Controllers.ControllerProveedores(modelProveedores, viewProveedores);

            Models.ModelClientes modelClientes = new Models.ModelClientes();
            Views.ViewClientes viewClientes = new Views.ViewClientes();
            Controllers.ControllerClientes controllerClientes = new Controllers.ControllerClientes(modelClientes, viewClientes);

            Object[] controllers = new Object[2];
            controllers[0] = controllerProveedores;
            controllers[1] = controllerClientes;

            Models.ModelMain modelMain = new Models.ModelMain();
            Views.ViewMenu viewMenu = new Views.ViewMenu();
            Controllers.ControllerMain controllerMain = new Controllers.ControllerMain(modelMain, viewMenu, controllers);

            System.out.println(modelLogin.getPassword());
            System.out.println(modelLogin.getUser());
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña o nombre de usuario incorrectos");
            System.out.println(modelLogin.getPassword());
            System.out.println(modelLogin.getUser());
            System.out.println(viewLogin.jtfUser.getText());
            System.out.println(viewLogin.jpfPassword.getPassword());

        }
    }

}
