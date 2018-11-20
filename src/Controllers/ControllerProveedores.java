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
            if (e.getSource() == viewProveedores.jb_insertar) {
                jmi_insertarP_actionPerformed();
            } else if (e.getSource() == viewProveedores.jb_modificar_proveedor) {
                jmi_modificarP_actionPerformed();
            }
        }
    };

    /**
     * Constructor de Controlador para unir el ModelProveedores y
     * ViewProveedores
     *
     * @param modelProveedores objeto de tipo ModelAgenda
     * @param viewProveedores objeto de tipo ViewAgenda
     */
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
    }
}
