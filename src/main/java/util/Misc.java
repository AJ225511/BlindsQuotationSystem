package util;

import java.math.BigInteger;
import java.util.UUID;

public class Misc {

    public static String generateId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
