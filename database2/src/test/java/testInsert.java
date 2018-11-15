import Bean.*;
import dao.*;
import daoImpl.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;


import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class testInsert {
    private userDao userdao=new userDaoImpl();
    private monthlyBillDao monthlybilldao=new monthlyBillDaoImpl();
    private packageServiceDao packageservicedao=new packageServiceDaoImpl();
    private packageServiceRecordDao packageservicerecorddao=new packageServiceRecordDaoImpl();
    private everyRecordDao everyrecorddao=new everyRecordDaoImpl();
    @Test
    public void testUserInsert(){
        User user=new User();
        user.setName("lz");
        user.setPhonenumber("13946789001");
        long l=System.currentTimeMillis();
        assertEquals(true, userdao.insert(user));
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Test
    public void testMonthlyBillInsert(){
        MonthlyBill monthlyBill=new MonthlyBill();
        monthlyBill.setUid(4);
        monthlyBill.setTotalCallTime(0);
        monthlyBill.setTotalAnswerTime(0);
        monthlyBill.setTotalLocalFlow(0);
        monthlyBill.setTotalDomesticFlow(0);
        monthlyBill.setTotalChits(0);
        monthlyBill.setTotalCharge(0);
        long l=System.currentTimeMillis();
        assertEquals(true,monthlybilldao.insertMonthlyBill(monthlyBill));
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(monthlyBill);
        transaction.commit();
        session.close();
    }

    @Test
    public void testPackageServiceInsert(){
        PackageService packageService=new PackageService();
        packageService.setPname("TestPackage");
        long l=System.currentTimeMillis();
        assertEquals(true,packageservicedao.insertPackageService(packageService));
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(packageService);
        transaction.commit();
        session.close();
    }

    @Test
    public void testPackageServiceRecordInsert(){
        PackageServiceRecord packageServiceRecord=new PackageServiceRecord();
        packageServiceRecord.setPid(4);
        packageServiceRecord.setUid(4);
        packageServiceRecord.setOrderDate(Date.valueOf("2018-10-30"));
        packageServiceRecord.setAvailability(true);
        packageServiceRecord.setEffiencicy(false);
        long l=System.currentTimeMillis();
        assertEquals(true,packageservicerecorddao.insert(packageServiceRecord));
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(packageServiceRecord);
        transaction.commit();
        session.close();
    }

    @Test
    public void testEveryrecordInsert(){
        EveryRecord everyRecord=new EveryRecord();
        everyRecord.setUid(3);
        everyRecord.setTypeEnum("ANSWER");
        everyRecord.setRecordDate(Date.valueOf("2018-10-30"));
        long l=System.currentTimeMillis();
        assertEquals(true,everyrecorddao.insertEveryRecord(everyRecord));
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(everyRecord);
        transaction.commit();
        session.close();
    }
}
