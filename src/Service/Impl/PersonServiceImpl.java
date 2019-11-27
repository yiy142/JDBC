package Service.Impl;
import Service.IPersonService;
import DBC.DataBaseConnection;
import vo.Address;
import vo.Person;
import DAO.Factory.DAOFactory;

import java.util.List;
import java.util.Set;

public class PersonServiceImpl implements IPersonService {
    public DataBaseConnection dbc;

    public PersonServiceImpl(){
        //数据库连接类，实例化以后就连接上了数据库 所以我们之后的方法 一定有finally 用来关闭数据库 this.dbc.close
         dbc = new DataBaseConnection();
    }

    @Override
    public Address match(Integer id) throws Exception{
        try{
            return DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).match(id);
        }
        catch (Exception e){
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


    @Override
    public boolean insert(Person vo) throws Exception {
        try {
            if (DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).findById(vo.getPersonId()) == null) {
                return DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
            return false;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public boolean update(Person vo) throws Exception {
        try {
            return DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch (Exception e) {
            throw e;
        }
//        finally {
//            this.dbc.close();
//        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch (Exception e) {
            throw e;
        }
//        finally {
//            this.dbc.close();
//        }
    }

    @Override
    public Person get(int ids) throws Exception {
        try {
            return DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).findById(ids);
        } catch (Exception e) {
            throw e;
        }
//        finally {
//            this.dbc.close();
//        }
    }

    @Override
    public List<Person> list() throws Exception {
        try {
            return DAOFactory.getIPersonDAOInstance(this.dbc.getConnection()).findAll();
        } catch (Exception e) {
            throw e;
        }
//        finally {
//            this.dbc.close();
//        }
    }
}