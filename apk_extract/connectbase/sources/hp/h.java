package hp;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends i {
    @Override // hp.i
    public void b(@os.l eo.b bVar, @os.l eo.b bVar2) {
        l0.p(bVar, "first");
        l0.p(bVar2, y1.o.r.f20674f);
        e(bVar, bVar2);
    }

    @Override // hp.i
    public void c(@os.l eo.b bVar, @os.l eo.b bVar2) {
        l0.p(bVar, "fromSuper");
        l0.p(bVar2, "fromCurrent");
        e(bVar, bVar2);
    }

    public abstract void e(@os.l eo.b bVar, @os.l eo.b bVar2);
}
