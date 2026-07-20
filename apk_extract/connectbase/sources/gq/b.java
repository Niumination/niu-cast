package gq;

import java.util.HashSet;
import java.util.Iterator;
import kn.l0;
import nm.s1;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T, K> extends nm.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Iterator<T> f6821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.l<T, K> f6822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final HashSet<K> f6823e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@os.l Iterator<? extends T> it, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(it, "source");
        l0.p(lVar, "keySelector");
        this.f6821c = it;
        this.f6822d = lVar;
        this.f6823e = new HashSet<>();
    }

    @Override // nm.b
    public void a() {
        while (this.f6821c.hasNext()) {
            T next = this.f6821c.next();
            if (this.f6823e.add(this.f6822d.invoke(next))) {
                e(next);
                return;
            }
        }
        this.f11609a = s1.Done;
    }
}
