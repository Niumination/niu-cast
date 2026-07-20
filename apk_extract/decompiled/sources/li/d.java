package li;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f7441a;

    public d(c[] cVarArr) {
        this.f7441a = cVarArr;
    }

    @Override // li.i
    public final void a(Throwable th2) {
        b();
    }

    public final void b() {
        for (c cVar : this.f7441a) {
            x0 x0Var = cVar.f7436h;
            if (x0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handle");
                x0Var = null;
            }
            x0Var.dispose();
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f7441a + ']';
    }
}
