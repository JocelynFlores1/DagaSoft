/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelEmpleados;
import Views.ViewEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author beto
 */
public class ControllerEmpleados {

    public Models.ModelEmpleados modelEmpleados;
    public Views.ViewEmpleados viewEmpleados;

    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
    }

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewEmpleados.jb_nuevo) {
                jmi_nuevo();
            }
            if (e.getSource() == viewEmpleados.jb_modificar) {
                jmi_modificar();
            }
            if (e.getSource() == viewEmpleados.jb_insertar) {
                jmi_insertarE();
            }
            if (e.getSource() == viewEmpleados.jb_eliminar) {
                jmi_eliminar();
            } else if (e.getSource() == viewEmpleados.jb_cancelar) {

            }
        }
    };

    public void setActionListener() {
        viewEmpleados.jb_nuevo.addActionListener(actionListener);
        viewEmpleados.jb_cancelar.addActionListener(actionListener);
        viewEmpleados.jb_modificar.addActionListener(actionListener);
        viewEmpleados.jb_insertar.addActionListener(actionListener);
        viewEmpleados.jb_eliminar.addActionListener(actionListener);
    }
}
