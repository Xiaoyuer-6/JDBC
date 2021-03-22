import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-03-21
 * Time: 23:20
 */
public class  TestDemo {
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";
        Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;

        //3.执行sql语句
        String sql = "select * from user";

        Statement statement = connection.createStatement();//获取statement 对象；

        ResultSet resultSet = statement.executeQuery(sql);//executeQuery(sql)查询语句；返回值为ResultSet;查询所有的结果在ResultSet地下

        if (resultSet.next()) {//resultset。next 获取时自动会想向下移    System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }


    }

    public static void main2(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";
        Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;

        //3.执行sql语句
        String sql = "select * from user  where name ='bit' and passord = '123'";

        Statement statement = connection.createStatement();//获取statement 对象；

        ResultSet resultSet = statement.executeQuery(sql);//executeQuery(sql)查询语句；返回值为ResultSet;查询所有的结果在ResultSet地下

        if (resultSet.next()) {//resultset。next 获取时自动会想向下移,多条数据改为while;
            User user = new User();
            user.setId(resultSet.getInt(1));//下标必须从1开始
            user.setName(resultSet.getString(2));
            user.setPassord(resultSet.getString(3));
            System.out.println(user);

        }

    }
    public static void main3(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";
        Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;

        //3.执行sql语句
        String sql = "select * from user  where name ='bit' and passord = '123'";

        Statement statement = connection.createStatement();//获取statement 对象；

        ResultSet resultSet = statement.executeQuery(sql);//executeQuery(sql)查询语句；返回值为ResultSet;查询所有的结果在ResultSet地下

        if (resultSet.next()) {//resultset。next 获取时自动会想向下移,多条数据改为while;
            User user = new User();
            user.setId(resultSet.getInt(1));//下标必须从1开始
            user.setName(resultSet.getString(2));
            user.setPassord(resultSet.getString(3));
            System.out.println(user);

        }

    }
    public static void main4(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";
        Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;

        //3.执行sql语句
        String uname = "bit";
        String upassord = "123";
        String sql = "select * from user  where name ='"+uname+"' and passord = '"+upassord+"'";//定义成变量形式,原始写法，一般不这样写
//需注意，这样写拼接时不能有空格，
        Statement statement = connection.createStatement();//获取statement 对象；

        ResultSet resultSet = statement.executeQuery(sql);//executeQuery(sql)查询语句；返回值为ResultSet;查询所有的结果在ResultSet地下

        if (resultSet.next()) {//resultset。next 获取时自动会想向下移,多条数据改为while;
            User user = new User();
            user.setId(resultSet.getInt(1));//下标必须从1开始
            user.setName(resultSet.getString(2));
            user.setPassord(resultSet.getString(3));
            System.out.println(user);

        }

    }



    public static void main5(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";
        Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;

        //3.执行sql语句
        String uname = "bit";
        String upassord = "1'or '1' ='1";// 使用statement时，会发生 sql注入
        String sql = "select * from user  where name ='"+uname+"' and passord = '"+upassord+"'";//定义成变量形式,原始写法，一般不这样写
//需注意，这样写拼接时不能有空格，
        Statement statement = connection.createStatement();//获取statement 对象；

        ResultSet resultSet = statement.executeQuery(sql);//executeQuery(sql)查询语句；返回值为ResultSet;查询所有的结果在ResultSet地下

        if (resultSet.next()) {//resultset。next 获取时自动会想向下移,多条数据改为while;
            User user = new User();
            user.setId(resultSet.getInt(1));//下标必须从1开始
            user.setName(resultSet.getString(2));
            user.setPassord(resultSet.getString(3));
            System.out.println(user);

        }

    }

//prepareStatement作用：预防sql注入和预编译
    public static void main6(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";

        //数据源
        DataSource dataSource = new MysqlDataSource();//         DataSource 连接池

        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        //Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;
//数据库连接池连接
        Connection connection = dataSource.getConnection();
        //MysqlDataSource 不具备连接池的概念



        //3.执行sql语句
        String uname = "bit";
        String upassord = "1'or '1' ='1";//防止sql注入
        //String sql = "select * from user where name = '"+uname+"' and password='"+upass+"'";
        String sql = "select * from user  where name = ? and passord = ?";//定义成变量形式,原始写法，一般不这样写
//需注意，这样写拼接时不能有空格，


       // Statement statement = connection.createStatement();//获取statement 对象；

       PreparedStatement preparedStatement    = connection.prepareStatement(sql);//prepareStatement作用：预防sql注入和预编译
       preparedStatement.setString(1,uname);
       preparedStatement.setString(2,upassord);

        System.out.println("sql："+preparedStatement.toString());

        ResultSet resultSet = preparedStatement.executeQuery();//executeQuery(sql)查询语句；返回值为ResultSet;查询所有的结果在ResultSet地下

        if (resultSet.next()) {//resultset。next 获取时自动会想向下移,多条数据改为while;
            User user = new User();
            user.setId(resultSet.getInt(1));//下标必须从1开始
            user.setName(resultSet.getString(2));
            user.setPassord(resultSet.getString(3));
            System.out.println(user);

        }
        //关闭顺序：
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }
    //通过preparedStatement学习增删查改；



