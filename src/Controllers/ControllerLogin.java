/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelLogin;
import Views.ViewLogin;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
        viewLogin.jbIniciar.addActionListener(this);
    }

    private void initComponents() {
        viewLogin.setVisible(true);
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setTitle("Inicio de sesión Ferreteria Acme");

        ImageIcon imagenUno = new ImageIcon(getClass().getResource("/img/login.png"));
        Image fondoUno = imagenUno.getImage().getScaledInstance(viewLogin.jl_Login.getWidth(), viewLogin.jl_Login.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(fondoUno);
        viewLogin.jl_Login.setIcon(iconoEscalado);
        viewLogin.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewLogin.jbIniciar) {
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
