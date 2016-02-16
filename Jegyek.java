import javax.persistence.*;

@Entity
@Table(name = "jegyek", catalog = "elso")
public class Jegyek
{
    private int jegyID;
    private int jegy;
    private Diak diak;
    private Tantargy Tantargy;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getJegyID() {
        return jegyID;
    }

    public void setJegyID(int jegyID) {
        this.jegyID = jegyID;
    }


    @Column(name = "JEGY", unique = false, nullable = false)
    public int getJegy() {
        return jegy;
    }

    public void setJegy(int jegy) {
        this.jegy = jegy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "DIAK_ID", unique = false,nullable = false)
    public Diak getDiak() {
        return diak;
    }

    public void setDiak(Diak diak) {
        this.diak = diak;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TANTARGY_ID", unique = false, nullable = false)
    public Tantargy getTantargy() {
        return Tantargy;
    }

    public void setTantargy(Tantargy tantargy) {
        Tantargy = tantargy;
    }

    public Jegyek() {
    }

    @Override
    public String toString(){
        return new StringBuilder().append(jegy).toString();
    }
}
