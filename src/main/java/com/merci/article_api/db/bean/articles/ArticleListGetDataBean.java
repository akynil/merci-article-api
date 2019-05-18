package com.merci.article_api.db.bean.articles;

import java.sql.Timestamp;

/**
 * 記事一覧取得データBean
 */
public class ArticleListGetDataBean {

    /** 記事ID */
    private Integer articleId;

    /** 記事タイトル */
    private String articleTitle;

    /** 記事URL */
    private String articleUrl;

    /** 記事説明 */
    private String description;

    /** サイト名 */
    private String siteName;

    /** サイトURL */
    private String siteUrl;

    /** 公表日時 */
    private Timestamp publishedDate;

    /**
     * 記事IDを取得する。
     *
     * @return 記事ID
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 記事IDを設定する。
     *
     * @param articleId 記事ID
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 記事タイトルを取得する。
     *
     * @return 記事タイトル
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 記事タイトルを設定する。
     *
     * @param articleTitle 記事タイトル
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 記事URLを取得する。
     *
     * @return 記事URL
     */
    public String getArticleUrl() {
        return articleUrl;
    }

    /**
     * 記事URLを設定する。
     *
     * @param articleUrl 記事URL
     */
    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    /**
     * 記事説明を取得する。
     *
     * @return 記事説明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 記事説明を設定する。
     *
     * @param description 記事説明
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * サイト名を取得する。
     *
     * @return サイト名
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * サイト名を設定する。
     *
     * @param siteName サイト名
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * サイトURLを取得する。
     *
     * @return サイトURL
     */
    public String getSiteUrl() {
        return siteUrl;
    }

    /**
     * サイトURLを設定する。
     *
     * @param siteUrl サイトURL
     */
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    /**
     * 公表日時を取得する。
     *
     * @return 公表日時
     */
    public Timestamp getPublishedDate() {
        return publishedDate;
    }

    /**
     * 公表日時を設定する。
     *
     * @param publishedDate 公表日時
     */
    public void setPublishedDate(Timestamp publishedDate) {
        this.publishedDate = publishedDate;
    }

}
