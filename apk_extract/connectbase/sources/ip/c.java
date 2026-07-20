package ip;

import eo.e1;
import eo.h;
import java.util.Collection;
import java.util.List;
import kn.l0;
import nm.k0;
import nm.x;
import os.l;
import os.m;
import vp.c1;
import vp.f0;
import vp.o1;
import wp.g;
import wp.j;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final c1 f8349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public j f8350b;

    public c(@l c1 c1Var) {
        l0.p(c1Var, "projection");
        this.f8349a = c1Var;
        c1Var.c();
        o1 o1Var = o1.INVARIANT;
    }

    @Override // vp.a1
    @l
    public Collection<f0> a() {
        f0 type = this.f8349a.c() == o1.OUT_VARIANCE ? this.f8349a.getType() : n().I();
        l0.o(type, "if (projection.projectio… builtIns.nullableAnyType");
        return x.k(type);
    }

    @Override // ip.b
    @l
    public c1 c() {
        return this.f8349a;
    }

    @Override // vp.a1
    public h d() {
        return null;
    }

    @Override // vp.a1
    public boolean e() {
        return false;
    }

    @m
    public Void f() {
        return null;
    }

    @m
    public final j g() {
        return this.f8350b;
    }

    @Override // vp.a1
    @l
    public List<e1> getParameters() {
        return k0.INSTANCE;
    }

    @Override // vp.a1
    @l
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c b(@l g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        c1 c1VarB = this.f8349a.b(gVar);
        l0.o(c1VarB, "projection.refine(kotlinTypeRefiner)");
        return new c(c1VarB);
    }

    public final void i(@m j jVar) {
        this.f8350b = jVar;
    }

    @Override // vp.a1
    @l
    public ao.h n() {
        ao.h hVarN = this.f8349a.getType().G0().n();
        l0.o(hVarN, "projection.type.constructor.builtIns");
        return hVarN;
    }

    @l
    public String toString() {
        return "CapturedTypeConstructor(" + this.f8349a + ')';
    }
}
