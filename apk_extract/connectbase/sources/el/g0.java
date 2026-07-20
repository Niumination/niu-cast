package el;

import kn.l0;
import kn.l1;
import lm.l2;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {
    public static final <S> void a(f0.a aVar, String str) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        g(aVar, str, dVarD, new c(dVarD, null));
    }

    @z0
    public static final <S> void b(@os.l f0.a aVar, @os.l String str, @os.l b<S> bVar, @os.l un.d<S> dVar, @os.l p pVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(bVar, "builder");
        l0.p(dVar, "sessionType");
        l0.p(pVar, "storage");
        aVar.b(new k<>(str, dVar, new w(str, bVar.f4507e, bVar.f4506d), new s(dVar, bVar.f4505c, pVar, bVar.f4501f)));
    }

    public static final <S> void c(f0.a aVar, String str, p pVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(pVar, "storage");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        b(aVar, str, new b(dVarD, null), dVarD, pVar);
    }

    public static final <S> void d(f0.a aVar, String str, p pVar, jn.l<? super b<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(pVar, "storage");
        l0.p(lVar, "block");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        b bVar = new b(dVarD, null);
        lVar.invoke(bVar);
        b(aVar, str, bVar, dVarD, pVar);
    }

    public static final <S> void e(f0.a aVar, String str, jn.l<? super c<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(lVar, "block");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        c cVar = new c(dVarD, null);
        lVar.invoke(cVar);
        g(aVar, str, dVarD, cVar);
    }

    @lm.k(message = "Use reified type parameter instead.")
    public static final <S> void f(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        g(aVar, str, dVar, new c(dVar));
    }

    @z0
    public static final <S> void g(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l c<S> cVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(cVar, "builder");
        aVar.b(new k<>(str, dVar, new w(str, cVar.f4507e, cVar.f4506d), new u(dVar, cVar.f4505c)));
    }

    @lm.k(message = "Use reified types instead.")
    public static final <S> void h(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l p pVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(pVar, "storage");
        b(aVar, str, new b(dVar), dVar, pVar);
    }

    @lm.k(message = "Use reified types instead.")
    public static final <S> void i(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l p pVar, @os.l jn.l<? super b<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(pVar, "storage");
        l0.p(lVar, "block");
        b bVar = new b(dVar);
        lVar.invoke(bVar);
        b(aVar, str, bVar, dVar, pVar);
    }

    @lm.k(message = "Use reified type instead.")
    public static final <S> void j(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l jn.l<? super c<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(lVar, "block");
        c cVar = new c(dVar);
        lVar.invoke(cVar);
        g(aVar, str, dVar, cVar);
    }

    public static final <S> void k(f0.a aVar, String str) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        q(aVar, str, dVarD, null, new f(dVarD, null));
    }

    public static final <S> void l(f0.a aVar, String str, p pVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(pVar, "storage");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        q(aVar, str, dVarD, pVar, new e(dVarD, null));
    }

    public static final <S> void m(f0.a aVar, String str, p pVar, jn.l<? super e<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(pVar, "storage");
        l0.p(lVar, "block");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        e eVar = new e(dVarD, null);
        lVar.invoke(eVar);
        q(aVar, str, dVarD, pVar, eVar);
    }

    public static final <S> void n(f0.a aVar, String str, jn.l<? super f<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(lVar, "block");
        l0.P();
        un.d dVarD = l1.d(Object.class);
        l0.P();
        f fVar = new f(dVarD, null);
        lVar.invoke(fVar);
        q(aVar, str, dVarD, null, fVar);
    }

    @lm.k(message = "Use reified type instead.")
    public static final <S> void o(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        q(aVar, str, dVar, null, new f(dVar));
    }

    @lm.k(message = "Use reified type instead.")
    public static final <S> void p(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l p pVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(pVar, "storage");
        q(aVar, str, dVar, pVar, new e(dVar));
    }

    @z0
    public static final <S> void q(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.m p pVar, @os.l f<S> fVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(fVar, "builder");
        aVar.b(new k<>(str, dVar, new y(str, fVar.f4522d), (pVar == null || !(fVar instanceof e)) ? new u(dVar, fVar.f4521c) : new s(dVar, fVar.f4521c, pVar, ((e) fVar).f4516e)));
    }

    @lm.k(message = "Use reified types instead.")
    public static final <S> void r(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l p pVar, @os.l jn.l<? super e<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(pVar, "storage");
        l0.p(lVar, "block");
        e eVar = new e(dVar);
        lVar.invoke(eVar);
        q(aVar, str, dVar, pVar, eVar);
    }

    @lm.k(message = "Use reified type instead.")
    public static final <S> void s(@os.l f0.a aVar, @os.l String str, @os.l un.d<S> dVar, @os.l jn.l<? super f<S>, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(dVar, "sessionType");
        l0.p(lVar, "block");
        f fVar = new f(dVar);
        lVar.invoke(fVar);
        aVar.b(new k<>(str, dVar, new y(str, fVar.f4522d), new u(dVar, fVar.f4521c)));
    }
}
