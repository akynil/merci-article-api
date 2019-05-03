package com.merci.article_api.domain.bean.request;

/**
 * 記事取得要求Bean
 */
public class ArticleGetRequestBean {
    /** 記事ID */
    private int articleId = 0;

    /**
     * 記事IDを取得する。
     *
     * @return 記事ID
     */
    public int getArticleId() {
        return articleId;
    }

    /**
     * 記事IDを設定する。
     *
     * @param articleId 記事ID
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

}
