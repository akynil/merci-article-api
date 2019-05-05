package com.merci.article_api.common.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.merci.article_api.common.constant.articles.ArticleGenre;

/**
 * 対象文字列が{@link ArticleGenre}のコードかを検証するアノテーション
 */
@Documented
@Constraint(validatedBy = ArticleGenreValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArticleGenreCode {

    String message() default "ErrorMsg";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Constraint(validatedBy = ArticleGenreValidator.class)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface List {
        ArticleGenreCode[] values();
    }
}
