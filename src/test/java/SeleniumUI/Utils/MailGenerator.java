package SeleniumUI.Utils;

import java.util.Random;

public class MailGenerator {

  public static String generateRandomEmail(){
    return "joe" + new Random().nextInt(10000)+ "@mail.com";
  }

}
