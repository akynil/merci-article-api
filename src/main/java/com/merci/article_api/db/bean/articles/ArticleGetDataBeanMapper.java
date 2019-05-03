package com.merci.article_api.db.bean.articles;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * DBのカラムと{@link ArticleGetDataBean}をマッピングするRowMapper
 */
public class ArticleGetDataBeanMapper implements RowMapper<ArticleGetDataBean> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleGetDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArticleGetDataBean bean = new ArticleGetDataBean();
        bean.setArticleId(rs.getInt("article_id"));
        bean.setArticleTitle(rs.getString("article_title"));
        bean.setArticleUrl(rs.getString("article_url"));
        bean.setDescription(rs.getString("description"));
        bean.setSiteName(rs.getString("site_name"));
        bean.setSiteUrl(rs.getString("site_url"));
        bean.setPublishedDate(rs.getTimestamp("published_date"));
        return bean;
    }
}
