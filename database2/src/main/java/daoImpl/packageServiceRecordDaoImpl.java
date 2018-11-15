package daoImpl;

import Bean.PackageServiceRecord;
import dao.packageServiceRecordDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class packageServiceRecordDaoImpl implements packageServiceRecordDao {

    public boolean insert(PackageServiceRecord packageServiceRecord) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(packageServiceRecord);
        transaction.commit();
        session.close();
        return true;
    }

    public ArrayList<PackageServiceRecord> findPackageRecordById(int userId) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("From PackageServiceRecord WHERE uid=?").setInteger(0,userId);
        List results=query.list();
        transaction.commit();
        session.close();
        return (ArrayList)results;
    }
}
