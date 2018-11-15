package Bean;

import javax.persistence.*;

/*
月账单:mid:1,uid:1,totalCallTime:0,totalAnswerTime:3,totalChits:1,totalLocalFlow:538M,
totalDomesticFlow:210M,totalCharge:224.1
mid:2,uid:2,totalCallTime:58,totalAnswerTime:0,totalChits:0,totalLocalFlow:520M,
totalDomesticFlow:20M,totalCharge:115.6
mid:3,uid:3,totalCallTime:582,totalAnswerTime:0,totalChits:1,totalLocalFlow:0M,
totalDomesticFlow:0M,totalCharge:119.2
 */

//月账单
@Entity
@Table(name="MonthlyBill")
public class MonthlyBill {
    //月账单的ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;

    //用户的Id
    @Column
    private int uid;

    //总拨打通话的时间
    @Column
    private double totalCallTime;

    //总接听通话的时间
    @Column
    private double totalAnswerTime;

    //总短信条数
    @Column
    private double totalChits;

    //总本地流量使用量
    @Column
    private double totalLocalFlow;

    //总国内流量使用量
    @Column
    private double totalDomesticFlow;

    //总费用
    @Column
    private double totalCharge;

    public int getMid(){
        return mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getTotalCallTime() {
        return totalCallTime;
    }

    public void setTotalCallTime(double totalCallTime) {
        this.totalCallTime = totalCallTime;
    }

    public double getTotalAnswerTime() {
        return totalAnswerTime;
    }

    public void setTotalAnswerTime(double totalAnswerTime) {
        this.totalAnswerTime = totalAnswerTime;
    }

    public double getTotalChits() {
        return totalChits;
    }

    public void setTotalChits(double totalChits) {
        this.totalChits = totalChits;
    }

    public double getTotalLocalFlow() {
        return totalLocalFlow;
    }

    public void setTotalLocalFlow(double totalLocalFlow) {
        this.totalLocalFlow = totalLocalFlow;
    }

    public double getTotalDomesticFlow() {
        return totalDomesticFlow;
    }

    public void setTotalDomesticFlow(double totalDomesticFlow) {
        this.totalDomesticFlow = totalDomesticFlow;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }
}
