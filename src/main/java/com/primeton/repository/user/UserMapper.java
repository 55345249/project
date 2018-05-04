package com.primeton.repository.user;

import com.github.pagehelper.PageInfo;
import com.primeton.domain.CapUser;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select operator_id as operatorId,tenant_id as tenantId,user_id as userId,user_name as userName,password,unlocktime,lastlogin,createtime from cap_user limit #{startNum},#{viewNum}")
    List<CapUser> selectUser(@Param("startNum") Integer startNum,@Param("viewNum") Integer viewNum);

    @Insert("INSERT INTO cap_user(operator_id,tenant_id,user_id,user_name,password,unlocktime,lastlogin,createtime) VALUES (#{operatorId},#{tendId},#{userId}, #{userName},#{passWord},#{unlockTime},#{lastLogin},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "operatorId", keyColumn = "operator_id")
    void insert(CapUser user);

    /*@Select("select * from cap_user")
    List<CapUser> list(Map<String, Object> map);

    int count(Map<String, Object> map);*/

    List<CapUser> selectByExample(Example example);

    PageInfo<CapUser> queryLimitedUser(String username,Integer page, Integer pageSize);
}
