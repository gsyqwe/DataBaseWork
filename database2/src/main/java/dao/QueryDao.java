package dao;

import Bean.MonthlyBill;
import Bean.PackageService;

import java.util.ArrayList;

//用来实现查询,作业要求的查询功能
public interface QueryDao {

    //根据用户Id来查找用户的通话资费,除套餐之外的
    public double findCallPriceById(int userId);

    //根据用户Id来查找用户的短信资费,除套餐之外的
    public double findChidPriceById(int userId);

    //根据用户Id来查找用户的流量资费，包括本地流量资费除套餐之外的
    public double findFlowPriceById(int userId);

    //查找国内套餐资费
    public double findDoesticFlowPriceById(int userId);

    //根据用户Id来查找用户的套餐资费
    public double findPackagePriceById(int userId);
}
