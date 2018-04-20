package com.primeton.repository;

import com.primeton.domain.CapUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

    /*public void validUser(String userName,String passWord){

    }*/
    @Insert("INSERT INTO cap_user(operator_id,tenant_id,user_id,user_name,password,unlocktime,lastlogin,createtime) VALUES (#{operatorId},#{tendId},#{userId}, #{userName},#{passWord},#{unlockTime},#{lastLogin},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="operatorId",keyColumn = "operator_id")
     void insert(CapUser user);
}
