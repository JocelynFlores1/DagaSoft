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
            
            Models.ModelMenu modelMenu = new Models.ModelMenu();
            Views.ViewMenu viewMenu = new Views.ViewMenu();
            Controllers.ControllerMenu controllerMenu = new Controllers.ControllerMenu(modelMenu, viewMenu);
            
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
