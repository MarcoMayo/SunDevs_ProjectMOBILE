package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSeat {
    public static String number(){
        List<Integer> validNumbers = new ArrayList<>();

        for (int i = 2; i <= 142; i++) {
            if ((i < 16 || i > 20) && (i < 23 || i > 26) && (i < 32 || i > 84) && (i < 95 || i > 99)) {//(i < 17 || i > 22) && (i < 26 || i > 29) && (i < 35 || i > 93) && (i < 125 || i > 165)
                validNumbers.add(i);
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(validNumbers.size());
        int randomNumber = validNumbers.get(randomIndex);

        String randomString = Integer.toString(randomNumber);

        return randomString;

    }
}


