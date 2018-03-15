package com.primeton.mapper;

import com.primeton.bean.Img;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgMapper {
        @Select("select * from img where picture=#{describe}"  )
        public List<Img> selectImg(String describe);

        @Select("select * from img")
        public List<Img> selectImg1();

}
