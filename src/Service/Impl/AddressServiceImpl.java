package Service.Impl;
import Service.IAddressService;
import DBC.DataBaseConnection;
import vo.Address;
import DAO.Factory.DAOFactory;

import java.util.List;
import java.util.Set;

public class AddressServiceImpl implements IAddressService {
    //数据库连接类，实例化以后就连接上了数据库 所以我们之后的方法 一定有finally 用来关闭数据库 this.dbc.close
    public DataBaseConnection dbc = new DataBaseConnection();

    @Override
    public boolean insert(Address vo) throws Exception {
        try {
            if (DAOFactory.getIAddressDAOInstance(this.dbc.getConnection()).findById(vo.getPersonId()) == null) {
                return DAOFactory.getIAddressDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(Address vo) throws Exception {
        try {
            return DAOFactory.getIAddressDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIAddressDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Address get(int ids) throws Exception {
        try {
            return DAOFactory.getIAddressDAOInstance(this.dbc.getConnection()).findById(ids);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Address> list() throws Exception {
        try {
            return DAOFactory.getIAddressDAOInstance(this.dbc.getConnection()).findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        try {
            this.dbc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}