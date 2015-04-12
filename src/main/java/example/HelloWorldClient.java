package example;

import  java.io.IOException;
/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 12.04.15.
 * e-mail : uakruk@ukr.net
 * GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class HelloWorldClient {
  public static void main(String[] args) {
    try {
      new HelloWorld(args);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("111");
  }
}
