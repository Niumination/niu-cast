package io.netty.handler.ssl;

import io.netty.util.AbstractConstant;
import io.netty.util.ConstantPool;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SslContextOption<T> extends AbstractConstant<SslContextOption<T>> {
    private static final ConstantPool<SslContextOption<Object>> pool = new ConstantPool<SslContextOption<Object>>() { // from class: io.netty.handler.ssl.SslContextOption.1
        @Override // io.netty.util.ConstantPool
        public SslContextOption<Object> newConstant(int i10, String str) {
            return new SslContextOption<>(i10, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> SslContextOption<T> valueOf(String str) {
        return (SslContextOption) pool.valueOf(str);
    }

    public void validate(T t10) {
        ObjectUtil.checkNotNull(t10, "value");
    }

    private SslContextOption(int i10, String str) {
        super(i10, str);
    }

    public static <T> SslContextOption<T> valueOf(Class<?> cls, String str) {
        return (SslContextOption) pool.valueOf(cls, str);
    }

    public SslContextOption(String str) {
        this(pool.nextId(), str);
    }
}
