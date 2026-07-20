package rq;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class k<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    public final int f14845a;

    public k(T t10, @os.m ReferenceQueue<T> referenceQueue) {
        super(t10, referenceQueue);
        this.f14845a = t10 != null ? t10.hashCode() : 0;
    }
}
