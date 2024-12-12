package com.maksemses.translatebot.enums;

public enum FLAG {
    ru_flag("\uD83C\uDDF7\uD83C\uDDFA"),
    us_flag("\uD83C\uDDFA\uD83C\uDDF8"),
    de_flag("\uD83C\uDDE9\uD83C\uDDEA"),
    cn_flag("\uD83C\uDDE8\uD83C\uDDF3"),
    fr_flag("\uD83C\uDDEB\uD83C\uDDF7"),
    vn_flag("\uD83C\uDDFB\uD83C\uDDF3"),
    es_flag("\uD83C\uDDEA\uD83C\uDDF8");

    private String flag;
    FLAG(String s) {
        this.flag = s;
    }

    public String getFlag() {
        return this.flag;
    }
}
