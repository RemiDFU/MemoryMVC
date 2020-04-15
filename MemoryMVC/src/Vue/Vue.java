package Vue;

import Model.Modele;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class Vue extends javax.swing.JFrame implements Observer{
    private Modele modele;
    private ImageIcon[] images;
    public List<JButton> buttons;
    private ImageIcon hidden;
    
    public Vue() {
        initComponents();
    }

    public Vue(Modele modele) {
        this();
        this.modele = modele;
        
        this.modele.addObserver(this);
        
        this.setLayout(new GridLayout(4, 4));
        
        images = new ImageIcon[this.modele.cartes.size()];
        hidden = new ImageIcon("src/images/card8.jpeg");
        for(int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon("src/images/card" + this.modele.cartes.get(i).getId() + ".jpeg");
        }
        
        buttons = new ArrayList<>();
        for(int i = 0; i < images.length; i++) {
            buttons.add(new JButton());
            buttons.get(i).setName("" + i);
            Component add = this.add(buttons.get(i));
        }
    }

    public void addButtonListener(ActionListener l) {
        buttons.forEach((bottone) -> {
            bottone.addActionListener(l);
        });
    }



    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        for(int i = 0; i < modele.cartes.size(); i++) {
            if(modele.cartes.get(i).estSelection())
                buttons.get(i).setIcon(images[i]);
            else buttons.get(i).setIcon(hidden);
        }
        
        if(modele.estRetirable()) {
            this.remove(buttons.get(modele.current.get(0)));
            this.remove(buttons.get(modele.current.get(1)));
        }
    }
}
