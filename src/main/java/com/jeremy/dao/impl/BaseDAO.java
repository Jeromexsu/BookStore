package com.jeremy.dao.impl;

import com.jeremy.bean.User;
import com.jeremy.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改操作
     * @param sql
     * @param params
     * @return 返回操作行数，-1表示执行失败
     */
    public int update(String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        int rows = -1;
        try {
            rows = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {} finally {
            JDBCUtils.close(connection);
        }
        return rows;
    }

    public <T> T query(Class<T> type,String sql,Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            BeanHandler<T> rsh = new BeanHandler<>(type);
            return queryRunner.query(connection,sql,rsh,params);
        } catch (SQLException e) {} finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    public <T> List<T> queryList(Class<T> type, String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            BeanListHandler<T> rsh = new BeanListHandler<>(type);
            return queryRunner.query(connection,sql,rsh,params);
        } catch (SQLException e) {} finally {
            JDBCUtils.close(connection);
        }
        return  null;
    }

    public Object queryVal(String sql, Object... params) {
        Connection connection = JDBCUtils.getConnection();
        try {
            ScalarHandler rsh = new ScalarHandler();
            queryRunner.query(connection,sql,rsh,params);
        } catch (SQLException e) {} finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

}
