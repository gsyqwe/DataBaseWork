package dao;

import Bean.PackageService;

import java.util.ArrayList;

public interface packageServiceDao {
    //插入新的套餐
    public boolean insertPackageService(PackageService packageService);

    //查找套餐
    public ArrayList<PackageService> findAllPackage();

    //根据套餐Id查找套餐
    public PackageService findPackageServiceByPid(int pid);
}
