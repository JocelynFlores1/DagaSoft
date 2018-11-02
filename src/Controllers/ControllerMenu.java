/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelMenu;
import Views.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Norberto
 */
public class ControllerMenu {

    Models.ModelMenu modelMenu;
    Views.ViewMenu viewMenu;

    public ControllerMenu(ModelMenu modelMenu, ViewMenu viewMenu) {
        this.modelMenu = modelMenu;
        this.viewMenu = viewMenu;
        setActionListener();
        initComponents();
    }

    private void initComponents() {
        viewMenu.setVisible(true);
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setTitle("Menu Principal Ferreteria Acme");
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }

 
    };

    private void setActionListener() {
        viewMenu.jmAlmacen.addActionListener(actionListener);
    }

}
