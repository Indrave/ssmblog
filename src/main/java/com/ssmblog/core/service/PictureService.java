package com.ssmblog.core.service;

import com.ssmblog.core.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/3/24
 * @description
 */
public interface PictureService {

    /**
     * 查询图片
     * @param map
     * @return
     */
    public List<Picture> findPicture(Map<String, Object> map);

    /**
     * 获取图片数量
     * @param map
     * @return
     */
    public Long getTotalPicture(Map<String,Object> map);

    /**
     * 添加图片
     * @param picture
     * @return
     */
    public int addPicture(Picture picture);

    /**
     * 更新图片
     * @param picture
     * @return
     */
    public int updatePicture(Picture picture);

    /**
     * 删除图片
     * @param id
     * @return
     */
    public int deletePicture(String id);

    /**
     * 根据id查找图片
     * @param id
     * @return
     */
    public Picture findPictureById(String id);

}
