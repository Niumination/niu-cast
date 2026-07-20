package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f8342id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    public AbstractConstant(int i10, String str) {
        this.f8342id = i10;
        this.name = str;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // io.netty.util.Constant
    public final int id() {
        return this.f8342id;
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    public final String toString() {
        return name();
    }

    @Override // java.lang.Comparable
    public final int compareTo(T t10) {
        if (this == t10) {
            return 0;
        }
        int iHashCode = hashCode() - t10.hashCode();
        if (iHashCode != 0) {
            return iHashCode;
        }
        long j10 = this.uniquifier;
        long j11 = t10.uniquifier;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
