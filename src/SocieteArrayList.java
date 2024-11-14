import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class SocieteArrayList implements IGestion<Employe>{
    private List<Employe> employes = new ArrayList<>();
@Override
    public void ajouterEmploye(Employe e){
        employes.add(e);
    }
    @Override
    public boolean rechercherEmploye(String nom)
    { for (Employe e : employes) {
        if (e.getNom().equalsIgnoreCase(nom)) {
            return true;
        }
    }
        return false;  }
    @Override
    public boolean rechercherEmploye(Employe e){
        return employes.contains(e);
    }
    @Override
    public void supprimerEmploye(Employe e){
        employes.remove(e);

    }
    @Override
    public void displayEmploye(){
        for (Employe e : employes) {
            System.out.println(e);
        }
    }

    public void trierEmployeParNomDepartementEtGrade() {
        employes.sort(new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int departementComparison = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());
                if (departementComparison != 0) {
                    return departementComparison;
                } else {
                    return Integer.compare(e1.getGrade(), e2.getGrade());
                }
            }
        });
    }

}
