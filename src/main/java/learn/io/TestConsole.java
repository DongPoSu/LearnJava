package learn.io;

import org.junit.Test;

import java.io.Console;
import java.util.Arrays;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.io
 * company: SiBu
 * create_date: 2018/01/16
 * description :
 */
public class TestConsole {
    public static void main(String[] args) {
        Console c = System.console();
        String username = c.readLine("User name:");
        c.printf("user:"+username+"\n");
        char []passwd = c.readPassword("Password:");
        c.printf(String.valueOf(passwd));
    }
}
