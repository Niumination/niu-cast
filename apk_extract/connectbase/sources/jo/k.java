package jo;

import eo.h0;
import kn.l0;
import kn.w;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f8765c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final rp.j f8766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jo.a f8767b;

    public static final class a {
        public a() {
        }

        @os.l
        public final k a(@os.l ClassLoader classLoader) {
            l0.p(classLoader, "classLoader");
            g gVar = new g(classLoader);
            wo.d.a aVar = wo.d.f19777b;
            ClassLoader classLoader2 = l2.class.getClassLoader();
            l0.o(classLoader2, "Unit::class.java.classLoader");
            wo.d.a.C0491a c0491aA = aVar.a(gVar, new g(classLoader2), new d(classLoader), l0.C("runtime module for ", classLoader), j.f8764b, l.f8768a);
            return new k(c0491aA.f19779a.f19778a, new jo.a(c0491aA.f19780b, gVar));
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ k(rp.j jVar, jo.a aVar, w wVar) {
        this(jVar, aVar);
    }

    @os.l
    public final rp.j a() {
        return this.f8766a;
    }

    @os.l
    public final h0 b() {
        return this.f8766a.f14728b;
    }

    @os.l
    public final jo.a c() {
        return this.f8767b;
    }

    public k(rp.j jVar, jo.a aVar) {
        this.f8766a = jVar;
        this.f8767b = aVar;
    }
}
