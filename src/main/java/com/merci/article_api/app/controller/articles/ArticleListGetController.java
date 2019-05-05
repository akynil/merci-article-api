package com.merci.article_api.app.controller.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.merci.article_api.app.form.request.articles.ArticleListGetRequestForm;
import com.merci.article_api.app.form.response.articles.ArticleListGetResponseForm;
import com.merci.article_api.common.constant.EnumCodeInterface;
import com.merci.article_api.common.constant.articles.ArticleGenre;
import com.merci.article_api.domain.bean.request.ArticleListGetRequestBean;
import com.merci.article_api.domain.bean.result.ArticleListGetResultBean;
import com.merci.article_api.domain.service.articles.ArticleListGetService;

/**
 * 記事一覧取得 Controller
 */
@SpringBootApplication
@RestController
@RequestMapping(value = "/articles")
public class ArticleListGetController {

    @Autowired
    private ArticleListGetService service;

    /**
     * 記事一覧を取得する。
     *
     * @param reqForm リクエストForm
     * @return レスポンスForm
     */
    @RequestMapping(method = RequestMethod.GET)
    public ArticleListGetResponseForm getArticleList(@ModelAttribute ArticleListGetRequestForm reqForm) {
        ArticleListGetResultBean result = service.execute(convertToRequestBean(reqForm));
        return convertToResponseForm(result);
    }

    /**
     * リクエストFormから値を詰め替え、要求Beanを作成する。
     *
     * @param reqForm リクエストForm
     * @return 要求Bean
     */
    private ArticleListGetRequestBean convertToRequestBean(ArticleListGetRequestForm reqForm) {
        ArticleGenre genre = EnumCodeInterface.getEnumByCode(ArticleGenre.class, reqForm.getGenreCd());

        ArticleListGetRequestBean reqBean = new ArticleListGetRequestBean();
        reqBean.setGenre(genre);
        return reqBean;
    }

    /**
     * 結果Beanから値を詰め替え、レスポンスFormを作成する。
     *
     * @param resBean 結果Bean
     * @return レスポンスForm
     */
    private ArticleListGetResponseForm convertToResponseForm(ArticleListGetResultBean resBean) {
        ArticleListGetResponseForm resForm = new ArticleListGetResponseForm();
        resForm.setArticles(resBean.getArticleList());
        return resForm;
    }

}
