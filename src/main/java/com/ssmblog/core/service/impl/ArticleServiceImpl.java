package com.ssmblog.core.service.impl;

import com.ssmblog.core.dao.ArticleDao;
import com.ssmblog.core.entity.Article;
import com.ssmblog.core.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/4/17
 * @description
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
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
        if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticle(null) > 90 || article.getArticleContent().length() > 50000) {
            return 0;
        }
        return articleDao.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticle(null) > 90 || article.getArticleContent().length() > 50000) {
            return 0;
        }
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
