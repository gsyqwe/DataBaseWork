package daoImpl;

import Bean.PackageService;
import dao.packageServiceDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class packageServiceDaoImpl implements packageServiceDao {
    public boolean insertPackageService(PackageService packageService) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(packageService);
        transaction.commit();
        session.close();
        return true;
    }

    public ArrayList<PackageService> findAllPackage() {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("From PackageService ");
        List results=query.list();
        transaction.commit();
        session.close();
        return (ArrayList)results;
    }

    public PackageService findPackageServiceByPid(int pid){
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("From PackageService WHERE pid=?").setInteger(0,pid);
        List results=query.list();
        transaction.commit();
        session.close();
        return (PackageService) results.get(0);
    }
}
