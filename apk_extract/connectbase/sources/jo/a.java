package jo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kn.l0;
import nm.h0;
import nm.x;
import wo.o;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final wo.f f8752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final g f8753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ConcurrentHashMap<dp.b, op.h> f8754c;

    public a(@os.l wo.f fVar, @os.l g gVar) {
        l0.p(fVar, "resolver");
        l0.p(gVar, "kotlinClassFinder");
        this.f8752a = fVar;
        this.f8753b = gVar;
        this.f8754c = new ConcurrentHashMap<>();
    }

    @os.l
    public final op.h a(@os.l f fVar) {
        Collection collectionK;
        l0.p(fVar, "fileClass");
        ConcurrentHashMap<dp.b, op.h> concurrentHashMap = this.f8754c;
        dp.b bVarA = ko.d.a(fVar.f8759a);
        op.h hVar = concurrentHashMap.get(bVarA);
        if (hVar == null) {
            dp.c cVarH = ko.d.a(fVar.f8759a).h();
            l0.o(cVarH, "fileClass.classId.packageFqName");
            xo.a aVar = fVar.f8760b;
            if (aVar.f20438a == xo.a.EnumC0527a.MULTIFILE_CLASS) {
                List<String> listF = aVar.f();
                collectionK = new ArrayList();
                Iterator<T> it = listF.iterator();
                while (it.hasNext()) {
                    dp.b bVarM = dp.b.m(mp.d.d((String) it.next()).e());
                    l0.o(bVarM, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    p pVarA = o.a(this.f8753b, bVarM);
                    if (pVarA != null) {
                        collectionK.add(pVarA);
                    }
                }
            } else {
                collectionK = x.k(fVar);
            }
            ho.m mVar = new ho.m(this.f8752a.e().f14728b, cVarH);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionK.iterator();
            while (it2.hasNext()) {
                op.h hVarC = this.f8752a.c(mVar, (p) it2.next());
                if (hVarC != null) {
                    arrayList.add(hVarC);
                }
            }
            List listV5 = h0.V5(arrayList);
            op.h hVarA = op.b.f12362d.a("package " + cVarH + " (" + fVar + ')', listV5);
            op.h hVarPutIfAbsent = concurrentHashMap.putIfAbsent(bVarA, hVarA);
            hVar = hVarPutIfAbsent == null ? hVarA : hVarPutIfAbsent;
        }
        l0.o(hVar, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return hVar;
    }
}
