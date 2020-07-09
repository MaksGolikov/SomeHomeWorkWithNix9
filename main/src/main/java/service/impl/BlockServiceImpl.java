package service.impl;

import org.apache.log4j.Logger;
import service.BlockService;

public class BlockServiceImpl implements BlockService {
    private final static Logger LOGGER = Logger.getLogger(BlockServiceImpl.class);

    private static final int NUMBER = 5;
    private static final int COUNT = 100;

    @Override
    public void run() throws Exception {

        int number = (int) (Math.random() * COUNT);
        if (number != NUMBER) {
            System.out.println(number + " dont equals " + NUMBER);
            LOGGER.warn("Exeption "+new Exception()+" in method "+ BlockServiceImpl.class.getMethod("run").getName());
            throw new Exception();
        }
        System.out.println(number + " = " + NUMBER);
    }
}
