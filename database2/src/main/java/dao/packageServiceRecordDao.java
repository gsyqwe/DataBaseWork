package dao;

import Bean.PackageServiceRecord;

import java.util.ArrayList;

public interface packageServiceRecordDao {
    //插入新的套餐订购
    public boolean insert(PackageServiceRecord packageServiceRecord);

    //根据用户Id查找用户的套餐订购历史
    public ArrayList<PackageServiceRecord> findPackageRecordById(int userId);
}
