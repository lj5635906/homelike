package com.homelike.common.core.util;

import java.util.Random;

/**
 * 随机数工具类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 15:27
 **/
public class RandomUtil {

    private RandomUtil() {
    }

    /**
     * 获取一个长度为length的随机数
     *
     * @param length 长度
     * @return 随机数
     */
    public static String getRandom(int length) {
        StringBuffer randomNum = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(9);
            randomNum.append(num);
        }
        return randomNum.toString();
    }

    public static void main(String[] args) {
        String num = RandomUtil.getRandom(6);
        System.out.println(num);
    }

}
