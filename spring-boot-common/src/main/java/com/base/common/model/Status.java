package com.base.common.model;

/**
 * Status model
 */
public class Status {

    /**
     * Status empty constructor to let it instantiate
     */
    public Status() {
        //empty constructor to let instantiate without arguments
    }

    /**
     *
     * @param code
     * @param value
     */
    public Status(int code, String value) {
        this.code = code;
        this.value = value;
    }

    private int code;
    private String value;

    /**
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
