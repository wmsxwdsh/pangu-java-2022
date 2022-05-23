package com.pangu.utils.enums;

/**
 * @author LZG
 */
public enum YesNoEnum {

    YES(1),
    NO(0);

    private Integer value;

    YesNoEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

}