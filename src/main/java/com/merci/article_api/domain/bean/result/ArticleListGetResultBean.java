package com.merci.article_api.domain.bean.result;

import java.util.List;

import com.merci.article_api.db.bean.articles.ArticleListGetDataBean;

/**
 * 記事一覧取得結果Bean
 */
public class ArticleListGetResultBean {
    /** 記事一覧 */
    List<ArticleListGetDataBean> articleList;

    /**
     * 記事一覧を取得する。
     *
     * @return 記事一覧
     */
    public List<ArticleListGetDataBean> getArticleList() {
        return articleList;
    }

    /**
     * 記事一覧を設定する。
     *
     * @param articleList 記事一覧
     */
    public void setArticleList(List<ArticleListGetDataBean> articleList) {
        this.articleList = articleList;
    }
}
