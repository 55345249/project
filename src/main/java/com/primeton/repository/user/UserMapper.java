package com.primeton.repository.user;

import com.primeton.domain.CapUser;
import com.primeton.domain.PageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select operator_id as operatorId,tenant_id as tenantId,user_id as userId,user_name as userName,password,unlocktime,lastlogin,createtime from cap_user limit #{startNum},#{viewNum}")
    List<CapUser> selectUser(@Param("startNum") Integer startNum, @Param("viewNum") Integer viewNum);

    @Insert("INSERT INTO cap_user(operator_id,tenant_id,user_id,user_name,password,unlocktime,lastlogin,createtime) VALUES (#{operatorId},#{tendId},#{userId}, #{userName},#{passWord},#{unlockTime},#{lastLogin},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "operatorId", keyColumn = "operator_id")
    void insert(CapUser user);

    @Select("select count(*) from cap_user")
    Integer queryTotalCount();

    @Select("select operator_id as operatorId,tenant_id as tenantId,user_id as userId,user_name as userName,password,unlocktime,lastlogin,createtime from cap_user order by createtime desc limit #{pageInfo.begin},#{pageInfo.perPageRecordCount}")
    List<CapUser> listUser(@Param("pageInfo") PageInfo pageInfo);


    //PageInfo<CapUser> queryLimitedUser(String username,Integer page, Integer pageSize);

}
