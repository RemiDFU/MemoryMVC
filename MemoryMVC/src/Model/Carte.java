package Model;

public class Carte {
    private final int id;
    private boolean clicked = false;
    
    public Carte(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean estSelection() {
        return this.clicked;
    }
    
    public void setSelection(boolean clicked) {
        this.clicked = clicked;
    }
}
