import dao.*;
import daoImpl.*;
import Bean.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testQuery {
    private userDao userdao=new userDaoImpl();
    private monthlyBillDao monthlybilldao=new monthlyBillDaoImpl();
    private packageServiceDao packageservicedao=new packageServiceDaoImpl();
    private packageServiceRecordDao packageservicerecorddao=new packageServiceRecordDaoImpl();
    private everyRecordDao everyrecorddao=new everyRecordDaoImpl();
    private QueryDao querydao=new QueryDaoImpl();
    @Test
    public void TestQueryUser(){
        long l=System.currentTimeMillis();
        assertEquals("gsy",userdao.finduserById(1).getuName());
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }

    @Test
    public void TestQueryeveryRecord(){
        long l=System.currentTimeMillis();
        ArrayList<EveryRecord> everyRecordArrayList=everyrecorddao.findRecordById(1);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        assertEquals(5,everyRecordArrayList.size());
        assertEquals((double)50,everyRecordArrayList.get(0).getCharge(),0);
        assertEquals("ANSWER",everyRecordArrayList.get(1).getTypeEnum());
    }

    @Test
    public void TestQueryPackage(){
        long l=System.currentTimeMillis();
        ArrayList<PackageService> packageServiceArrayList=packageservicedao.findAllPackage();
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        assertEquals(2,packageServiceArrayList.size());
        assertEquals(50,packageServiceArrayList.get(0).getMonthlyCharge(),0);
    }

    @Test
    public void TestQueryMonthlyBillById(){
        long l=System.currentTimeMillis();
        MonthlyBill monthlyBill=monthlybilldao.getBillById(1);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        assertEquals(224.1,monthlyBill.getTotalCharge(),0);
        assertEquals(538,monthlyBill.getTotalLocalFlow(),0);
    }

    @Test
    public void TestFindPackageServiceRecordById(){
        long l=System.currentTimeMillis();
        ArrayList<PackageServiceRecord> packageServiceRecordArrayList=packageservicerecorddao.findPackageRecordById(1);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        assertEquals(1,packageServiceRecordArrayList.size());
        assertEquals(true,packageServiceRecordArrayList.get(0).isAvailability());
    }

    @Test
    public void TestUpdateMonthlyBill(){
        //先加入一个新的everyRecord,然后插入everyRecord，然后查找monthlybill，然后进行比较
        EveryRecord everyRecord=new EveryRecord();
        everyRecord.setUid(3);
        everyRecord.setRecordDate(Date.valueOf("2018-10-08"));
        everyRecord.setTypeEnum("CALL");
        everyRecord.setCharge(60);
        everyRecord.setInventory(100);
        long l=System.currentTimeMillis();
        everyrecorddao.insertEveryRecord(everyRecord);
        MonthlyBill monthlyBill=monthlybilldao.getBillById(3);
        assertEquals(682,monthlyBill.getTotalCallTime(),0);
        assertEquals(179.2,monthlyBill.getTotalCharge(),0);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        monthlyBill.setTotalCallTime(582);
        monthlyBill.setTotalCharge(119.2);
        session.update(monthlyBill);
        session.delete(everyRecord);
        transaction.commit();
        session.close();
    }
}
