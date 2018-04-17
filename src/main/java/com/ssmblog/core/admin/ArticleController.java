package com.ssmblog.core.admin;

import com.ssmblog.core.entity.Article;
import com.ssmblog.core.entity.PageBean;
import com.ssmblog.core.service.ArticleService;
import com.ssmblog.core.util.ResponseUtil;
import com.ssmblog.core.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/4/17
 * @description
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(ArticleController.class);

    /**
     * 查询文章
     * @param page
     * @param rows
     * @param article
     * @param response
     * @return
     * @throws IOException
     */
    public String list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Article article, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (article != null) {
            map.put("articleTitle", StringUtil.formatLike(article.getArticleTitle()));
        }
        List<Article> articleList = articleService.findArticle(map);
        Long total = articleService.getTotalArticle(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(articleList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response,result);
        log.info("request:article/list,map:"+map.toString());
        return null;
    }


}
