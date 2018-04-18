package com.ssmblog.core.admin;

import com.ssmblog.core.entity.Article;
import com.ssmblog.core.entity.PageBean;
import com.ssmblog.core.service.ArticleService;
import com.ssmblog.core.util.DateUtil;
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
     *
     * @param page
     * @param rows
     * @param article
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/list")
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
        ResponseUtil.write(response, result);
        log.info("request:article/list,map:" + map.toString());
        return null;
    }

    /**
     * 保存或修改文章
     * @param article
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/save")
    public String save(Article article, HttpServletResponse response) throws IOException {
        int resultTotal = 0;
        if (article.getId() == null) {
            article.setArticleCreateDate(DateUtil.getCurrentDateStr());
            resultTotal = articleService.addArticle(article);
        } else {
            resultTotal = articleService.updateArticle(article);
        }
        JSONObject result = new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else {
            result.put("success", false);
        }
        ResponseUtil.write(response,result);
        log.info("request:article/save,article:"+article.toString());
        return null;
    }

    /**
     * 删除文章
     * @param ids
     * @param response
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids,HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        String[] idArray = ids.split(",");
        for (String id: idArray
             ) {
            articleService.deleteArticle(id);
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        log.info("request:article/delete,ids:" + ids);
        return null;
    }

    /**
     * 根据id查找
     * @param id
     * @param response
     * @return
     */
    @RequestMapping("/findById")
    public String findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws IOException {
        Article article = articleService.findById(id);
        JSONObject result = JSONObject.fromObject(article);
        ResponseUtil.write(response,result);
        log.info("request:article/findById+id"+id);
        return null;
    }


}
