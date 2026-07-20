package q0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends f<u0.c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u0.c f13364i;

    public d(List<a1.a<u0.c>> list) {
        super(list);
        u0.c cVar = list.get(0).f6b;
        int iC = cVar != null ? cVar.c() : 0;
        this.f13364i = new u0.c(new float[iC], new int[iC]);
    }

    @Override // q0.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public u0.c i(a1.a<u0.c> aVar, float f10) {
        this.f13364i.d(aVar.f6b, aVar.f7c, f10);
        return this.f13364i;
    }
}
