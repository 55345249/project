package com.primeton.service.impl;

import com.primeton.domain.Img;
import com.primeton.repository.ImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl {
    @Autowired
    private ImgMapper imgMapper;

    public List<Img> selectImg(String describe){
        return imgMapper.selectImg(describe);
    }

    public List<Img> selectImg1(){
        return imgMapper.selectImg1();
    }

}
