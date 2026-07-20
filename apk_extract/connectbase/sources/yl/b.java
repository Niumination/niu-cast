package yl;

import java.io.InputStream;
import java.io.OutputStream;
import kn.l0;
import nq.l2;
import os.l;
import os.m;
import pl.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final Object f21445a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Object f21446b = new Object();

    public static final void d() {
        if (!g.b()) {
            throw new IllegalStateException("Using blocking primitives on this dispatcher is not allowed. Consider using async channel instead or use blocking primitives in withContext(Dispatchers.IO) instead.");
        }
    }

    @l
    public static final InputStream e(@l pl.k kVar, @m l2 l2Var) {
        l0.p(kVar, "<this>");
        return new d(l2Var, kVar);
    }

    public static /* synthetic */ InputStream f(pl.k kVar, l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return e(kVar, l2Var);
    }

    @l
    public static final OutputStream g(@l n nVar, @m l2 l2Var) {
        l0.p(nVar, "<this>");
        return new e(l2Var, nVar);
    }

    public static /* synthetic */ OutputStream h(n nVar, l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return g(nVar, l2Var);
    }
}
