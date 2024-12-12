package com.maksemses.translatebot.enums;

public enum LANG {
    ru("ru"),
    us("en-US"),
    de("de"),
    cn("ZH-HANS"),
    fr("fr"),
    vn("vi"),
    es("es");
    private String Lang;
    LANG(String Lang) {
        this.Lang = Lang;
    }

    public String getLang() {
        return this.Lang;
    }
}
