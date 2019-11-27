package DAO;
import vo.Address;
import java.util.*;

public interface IAddressDAO {

    //数据的增加操作
    public boolean doCreate(Address vo) throws Exception;

    //数据的修改操作
    public boolean doUpdate(Address vo) throws Exception;

    //数据的批量删除操作
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    //数据的查询操作
    public Address findById(Integer id) throws Exception;

    //查询指定数据表的全部记录 并且以集合形式返回
    public List<Address> findAll()throws Exception;


}
