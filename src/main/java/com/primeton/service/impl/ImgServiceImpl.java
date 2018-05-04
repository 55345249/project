package com.primeton.service.impl;

import com.primeton.domain.Img;
import com.primeton.repository.img.ImgMapper;
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
    public void insert(Img img){
        imgMapper.insert(img);
    }
    public void del(String id){
        imgMapper.del(id);
    }


}
