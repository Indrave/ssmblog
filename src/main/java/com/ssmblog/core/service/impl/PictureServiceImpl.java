package com.ssmblog.core.service.impl;

import com.ssmblog.core.dao.PictureDao;
import com.ssmblog.core.entity.Picture;
import com.ssmblog.core.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/3/24
 * @description
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService{

    @Resource
    private PictureDao pictureDao;

    @Override
    public List<Picture> findPicture(Map<String, Object> map) {
        return pictureDao.findPictures(map);
    }

    @Override
    public Long getTotalPicture(Map<String, Object> map) {
        return pictureDao.getTotalPictures(map);
    }

    @Override
    public int addPicture(Picture picture) {
        if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100 || picture.getUrl().length() > 100) {
            return 0;
        }
        return pictureDao.addPicture(picture);
    }

    @Override
    public int updatePicture(Picture picture) {
        if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100 || picture.getUrl().length() > 100) {
            return 0;
        }
        return pictureDao.updPicture(picture);
    }

    @Override
    public int deletePicture(String id) {
        return pictureDao.delPicture(id);
    }

    @Override
    public Picture findPictureById(String id) {
        return pictureDao.findPictureById(id);
    }
}
