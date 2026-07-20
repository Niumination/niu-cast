package rp;

import eo.z0;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import nm.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ap.c f14775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ap.a f14776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<dp.b, z0> f14777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Map<dp.b, yo.a.c> f14778d;

    /* JADX WARN: Multi-variable type inference failed */
    public y(@os.l yo.a.m mVar, @os.l ap.c cVar, @os.l ap.a aVar, @os.l jn.l<? super dp.b, ? extends z0> lVar) {
        l0.p(mVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(aVar, "metadataVersion");
        l0.p(lVar, "classSource");
        this.f14775a = cVar;
        this.f14776b = aVar;
        this.f14777c = lVar;
        List<yo.a.c> class_List = mVar.getClass_List();
        l0.o(class_List, "proto.class_List");
        List<yo.a.c> list = class_List;
        int iJ = c1.j(nm.z.b0(list, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ < 16 ? 16 : iJ);
        for (Object obj : list) {
            linkedHashMap.put(x.a(this.f14775a, ((yo.a.c) obj).getFqName()), obj);
        }
        this.f14778d = linkedHashMap;
    }

    @Override // rp.g
    @os.m
    public f a(@os.l dp.b bVar) {
        l0.p(bVar, "classId");
        yo.a.c cVar = this.f14778d.get(bVar);
        if (cVar == null) {
            return null;
        }
        return new f(this.f14775a, cVar, this.f14776b, this.f14777c.invoke(bVar));
    }

    @os.l
    public final Collection<dp.b> b() {
        return this.f14778d.keySet();
    }
}
