package dao;

import Bean.EveryRecord;
import Bean.MonthlyBill;

public interface monthlyBillDao {
    //加入一个新的，在有新的用户注册的时候为此用户生成
    public boolean insertMonthlyBill(MonthlyBill monthlyBill);

    //更新,在有新的everyRecord生成的时候同时更新用户的月账单
    public boolean updateMonthlyBill(EveryRecord everyRecord);

    //根据Id找一个用户的月账单
    public MonthlyBill getBillById(int userId);
}
