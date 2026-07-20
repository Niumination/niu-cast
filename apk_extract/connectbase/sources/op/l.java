package op;

import eo.y0;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.y;
import un.o;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f12407d = {l1.f9319a.n(new g1(l1.d(l.class), "functions", "getFunctions()Ljava/util/List;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final eo.e f12408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.i f12409c;

    public static final class a extends n0 implements jn.a<List<? extends y0>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends y0> invoke() {
            return y.O(hp.c.d(l.this.f12408b), hp.c.e(l.this.f12408b));
        }
    }

    public l(@os.l up.n nVar, @os.l eo.e eVar) {
        l0.p(nVar, "storageManager");
        l0.p(eVar, "containingClass");
        this.f12408b = eVar;
        eVar.getKind();
        eo.f fVar = eo.f.ENUM_CLASS;
        this.f12409c = nVar.h(new a());
    }

    @Override // op.i, op.k
    public /* bridge */ /* synthetic */ eo.h f(dp.f fVar, mo.b bVar) {
        return (eo.h) j(fVar, bVar);
    }

    @os.m
    public Void j(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return null;
    }

    @Override // op.i, op.k
    @os.l
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public List<y0> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        return m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // op.i, op.h, op.k
    @os.l
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public eq.e<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        List<y0> listM = m();
        eq.e<y0> eVar = new eq.e<>();
        for (Object obj : listM) {
            if (l0.g(((y0) obj).getName(), fVar)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    public final List<y0> m() {
        return (List) up.m.a(this.f12409c, this, f12407d[0]);
    }
}
