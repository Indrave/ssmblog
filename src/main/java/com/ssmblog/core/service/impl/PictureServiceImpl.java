package com.ssmblog.core.service.impl;

import com.ssmblog.core.entity.Picture;
import com.ssmblog.core.service.PictureService;

import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/3/24
 * @description
 */
public class PictureServiceImpl implements PictureService{
    @Override
    public List<Picture> findPicture(Map<String, Object> map) {
        return null;
    }

    @Override
    public Long getTotalPicture(Map<String, Object> map) {
        return null;
    }

    @Override
    public int addPicture(Picture picture) {
        return 0;
    }

    @Override
    public int updatePicture(Picture picture) {
        return 0;
    }

    @Override
    public int deletePicture(String id) {
        return 0;
    }

    @Override
    public Picture findPictureById(String id) {
        return null;
    }
}
