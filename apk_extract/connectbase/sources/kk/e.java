package kk;

import ik.p0;
import java.util.Iterator;
import jq.h0;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final boolean a(@os.l p0 p0Var, long j10, @os.m CharSequence charSequence, @os.m d dVar, @os.m CharSequence charSequence2) {
        l0.p(p0Var, "method");
        if (charSequence != null) {
            e(charSequence);
            return true;
        }
        if (j10 != -1) {
            return j10 > 0;
        }
        if (charSequence2 != null) {
            return true;
        }
        p0.a aVar = p0.f8135b;
        aVar.getClass();
        if (!l0.g(p0Var, p0.f8136c)) {
            aVar.getClass();
            if (!l0.g(p0Var, p0.f8141h)) {
                aVar.getClass();
                if (!l0.g(p0Var, p0.f8142i) && dVar != null && dVar.f9209a) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean b(@os.l n nVar) {
        l0.p(nVar, "request");
        p0 p0Var = nVar.f9238c;
        CharSequence charSequenceE = nVar.f9221a.e("Content-Length");
        return a(p0Var, charSequenceE == null ? -1L : lk.f.m(charSequenceE), nVar.f9221a.e("Transfer-Encoding"), d.f9204e.d(nVar.f9221a.e("Connection")), nVar.f9221a.e("Content-Type"));
    }

    public static final boolean c(@os.l p0 p0Var, @os.m CharSequence charSequence, @os.m d dVar) {
        l0.p(p0Var, "method");
        p0.f8135b.getClass();
        return l0.g(p0Var, p0.f8136c) && charSequence != null && dVar != null && dVar.f9211c;
    }

    public static final boolean d(@os.l n nVar) {
        l0.p(nVar, "request");
        return c(nVar.f9238c, nVar.f9221a.e("Upgrade"), d.f9204e.d(nVar.f9221a.e("Connection")));
    }

    public static final boolean e(CharSequence charSequence) {
        if (lk.f.b(charSequence, 0, 0, "chunked", 3, null)) {
            return true;
        }
        boolean z10 = false;
        if (lk.f.b(charSequence, 0, 0, "identity", 3, null)) {
            return false;
        }
        Iterator it = h0.R4(charSequence, new String[]{ks.g.f9491d}, false, 0, 6, null).iterator();
        while (it.hasNext()) {
            String lowerCase = h0.C5((String) it.next()).toString().toLowerCase();
            l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
            if (l0.g(lowerCase, "chunked")) {
                if (z10) {
                    throw new IllegalArgumentException(l0.C("Double-chunked TE is not supported: ", charSequence));
                }
                z10 = true;
            } else if (!l0.g(lowerCase, "identity")) {
                throw new IllegalArgumentException(l0.C("Unsupported transfer encoding ", lowerCase));
            }
        }
        return z10;
    }

    @os.m
    public static final Object f(long j10, @os.m CharSequence charSequence, @os.m d dVar, @os.l pl.k kVar, @os.l pl.n nVar, @os.l um.d<? super l2> dVar2) {
        if (charSequence != null && e(charSequence)) {
            Object objC = c.c(kVar, nVar, dVar2);
            return objC == wm.a.COROUTINE_SUSPENDED ? objC : l2.f10208a;
        }
        if (j10 != -1) {
            Object objC2 = pl.l.c(kVar, nVar, j10, dVar2);
            return objC2 == wm.a.COROUTINE_SUSPENDED ? objC2 : l2.f10208a;
        }
        if (dVar != null && dVar.f9209a) {
            Object objC3 = pl.l.c(kVar, nVar, Long.MAX_VALUE, dVar2);
            return objC3 == wm.a.COROUTINE_SUSPENDED ? objC3 : l2.f10208a;
        }
        nVar.f(new IllegalStateException("Failed to parse request body: request body length should be specified,\nchunked transfer encoding should be used or\nkeep-alive should be disabled (connection: close)"));
        return l2.f10208a;
    }

    @os.m
    public static final Object g(@os.l f fVar, @os.l pl.k kVar, @os.l pl.n nVar, @os.l um.d<? super l2> dVar) {
        CharSequence charSequenceE = fVar.e("Content-Length");
        Object objF = f(charSequenceE == null ? -1L : lk.f.m(charSequenceE), fVar.e("Transfer-Encoding"), d.f9204e.d(fVar.e("Connection")), kVar, nVar, dVar);
        return objF == wm.a.COROUTINE_SUSPENDED ? objF : l2.f10208a;
    }
}
