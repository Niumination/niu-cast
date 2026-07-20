package gq;

import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class c<T, K> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m<T> f6824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<T, K> f6825b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@os.l m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "source");
        l0.p(lVar, "keySelector");
        this.f6824a = mVar;
        this.f6825b = lVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        return new b(this.f6824a.iterator(), this.f6825b);
    }
}
