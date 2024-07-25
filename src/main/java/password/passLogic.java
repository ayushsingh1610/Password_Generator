package password;

import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class passLogic {

    public static String getPassword1(int length, boolean isNumber, boolean isCapital, boolean isSmall)
    {
        String result = RandomStringUtils.random(length,isCapital,isNumber);

        return result;
    }

    public static String getPassword2(int length, boolean isNumber, boolean isCapital, boolean isSmall, boolean isSpecial) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String specialCase = "!@#$%&*+";
        String number = "1234567890";
        String allChars = "";

        if(isCapital)   allChars += upperCase;
        if(isSmall)     allChars += lowerCase;
        if(isNumber)    allChars += number;
        if(isSpecial)   allChars += specialCase;
        if(!isCapital && !isSmall && !isNumber && !isSpecial)
        {
            allChars += upperCase + lowerCase + number + specialCase;
        }

        StringBuilder password = new StringBuilder(length);
        Random rand = new Random();
        for(int i=0;i<length;i++)
        {
            int index = rand.nextInt(allChars.length());
            password.append(allChars.substring(index,index+1));
        }
        return password.toString();
    }

}
