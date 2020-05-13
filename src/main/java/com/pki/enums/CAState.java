package com.pki.enums;

public enum CAState {
    /**
     * 没审核
     */
    UNDER(0, "未审核"),
    /**
     * 签发
     */
    PASS(1, "通过"),

    NOPASS(2, "未通过");

    private int statCode;
    private String discribe;

    /**
     *
     * @param stateCode
     * @param discribe
     */
    private CAState(int stateCode, String discribe) {
        this.statCode = stateCode;
        this.discribe = discribe;
    }

    /**
     *
     * @return
     */
    public int getStatCode() {
        return statCode;
    }

    /**
     * 得到枚举值得描述
     *
     * @return
     */
    public String getDiscribe() {
        return discribe;
    }

    /**
     * 根据枚举值得到状态�?
     *
     * @param stateCode
     * @return
     */
    public static CAState valueOf(int stateCode) {
        switch (stateCode) {
            case 1:
                return CAState.PASS;
            case 2:
                return CAState.NOPASS;

            default:
                return null;
        }
    }


}
