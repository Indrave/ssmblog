package com.ssmblog.core.admin;

import com.ssmblog.core.entity.PageBean;
import com.ssmblog.core.entity.Picture;
import com.ssmblog.core.service.PictureService;
import com.ssmblog.core.util.DateUtil;
import com.ssmblog.core.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/3/25
 * @description
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    //日志记录
    private static final Logger log = Logger.getLogger(PictureController.class);

    private static final Long serialVersionUID = 1L;


    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       Picture picture, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (picture != null) {
            map.put("id", picture.getId());
            map.put("type", picture.getType());
            map.put("grade", picture.getGrade());
        }
        List<Picture> pictureList = pictureService.findPicture(map);
        Long total = pictureService.getTotalPicture(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(pictureList);
        log.info("request:/picture/list,map:" + map.toString());
        result.put("total", total);
        result.put("rows", jsonArray);
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     *删除图片
     * @param ids
     * @param response
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids,HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        String[] idsStr = ids.split(",");
        for (String id: idsStr) {
            pictureService.deletePicture(id);
        }
        result.put("success", true);
        log.info("request:picture/delete,ids:" + ids);
        ResponseUtil.write(response, result);
        return null;
    }


    /**
     * 新增或更新图片
     * @param picture
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/save")
    public String save(Picture picture,HttpServletResponse response) throws IOException {
        int resultTotal = 0;
        if(picture.getId()==null){
            picture.setTime(DateUtil.getCurrentDateStr());
            pictureService.addPicture(picture);
        }else{
            System.out.println(picture.getPath());
            resultTotal = pictureService.updatePicture(picture);
        }
        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        log.info("request: picture/save ,  " + picture.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 根据id查找图片
     * @param id
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public String findById(@RequestParam(value = "id") String id,
                           HttpServletResponse response) throws Exception {
        Picture picture = pictureService.findPictureById(id);
        JSONObject jsonObject = JSONObject.fromObject(picture);
        log.info("request: picture/findById");
        ResponseUtil.write(response, jsonObject);
        return null;
    }

}
