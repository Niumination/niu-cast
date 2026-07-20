package rq;

import kn.l0;
import vq.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14809a = -1640531527;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14810b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final u0 f14811c = new u0("REHASH");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final l f14812d = new l(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final l f14813e = new l(Boolean.TRUE);

    public static final l d(Object obj) {
        if (obj == null) {
            return f14812d;
        }
        return l0.g(obj, Boolean.TRUE) ? f14813e : new l(obj);
    }

    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
