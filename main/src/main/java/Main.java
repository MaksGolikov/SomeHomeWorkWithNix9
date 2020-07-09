import service.BlockService;
import service.impl.BlockServiceImpl;
import util.RetryUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InterruptedException {

        RetryUtil retry = new RetryUtil();
        BlockService block = new BlockServiceImpl();

        System.out.println("How many times do you want? Please enter your number: ");

        int number = 0;
        while (true) {
            try {
                number = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Please , enter the INTEGER!!!");
            }
        }
        int k = 0;
        retry.repeat(number, block, k);

    }
}
