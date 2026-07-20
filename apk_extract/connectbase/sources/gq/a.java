package gq;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final AtomicReference<m<T>> f6816a;

    public a(@os.l m<? extends T> mVar) {
        l0.p(mVar, "sequence");
        this.f6816a = new AtomicReference<>(mVar);
    }

    @Override // gq.m
    @os.l
    public Iterator<T> iterator() {
        m<T> andSet = this.f6816a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
