package com.pangu.utils.generator;

import com.pangu.utils.common.IdCardUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 身份证生成器test
 * @author LZG
 * @date 2018/10/29
 */
public class IdGenGeneratorTest {

    @Test
    public void test() {
        IdCardGenerator g = new IdCardGenerator();
        List<String> idCardList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            idCardList.add(g.generate());
        }

        for (String idCardStr : idCardList) {
            System.out.println("身份证号：" + idCardStr);
            System.out.println("是否是有效身份证：" + IdCardUtil.validateCard(idCardStr));
            System.out.println("--------------------------");
        }
    }
}