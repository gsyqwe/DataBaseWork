package Bean;

import javax.persistence.*;
import java.util.Date;

/*
套餐记录:prid:1,pid:1,uid:1,availability:true,effiencicy:true,orderDate:2018-09-02
prid:2,pid:2,uid:2,availability:true,effiencicy:true,orderDate:2018-09-12
prid:3,pid:2,uid:2,availability:false,effiencicy:false,orderDate:2018-09-26
prid:4,pid:1,uid:3,availability:true,effiencicy:true,orderDate:2018-09-12
prid:5,pid:2,uid:3,availability:true,effiencicy:false,orderDate:2018-09-04
 */

//套餐记录
@Entity
@Table(name="PackageServiceRecord")
public class PackageServiceRecord {

    //套餐记录ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prid;

    //套餐的ID
    @Column
    private int pid;

    //订购套餐的用户id
    @Column
    private int uid;

    //记录此项记录是订购还是退订,true为订购，false为退订，退订统一次月生效
    @Column
    private boolean availability;

    //记录订购是立即生效还是次月生效,true为立即生效，false为次月生效，退订统一设定为false
    @Column
    private boolean effiencicy;

    //套餐订购或者退订的时间
    @Column
    private Date orderDate;

    public int getPrid(){
        return prid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isEffiencicy() {
        return effiencicy;
    }

    public void setEffiencicy(boolean effiencicy) {
        this.effiencicy = effiencicy;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
