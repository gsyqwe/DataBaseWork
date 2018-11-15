package dao;

import Bean.User;

public interface userDao {
    //插入新的用户
    public boolean insert(User user);

    //根据用户id查找一个用户
    public User finduserById(int userId);
}
