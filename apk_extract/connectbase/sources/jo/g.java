package jo;

import java.io.InputStream;
import kn.l0;
import wo.n;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ClassLoader f8761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final sp.d f8762b;

    public g(@os.l ClassLoader classLoader) {
        l0.p(classLoader, "classLoader");
        this.f8761a = classLoader;
        this.f8762b = new sp.d();
    }

    @Override // wo.n
    @os.m
    public n.a a(@os.l dp.b bVar) {
        l0.p(bVar, "classId");
        return d(h.b(bVar));
    }

    @Override // wo.n
    @os.m
    public n.a b(@os.l uo.g gVar) {
        l0.p(gVar, "javaClass");
        dp.c cVarE = gVar.e();
        if (cVarE == null) {
            return null;
        }
        String strB = cVarE.b();
        l0.o(strB, "javaClass.fqName?.asString() ?: return null");
        return d(strB);
    }

    @Override // rp.t
    @os.m
    public InputStream c(@os.l dp.c cVar) {
        l0.p(cVar, "packageFqName");
        if (cVar.i(ao.k.f564l)) {
            return this.f8762b.a(sp.a.f15197n.n(cVar));
        }
        return null;
    }

    public final n.a d(String str) {
        f fVarA;
        Class<?> clsA = e.a(this.f8761a, str);
        if (clsA == null || (fVarA = f.f8758c.a(clsA)) == null) {
            return null;
        }
        return new n.a.b(fVarA, null, 2, null);
    }
}
