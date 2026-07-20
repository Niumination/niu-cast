package io.netty.util;

/* JADX INFO: loaded from: classes3.dex */
public interface Attribute<T> {
    boolean compareAndSet(T t10, T t11);

    T get();

    @Deprecated
    T getAndRemove();

    T getAndSet(T t10);

    AttributeKey<T> key();

    @Deprecated
    void remove();

    void set(T t10);

    T setIfAbsent(T t10);
}
