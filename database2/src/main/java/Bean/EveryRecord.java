package Bean;

import javax.persistence.*;
import java.util.Date;

/*
每次操作数据:eid:1,uid:1,typeEnum:ANSWER,recordDate:2018-10-08,inventory:3,charge=0
eid:2,uid:2,typeEnum:CALL,recordDate:2018-10-28,inventory:58,charge=5.6
eid:3,uid:1,typeEnum:LOCALFLOW,recordDate:2018-10-03,inventory:538M,charge=114
eid:4,uid:1,typeEnum:DOMESTICFLOW,recordDate:2018-10-05,inventory:210M,charge=60
eid:5,uid:2,typeEnum:LOCALFLOW,recordDate:2018-10-15,inventory:520M,charge=60
eid:6,uid:2,typeEnum:DOMESTICFLOW,recordDate:2018-10-05,inventory:20M,charge=0
eid:7,uid:3,typeEnum:CALL,recordDate:2018-10-08,inventory:582,charge=19.2
eid:8,uid:3,typeEnum:CHIT,recordDate:2018-10-12,inventory:1,charge=0
eid:9,uid:1,typeEnum:CHIT,recordDate:2018-10-18,inventory:1,charge=0.1
eid:10,uid:3,typeEnum:LOCALFLOW,recordDate:2018-10-20,inventory:38M,charge=76
 */

//记录每次操作
@Entity
@Table(name="EveryRecord")
public class EveryRecord {
    public EveryRecord(){
        inventory=0;
        charge=0;
    }

    //记录的ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;

    //记录的用户的ID
    @Column
    private int uid;

    //记录的类型,分为拨打通话CALL与接听通话ANSWER，短信CHIT，本地流量LOCALFLOW，
    // 国内流量DOMESTICFLOW，默认短信是发一次就记录一次
    @Column
    private String typeEnum;

    //记录生成的日期
    @Column
    private Date recordDate;

    //记录使用量，通话为通话时间，短信为条数，本地流量与国内流量为使用量,短信的inventory始终为1
    @Column
    private double inventory;

    //本次记录最后的费用，接听通话免费,当使用时间为超过套餐的规定时间时,与接听通话一样均为0
    @Column
    private double charge;

    public int getEid(){
        return eid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(String typeEnum) {
        this.typeEnum = typeEnum;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public double getInventory() {
        return inventory;
    }

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }


}
