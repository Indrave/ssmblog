package logger;

import org.apache.log4j.Logger;

/**
 * @author wangyj
 * @date 2018/3/15
 * @description
 */
public class LogTest {

    static Logger log = Logger.getLogger(LogTest.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            log.info("log输出info：" + i);
            log.debug("log输出debug:"+i);
        }
        long time = System.currentTimeMillis() - start;
        log.info("所用时间" + time);
    }


}
