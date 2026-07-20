package ni;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends qi.w {
    public final m e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f8327h;

    public v(long j8, v vVar, m mVar, int i8) {
        super(j8, vVar, i8);
        this.e = mVar;
        this.f8327h = new AtomicReferenceArray(o.f8307b * 2);
    }

    @Override // qi.w
    public final int g() {
        return o.f8307b;
    }

    @Override // qi.w
    public final void h(int i8, CoroutineContext coroutineContext) {
        m mVar;
        int i9 = o.f8307b;
        boolean z2 = i8 >= i9;
        if (z2) {
            i8 -= i9;
        }
        Object obj = this.f8327h.get(i8 * 2);
        while (true) {
            Object objL = l(i8);
            boolean z3 = objL instanceof s2;
            mVar = this.e;
            if (z3 || (objL instanceof h0)) {
                if (k(i8, objL, z2 ? o.f8313j : o.f8314k)) {
                    n(i8, null);
                    m(i8, !z2);
                    if (z2) {
                        Intrinsics.checkNotNull(mVar);
                        Function1 function1 = mVar.f8304b;
                        if (function1 != null) {
                            qi.g.a(function1, obj, coroutineContext);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else {
                if (objL == o.f8313j || objL == o.f8314k) {
                    break;
                }
                if (objL != o.f8310g && objL != o.f) {
                    if (objL == o.f8312i || objL == o.f8309d || objL == o.f8315l) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + objL).toString());
                }
            }
        }
        n(i8, null);
        if (z2) {
            Intrinsics.checkNotNull(mVar);
            Function1 function2 = mVar.f8304b;
            if (function2 != null) {
                qi.g.a(function2, obj, coroutineContext);
            }
        }
    }

    public final boolean k(int i8, Object obj, Object obj2) {
        return this.f8327h.compareAndSet((i8 * 2) + 1, obj, obj2);
    }

    public final Object l(int i8) {
        return this.f8327h.get((i8 * 2) + 1);
    }

    public final void m(int i8, boolean z2) {
        if (z2) {
            m mVar = this.e;
            Intrinsics.checkNotNull(mVar);
            mVar.K((this.f9170c * ((long) o.f8307b)) + ((long) i8));
        }
        i();
    }

    public final void n(int i8, Object obj) {
        this.f8327h.set(i8 * 2, obj);
    }

    public final void o(int i8, a8.a aVar) {
        this.f8327h.set((i8 * 2) + 1, aVar);
    }
}
