package com.merci.article_api.common.constant;

import java.util.Arrays;

public interface EnumCodeInterface<E extends Enum<E>> {

    /**
     * コード値を取得する。
     *
     * @return code コード
     */
    public String getCode();

    /**
     * 対象のコード値が、引数のコード値と一致するかを確認する。
     *
     * @return true:コード値が一致する。<br>
     *         false:コード値が一致しない。
     */
    public default boolean equalsByCode(String code) {
        return getCode().equals(code);
    }

    /**
     * 第一引数に指定されたEnumの中に第2引数のコード値と一致するものがあるかを確認する。<br>
     *
     * @param clazz 確認対象のEnumのクラス
     * @param code 検索するコード値
     * @return true:コードが含まれている。<br>
     *         false:コードが含まれていない。
     */
    static <E extends Enum<E>> boolean hasCode(Class<? extends EnumCodeInterface<E>> clazz, String code) {
        return Arrays.stream(clazz.getEnumConstants())
                .anyMatch(e -> e.equalsByCode(code));
    }

    /**
     * 第一引数に指定されたEnumの中から、第2引数のコード値と一致するものを取得する。<br>
     * 存在しないコードを指定した場合はnullを返却する。
     *
     * @param clazz 取得したいEnumのクラス
     * @param code 検索するコード値
     * @return コード値と一致する値
     */
    @SuppressWarnings("unchecked")
    static <E extends Enum<E>> E getEnumByCode(Class<? extends EnumCodeInterface<E>> clazz, String code) {
        return (E) Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.equalsByCode(code))
                .findFirst()
                .orElse(null);
    }
}
