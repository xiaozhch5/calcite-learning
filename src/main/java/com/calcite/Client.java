package com.calcite;


import org.apache.log4j.Logger;

import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by zhchxiao on 2019-10-17.
 */
public class Client {

    public static void main(String[] args){
        try {
            Logger logger = Logger.getLogger(Client.class);
            URL url = Client.class.getResource("/model.json");
            String s = URLDecoder.decode(url.toString(), "UTF-8");
            // 得到的model文件路径会多一个file:，比如这样子：file:/D:/Users/admin/calcitetest/target/classes/model.json，打个日志出来瞧瞧
            logger.info("model文件路径 \t" + s);
            // 替换一下就没有了
            logger.info("去掉model文件路径前面的file: \t" + s.replace("file:",""));
            Properties info = new Properties();
            info.put("model", s.replace("file:",""));
            logger.info("连接数据库 \t" + "jdbc:calcite:" + info);
            Connection connection = DriverManager.getConnection("jdbc:calcite:", info);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from TEST01");
            while(resultSet.next()){
                System.out.println("data => ");
                System.out.println(resultSet.getObject("value"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
