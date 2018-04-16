package com.ssmblog.core.service;

import com.ssmblog.core.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/4/8
 * @description 文章管理
 */
public interface ArticleService {

    /**
     * 查询文章
     * @param map
     * @return
     */
    public List<Article> findArticle(Map<String,Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalArticle(Map<String, Object> map);

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    public int addArticle(Article article);

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    public int updateArticle(Article article);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteArticle(String id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Article findById(String id);

}
