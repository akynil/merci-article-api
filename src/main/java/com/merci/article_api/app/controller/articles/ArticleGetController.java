package com.merci.article_api.app.controller.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.merci.article_api.app.form.request.articles.ArticleGetRequestForm;
import com.merci.article_api.app.form.response.articles.ArticleGetResponseForm;
import com.merci.article_api.domain.bean.request.ArticleGetRequestBean;
import com.merci.article_api.domain.bean.result.ArticleGetResultBean;
import com.merci.article_api.domain.service.articles.ArticleGetService;

/**
 * 記事取得 Controller
 */
@SpringBootApplication
@RestController
@RequestMapping(value = "/articles")
public class ArticleGetController {

    @Autowired
    private ArticleGetService service;

    /**
     * 記事を取得する。
     *
     * @param reqForm リクエストForm
     * @return レスポンスForm
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public ArticleGetResponseForm getArticleList(@PathVariable("articleId") int articleId,
            @Validated @ModelAttribute ArticleGetRequestForm reqForm) {

        ArticleGetRequestBean reqBean = convertToRequestBean(reqForm);
        reqBean.setArticleId(articleId);
        ArticleGetResultBean result = service.execute(reqBean);
        return convertToResponseForm(result);
    }

    /**
     * リクエストFormから値を詰め替え、要求Beanを作成する。
     *
     * @param reqForm リクエストForm
     * @return 要求Bean
     */
    private ArticleGetRequestBean convertToRequestBean(ArticleGetRequestForm reqForm) {
        return new ArticleGetRequestBean();
    }

    /**
     * 結果Beanから値を詰め替え、レスポンスFormを作成する。
     *
     * @param resBean 結果Bean
     * @return レスポンスForm
     */
    private ArticleGetResponseForm convertToResponseForm(ArticleGetResultBean resBean) {
        ArticleGetResponseForm resForm = new ArticleGetResponseForm();
        resForm.setArticle(resBean.getArticle());
        return resForm;
    }

}
