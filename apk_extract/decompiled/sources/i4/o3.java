package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public class o3 extends m2 implements q3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile r3 f5669b;

    public o3(ReferenceQueue referenceQueue, Object obj, int i8) {
        super(referenceQueue, obj, i8);
        this.f5669b = u3.unsetWeakValueReference();
    }

    @Override // i4.q3
    public final r3 a() {
        return this.f5669b;
    }

    @Override // i4.p2
    public final Object getValue() {
        return this.f5669b.get();
    }
}
