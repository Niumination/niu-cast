package io.netty.util;

import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private T createOrThrow(String str) {
        if (this.constants.get(str) == null) {
            T t10 = (T) newConstant(nextId(), str);
            if (this.constants.putIfAbsent(str, t10) == null) {
                return t10;
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is already in use", str));
    }

    private T getOrCreate(String str) {
        T t10 = this.constants.get(str);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) newConstant(nextId(), str);
        T tPutIfAbsent = this.constants.putIfAbsent(str, t11);
        return tPutIfAbsent == null ? t11 : tPutIfAbsent;
    }

    public boolean exists(String str) {
        return this.constants.containsKey(ObjectUtil.checkNonEmpty(str, "name"));
    }

    public abstract T newConstant(int i10, String str);

    public T newInstance(String str) {
        return (T) createOrThrow(ObjectUtil.checkNonEmpty(str, "name"));
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public T valueOf(Class<?> cls, String str) {
        return (T) valueOf(((Class) ObjectUtil.checkNotNull(cls, "firstNameComponent")).getName() + '#' + ((String) ObjectUtil.checkNotNull(str, "secondNameComponent")));
    }

    public T valueOf(String str) {
        return (T) getOrCreate(ObjectUtil.checkNonEmpty(str, "name"));
    }
}
