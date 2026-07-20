package jo;

import java.util.Set;
import jq.e0;
import jq.m0;
import kn.l0;
import ko.w;
import no.o;
import uo.u;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ClassLoader f8757a;

    public d(@os.l ClassLoader classLoader) {
        l0.p(classLoader, "classLoader");
        this.f8757a = classLoader;
    }

    @Override // no.o
    @os.m
    public uo.g a(@os.l o.a aVar) {
        l0.p(aVar, "request");
        dp.b bVar = aVar.f11764a;
        dp.c cVarH = bVar.h();
        l0.o(cVarH, "classId.packageFqName");
        String strB = bVar.i().b();
        l0.o(strB, "classId.relativeClassName.asString()");
        String strH2 = e0.h2(strB, n1.e.f11183c, m0.f8865c, false, 4, null);
        if (!cVarH.d()) {
            strH2 = cVarH.b() + n1.e.f11183c + strH2;
        }
        Class<?> clsA = e.a(this.f8757a, strH2);
        if (clsA != null) {
            return new ko.l(clsA);
        }
        return null;
    }

    @Override // no.o
    @os.m
    public u b(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return new w(cVar);
    }

    @Override // no.o
    @os.m
    public Set<String> c(@os.l dp.c cVar) {
        l0.p(cVar, "packageFqName");
        return null;
    }
}
