package i4;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public class l3 extends m2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f5637b;

    public l3(ReferenceQueue referenceQueue, Object obj, int i8) {
        super(referenceQueue, obj, i8);
        this.f5637b = null;
    }

    @Override // i4.p2
    public final Object getValue() {
        return this.f5637b;
    }
}
