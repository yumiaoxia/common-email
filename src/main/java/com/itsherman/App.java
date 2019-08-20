package com.itsherman;

import com.itsherman.example.EmailSenderExample;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmailSenderExample example = new EmailSenderExample();
        example.sendEmail();
    }
}
