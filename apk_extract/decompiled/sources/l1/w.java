package l1;

import java.util.ArrayList;
import java.util.List;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public final class w implements d, m1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7197b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f7198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1.i f7199d;
    public final m1.i e;
    public final m1.i f;

    public w(s1.c cVar, r1.o oVar) {
        oVar.getClass();
        this.f7196a = oVar.f9286d;
        this.f7198c = (y) oVar.f9284b;
        m1.i iVarG = oVar.f9285c.g();
        this.f7199d = iVarG;
        m1.i iVarG2 = ((q1.b) oVar.e).g();
        this.e = iVarG2;
        m1.i iVarG3 = ((q1.b) oVar.f).g();
        this.f = iVarG3;
        cVar.f(iVarG);
        cVar.f(iVarG2);
        cVar.f(iVarG3);
        iVarG.a(this);
        iVarG2.a(this);
        iVarG3.a(this);
    }

    @Override // m1.a
    public final void a() {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f7197b;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((m1.a) arrayList.get(i8)).a();
            i8++;
        }
    }

    @Override // l1.d
    public final void b(List list, List list2) {
    }

    public final void c(m1.a aVar) {
        this.f7197b.add(aVar);
    }
}
