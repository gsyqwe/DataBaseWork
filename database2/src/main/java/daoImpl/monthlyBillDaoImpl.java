package daoImpl;

import Bean.EveryRecord;
import Bean.MonthlyBill;
import Bean.PackageService;
import Bean.PackageServiceRecord;
import dao.monthlyBillDao;
import dao.packageServiceRecordDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class monthlyBillDaoImpl implements monthlyBillDao {

    public boolean insertMonthlyBill(MonthlyBill monthlyBill) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(monthlyBill);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean updateMonthlyBill(EveryRecord everyRecord) {
        int uid=everyRecord.getUid();
        monthlyBillDao monthlybilldao=new monthlyBillDaoImpl();
        //根据uid先查找出其月账单
        MonthlyBill monthlyBill=monthlybilldao.getBillById(uid);
        monthlyBill.setTotalCharge(monthlyBill.getTotalCharge()+everyRecord.getCharge());
        //首先检查其类型
        String type=everyRecord.getTypeEnum();
        if(type.equals("ANSWER")){
            monthlyBill.setTotalAnswerTime(monthlyBill.getTotalAnswerTime()+everyRecord.getInventory());
        }else if(type.equals("CALL")){
            monthlyBill.setTotalCallTime(monthlyBill.getTotalCallTime()+everyRecord.getInventory());
        }else if(type.equals("CHIT")){
            monthlyBill.setTotalChits(monthlyBill.getTotalChits()+everyRecord.getInventory());
        }else if(type.equals("LOCALFLOW")){
            monthlyBill.setTotalLocalFlow(monthlyBill.getTotalLocalFlow()+everyRecord.getInventory());
        }else if(type.equals("DOMESTICFLOW")){
            monthlyBill.setTotalDomesticFlow(monthlyBill.getTotalDomesticFlow()+everyRecord.getInventory());
        }
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.update(monthlyBill);
        transaction.commit();
        session.close();
        return true;
    }


    public MonthlyBill getBillById(int userId) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("From MonthlyBill WHERE uid =?").setInteger(0,userId);
        List results=query.list();
        transaction.commit();
        session.close();
        return (MonthlyBill)results.get(0);
    }
}
