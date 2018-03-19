package com.primeton.repository;

import com.primeton.domain.Img;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgMapper {
        @Select("select * from img where picture=#{describe}"  )
        public List<Img> selectImg(String describe);

        @Select("select * from img")
        public List<Img> selectImg1();

        @Insert("INSERT INTO img VALUES (#{id}, #{picture},#{describe})")
        public void insert(Img img);

        @Delete("delete from img where id=#{id}")
        public void del(String id);


}
