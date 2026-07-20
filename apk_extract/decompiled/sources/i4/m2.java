package i4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class m2 extends WeakReference implements p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5646a;

    public m2(ReferenceQueue referenceQueue, Object obj, int i8) {
        super(obj, referenceQueue);
        this.f5646a = i8;
    }

    @Override // i4.p2
    public final int b() {
        return this.f5646a;
    }

    public p2 c() {
        return null;
    }

    @Override // i4.p2
    public final Object getKey() {
        return get();
    }
}
