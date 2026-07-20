package vq;

import nq.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {
    @g2
    public static /* synthetic */ void a() {
    }

    @g2
    public static final <T> T b(@os.l Object obj, @os.l jn.a<? extends T> aVar) {
        T tInvoke;
        synchronized (obj) {
            tInvoke = aVar.invoke();
        }
        return tInvoke;
    }
}
