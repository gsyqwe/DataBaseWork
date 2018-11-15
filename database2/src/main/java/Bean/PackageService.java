package Bean;

import javax.persistence.*;
import java.util.Date;

/*
当一个套餐不包含通话,短信或者本地流量或者国内流量时，将其总量与超出后的价格都设为0
在构造函数时默认设为0
设定套餐:pid:1,pname:包月大流量套餐,monthlyCharge:50,totalCallTime:50,overCallPrice0.7,
totalChits:0,overChitPrice:0,localFlow:500M,overLocalFlowPrice:3,domesticFlow:200M,
overDomesticFlowPrice:6
pid:2,pname:包月通话大套餐,monthlyCharge:50,totalCallTime:500,overCallPrice:0.6,
totalChits:100,overChitPrice:0.2,localFlow:0M,overLocalFlowPrice:0,domesticFlow:0M,
overDomesticFlowPrice:0
 */

@Entity
@Table(name="packageService")
//套餐
public class PackageService {
    public PackageService(){
        pname="";
        monthlyCharge=0;
        totalCallTime=0;
        overCallPrice=0;
        totalChits=0;
        overChitPrice=0;
        localFlow=0;
        overLocalFlowPrice=0;
        domesticFlow=0;
        overDomesticFlowPrice=0;
    }
    //套餐ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    //套餐名称
    @Column
    private String pname;

    //月功能费
    @Column
    private double monthlyCharge;

    //通话总时间
    @Column
    private double totalCallTime;

    //超出通话时间后的通话价钱
    @Column
    private double overCallPrice;

    //短信总条数
    @Column
    private double totalChits;

    //超出短信条数后的价格
    @Column
    private double overChitPrice;

    //本地流量使用量
    @Column
    private double localFlow;

    //本地流量使用超出后的价格
    @Column
    private double overLocalFlowPrice;

    //国内流量使用量
    @Column
    private double domesticFlow;

    //国内流量超出后的价格
    @Column
    private double overDomesticFlowPrice;

    public int getPid(){
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public double getTotalCallTime() {
        return totalCallTime;
    }

    public void setTotalCallTime(double totalCallTime) {
        this.totalCallTime = totalCallTime;
    }

    public double getOverCallPrice() {
        return overCallPrice;
    }

    public void setOverCallPrice(double overCallPrice) {
        this.overCallPrice = overCallPrice;
    }

    public double getTotalChits() {
        return totalChits;
    }

    public void setTotalChits(double totalChits) {
        this.totalChits = totalChits;
    }

    public double getOverChitPrice() {
        return overChitPrice;
    }

    public void setOverChitPrice(double overChitPrice) {
        this.overChitPrice = overChitPrice;
    }

    public double getLocalFlow() {
        return localFlow;
    }

    public void setLocalFlow(double localFlow) {
        this.localFlow = localFlow;
    }

    public double getOverLocalFlowPrice() {
        return overLocalFlowPrice;
    }

    public void setOverLocalFlowPrice(double overLocalFlowPrice) {
        this.overLocalFlowPrice = overLocalFlowPrice;
    }

    public double getDomesticFlow() {
        return domesticFlow;
    }

    public void setDomesticFlow(double domesticFlow) {
        this.domesticFlow = domesticFlow;
    }

    public double getOverDomesticFlowPrice() {
        return overDomesticFlowPrice;
    }

    public void setOverDomesticFlowPrice(double overDomesticFlowPrice) {
        this.overDomesticFlowPrice = overDomesticFlowPrice;
    }
}
