package com.nucleiassignment3.HttpServer.utility;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdGenerator {

    private static SecureRandom RANDOM=new SecureRandom();
    private static final String ALLOWED_CHARS="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public String employeeIdGen()
    {
        return "GN-"+ IntStream.range(0,3)
                .mapToObj(obj->
                        IntStream.range(0,7)
                                .mapToObj(dummy->String.valueOf(
                                        ALLOWED_CHARS.charAt(RANDOM.nextInt(ALLOWED_CHARS.length()))))
                                .collect(Collectors.joining()))
                .collect(Collectors.joining());
    }
}
