package com.june.demo.io;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static final String FILE_SEPARATOR = System.getProperties()
            .getProperty("file.separator");
    public static String FILE_CODE = "UTF-8";
    private static FileInputStream fileInputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static File file = null;
    /**
     * 常用信息放入到内存
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private static List<String> accounts = Lists.newArrayList();

    public static void main(String[] args) {
        /* 读取数据 */
        try {
            file = new File("d:\\renew\\11-29.txt");
            fileInputStream = new FileInputStream(file);


            inputStreamReader = new InputStreamReader(fileInputStream,
                    FILE_CODE);
            BufferedReader br = new BufferedReader(inputStreamReader,
                    60 * 1024 * 1024);
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                String[] lines = lineTxt.split(", ");
                if (lines.length >= 2) {
                    if (lines[1].contains("account")) {
                        String[] names = lines[1].split(":");
                        accounts.add(names[1]);
                    }
                }
            }
            System.out.println(accounts.toString());
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }


    }

}
