package com.merci.article_api.domain.bean.request;

import com.merci.article_api.common.constant.articles.ArticleGenre;

/**
 * 記事一覧取得要求Bean
 */
public class ArticleListGetRequestBean {
    /** 記事ジャンル */
    private ArticleGenre genre;
    /** 取得件数 */
    private int recodeNum = 0;

    /**
     * 記事ジャンルを取得する。
     *
     * @return 記事ジャンル
     */
    public ArticleGenre getGenre() {
        return genre;
    }

    /**
     * 記事ジャンルを設定する。
     *
     * @param genre 記事ジャンル
     */
    public void setGenre(ArticleGenre genre) {
        this.genre = genre;
    }

    /**
     * 取得件数を取得する。
     *
     * @return 取得件数
     */
    public int getRecodeNum() {
        return recodeNum;
    }

    /**
     * 取得件数を設定する。
     *
     * @param getNum 取得件数
     */
    public void setRecodeNum(int recodeNum) {
        this.recodeNum = recodeNum;
    }

}
