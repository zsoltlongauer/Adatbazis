import javafx.util.Pair;
import org.hibernate.ObjectDeletedException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zsolt on 1/27/2016.
 */
public class ManageEntity<T> {

    private final Class<T> type;

    public ManageEntity(Class<T> type)
    {
        this.type = type;
    }

    public Class<T> getType()
    {
        return type;
    }

    // TODO PRE / POST
    // TODO Interfacet lecserelni

    private Session getSession(){
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    private void closeSession(Session session){
        session.getTransaction().commit();
        session.close();
    }

    public void preInsert()
    {

    }

    public boolean insert(List<T> ts){ // TODO Listak
        Session session = getSession();
        for (T t:ts)
        {
            session.save(t);
        }
        closeSession(session);
        return true;
    }

    public void postInsert()
    {

    }

    public List<T> findByParams(HashMap<String,Object> params){
        StringBuilder sb = new StringBuilder();
        sb.append("select e from ");
        //sb.append(getGenericName());
        sb.append(getType().getSimpleName());
        sb.append(" e");
        if (!params.isEmpty())
        {
            sb.append(" where");
            int i=0;
            for (HashMap.Entry <String, Object> it : params.entrySet())
            {
                if(i++ != 0){
                    sb.append(",");
                }
                sb.append(" "+it.getKey()+"=:"+it.getKey());
            }
        }
        Session session = getSession();
        Query query = session.createQuery(sb.toString());

        for (HashMap.Entry <String, Object> it : params.entrySet())
        {
           query.setParameter(it.getKey(),it.getValue());
        }
        List<T> retList = query.list();
        closeSession(session);
        return retList;
    }


    public void preUpdate(T e){

    }


    public boolean update(T e) // TODO Listakra
    {
        Session session = getSession();
        preUpdate(e);
        session.update(e);
        closeSession(session);
        postUpdate(e);
        return true;
    }


    public void postUpdate(T e){

    }

    public boolean delete(IEntityInterface e){
        return false;
    }

}
