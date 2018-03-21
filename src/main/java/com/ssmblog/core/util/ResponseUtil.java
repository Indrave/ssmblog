package com.ssmblog.core.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangyj
 * @date 2018/3/18
 * @description
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(o.toString());
        printWriter.flush();
        printWriter.close();
    }

}
