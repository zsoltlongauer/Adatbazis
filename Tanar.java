import javax.persistence.*;

@Entity
@Table(name = "Tanar_Nev", catalog = "elso")
public class Tanar
{
    private int ID;
    private String Tanar_Nev;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Tanar_Nev",cascade = CascadeType.ALL)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "TANAR", unique = false, nullable = false)
    public String getTanar_Nev() {
        return Tanar_Nev;
    }

    public void setTanar_Nev(String tanar_Nev) {
        this.Tanar_Nev = tanar_Nev;
    }
}
