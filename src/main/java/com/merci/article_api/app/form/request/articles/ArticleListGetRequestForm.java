package com.merci.article_api.app.form.request.articles;

import com.merci.article_api.common.validate.ArticleGenreCode;

/**
 * 記事一覧取得リクエストForm
 */
public class ArticleListGetRequestForm {

    /** 記事ジャンルコード */
    @ArticleGenreCode
    private String genreCd;

    /**
     * 記事ジャンルコードを取得する。
     *
     * @return 記事ジャンルコード
     */
    public String getGenreCd() {
        return genreCd;
    }

    /**
     * 記事ジャンルコードを設定する。
     *
     * @param genreCd 記事ジャンルコード
     */
    public void setGenreCd(String genreCd) {
        this.genreCd = genreCd;
    }

}
