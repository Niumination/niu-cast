package vi;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import qi.w;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends w {
    public final /* synthetic */ AtomicReferenceArray e;

    public k(long j8, k kVar, int i8) {
        super(j8, kVar, i8);
        this.e = new AtomicReferenceArray(j.f);
    }

    @Override // qi.w
    public final int g() {
        return j.f;
    }

    @Override // qi.w
    public final void h(int i8, CoroutineContext coroutineContext) {
        this.e.set(i8, j.e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f9170c + ", hashCode=" + hashCode() + ']';
    }
}
