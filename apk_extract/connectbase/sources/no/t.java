package no;

import kn.l0;
import lm.t0;
import nm.d1;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final dp.c f11776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final dp.c f11777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final b0<u> f11778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final u f11779d;

    static {
        dp.c cVar = new dp.c("org.jspecify.nullness");
        f11776a = cVar;
        dp.c cVar2 = new dp.c("org.checkerframework.checker.nullness.compatqual");
        f11777b = cVar2;
        dp.c cVar3 = new dp.c("org.jetbrains.annotations");
        u.a aVar = u.f11780d;
        aVar.getClass();
        t0 t0Var = new t0(cVar3, u.f11781e);
        dp.c cVar4 = new dp.c("androidx.annotation");
        aVar.getClass();
        t0 t0Var2 = new t0(cVar4, u.f11781e);
        dp.c cVar5 = new dp.c("android.support.annotation");
        aVar.getClass();
        t0 t0Var3 = new t0(cVar5, u.f11781e);
        dp.c cVar6 = new dp.c("android.annotation");
        aVar.getClass();
        t0 t0Var4 = new t0(cVar6, u.f11781e);
        dp.c cVar7 = new dp.c("com.android.annotations");
        aVar.getClass();
        t0 t0Var5 = new t0(cVar7, u.f11781e);
        dp.c cVar8 = new dp.c("org.eclipse.jdt.annotation");
        aVar.getClass();
        t0 t0Var6 = new t0(cVar8, u.f11781e);
        dp.c cVar9 = new dp.c("org.checkerframework.checker.nullness.qual");
        aVar.getClass();
        t0 t0Var7 = new t0(cVar9, u.f11781e);
        aVar.getClass();
        t0 t0Var8 = new t0(cVar2, u.f11781e);
        dp.c cVar10 = new dp.c("javax.annotation");
        aVar.getClass();
        t0 t0Var9 = new t0(cVar10, u.f11781e);
        dp.c cVar11 = new dp.c("edu.umd.cs.findbugs.annotations");
        aVar.getClass();
        t0 t0Var10 = new t0(cVar11, u.f11781e);
        dp.c cVar12 = new dp.c("io.reactivex.annotations");
        aVar.getClass();
        t0 t0Var11 = new t0(cVar12, u.f11781e);
        dp.c cVar13 = new dp.c("androidx.annotation.RecentlyNullable");
        e0 e0Var = e0.WARN;
        t0 t0Var12 = new t0(cVar13, new u(e0Var, null, null, 4, null));
        t0 t0Var13 = new t0(new dp.c("androidx.annotation.RecentlyNonNull"), new u(e0Var, null, null, 4, null));
        dp.c cVar14 = new dp.c("lombok");
        aVar.getClass();
        t0 t0Var14 = new t0(cVar14, u.f11781e);
        lm.a0 a0Var = new lm.a0(1, 7, 0);
        e0 e0Var2 = e0.STRICT;
        f11778c = new c0(d1.W(t0Var, t0Var2, t0Var3, t0Var4, t0Var5, t0Var6, t0Var7, t0Var8, t0Var9, t0Var10, t0Var11, t0Var12, t0Var13, t0Var14, new t0(cVar, new u(e0Var, a0Var, e0Var2)), new t0(new dp.c("io.reactivex.rxjava3.annotations"), new u(e0Var, new lm.a0(1, 7, 0), e0Var2))));
        f11779d = new u(e0Var, null, null, 4, null);
    }

    @os.l
    public static final x a(@os.l lm.a0 a0Var) {
        l0.p(a0Var, "configuredKotlinVersion");
        u uVar = f11779d;
        lm.a0 a0Var2 = uVar.f11783b;
        e0 e0Var = (a0Var2 == null || a0Var2.compareTo(a0Var) > 0) ? uVar.f11782a : uVar.f11784c;
        return new x(e0Var, c(e0Var), null, 4, null);
    }

    public static /* synthetic */ x b(lm.a0 a0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            a0Var = lm.a0.f10167g;
        }
        return a(a0Var);
    }

    @os.m
    public static final e0 c(@os.l e0 e0Var) {
        l0.p(e0Var, "globalReportLevel");
        if (e0Var == e0.WARN) {
            return null;
        }
        return e0Var;
    }

    @os.l
    public static final e0 d(@os.l dp.c cVar) {
        l0.p(cVar, "annotationFqName");
        b0.f11724a.getClass();
        return g(cVar, b0.a.f11726b, null, 4, null);
    }

    @os.l
    public static final dp.c e() {
        return f11776a;
    }

    @os.l
    public static final e0 f(@os.l dp.c cVar, @os.l b0<? extends e0> b0Var, @os.l lm.a0 a0Var) {
        l0.p(cVar, "annotation");
        l0.p(b0Var, "configuredReportLevels");
        l0.p(a0Var, "configuredKotlinVersion");
        e0 e0VarA = b0Var.a(cVar);
        if (e0VarA != null) {
            return e0VarA;
        }
        u uVarA = f11778c.a(cVar);
        if (uVarA == null) {
            return e0.IGNORE;
        }
        lm.a0 a0Var2 = uVarA.f11783b;
        return (a0Var2 == null || a0Var2.compareTo(a0Var) > 0) ? uVarA.f11782a : uVarA.f11784c;
    }

    public static /* synthetic */ e0 g(dp.c cVar, b0 b0Var, lm.a0 a0Var, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            a0Var = lm.a0.f10167g;
        }
        return f(cVar, b0Var, a0Var);
    }
}
