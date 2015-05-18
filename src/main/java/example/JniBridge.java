package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cjohannsen on 5/17/15.
 */
public class JniBridge {
    private final static Logger logger = LoggerFactory.getLogger(JniBridge.class);

    static {
        logger.info("***********************************************************************************");
        logger.info("*** Native library initialization sequence beginning.  ");
        logger.info("*** java.library.path: " + System.getProperty("java.library.path"));
        logger.info("***");

        // Load the JNI bridge
        logger.info("***");
        logger.info("*** Loading JNI bridge library...");
        try {
            System.loadLibrary("bridge");
        } catch (Error | Exception e) {
            logger.error("***********************************************************************************");
            logger.error("*** Failed to load JNI bridge library: ", e);
            logger.error("***********************************************************************************");
        }

        logger.info("***");
        logger.info("*** Native library initialization sequence complete.  ");
        logger.info("***********************************************************************************");
    }

    public JniBridge() {
    }

    public long[] calculateSquares(long[] values) {
        logger.debug("Making native call...");
        long[] result = nativeCalculateSquares(values, values.length);
        logger.debug("Native call complete.");
        return result;
    }

    private native long[] nativeCalculateSquares(long[] values, int numValue);
}
