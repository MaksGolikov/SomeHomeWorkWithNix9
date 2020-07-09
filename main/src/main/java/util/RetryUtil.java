package util;
import org.apache.log4j.Logger;
import service.BlockService;
import service.impl.BlockServiceImpl;

public class RetryUtil {
    private static final Logger LOGGER = Logger.getLogger(RetryUtil.class);

    public void repeat(int number, BlockService block, int k) throws NoSuchMethodException, InterruptedException {
        int progression = 1;
        while (k < number) {
            try {
                System.out.print(k+")  ");
                block.run();
            } catch (Exception e) {
                LOGGER.warn("We have " + e +" \nMay be it is will fixed");
                System.out.println("Now the function   " + BlockServiceImpl.class.getMethod("run").getName() + "   wants to try again");
                Thread.sleep(progression);
                progression += 500;
                if (k < number - 1) {
                    repeat(number, block, ++k);
                } else{
                    LOGGER.error("It is not fixed " +e);
                    System.out.println("oops, your attempts is over ");
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
