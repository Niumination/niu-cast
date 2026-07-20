package si;

import kotlin.coroutines.CoroutineContext;
import li.a0;
import qi.s;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10130a = new m();

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f.f10120b.f10122a.c(runnable, true, false);
    }

    @Override // li.a0
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f.f10120b.f10122a.c(runnable, true, true);
    }

    @Override // li.a0
    public final a0 limitedParallelism(int i8, String str) {
        qi.g.c(i8);
        if (i8 >= l.f10129d) {
            return str != null ? new s(this, str) : this;
        }
        return super.limitedParallelism(i8, str);
    }

    @Override // li.a0
    public final String toString() {
        return "Dispatchers.IO";
    }
}
