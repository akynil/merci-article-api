package com.merci.article_api.common.util;

import java.util.Arrays;

import com.merci.article_api.common.constant.EnumCodeInterface;

/**
 * Enum用ユーティリティクラス
 */
public class EnumUtils {
    /**
     * 第一引数に指定されたEnumの中から、第2引数のコード値と一致するものを取得する。<br>
     * 存在しないコードを指定した場合はnullを返却する。
     *
     * @param target 取得したいEnumのクラス
     * @param code 検索するコード値
     * @param <E> EnumCodeInterfaceを実装したEnumクラス
     * @return コード値と一致する値
     */
    public static <E extends Enum<?> & EnumCodeInterface> E getEnumByCode(Class<E> target, String code) {

        return Arrays.stream(target.getEnumConstants())
                .filter(data -> data.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
