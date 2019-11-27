package Service;

import vo.Address;

import java.util.List;
import java.util.Set;

public interface IAddressService {
    public  boolean insert(Address vo)throws Exception;

    public  boolean update(Address vo)throws Exception;

    public  boolean delete(Set<Integer> ids)throws Exception;

    public  Address get(int ids)throws Exception;

    public List<Address> list() throws Exception;

    public void close() throws Exception;
}
