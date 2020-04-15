package memory;

import Controller.Controller;
import Vue.Vue;
import Model.Modele;

public class Memory {
    public static void main(String[] args) {
        Modele modele = new Modele();
        Vue vue = new Vue(modele);
        Controller controller = new Controller(modele, vue);
        
        java.awt.EventQueue.invokeLater(() -> {
            vue.setVisible(true);
        });
    }
}
