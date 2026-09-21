package lw01.Unguided;

public abstract class Rental implements Chargeable {
 private String id ;
 private int days ;  

 protected Rental (String id, int days) {
      if (days <= 0) {
            throw new IllegalArgumentException();
      }
    this.id = id;
    this.days = days ;
 }
 public String getId () {
    return id ;
  }

 public int getDays () {
    return days ;
 } 

 public int calculateCharge(int units) ;
    if (units <= 0) {
        throw new IllegalArgumentException ("Units must be postive");
    }
    return units * calculateCharge();
 }
 public String label() {
    return "Rental" ;
 }
 public String summary(){
    return id + "|" + label() + "|" + calculateCharge() ;
 }
 