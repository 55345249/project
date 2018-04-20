package com.primeton.repository;

import com.primeton.domain.CapUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from cap_user limit #{startNum},#{viewNum}")
    List<CapUser> selectUser(@Param("startNum") Integer startNum,@Param("viewNum") Integer viewNum);

    @Insert("INSERT INTO cap_user(operator_id,tenant_id,user_id,user_name,password,unlocktime,lastlogin,createtime) VALUES (#{operatorId},#{tendId},#{userId}, #{userName},#{passWord},#{unlockTime},#{lastLogin},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "operatorId", keyColumn = "operator_id")
    void insert(CapUser user);
}
