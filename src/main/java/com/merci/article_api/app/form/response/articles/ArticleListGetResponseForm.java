package com.merci.article_api.app.form.response.articles;

import java.util.List;

import com.merci.article_api.db.bean.articles.ArticleListGetDataBean;

/**
 * 記事一覧取得レスポンスForm
 */
public class ArticleListGetResponseForm {
    /** 記事一覧 */
    List<ArticleListGetDataBean> articles;

    /**
     * 記事一覧を取得する。
     *
     * @return 記事一覧
     */
    public List<ArticleListGetDataBean> getArticls() {
        return articles;
    }

    /**
     * 記事一覧を設定する。
     *
     * @param articleList 記事一覧
     */
    public void setArticles(List<ArticleListGetDataBean> articles) {
        this.articles = articles;
    }
}
