package qo;

import eo.h0;
import kn.l0;
import lm.d0;
import no.w;
import os.m;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final c f14088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final l f14089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final d0<w> f14090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final d0 f14091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final so.c f14092e;

    public h(@os.l c cVar, @os.l l lVar, @os.l d0<w> d0Var) {
        l0.p(cVar, "components");
        l0.p(lVar, "typeParameterResolver");
        l0.p(d0Var, "delegateForDefaultTypeQualifiers");
        this.f14088a = cVar;
        this.f14089b = lVar;
        this.f14090c = d0Var;
        this.f14091d = d0Var;
        this.f14092e = new so.c(this, lVar);
    }

    @os.l
    public final c a() {
        return this.f14088a;
    }

    @m
    public final w b() {
        return (w) this.f14091d.getValue();
    }

    @os.l
    public final d0<w> c() {
        return this.f14090c;
    }

    @os.l
    public final h0 d() {
        return this.f14088a.f14069o;
    }

    @os.l
    public final n e() {
        return this.f14088a.f14055a;
    }

    @os.l
    public final l f() {
        return this.f14089b;
    }

    @os.l
    public final so.c g() {
        return this.f14092e;
    }
}
