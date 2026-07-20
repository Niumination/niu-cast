package qo;

import kn.l0;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mp.c f14098a;

    @Override // qo.j
    @m
    public eo.e a(@os.l uo.g gVar) {
        l0.p(gVar, "javaClass");
        return b().b(gVar);
    }

    @os.l
    public final mp.c b() {
        mp.c cVar = this.f14098a;
        if (cVar != null) {
            return cVar;
        }
        l0.S("resolver");
        return null;
    }

    public final void c(@os.l mp.c cVar) {
        l0.p(cVar, "<set-?>");
        this.f14098a = cVar;
    }
}
