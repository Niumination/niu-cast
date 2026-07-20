package io.netty.handler.codec.serialization;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class CachingClassResolver implements ClassResolver {
    private final Map<String, Class<?>> classCache;
    private final ClassResolver delegate;

    public CachingClassResolver(ClassResolver classResolver, Map<String, Class<?>> map) {
        this.delegate = classResolver;
        this.classCache = map;
    }

    @Override // io.netty.handler.codec.serialization.ClassResolver
    public Class<?> resolve(String str) throws ClassNotFoundException {
        Class<?> cls = this.classCache.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> clsResolve = this.delegate.resolve(str);
        this.classCache.put(str, clsResolve);
        return clsResolve;
    }
}
