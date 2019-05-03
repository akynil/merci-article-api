package com.merci.article_api.app.form.response.articles;

import com.merci.article_api.db.bean.articles.ArticleGetDataBean;

/**
 * 記事取得レスポンスForm
 */
public class ArticleGetResponseForm {
    /** 記事 */
    ArticleGetDataBean article;

    /**
     * 記事を取得する。
     *
     * @return 記事
     */
    public ArticleGetDataBean getArticl() {
        return article;
    }

    /**
     * 記事を設定する。
     *
     * @param article 記事
     */
    public void setArticle(ArticleGetDataBean article) {
        this.article = article;
    }
}