    public static void main7(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";

        //数据源
        DataSource dataSource = new MysqlDataSource();//         DataSource 连接池

        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        //Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;
//数据库连接池连接
        Connection connection = dataSource.getConnection();
        //MysqlDataSource 不具备连接池的概念



        //3.执行sql语句

        String sql = "insert into user(id,name,passord) values (?,?,?)";


        PreparedStatement preparedStatement    = connection.prepareStatement(sql);//prepareStatement作用：预防sql注入和预编译
        preparedStatement.setInt(1,2);
        preparedStatement.setString(2,"huyu");
        preparedStatement.setString(3,"025");



        System.out.println("sql："+preparedStatement.toString());

        //除了 查询 其他都要用executeUpdate  返回值是受影响的行数
        int ret  = preparedStatement.executeUpdate();//executeUpdate为插入语句，返回值为int、要用int接受

        if(ret != 0) {
            System.out.println("插入成功！");
        }

        //关闭顺序：
        preparedStatement.close();
        connection.close();


    }



    public static void main8(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";

        //数据源
        DataSource dataSource = new MysqlDataSource();//         DataSource 连接池

        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        //Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;
//数据库连接池连接
        Connection connection = dataSource.getConnection();
        //MysqlDataSource 不具备连接池的概念



        //3.执行sql语句

        String sql = "update user set name=? where id=?";


        PreparedStatement preparedStatement    = connection.prepareStatement(sql);//prepareStatement作用：预防sql注入和预编译
        preparedStatement.setString(1,"huyu2");
        preparedStatement.setInt(2,2);




        System.out.println("sql："+preparedStatement.toString());

        //除了 查询 其他都要用executeUpdate  返回值是受影响的行数
        int ret  = preparedStatement.executeUpdate();//executeUpdate为插入语句，返回值为int、要用int接受

        if(ret != 0) {
            System.out.println("更新成功！");
        }

        //关闭顺序：
        preparedStatement.close();
        connection.close();


    }

    public static void main9(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";

        //数据源
        DataSource dataSource = new MysqlDataSource();//         DataSource 连接池

        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        //Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;
//数据库连接池连接
        Connection connection = dataSource.getConnection();
        //MysqlDataSource 不具备连接池的概念



        //3.执行sql语句

        String sql = "delete from user where id=?";


        PreparedStatement preparedStatement    = connection.prepareStatement(sql);//prepareStatement作用：预防sql注入和预编译

        preparedStatement.setInt(1,2);




        System.out.println("sql："+preparedStatement.toString());

        //除了 查询 其他都要用executeUpdate  返回值是受影响的行数
        int ret  = preparedStatement.executeUpdate();//executeUpdate为插入语句，返回值为int、要用int接受

        if(ret != 0) {
            System.out.println("删除成功！");
        }

        //关闭顺序：
        preparedStatement.close();
        connection.close();


    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");//受查异常

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/testjava17_18?useSSL=false";
        String username = "root";
        String password = "1111";

        //数据源
        DataSource dataSource = new MysqlDataSource();//         DataSource 连接池

        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        //Connection connection = DriverManager.getConnection(url, username, password);//此时在import java.sql.SQLException包下;
//数据库连接池连接
        Connection connection = dataSource.getConnection();
        //MysqlDataSource 不具备连接池的概念



        //3.执行sql语句

        String sql = "delete from user where id=?";


        PreparedStatement preparedStatement    = connection.prepareStatement(sql);//prepareStatement作用：预防sql注入和预编译

        preparedStatement.setInt(1,2);




        System.out.println("sql："+preparedStatement.toString());

        //除了 查询 其他都要用executeUpdate  返回值是受影响的行数
        int ret  = preparedStatement.executeUpdate();//executeUpdate为插入语句，返回值为int、要用int接受

        if(ret != 0) {
            System.out.println("删除成功！");
        }

        //关闭顺序：
        preparedStatement.close();
        connection.close();


    }
}
