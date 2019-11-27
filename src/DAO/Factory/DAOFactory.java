package DAO.Factory;

import DAO.Impl.PersonDAOImpl;
import DAO.Impl.AddressDAOImpl;
import DAO.IPersonDAO;
import DAO.IAddressDAO;
import java.sql.Connection;

//数据层工厂类 为了方便业务层对数据层进行操作 关闭开启数据库
public class DAOFactory{//接口集合
    public static IPersonDAO getIPersonDAOInstance(Connection conn){//由外部传入形参
        return new PersonDAOImpl(conn);//双重形参
    }

    public static IAddressDAO getIAddressDAOInstance(Connection conn){
        return new AddressDAOImpl(conn);
    }
}