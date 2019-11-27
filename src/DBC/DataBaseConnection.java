package DBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DataBaseConnection {
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://127.0.0.1:3306/mydb";//这里是Oracle数据库的写法
    private static final String DBUSER="root";
    private static final String PASSWORD="1997728yy";

    private Connection conn=null;
    //在构造方法里为conn对象实例化，可以直接取得数据库的连接对象
    public DataBaseConnection() {
        try{
            Class.forName(DBDRIVER);
            //连接数据库
            this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //取得一个数据库的连接对象 返回一个Connection的实例对象
    public Connection getConnection(){
        return this.conn;
    }

    //负责数据库的关闭
    public void close(){
        if(this.conn!=null){//表示现在存在有我们的连接对象
            try{
                this.conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
