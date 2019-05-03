package com.merci.article_api.db.bean.articles;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * DBのカラムと{@link ArticleListGetDataBean}をマッピングするRowMapper
 */
public class ArticleListGetDataBeanMapper implements RowMapper<ArticleListGetDataBean> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleListGetDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArticleListGetDataBean bean = new ArticleListGetDataBean();
        bean.setArticleId(rs.getInt("article_id"));
        bean.setArticleTitle(rs.getString("article_title"));
        bean.setSiteName(rs.getString("site_name"));
        bean.setSiteUrl(rs.getString("site_url"));
        bean.setPublishedDate(rs.getTimestamp("published_date"));
        return bean;
    }
}
