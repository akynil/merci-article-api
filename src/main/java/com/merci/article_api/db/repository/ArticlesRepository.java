package com.merci.article_api.db.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.merci.article_api.common.constant.articles.ArticleGenre;
import com.merci.article_api.db.bean.articles.ArticleGetDataBean;
import com.merci.article_api.db.bean.articles.ArticleGetDataBeanMapper;
import com.merci.article_api.db.bean.articles.ArticleListGetDataBean;
import com.merci.article_api.db.bean.articles.ArticleListGetDataBeanMapper;
import com.merci.article_api.domain.bean.request.ArticleListGetRequestBean;

/**
 * 記事テーブルRepository
 */
@Repository
public class ArticlesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 記事ジャンルコードを条件に記事一覧を取得する。<br>
     * 記事ジャンルコードを指定しない場合は、すべてのジャンルの記事を取得する。
     *
     * @param bean 記事一覧取得要求Bean
     * @return 記事一覧
     */
    public List<ArticleListGetDataBean> getArticleListByGenre(ArticleListGetRequestBean bean) {
        ArticleGenre genre = bean.getGenre();
        int limit = bean.getRecodeNum();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT");
        sql.append(" a.article_id");
        sql.append(" , ag.article_id");
        sql.append(" , a.article_title");
        sql.append(" , a.site_name");
        sql.append(" , a.site_url");
        sql.append(" , a.published_date ");
        sql.append(" , ag.genre_cd ");

        sql.append("FROM");
        sql.append(" articles a ");
        sql.append(" INNER JOIN article_genres ag ");
        sql.append(" ON a.article_id = ag.article_id ");
        sql.append(" AND ag.deleted_on IS NULL ");
        if (Objects.nonNull(genre)) {
            sql.append(" AND ag.genre_cd = :genreCd ");
        }

        sql.append("WHERE");
        sql.append(" a.deleted_on IS NULL ");
        sql.append("GROUP BY");
        sql.append(" ag.article_id ");
        sql.append("ORDER BY");
        sql.append(" a.created_on DESC ");
        sql.append(" , a.article_id ASC ");
        sql.append("LIMIT");
        sql.append(" :limit");

        // パラメータ設定
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("limit", limit);
        if (Objects.nonNull(genre)) {
            paramMap.addValue("genreCd", genre.getCode());
        }

        SqlParameterSource param = paramMap;
        return template.query(sql.toString(), param, new ArticleListGetDataBeanMapper());
    }

    /**
     * 記事IDを条件に記事を取得する。
     *
     * @param articleId 記事ID
     * @return 記事
     */
    public ArticleGetDataBean getArticleById(int articleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT");
        sql.append("  a.article_id");
        sql.append("  , a.article_title");
        sql.append("  , a.article_url");
        sql.append("  , a.description");
        sql.append("  , a.site_name");
        sql.append("  , a.site_url");
        sql.append("  , a.published_date ");

        sql.append("FROM");
        sql.append("  articles a ");

        sql.append("WHERE");
        sql.append("  a.deleted_on IS NULL ");
        sql.append("  AND a.article_id = :articleId ");

        // パラメータ設定
        SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);

        return template.queryForObject(sql.toString(), param, new ArticleGetDataBeanMapper());
    }

}
