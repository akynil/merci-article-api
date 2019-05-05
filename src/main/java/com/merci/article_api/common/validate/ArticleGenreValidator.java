package com.merci.article_api.common.validate;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.merci.article_api.common.constant.EnumCodeInterface;
import com.merci.article_api.common.constant.articles.ArticleGenre;

/**
 * 対象文字列が{@link ArticleGenre}かを検証するクラス。
 */
public class ArticleGenreValidator implements ConstraintValidator<ArticleGenreCode, String> {

    @Override
    public void initialize(ArticleGenreCode annotation) {
        // nop
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        if (Objects.isNull(code)) {
            return true;
        }
        return EnumCodeInterface.hasCode(ArticleGenre.class, code);
    }
}
