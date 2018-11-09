/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelMenu;
import Views.ViewMenu;

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
    }
}
