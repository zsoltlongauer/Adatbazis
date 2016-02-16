import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class HibernateTest
{

    public static void main(String[] args)
    {
        ManageEntity<Diak> me = new ManageEntity<Diak>(Diak.class){
            @Override
            public void preUpdate(Diak e) {
                super.preUpdate(e);
                if(e.getHelyseg().equalsIgnoreCase("Brasso")){
                    e.setHelyseg("Praga");
                }
            }
        };
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id",3);
        List<Diak> list = me.findByParams(params);
        for(Diak d : list){
            d.setNev(d.getNev()+d.getHelyseg());
            me.update(d);
        }


    }



}
