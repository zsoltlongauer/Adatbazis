import javax.persistence.*;

/**
 * Created by Zsolt on 12/1/2015.
 */


@Entity
@Table(name = "media",catalog = "elso")
public class Media
{
    private int id;
    private Diak diak_id;
    private Tantargy tantargy_id;
    private float media;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID", unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name ="DIAK_ID", unique = false,nullable = false)
    public Diak getDiak_id() {
        return diak_id;
    }

    public void setDiak_id(Diak diak_id) {
        this.diak_id = diak_id;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name ="TANTARGY_ID", unique = false,nullable = false)
    public Tantargy getTantargy_id() {
        return tantargy_id;
    }

    public void setTantargy_id(Tantargy tantargy_id) {
        this.tantargy_id = tantargy_id;
    }
    @Column(name ="MEDIA", unique = false,nullable = true)
    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}
