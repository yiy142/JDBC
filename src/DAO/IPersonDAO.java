package DAO;
import vo.Address;
import vo.Person;
import java.util.*;

public interface IPersonDAO {
    //数据的增加操作
    public boolean doCreate(Person vo) throws Exception;

    //数据的修改操作
    public boolean doUpdate(Person vo) throws Exception;

    //数据的批量删除操作
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    //数据的查询操作
    public Person findById(Integer id) throws Exception;

    //查询指定数据表的全部记录 并且以集合形式返回
    public List<Person> findAll()throws Exception;

    public Address match (Integer id) throws Exception;

}
