import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "osztaly", catalog = "elso")
public class Osztaly
{
    private int ID;
    private String Osztaly_Nev;
    private int Osztalyfonok_ID;
    private Collection<Diak> diakList;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "OSZTALY", unique = false, nullable = false)
    public String getOsztaly_Nev() {
        return Osztaly_Nev;
    }

    public void setOsztaly_Nev(String osztaly_Nev) {
        Osztaly_Nev = osztaly_Nev;
    }

    @Column(name = "OSZTALYFONOK_ID", unique = false, nullable = false)
    public int getOsztalyfonok_ID() {
        return Osztalyfonok_ID;
    }

    public void setOsztalyfonok_ID(int osztalyfonok_ID) {
        Osztalyfonok_ID = osztalyfonok_ID;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "osztaly", cascade = CascadeType.ALL)
    public Collection<Diak> getDiakList() {
        return diakList;
    }

    public void setDiakList(Collection<Diak> diakList) {
        this.diakList = diakList;
    }
}
