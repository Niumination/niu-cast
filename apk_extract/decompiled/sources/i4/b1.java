package i4;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b1 extends h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5 f5563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h5 f5565c = e2.f5579d;

    public b1(j1 j1Var) {
        this.f5563a = j1Var.map.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5565c.hasNext() || this.f5563a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f5565c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f5563a.next();
            this.f5564b = entry.getKey();
            this.f5565c = ((a0) entry.getValue()).iterator();
        }
        Object obj = this.f5564b;
        Objects.requireNonNull(obj);
        return new b0(obj, this.f5565c.next());
    }
}
