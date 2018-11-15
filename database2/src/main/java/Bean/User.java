package Bean;

import javax.persistence.*;

/*
设定用户为1,gsy,13046539662
2,lml,18345789801
3,gyd,13012557129
 */

@Entity
@Table(name="user")
//用户
public class User {
    public User(){
        uname="";
        phonenumber="";
    }
    //用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    //用户名称
    @Column
    private String uname;

    //电话号码
    @Column
    private String phonenumber;

    public int getUid(){
        return uid;
    }

    public String getuName() {
        return uname;
    }

    public void setName(String uname) {
        this.uname = uname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
