package com.merci.article_api.domain.service.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merci.article_api.db.bean.articles.ArticleGetDataBean;
import com.merci.article_api.db.repository.ArticlesRepository;
import com.merci.article_api.domain.bean.request.ArticleGetRequestBean;
import com.merci.article_api.domain.bean.result.ArticleGetResultBean;

/**
 * 記事取得サービス
 */
@Service
@Transactional(readOnly = true)
public class ArticleGetService {

    @Autowired
    private ArticlesRepository repository;

    /**
     * 業務処理を実施する。
     *
     * @param reqBean 要求Bean
     * @return resBean 結果Bean
     */
    public ArticleGetResultBean execute(ArticleGetRequestBean reqBean) {
        ArticleGetDataBean article = repository.getArticleById(reqBean.getArticleId());

        ArticleGetResultBean resBean = new ArticleGetResultBean();
        resBean.setArticle(article);
        return resBean;
    }

}
