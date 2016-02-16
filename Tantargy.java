import javax.persistence.*;

@Entity
@Table(name = "tantargy", catalog = "elso")
public class Tantargy
{
    private int ID;
    private String Tantargy_Nev;
    private Tanar Tanar;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tantargy", cascade = CascadeType.ALL)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "TANTARGY", unique = false, nullable = false)
    public String getTantargy_Nev() {
        return Tantargy_Nev;
    }

    public void setTantargy_Nev(String tantargy_Nev) {
        Tantargy_Nev = tantargy_Nev;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TANAR_ID", unique = false, nullable = false)
    public Tanar getTanar() {
        return Tanar;
    }

    public void setTanar(Tanar tanar) {
        Tanar = tanar;
    }

}
