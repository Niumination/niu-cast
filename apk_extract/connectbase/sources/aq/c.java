package aq;

import eo.e1;
import kn.l0;
import os.l;
import vp.f0;
import wp.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final e1 f678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final f0 f679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final f0 f680c;

    public c(@l e1 e1Var, @l f0 f0Var, @l f0 f0Var2) {
        l0.p(e1Var, "typeParameter");
        l0.p(f0Var, "inProjection");
        l0.p(f0Var2, "outProjection");
        this.f678a = e1Var;
        this.f679b = f0Var;
        this.f680c = f0Var2;
    }

    @l
    public final f0 a() {
        return this.f679b;
    }

    @l
    public final f0 b() {
        return this.f680c;
    }

    @l
    public final e1 c() {
        return this.f678a;
    }

    public final boolean d() {
        return e.f19851a.c(this.f679b, this.f680c);
    }
}
