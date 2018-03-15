package com.primeton.service;

import com.primeton.mapper.ImgMapper;
import com.primeton.bean.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgService {
    @Autowired
    private ImgMapper imgMapper;

    public List<Img> selectImg(String describe){
        return imgMapper.selectImg(describe);
    }

    public List<Img> selectImg1(){
        return imgMapper.selectImg1();
    }

}
