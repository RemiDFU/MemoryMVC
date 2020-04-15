package Controller;

import Vue.Vue;
import Model.Modele;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Controller {
    private final Modele modele;
    private final Vue vue;
        
    public Controller(Modele modele, Vue vue) {
        this.modele = modele;
        this.vue = vue;
    
        this.vue.addButtonListener((ActionEvent e) -> {
            int button = Integer.parseInt(((JButton)e.getSource()).getName());
            
            if(this.modele.current.size() <= 1) {
                this.modele.montrerCartes(button);
                this.modele.current.add(button);
            }
            
            if(this.modele.current.size() == 2) {
                boolean removable = this.modele.correspondre();
                if(removable) this.modele.setRetirable(true);
                this.modele.current.clear();
                this.modele.setRetirable(false);
            }
        });
    }
}
