package com.june.demo.util;

/**
 * 工具类
 *
 * @author think
 */
public class CmdUtil {

    public static void printCmd(String... cmds) {
        StringBuilder text = new StringBuilder("$ ");
        for (String cmd : cmds) {
            text.append(cmd).append(" ");
        }
        System.out.println(text.toString());
    }

    public static void printResult(Object result) {
        System.out.println(
                result instanceof byte[]
                        ? new String((byte[]) result)
                        : result);
    }
}
