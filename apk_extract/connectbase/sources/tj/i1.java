package tj;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class i1 implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sj.f f15627a;

    public interface a {
        sj.r a(String str, sj.q qVar);
    }

    public static class b implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sj.f f15628a;

        public b(sj.f fVar) {
            this.f15628a = fVar;
        }

        @Override // sj.i
        public sj.n a(sj.e eVar, URL url) {
            sj.f fVar = this.f15628a;
            return fVar instanceof sj.i ? ((sj.i) fVar).a(eVar, url) : i1.j(eVar, url);
        }

        @Override // sj.h
        public sj.n b(sj.e eVar, File file) {
            sj.f fVar = this.f15628a;
            return fVar instanceof sj.h ? ((sj.h) fVar).b(eVar, file) : i1.h(eVar, file);
        }

        @Override // sj.f
        public sj.n c(sj.e eVar, String str) {
            return this.f15628a.c(eVar, str);
        }

        @Override // sj.g
        public sj.n d(sj.e eVar, String str) {
            sj.f fVar = this.f15628a;
            return fVar instanceof sj.g ? ((sj.g) fVar).d(eVar, str) : i1.i(eVar, str);
        }

        @Override // sj.f
        public sj.f e(sj.f fVar) {
            return this;
        }
    }

    public static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sj.e f15629a;

        public c(sj.e eVar) {
            this.f15629a = eVar;
        }

        @Override // tj.i1.a
        public sj.r a(String str, sj.q qVar) {
            sj.r rVarA = this.f15629a.a(str);
            if (rVarA != null) {
                return rVarA;
            }
            return o0.o(str, "include was not found: '" + str + "'", qVar);
        }
    }

    public i1(sj.f fVar) {
        this.f15627a = fVar;
    }

    public static sj.q f(sj.q qVar) {
        return qVar.m(null).l(null).i(true);
    }

    public static sj.n g(a aVar, String str, sj.q qVar) {
        boolean z10;
        if (str.endsWith(".conf") || str.endsWith(".json") || str.endsWith(".properties")) {
            sj.r rVarA = aVar.a(str, qVar);
            return rVarA.c(rVarA.b().i(qVar.f15092c));
        }
        sj.r rVarA2 = aVar.a(str.concat(".conf"), qVar);
        sj.r rVarA3 = aVar.a(str.concat(".json"), qVar);
        sj.r rVarA4 = aVar.a(str.concat(".properties"), qVar);
        ArrayList arrayList = new ArrayList();
        sj.v vVar = qVar.f15090a;
        sj.n nVarEmpty = f1.empty(g1.t(str));
        boolean z11 = true;
        if (vVar == null || vVar == sj.v.CONF) {
            try {
                nVarEmpty = rVarA2.c(rVarA2.b().i(false).m(sj.v.CONF));
                z10 = true;
            } catch (sj.c.f e10) {
                arrayList.add(e10);
                z10 = false;
            }
        } else {
            z10 = false;
        }
        if (vVar == null || vVar == sj.v.JSON) {
            try {
                nVarEmpty = nVarEmpty.withFallback((sj.m) rVarA3.c(rVarA3.b().i(false).m(sj.v.JSON)));
                z10 = true;
            } catch (sj.c.f e11) {
                arrayList.add(e11);
            }
        }
        if (vVar == null || vVar == sj.v.PROPERTIES) {
            try {
                nVarEmpty = nVarEmpty.withFallback((sj.m) rVarA4.c(rVarA4.b().i(false).m(sj.v.PROPERTIES)));
            } catch (sj.c.f e12) {
                arrayList.add(e12);
                z11 = z10;
            }
        } else {
            z11 = z10;
        }
        if (qVar.f15092c || z11) {
            if (z11 || !m.M()) {
                return nVarEmpty;
            }
            m.L("Did not find '" + str + "' with any extension (.conf, .json, .properties); but '" + str + "' is allowed to be missing. Exceptions from load attempts should have been logged above.");
            return nVarEmpty;
        }
        if (m.M()) {
            m.L("Did not find '" + str + "' with any extension (.conf, .json, .properties); exceptions should have been logged above.");
        }
        if (arrayList.isEmpty()) {
            throw new sj.c.d("should not be reached: nothing found but no exceptions thrown");
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append(((Throwable) it.next()).getMessage());
            sb2.append(", ");
        }
        sb2.setLength(sb2.length() - 2);
        throw new sj.c.f(g1.t(str), sb2.toString(), (Throwable) arrayList.get(0));
    }

    public static sj.n h(sj.e eVar, File file) {
        return sj.d.L(file, eVar.b()).root();
    }

    public static sj.n i(sj.e eVar, String str) {
        return sj.d.d0(str, eVar.b()).root();
    }

    public static sj.n j(sj.e eVar, URL url) {
        return sj.d.h0(url, eVar.b()).root();
    }

    public static sj.n k(sj.e eVar, String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        return url != null ? j(eVar, url) : g(new c(eVar), str, eVar.b());
    }

    public static k0 l(sj.f fVar) {
        return fVar instanceof k0 ? (k0) fVar : new b(fVar);
    }

    @Override // sj.i
    public sj.n a(sj.e eVar, URL url) {
        sj.n nVarJ = j(eVar, url);
        sj.f fVar = this.f15627a;
        return (fVar == null || !(fVar instanceof sj.i)) ? nVarJ : nVarJ.withFallback((sj.m) ((sj.i) fVar).a(eVar, url));
    }

    @Override // sj.h
    public sj.n b(sj.e eVar, File file) {
        sj.n nVarH = h(eVar, file);
        sj.f fVar = this.f15627a;
        return (fVar == null || !(fVar instanceof sj.h)) ? nVarH : nVarH.withFallback((sj.m) ((sj.h) fVar).b(eVar, file));
    }

    @Override // sj.f
    public sj.n c(sj.e eVar, String str) {
        sj.n nVarK = k(eVar, str);
        sj.f fVar = this.f15627a;
        return fVar != null ? nVarK.withFallback((sj.m) fVar.c(eVar, str)) : nVarK;
    }

    @Override // sj.g
    public sj.n d(sj.e eVar, String str) {
        sj.n nVarI = i(eVar, str);
        sj.f fVar = this.f15627a;
        return (fVar == null || !(fVar instanceof sj.g)) ? nVarI : nVarI.withFallback((sj.m) ((sj.g) fVar).d(eVar, str));
    }

    @Override // sj.f
    public sj.f e(sj.f fVar) {
        if (this == fVar) {
            throw new sj.c.d("trying to create includer cycle");
        }
        sj.f fVar2 = this.f15627a;
        if (fVar2 == fVar) {
            return this;
        }
        return fVar2 != null ? new i1(fVar2.e(fVar)) : new i1(fVar);
    }
}
