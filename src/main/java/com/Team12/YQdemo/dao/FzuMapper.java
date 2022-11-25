package com.Team12.YQdemo.dao;

import com.Team12.YQdemo.bean.fzumap;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author cr
 * &#064;date   2022/11/11
 * 使用注解方式进行数据库查询
 */
@Mapper
public interface FzuMapper {
    @Select("select * from fzumap")//用户根据地点显示相应活动
    List<fzumap>user_show();

    @Update("update fzumap set activity_name = #{activity_name} where address=#{address}")//管理员端选择地址修改对应地址的活动
    void updatedate(@RequestParam("address") String address,@RequestParam("activity_name") String activity_name);
}
