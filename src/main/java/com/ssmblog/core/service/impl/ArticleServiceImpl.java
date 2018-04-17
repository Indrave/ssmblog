package com.ssmblog.core.service.impl;

import com.ssmblog.core.dao.ArticleDao;
import com.ssmblog.core.entity.Article;
import com.ssmblog.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/4/17
 * @description
 */
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findArticle(Map<String, Object> map) {
        return articleDao.findArticles(map);
    }

    @Override
    public Long getTotalArticle(Map<String, Object> map) {
        return articleDao.getTotalArticles(map);
    }

    @Override
    public int addArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updArticle(article);
    }

    @Override
    public int deleteArticle(String id) {
        return articleDao.delArticle(id);
    }

    @Override
    public Article findById(String id) {
        return articleDao.getArticleById(id);
    }
}
