package kn;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9323a = "kotlin.jvm.functions.";

    public un.d a(Class cls) {
        return new u(cls);
    }

    public un.d b(Class cls, String str) {
        return new u(cls);
    }

    public un.i c(g0 g0Var) {
        return g0Var;
    }

    public un.d d(Class cls) {
        return new u(cls);
    }

    public un.d e(Class cls, String str) {
        return new u(cls);
    }

    public un.h f(Class cls, String str) {
        return new b1(cls, str);
    }

    @lm.f1(version = "1.6")
    public un.s g(un.s sVar) {
        w1 w1Var = (w1) sVar;
        return new w1(sVar.i(), sVar.n(), w1Var.f9380c, w1Var.f9381d | 2);
    }

    public un.k h(u0 u0Var) {
        return u0Var;
    }

    public un.l i(w0 w0Var) {
        return w0Var;
    }

    public un.m j(y0 y0Var) {
        return y0Var;
    }

    @lm.f1(version = "1.6")
    public un.s k(un.s sVar) {
        w1 w1Var = (w1) sVar;
        return new w1(sVar.i(), sVar.n(), w1Var.f9380c, w1Var.f9381d | 4);
    }

    @lm.f1(version = "1.6")
    public un.s l(un.s sVar, un.s sVar2) {
        return new w1(sVar.i(), sVar.n(), sVar2, ((w1) sVar).f9381d);
    }

    public un.p m(d1 d1Var) {
        return d1Var;
    }

    public un.q n(f1 f1Var) {
        return f1Var;
    }

    public un.r o(h1 h1Var) {
        return h1Var;
    }

    @lm.f1(version = "1.3")
    public String p(e0 e0Var) {
        String string = e0Var.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith(f9323a) ? string.substring(21) : string;
    }

    @lm.f1(version = "1.1")
    public String q(n0 n0Var) {
        return p(n0Var);
    }

    @lm.f1(version = "1.4")
    public void r(un.t tVar, List<un.s> list) {
        ((v1) tVar).f(list);
    }

    @lm.f1(version = "1.4")
    public un.s s(un.g gVar, List<un.u> list, boolean z10) {
        return new w1(gVar, list, z10);
    }

    @lm.f1(version = "1.4")
    public un.t t(Object obj, String str, un.v vVar, boolean z10) {
        return new v1(obj, str, vVar, z10);
    }
}
