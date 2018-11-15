package daoImpl;

import Bean.EveryRecord;
import Bean.MonthlyBill;
import Bean.PackageService;
import dao.*;

import java.util.ArrayList;

public class QueryDaoImpl implements QueryDao {

    private everyRecordDao everyrecorddao=new everyRecordDaoImpl();

    public double findCallPriceById(int userId) {
        double result=0;
        ArrayList<EveryRecord> everyRecordArrayList=everyrecorddao.findRecordById(userId);
        for(int i=0;i<everyRecordArrayList.size();i++){
            EveryRecord everyrecord=everyRecordArrayList.get(i);
            if(everyrecord.getTypeEnum().equals("CALL")){
                result=result+everyrecord.getCharge();
            }
        }
        return result;
    }

    public double findChidPriceById(int userId) {
        double result=0;
        ArrayList<EveryRecord> everyRecordArrayList=everyrecorddao.findRecordById(userId);
        for(int i=0;i<everyRecordArrayList.size();i++){
            EveryRecord everyrecord=everyRecordArrayList.get(i);
            if(everyrecord.getTypeEnum().equals("CHIT")){
                result=result+everyrecord.getCharge();
            }
        }
        return result;
    }

    public double findFlowPriceById(int userId) {
        double result=0;
        ArrayList<EveryRecord> everyRecordArrayList=everyrecorddao.findRecordById(userId);
        for(int i=0;i<everyRecordArrayList.size();i++){
            EveryRecord everyrecord=everyRecordArrayList.get(i);
            if(everyrecord.getTypeEnum().equals("LOCALFLOW")){
                result=result+everyrecord.getCharge();
            }
        }
        return result;
    }

    public double findDoesticFlowPriceById(int userId) {
        double result=0;
        ArrayList<EveryRecord> everyRecordArrayList=everyrecorddao.findRecordById(userId);
        for(int i=0;i<everyRecordArrayList.size();i++){
            EveryRecord everyrecord=everyRecordArrayList.get(i);
            if(everyrecord.getTypeEnum().equals("DOMESTICFLOW")){
                result=result+everyrecord.getCharge();
            }
        }
        return result;
    }

    public double findPackagePriceById(int userId) {
        double result=0;
        ArrayList<EveryRecord> everyRecordArrayList=everyrecorddao.findRecordById(userId);
        for(int i=0;i<everyRecordArrayList.size();i++){
            EveryRecord everyrecord=everyRecordArrayList.get(i);
            if(everyrecord.getTypeEnum().equals("MONTHLYCHARGE")){
                result=result+everyrecord.getCharge();
            }
        }
        return result;
    }
}
