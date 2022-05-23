package com.pangu.utils.generator;

import org.junit.Test;

/**
 * @description: 中文姓名生成器test
 * @author LZG
 * @date 2018/11/5
 */
public class ChineseNameGeneratorTest {

    @Test
    public void test() {
        for(int i = 0; i < 10; i++) {
            System.out.println(ChineseNameGenerator.generate());
        }
    }

}