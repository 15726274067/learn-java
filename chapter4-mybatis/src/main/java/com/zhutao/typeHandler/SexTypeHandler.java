package com.zhutao.typeHandler;

import com.zhutao.enumation.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 类型处理器
 * 处理在mysql与java中类型不一致的字段
 *
 * sex 在mysql中为int, 通过注解 @MappedJdbcTypes(JdbcType.INTEGER)
 * 在java中为SexEnum @MappedTypes(SexEnum.class)
 * @Author: zhutao
 * @Date: 2019/2/12 11:07
 * @Version 1.0
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    /**
     * 设置非空性别参数
     * @param preparedStatement
     * @param i
     * @param sexEnum
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getId());
    }

    // 通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sexId = resultSet.getInt(s);

        return SexEnum.getSexById(sexId);
    }

    // 通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sexId = resultSet.getInt(i);

        return SexEnum.getSexById(sexId);
    }

    // 通过存储过程读取性别
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sexId = callableStatement.getInt(i);

        return SexEnum.getSexById(sexId);
    }
}
