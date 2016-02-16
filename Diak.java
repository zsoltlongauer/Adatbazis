import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "diak", catalog = "elso")
public class Diak implements IEntityInterface
{

    private int ID;
    private String Nev;
    private String Helyseg;
    private Osztaly osztaly;
    private Collection<Jegyek> jegyek_list;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID", unique = true,nullable = false)
    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    @Column(name = "NEV", unique = true, nullable = false)
    public String getNev()
    {
        return Nev;
    }

    public void setNev(String nev)
    {
        Nev = nev;
    }

    @Column(name = "HELYSEG", unique = false, nullable = false)
    public String getHelyseg()
    {
        return Helyseg;
    }


    public void setHelyseg(String helyseg)
    {
        Helyseg = helyseg;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSZTALY_ID", unique = false, nullable = false)
    public Osztaly getOsztaly()
    {
        return osztaly;
    }

    public void setOsztaly(Osztaly osztaly)
    {
        this.osztaly = osztaly;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diak", cascade = CascadeType.ALL)
    public Collection<Jegyek> getJegyek_list() {
        return jegyek_list;
    }

    public void setJegyek_list(Collection<Jegyek> jegyek_list) {
        this.jegyek_list = jegyek_list;
    }
}
