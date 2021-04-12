package MyLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mylog {

    private static final Logger logger = LoggerFactory.getLogger(Mylog.class);

    public static void lDprintf(String info){
        logger.debug(info);
    }
    public static void lIprintf(String info){
        logger.info(info);
    }
    public static void lWprintf(String info){
        logger.warn(info);
    }
    public static void lEprintf(String info) { logger.error(info);}
}
