package com.ssmblog.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangyj
 * @date 2018/4/7
 * @description
 */
public class DateUtil {

    /**
     * 格式化时间
     * @param date
     * @param format
     * @return
     */
    public static String formateDate(Date date,String format){
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if(date!=null){
            result = sdf.format(date);
        }
        return result;
    }

    public static Date formatString(String str,String format) throws ParseException {
        if(StringUtil.isEmpty(str)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    public static String getCurrentDateStr(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
