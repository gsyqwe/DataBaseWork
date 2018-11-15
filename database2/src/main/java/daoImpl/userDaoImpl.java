package daoImpl;

import Bean.User;
import dao.userDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class userDaoImpl implements userDao {
    public boolean insert(User user) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    public User finduserById(int userId) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("From User WHERE uid =?").setInteger(0,userId);
        List results=query.list();
        transaction.commit();
        session.close();
        User user=(User)results.get(0);
        return user;
    }
}
