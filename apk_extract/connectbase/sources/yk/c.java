package yk;

import fl.h1;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public um.g f21370a = um.i.INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public List<String> f21371b = nm.x.k(f0.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public ClassLoader f21372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public ps.a f21373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public ek.a f21374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final List<x> f21375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final List<jn.l<dk.a, l2>> f21376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public String f21377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21378i;

    public c() {
        ClassLoader classLoader = b.class.getClassLoader();
        l0.o(classLoader, "ApplicationEngineEnviron…t::class.java.classLoader");
        this.f21372c = classLoader;
        ps.a aVarJ = ps.b.j("Application");
        l0.o(aVarJ, "getLogger(\"Application\")");
        this.f21373d = aVarJ;
        this.f21374e = new ek.f();
        this.f21375f = new ArrayList();
        this.f21376g = new ArrayList();
        this.f21377h = "";
        h1.f6045a.getClass();
        this.f21378i = h1.f6050f;
    }

    @os.l
    public final b a(@os.l jn.l<? super c, l2> lVar) {
        l0.p(lVar, "builder");
        lVar.invoke(this);
        return new e(this.f21372c, this.f21373d, this.f21374e, this.f21375f, this.f21376g, this.f21371b, this.f21370a, this.f21377h, this.f21378i);
    }

    @os.l
    public final ClassLoader b() {
        return this.f21372c;
    }

    @os.l
    public final ek.a c() {
        return this.f21374e;
    }

    @os.l
    public final List<x> d() {
        return this.f21375f;
    }

    public final boolean e() {
        return this.f21378i;
    }

    @os.l
    public final ps.a f() {
        return this.f21373d;
    }

    @os.l
    public final List<jn.l<dk.a, l2>> g() {
        return this.f21376g;
    }

    @os.l
    public final um.g h() {
        return this.f21370a;
    }

    @os.l
    public final String i() {
        return this.f21377h;
    }

    @os.l
    public final List<String> j() {
        return this.f21371b;
    }

    public final void k(@os.l jn.l<? super dk.a, l2> lVar) {
        l0.p(lVar, "body");
        this.f21376g.add(lVar);
    }

    public final void l(@os.l ClassLoader classLoader) {
        l0.p(classLoader, "<set-?>");
        this.f21372c = classLoader;
    }

    public final void m(@os.l ek.a aVar) {
        l0.p(aVar, "<set-?>");
        this.f21374e = aVar;
    }

    public final void n(boolean z10) {
        this.f21378i = z10;
    }

    public final void o(@os.l ps.a aVar) {
        l0.p(aVar, "<set-?>");
        this.f21373d = aVar;
    }

    public final void p(@os.l um.g gVar) {
        l0.p(gVar, "<set-?>");
        this.f21370a = gVar;
    }

    public final void q(@os.l String str) {
        l0.p(str, "<set-?>");
        this.f21377h = str;
    }

    public final void r(@os.l List<String> list) {
        l0.p(list, "<set-?>");
        this.f21371b = list;
    }
}
