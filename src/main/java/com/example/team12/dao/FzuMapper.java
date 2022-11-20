package com.example.team12.dao;

import org.apache.ibatis.annotations.*;

/**
 * @author cr
 * &#064;date   2022/11/11
 * 使用注解方式进行数据库查询
 */
@Mapper
public interface FzuMapper {
    @Select("select activity_name from fzumap where address = #{address}")
    String user_show(@Param("address")String address);

    @Update("update fzumap set activity_name = #{activity_name} where address=#{address}")
    int updatedate(@Param("address")String address,@Param("activity_name")String activity_name);
}
