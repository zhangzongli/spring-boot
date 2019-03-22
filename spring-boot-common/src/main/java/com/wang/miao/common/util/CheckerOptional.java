package com.wang.miao.common.util;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * 验证工具
 */
public class CheckerOptional<T> {

    /**
     * 空Optional
     */
    private static final CheckerOptional<?> EMPTY = new CheckerOptional();
    private T value;
    private String message;

    private CheckerOptional() {
        this.value = null;
    }

    private CheckerOptional(T value) {
        this.value = value;
    }

    private CheckerOptional(String message) {
        this.value = null;
        this.message = message;
    }

    /**
     * 构建一个空Optional
     */
    public static <T> CheckerOptional<T> empty() {
        @SuppressWarnings("unchecked")
        CheckerOptional<T> t = (CheckerOptional<T>) EMPTY;
        return t;
    }

    /**
     * 构造一个Optional
     */
    public static <T> CheckerOptional<T> of(T value) {
        return new CheckerOptional<T>(value);
    }

    /**
     * 构造一个Optional
     */
    public static <T> CheckerOptional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public CheckerOptional<T> filter(String message, Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        }

        boolean success = predicate.test(value);
        if (success) {
            return this;
        }

        return new CheckerOptional(message);
    }

    public String error() {
        return message;
    }

}
