package io.netty.handler.codec;

import io.netty.util.HashingStrategy;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultHeadersImpl<K, V> extends DefaultHeaders<K, V, DefaultHeadersImpl<K, V>> {
    public DefaultHeadersImpl(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator) {
        super(hashingStrategy, valueConverter, nameValidator);
    }

    public DefaultHeadersImpl(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator, int i10, DefaultHeaders.ValueValidator<V> valueValidator) {
        super(hashingStrategy, valueConverter, nameValidator, i10, valueValidator);
    }
}
