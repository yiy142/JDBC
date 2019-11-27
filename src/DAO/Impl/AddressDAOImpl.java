package DAO.Impl;
import DAO.IAddressDAO;
import vo.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AddressDAOImpl implements IAddressDAO {
    private Connection conn;
    private PreparedStatement pstmt;

    public AddressDAOImpl(Connection conn) {    //由外部传入Connection对象
        this.conn = conn;
    }

    @Override
    public boolean doCreate(Address vo) throws Exception {
        String sql="INSERT INTO Address(AddressId, PersonId,City,State) VALUES(?,?,?,?)";
        this.pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, vo.getAddressId());
        pstmt.setInt(2, vo.getPersonId());
        pstmt.setString(3, vo.getCity());
        pstmt.setString(4, vo.getState());

        return this.pstmt.executeUpdate()>0;//如果为真 就是执行了操作 返回true1 否则返回false0
    }

    @Override
    public boolean doUpdate(Address vo) throws Exception {
        String sql="UPDATE Address PersonId=?, city=?, state=? WHERE AddressId=?";
        this.pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, vo.getPersonId());
        pstmt.setString(2, vo.getCity());
        pstmt.setString(3, vo.getState());
        pstmt.setInt(4, vo.getAddressId());

        return this.pstmt.executeUpdate()>0;//如果为真 就是执行了操作 返回true1 否则返回false0
    }

    //批量删除 数据更新
    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        if(ids==null||ids.size()==0){//如果没有要删除的对象id(即表中idStudent)
            return false;
        }
        StringBuffer sql=new StringBuffer();//拼凑字符串 拼凑sql语句
        sql.append("DELETE FROM Address WHERE AddressId IN(");//append用来正式添加进拼凑的语句中
        Iterator<Integer> iter=ids.iterator();
        while (iter.hasNext()) {
            sql.append(iter.next()).append(",");//添加进ids整型集合中的整型数字 每个数字用","隔开
        }
        sql.delete(ids.size()-1, ids.size());//删除最后一个逗号
        sql.append(")");//加上IN（）的结尾小括号
        this.pstmt=this.conn.prepareStatement(sql.toString());//toString将StringBuffer变为String
        return this.pstmt.executeUpdate()==ids.size();//删除的数量是否等于id集合的长度
    }

    //根据id查询 数据查询 成功返回VO类对象 失败返回null
    @Override
    public Address findById(Integer id) throws Exception {
        Address vo=null;
        String sql="SELECT AddressId, PersonId,City,State FROM Address WHERE AddressId=?";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, id);//根据传入的实参来删除对象

        ResultSet rs=this.pstmt.executeQuery();//对数据库进行查询 有结果返回
        if(rs.next()){
            vo=new Address();
            vo.setPersonId(rs.getInt(1));//逐列读出
            vo.setPersonId(rs.getInt(2));//逐列读出
            vo.setCity(rs.getString(3));
            vo.setState(rs.getString(4));
        }
        return vo;
    }

    //查询全部数据 数据查询
    @Override
    public List<Address> findAll() throws Exception {
        List<Address> all=new ArrayList<Address>();
        String sql="SELECT * FROM Address";
        this.pstmt=this.conn.prepareStatement(sql);
        ResultSet rs=this.pstmt.executeQuery();//对数据库进行查询 有结果返回
        while(rs.next()){//逐行读数据 虽然只有一行
            Address vo=new Address();
            vo.setAddressId((rs.getInt(1)));//逐列读出
            vo.setPersonId(rs.getInt(2));//逐列读出
            vo.setCity(rs.getString(3));
            vo.setState(rs.getString(4));
            all.add(vo);
        }
        return all;
    }


}
