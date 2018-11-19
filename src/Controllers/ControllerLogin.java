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

        if (!viewLogin.jtfUser.getText().equals("") && !pass.equals("")) {
            modelLogin.setUser(viewLogin.jtfUser.getText());
            modelLogin.setPassword(pass);

            if (modelLogin.login()) {
                String usuario = modelLogin.getUser();
                String tipo = modelLogin.getTipoUsuario();
                String sucursal = modelLogin.getSucursal();
                ControllerConstructoresPrincipal constructoresPrincipal = new ControllerConstructoresPrincipal();
                constructoresPrincipal.controllersPrincial(usuario, tipo, sucursal);
                viewLogin.dispose();
            } else {
                System.out.println("Datos incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }

    }

}
