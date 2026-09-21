package lw01.Unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    public int calculateCharge() {
        int days = getDays();
        int charge;

        if (getDays() <= 3) {
            charge = ((days * 60000)+20000);
        } else { 
            charge = ((3 * 60000 + ((getDays() - 3) * 450000) + 20000));
        }
        return charge;
    }
    public String label() {
        return "Projector" ;
    }   
}
