public class CompteBancaire{
    private static int dernierNumero = 0;

    private final int idcompte;
    private final String titulaire;

    private double solde;
    private double decouvertMax;
    private double debitMax;


    public CompteBancaire(String titulaire, double solde, double decouvertMax, double debitMax ) throws IllegalArgumentException{
        
        if(decouvertMax < 0) {
            throw new IllegalArgumentException("Le decouvert maximum ne peut pas etre négatif.");
        }
        if (debitMax <= 0)  { 
            throw new IllegalArgumentException("Le débit maximum ne peut pas etre négatif.");
        }
         if (solde < -decouvertMax)  { 
            throw new IllegalArgumentException("Le solde  ne peut pas etre négatif.");
        }

        ++dernierNumero;
        this.idcompte = dernierNumero;
        this.titulaire = titulaire;
        this.solde = solde;
        this.decouvertMax = decouvertMax;
        this.debitMax = debitMax;
    }
/// contructeur avec valuer par defaults
    public CompteBancaire(String titulaire) {
        ++dernierNumero;
        this.idcompte = dernierNumero;
        this.titulaire = titulaire;
        this.solde = 0;
        this.decouvertMax = 800.0;
        this.debitMax = 1000.0;
    }

//getters 
public double getSolde() {
    return solde;
}

//setters
public void setSolde(double solde) {
    if (solde <= -this.decouvertMax) {
        this.solde = solde;
    }
    
}
public void setDecouvertMax(double découvertMax){
    if (decouvertMax >= 0 && this.solde >= -decouvertMax){
        this.decouvertMax = découvertMax;
    }
}
public void setDebitMax( double debitMax){
    if (debitMax > 0){
        this.debitMax = debitMax;
    }
}


//Méthode 

public void crediter(double montant){
    if (montant > 0){
        this.solde += montant;
    }
}
public boolean debiter(double montant){
    if(montant > 0 && (this.solde - montant >= -this.decouvertMax)){
        this.solde -= montant;
        return true; 
    }
    return false;
}
public boolean effectuerRetrait ( double montant){
    if(montant <= debitMax){
        return debiter(montant);

    }
    return false;
}

public boolean effectuerVirement (CompteBancaire destinataire, double montant){
    if (destinataire != null && debiter(montant) && destinataire != this){
        destinataire.crediter(montant);
        return true;
    }
    return false;
}

}

///// partie 2 Historique des operations











    