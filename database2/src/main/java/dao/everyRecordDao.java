package dao;

import Bean.EveryRecord;

import java.util.ArrayList;

public interface everyRecordDao {
    //插入新的everyRecord
    public boolean insertEveryRecord(EveryRecord everyRecord);

    //根据用户id查找用户的每一步操作
    public ArrayList<EveryRecord> findRecordById(int userId);
}
