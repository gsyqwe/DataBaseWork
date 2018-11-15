package main;

import Bean.MonthlyBill;
import Bean.PackageService;
import Bean.PackageServiceRecord;
import dao.*;
import daoImpl.*;

import java.util.ArrayList;

public class main {

    //用来展示的userid，可以直接更改看到用户1，2，3的Id
    private static int useridToShow=1;
    private QueryDao querydao=new QueryDaoImpl();
    private userDao userdao=new userDaoImpl();
    private everyRecordDao everyrecorddao=new everyRecordDaoImpl();
    private monthlyBillDao monthlybilldao=new monthlyBillDaoImpl();
    private packageServiceDao packageservicedao=new packageServiceDaoImpl();
    private packageServiceRecordDao packageservicerecorddao=new packageServiceRecordDaoImpl();
    public static void main(String[]args){
        //new main().queryPackage(useridToShow);
        //new main().queryCallPrice(useridToShow);
        //new main().queryChidPrice(useridToShow);
        //new main().queryFlowPrice(useridToShow);
        //new main().queryPackagePriceById(useridToShow);
        new main().queryMonthlyBillById(useridToShow);
    }

    //展示根据用户id查询用户的套餐,userid为:1,2,3可以进行更改
    public void queryPackage(int userid){
        long l=System.currentTimeMillis();
        String username=userdao.finduserById(userid).getuName();
        ArrayList<PackageServiceRecord> packageServiceRecordArrayList=packageservicerecorddao.findPackageRecordById(userid);
        String result="";
        for (int i=0;i<packageServiceRecordArrayList.size();i++){
            result=username;
            PackageServiceRecord packageServiceRecord=packageServiceRecordArrayList.get(i);
            result=result+" "+packageServiceRecord.getOrderDate();
            int pid=packageServiceRecord.getPid();
            PackageService packageService=packageservicedao.findPackageServiceByPid(pid);
            if (packageServiceRecord.isAvailability()){
                result=result+" 订购";
                result=result+" "+packageService.getPname();
                if (packageServiceRecord.isEffiencicy()){
                    result=result+" 立即生效";
                }else{
                    result=result+" 次月生效";
                }
            }else{
                result=result+" 退订";
                result=result+" "+packageService.getPname();
            }
            System.out.println(result);
        }
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }

    //展示根据用户id查询用户的通话资费
    public void queryCallPrice(int userid){
        long l=System.currentTimeMillis();
        String username=userdao.finduserById(userid).getuName();
        double price=querydao.findCallPriceById(userid);
        String result="";
        result=username+" 本月 "+"通话总资费为:"+" "+price;
        System.out.println(result);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }

    //展示根据用户id查询用户的短信资费
    public void queryChidPrice(int userid){
        long l=System.currentTimeMillis();
        String username=userdao.finduserById(userid).getuName();
        double price=querydao.findChidPriceById(userid);
        String result="";
        result=username+" 本月 "+"短信总资费为:"+" "+price;
        System.out.println(result);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }

    //展示根据用户id查询用户的流量资费
    public void queryFlowPrice(int userid){
        long l=System.currentTimeMillis();
        String username=userdao.finduserById(userid).getuName();
        double price=querydao.findFlowPriceById(userid);
        String result="";
        result=username+" 本月 "+"本地流量总资费为:"+" "+price;
        double price1=querydao.findDoesticFlowPriceById(userid);
        result=result+" 国内流量总资费为"+price1+" 总流量资费为"+(price+price1);
        System.out.println(result);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }

    //展示根据用户id查询用户的套餐资费
    public void queryPackagePriceById(int userid){
        long l=System.currentTimeMillis();
        String username=userdao.finduserById(userid).getuName();
        double price=querydao.findPackagePriceById(userid);
        String result="";
        result=username+" 本月 "+"套餐总资费为:"+" "+price;
        System.out.println(result);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }

    //展示根据用户id查询用户的月账单
    public void queryMonthlyBillById(int userid){
        long l=System.currentTimeMillis();
        String username=userdao.finduserById(userid).getuName();
        MonthlyBill monthlyBill=monthlybilldao.getBillById(userid);
        String result="";
        result=result+username+" 总通话时间为:"+monthlyBill.getTotalCallTime()+" 总接听时间为:"
                +monthlyBill.getTotalAnswerTime()+" 总短信为:"+monthlyBill.getTotalChits()
                +" 总本地流量为:"+monthlyBill.getTotalLocalFlow()+" 总国内流量为："+monthlyBill.getTotalDomesticFlow()
                +" 总费用为:"+monthlyBill.getTotalCharge();
        System.out.println(result);
        long l1=System.currentTimeMillis();
        System.out.println(l1-l);
    }
}
