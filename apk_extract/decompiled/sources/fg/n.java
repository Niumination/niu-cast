package fg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5042a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur = new p(8);

    public final boolean a(s element) {
        Intrinsics.checkNotNullParameter(element, "element");
        while (true) {
            p pVar = (p) this._cur;
            int iA = pVar.a(element);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                f5042a.compareAndSet(this, pVar, pVar.d());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            p pVar = (p) this._cur;
            if (pVar.b()) {
                return;
            } else {
                f5042a.compareAndSet(this, pVar, pVar.d());
            }
        }
    }

    public final boolean c() {
        return ((p) this._cur).c();
    }

    public final Object d() {
        while (true) {
            p pVar = (p) this._cur;
            Object objE = pVar.e();
            if (objE != p.f) {
                return objE;
            }
            f5042a.compareAndSet(this, pVar, pVar.d());
        }
    }
}
