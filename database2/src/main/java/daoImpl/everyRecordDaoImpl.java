package daoImpl;

import Bean.EveryRecord;
import dao.everyRecordDao;
import dao.monthlyBillDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class everyRecordDaoImpl implements everyRecordDao {

    public boolean insertEveryRecord(EveryRecord everyRecord) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(everyRecord);
        transaction.commit();
        session.close();
        //然后去更新越账单
        monthlyBillDao monthlybilldao=new monthlyBillDaoImpl();
        monthlybilldao.updateMonthlyBill(everyRecord);
        return true;
    }

    public ArrayList<EveryRecord> findRecordById(int userId) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("From EveryRecord WHERE uid =?").setInteger(0,userId);
        List results=query.list();
        transaction.commit();
        session.close();
        return (ArrayList)results;
    }
}
