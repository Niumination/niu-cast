package gl;

import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {
    public /* synthetic */ d(String str, Throwable th2, int i10, w wVar) {
        this((i10 & 1) != 0 ? "Cannot read from a channel" : str, th2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@os.l String str, @os.l Throwable th2) {
        super(str, th2);
        l0.p(str, "message");
        l0.p(th2, "exception");
    }
}
