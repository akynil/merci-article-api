package com.merci.article_api.common.constant.articles;

import com.merci.article_api.common.constant.EnumCodeInterface;

/**
 * 記事ジャンルの定義
 */
public enum ArticleGenre implements EnumCodeInterface {
    /** art:美術 */
    ART("art", "美術"),
    /** coffee:コーヒー */
    COFFEE("coffee", "コーヒー"),
    /** cafe:カフェ */
    CAFE("cafe", "カフェ");

    /** コード */
    private String code;
    /** 設定値 */
    private String value;

    private ArticleGenre(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * 設定値を取得する。
     *
     * @return value 設定値
     */
    public String getValue() {
        return value;
    }
}
