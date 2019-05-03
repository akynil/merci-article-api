package com.merci.article_api.domain.service.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merci.article_api.db.bean.articles.ArticleListGetDataBean;
import com.merci.article_api.db.repository.ArticlesRepository;
import com.merci.article_api.domain.bean.request.ArticleListGetRequestBean;
import com.merci.article_api.domain.bean.result.ArticleListGetResultBean;

/**
 * 記事一覧取得サービス
 */
@Service
@Transactional(readOnly = true)
public class ArticleListGetService {
    /** 一度に取得する記事の件数 */
    private static final int GET_RECODE_NUM = 50;

    @Autowired
    private ArticlesRepository repository;

    /**
     * 業務処理を実施する。
     *
     * @param reqBean 要求Bean
     * @return resBean 結果Bean
     */
    public ArticleListGetResultBean execute(ArticleListGetRequestBean reqBean) {
        reqBean.setRecodeNum(GET_RECODE_NUM);
        List<ArticleListGetDataBean> articleList = repository.getArticleListByGenre(reqBean);

        ArticleListGetResultBean resBean = new ArticleListGetResultBean();
        resBean.setArticleList(articleList);
        return resBean;
    }

}
