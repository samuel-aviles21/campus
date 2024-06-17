
package modelo;
    
public class Profesor {
    private int id_profe;
    private String nom_profe;

    public Profesor(int id_profe, String nom_profe) {
        this.id_profe = id_profe;
        this.nom_profe = nom_profe;
    }
    
    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }

    public String getNom_profe() {
        return nom_profe;
    }
    
    public void setNom_profe(String nom_profe) {
        this.nom_profe = nom_profe;
    }
}
