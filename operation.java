import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class operation {
private LocalDateTime date; // date et heure de l'opération
private TypeOperation type; // type de l'opération
private double montant; // montant de l'opération
private String libelle; // libellé de l'opération
public operation(LocalDateTime date, TypeOperation type, double montant, String libelle) throws IllegalArgumentException{
if (date == null) {throw new IllegalArgumentException ("La date ne peut pas être nulle.");}
if(libelle == null || libelle.trim().isEmpty()) {throw new IllegalArgumentException("Le libelle ne peut pas etre vide.");}
if (montant <= 0){throw new IllegalArgumentException ("Le montant doit être strictement positif.");}
boolean typeValide = false;
if(type != null){
for (TypeOperation t : TypeOperation.values()){
if (t == type){
typeValide = true;
break;
}
}
}
if (!typeValide){ throw new IllegalArgumentException ("Le type doit etre un DEPOT, RETRAIT, VIREMENT_ENTRANT ou VIREMENT_SORTANT");}
this.date = date;
this.type = type;
this.montant = montant;
this.libelle = libelle;
}
public operation(TypeOperation type, double montant, String libelle) {
this(LocalDateTime.now(), type, montant, libelle);
}
//getters [https://getters/]
public LocalDateTime getDate(){
return date;
}
public TypeOperation getType(){
return type;
}
public double getMontant(){
return montant;
}
public String getLibelle(){
return libelle;
}
@Override
public String toString(){
DateTimeFormatter formatteur = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm");
return this.date.format(formatteur) +" - "+ this.type +" - "+ this.montant +" € "+" - "+ this.libelle;
}
}
