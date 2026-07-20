package i4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class s3 extends WeakReference implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p2 f5688a;

    public s3(ReferenceQueue referenceQueue, Object obj, p2 p2Var) {
        super(obj, referenceQueue);
        this.f5688a = p2Var;
    }

    @Override // i4.r3
    public final r3 a(ReferenceQueue referenceQueue, q3 q3Var) {
        return new s3(referenceQueue, get(), q3Var);
    }

    @Override // i4.r3
    public final p2 b() {
        return this.f5688a;
    }
}
