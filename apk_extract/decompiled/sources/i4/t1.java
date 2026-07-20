package i4;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class t1 extends d1 {
    @Override // i4.d1
    public final Collection a() {
        return q.create();
    }

    @Override // i4.d1
    public final d1 b(Object obj, Object obj2) {
        super.b(obj, obj2);
        return this;
    }

    public final w1 d() {
        return w1.fromMapEntries(this.f5575a.entrySet(), null);
    }

    public final void e(Object obj, Object obj2) {
        super.b(obj, obj2);
    }
}
