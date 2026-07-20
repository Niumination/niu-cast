package kn;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f9319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9320b = " (Kotlin reflection is not available)";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final un.d[] f9321c;

    static {
        m1 m1Var = null;
        try {
            m1Var = (m1) xn.b0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (m1Var == null) {
            m1Var = new m1();
        }
        f9319a = m1Var;
        f9321c = new un.d[0];
    }

    @lm.f1(version = "1.4")
    public static un.s A(Class cls) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), Collections.emptyList(), false);
    }

    @lm.f1(version = "1.4")
    public static un.s B(Class cls, un.u uVar) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), Collections.singletonList(uVar), false);
    }

    @lm.f1(version = "1.4")
    public static un.s C(Class cls, un.u uVar, un.u uVar2) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), Arrays.asList(uVar, uVar2), false);
    }

    @lm.f1(version = "1.4")
    public static un.s D(Class cls, un.u... uVarArr) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), nm.r.Ky(uVarArr), false);
    }

    @lm.f1(version = "1.4")
    public static un.s E(un.g gVar) {
        return f9319a.s(gVar, Collections.emptyList(), false);
    }

    @lm.f1(version = "1.4")
    public static un.t F(Object obj, String str, un.v vVar, boolean z10) {
        return f9319a.t(obj, str, vVar, z10);
    }

    public static un.d a(Class cls) {
        return f9319a.a(cls);
    }

    public static un.d b(Class cls, String str) {
        return f9319a.b(cls, str);
    }

    public static un.i c(g0 g0Var) {
        return f9319a.c(g0Var);
    }

    public static un.d d(Class cls) {
        return f9319a.d(cls);
    }

    public static un.d e(Class cls, String str) {
        return f9319a.e(cls, str);
    }

    public static un.d[] f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f9321c;
        }
        un.d[] dVarArr = new un.d[length];
        for (int i10 = 0; i10 < length; i10++) {
            dVarArr[i10] = f9319a.d(clsArr[i10]);
        }
        return dVarArr;
    }

    @lm.f1(version = "1.4")
    public static un.h g(Class cls) {
        return f9319a.f(cls, "");
    }

    public static un.h h(Class cls, String str) {
        return f9319a.f(cls, str);
    }

    @lm.f1(version = "1.6")
    public static un.s i(un.s sVar) {
        return f9319a.g(sVar);
    }

    public static un.k j(u0 u0Var) {
        return f9319a.h(u0Var);
    }

    public static un.l k(w0 w0Var) {
        return f9319a.i(w0Var);
    }

    public static un.m l(y0 y0Var) {
        return f9319a.j(y0Var);
    }

    @lm.f1(version = "1.6")
    public static un.s m(un.s sVar) {
        return f9319a.k(sVar);
    }

    @lm.f1(version = "1.4")
    public static un.s n(Class cls) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), Collections.emptyList(), true);
    }

    @lm.f1(version = "1.4")
    public static un.s o(Class cls, un.u uVar) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), Collections.singletonList(uVar), true);
    }

    @lm.f1(version = "1.4")
    public static un.s p(Class cls, un.u uVar, un.u uVar2) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), Arrays.asList(uVar, uVar2), true);
    }

    @lm.f1(version = "1.4")
    public static un.s q(Class cls, un.u... uVarArr) {
        m1 m1Var = f9319a;
        return m1Var.s(m1Var.d(cls), nm.r.Ky(uVarArr), true);
    }

    @lm.f1(version = "1.4")
    public static un.s r(un.g gVar) {
        return f9319a.s(gVar, Collections.emptyList(), true);
    }

    @lm.f1(version = "1.6")
    public static un.s s(un.s sVar, un.s sVar2) {
        return f9319a.l(sVar, sVar2);
    }

    public static un.p t(d1 d1Var) {
        return f9319a.m(d1Var);
    }

    public static un.q u(f1 f1Var) {
        return f9319a.n(f1Var);
    }

    public static un.r v(h1 h1Var) {
        return f9319a.o(h1Var);
    }

    @lm.f1(version = "1.3")
    public static String w(e0 e0Var) {
        return f9319a.p(e0Var);
    }

    @lm.f1(version = "1.1")
    public static String x(n0 n0Var) {
        return f9319a.q(n0Var);
    }

    @lm.f1(version = "1.4")
    public static void y(un.t tVar, un.s sVar) {
        f9319a.r(tVar, Collections.singletonList(sVar));
    }

    @lm.f1(version = "1.4")
    public static void z(un.t tVar, un.s... sVarArr) {
        f9319a.r(tVar, nm.r.Ky(sVarArr));
    }
}
