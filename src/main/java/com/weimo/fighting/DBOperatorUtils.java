package com.weimo.fighting;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class DBOperatorUtils {

    private static DBOperatorUtils dbOperatorUtils;
    private SqlSessionFactory sqlSessionFactory;
    public static Logger logger=Logger.getLogger(DBOperatorUtils.class.getName());

    private DBOperatorUtils(){
        InputStream inputStream;
        try {
            inputStream=Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    public static DBOperatorUtils getInstance(){
        if (dbOperatorUtils==null) {
            dbOperatorUtils=new DBOperatorUtils();
        }
        return dbOperatorUtils;
    }

    public SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
