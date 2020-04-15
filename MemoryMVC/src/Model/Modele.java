package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Modele extends Observable{
    public List<Carte> cartes;
    public ArrayList<Integer> current = new ArrayList<>();
    private boolean retirable = false;
    
    public Modele() {
        disposerCartes();
    }
    
    public void setRetirable(boolean retirable) {
        this.retirable = retirable;
        
        setChanged();
        notifyObservers();
    }
    
    public boolean estRetirable() {
        return this.retirable;
    }
    
    public void montrerCartes(int card) {
        cartes.get(card).setSelection(true);
        
        setChanged();
        notifyObservers();
    }
    
    public boolean correspondre() {
        if(cartes.get(current.get(0)).getId() == cartes.get(current.get(1)).getId()) {
            boolean remove = cartes.remove(current.get(0));
            boolean remove1 = cartes.remove(current.get(1));
            return true;
        }
        else {
            cartes.forEach((carte) -> {
                carte.setSelection(false);
            });
        }
        
        setChanged();
        notifyObservers();
        return false;
    }
    
    private void disposerCartes() {
        cartes = new ArrayList<>();
        
        for(int i = 0; i < 8; i++) {
            cartes.add(new Carte(i));
            cartes.add(new Carte(i));
        }
        
        Collections.shuffle(cartes);
    }
}
