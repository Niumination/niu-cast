package jo;

import el.b0;
import jq.e0;
import kn.l0;
import kn.w;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f8758c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Class<?> f8759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final xo.a f8760b;

    public static final class a {
        public a() {
        }

        @os.m
        public final f a(@os.l Class<?> cls) {
            l0.p(cls, "klass");
            xo.b bVar = new xo.b();
            c.f8756a.b(cls, bVar);
            xo.a aVarM = bVar.m();
            if (aVarM == null) {
                return null;
            }
            return new f(cls, aVarM);
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ f(Class cls, xo.a aVar, w wVar) {
        this(cls, aVar);
    }

    @Override // wo.p
    public void a(@os.l p.d dVar, @os.m byte[] bArr) {
        l0.p(dVar, "visitor");
        c.f8756a.i(this.f8759a, dVar);
    }

    @Override // wo.p
    @os.l
    public xo.a b() {
        return this.f8760b;
    }

    @Override // wo.p
    public void c(@os.l p.c cVar, @os.m byte[] bArr) {
        l0.p(cVar, "visitor");
        c.f8756a.b(this.f8759a, cVar);
    }

    @os.l
    public final Class<?> d() {
        return this.f8759a;
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof f) && l0.g(this.f8759a, ((f) obj).f8759a);
    }

    @Override // wo.p
    @os.l
    public dp.b f() {
        return ko.d.a(this.f8759a);
    }

    @Override // wo.p
    @os.l
    public String getLocation() {
        String name = this.f8759a.getName();
        l0.o(name, "klass.name");
        return l0.C(e0.h2(name, n1.e.f11183c, b0.f4502a, false, 4, null), p1.c.f12696d);
    }

    public int hashCode() {
        return this.f8759a.hashCode();
    }

    @os.l
    public String toString() {
        return f.class.getName() + ": " + this.f8759a;
    }

    public f(Class<?> cls, xo.a aVar) {
        this.f8759a = cls;
        this.f8760b = aVar;
    }
}
