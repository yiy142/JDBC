package Service;

import java.util.List;
import java.util.Set;

import vo.Address;
import vo.Person;

//业务层通信标准 业务层接口 并且继承此接口的类在业务层一定要负责数据库的打开和关闭操作
//此外继承此接口的类可以通过DAOFactory类取得IEmpDAO接口对象
//业务层能用int还是使用int型 不用包装类 便于区分
public interface IPersonService {
    public void close() throws Exception;

    public  boolean insert(Person vo)throws Exception;

    public  boolean update(Person vo)throws Exception;

    public  boolean delete(Set<Integer> ids)throws Exception;

    public  Person get(int ids)throws Exception;

    public List<Person> list() throws Exception;

    public Address match(Integer id) throws Exception;

}
