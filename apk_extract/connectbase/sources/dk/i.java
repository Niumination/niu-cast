package dk;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final fl.b<fl.c> f3716a = new fl.b<>("ApplicationFeatureRegistry");

    public static final class a extends n0 implements jn.l<Object, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Object obj) {
            l0.p(obj, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }
    }

    public static final class b extends n0 implements jn.a<fl.c> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final fl.c invoke() {
            return fl.e.a(true);
        }
    }

    public static final class c extends n0 implements jn.a<fl.c> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final fl.c invoke() {
            return fl.e.a(true);
        }
    }

    @os.l
    public static final <A extends nl.e<?, dk.b>, B, F> F a(@os.l A a10, @os.l h<? super A, ? extends B, F> hVar) {
        l0.p(a10, "<this>");
        l0.p(hVar, "feature");
        F f10 = (F) ((fl.c) a10.f11582a.h(f3716a)).b(hVar.getKey());
        if (f10 != null) {
            return f10;
        }
        throw new n(hVar.getKey());
    }

    @os.m
    public static final <A extends nl.e<?, dk.b>, B, F> F b(@os.l A a10, @os.l h<? super A, ? extends B, F> hVar) {
        l0.p(a10, "<this>");
        l0.p(hVar, "feature");
        fl.c cVar = (fl.c) a10.f11582a.b(f3716a);
        if (cVar == null) {
            return null;
        }
        return (F) cVar.b(hVar.getKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <P extends nl.e<?, dk.b>, B, F> F c(@os.l P p10, @os.l h<? super P, ? extends B, F> hVar, @os.l jn.l<? super B, l2> lVar) throws l {
        l0.p(p10, "<this>");
        l0.p(hVar, "feature");
        l0.p(lVar, "configure");
        fl.c cVar = (fl.c) p10.f11582a.a(f3716a, b.INSTANCE);
        F f10 = (F) cVar.b(hVar.getKey());
        if (f10 == null) {
            F fA = hVar.a(p10, lVar);
            cVar.g(hVar.getKey(), fA);
            return fA;
        }
        if (l0.g(f10, hVar)) {
            return f10;
        }
        throw new l(l.a.a(new StringBuilder("Conflicting application feature is already installed with the same key as `"), hVar.getKey().f6017a, '`'));
    }

    public static /* synthetic */ Object d(nl.e eVar, h hVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = a.INSTANCE;
        }
        return c(eVar, hVar, lVar);
    }

    @lm.k(message = "This method is misleading and will be removed. If you have use case that requires this functionaity, please add it in KTOR-2696")
    public static final <A extends nl.e<?, dk.b>, B, F> void e(@os.l A a10, @os.l h<? super A, ? extends B, F> hVar) throws IOException {
        l0.p(a10, "<this>");
        l0.p(hVar, "feature");
        g(a10, hVar.getKey());
    }

    @lm.k(message = "This method is misleading and will be removed. If you have use case that requires this functionaity, please add it in KTOR-2696")
    public static final <A extends nl.e<?, dk.b>> void f(@os.l A a10) {
        l0.p(a10, "<this>");
        Iterator<T> it = ((fl.c) a10.f11582a.a(f3716a, c.INSTANCE)).f().iterator();
        while (it.hasNext()) {
            g(a10, (fl.b) it.next());
        }
    }

    @lm.k(message = "This method is misleading and will be removed. If you have use case that requires this functionaity, please add it in KTOR-2696")
    public static final <A extends nl.e<?, dk.b>, F> void g(@os.l A a10, @os.l fl.b<F> bVar) throws IOException {
        Object objB;
        l0.p(a10, "<this>");
        l0.p(bVar, cb.b.c.f1408o);
        fl.c cVar = (fl.c) a10.f11582a.b(f3716a);
        if (cVar == null || (objB = cVar.b(bVar)) == null) {
            return;
        }
        if (objB instanceof Closeable) {
            ((Closeable) objB).close();
        }
        cVar.c(bVar);
    }
}
