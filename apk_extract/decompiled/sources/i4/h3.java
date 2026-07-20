package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class h3 extends i3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3 f5602b;

    public h3(ReferenceQueue referenceQueue, Object obj, int i8, i3 i3Var) {
        super(referenceQueue, obj, i8);
        this.f5602b = i3Var;
    }

    @Override // i4.m2, i4.p2
    public final p2 c() {
        return this.f5602b;
    }

    @Override // i4.i3, i4.p2
    public final Object getValue() {
        return h2.VALUE;
    }
}
