package wk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@nl.a
public class v extends dk.c {

    @os.m
    public final v I;

    @os.l
    public final w J;

    @os.l
    public final List<v> K;

    @os.l
    public final ArrayList<jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object>> L;

    @os.m
    private volatile dk.c cachedPipeline;

    public /* synthetic */ v(v vVar, w wVar, boolean z10, int i10, kn.w wVar2) {
        this(vVar, wVar, (i10 & 4) != 0 ? false : z10);
    }

    @os.l
    public final dk.c X() throws nl.c {
        dk.c cVar = this.cachedPipeline;
        if (cVar == null) {
            cVar = new dk.c(this.f3711i);
            ArrayList arrayList = new ArrayList();
            for (v vVar = this; vVar != null; vVar = vVar.I) {
                arrayList.add(vVar);
            }
            int iJ = nm.y.J(arrayList);
            if (iJ >= 0) {
                while (true) {
                    int i10 = iJ - 1;
                    dk.c cVar2 = (dk.c) arrayList.get(iJ);
                    cVar.C(cVar2);
                    cVar.f3712n.C(cVar2.f3712n);
                    cVar.f3713p.C(cVar2.f3713p);
                    if (i10 < 0) {
                        break;
                    }
                    iJ = i10;
                }
            }
            ArrayList<jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object>> arrayList2 = this.L;
            int iJ2 = nm.y.J(arrayList2);
            if (iJ2 >= 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    dk.c.f3706v.getClass();
                    nl.j jVar = dk.c.f3710z;
                    jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> qVar = arrayList2.get(i11);
                    kn.l0.o(qVar, "handlers[index]");
                    cVar.x(jVar, qVar);
                    if (i11 == iJ2) {
                        break;
                    }
                    i11 = i12;
                }
            }
            this.cachedPipeline = cVar;
        }
        return cVar;
    }

    @os.l
    public final v Y(@os.l w wVar) {
        Object next;
        kn.l0.p(wVar, "selector");
        Iterator<T> it = this.K.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kn.l0.g(((v) next).J, wVar));
        v vVar = (v) next;
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this, wVar, this.f3711i);
        this.K.add(vVar2);
        return vVar2;
    }

    @os.l
    public final List<v> Z() {
        return this.K;
    }

    @os.l
    public final ArrayList<jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object>> a0() {
        return this.L;
    }

    @Override // nl.e
    public void c() {
        g0();
    }

    @os.m
    public final v c0() {
        return this.I;
    }

    @os.l
    public final w d0() {
        return this.J;
    }

    public final void e0(@os.l jn.q<? super nl.f<l2, dk.b>, ? super l2, ? super um.d<? super l2>, ? extends Object> qVar) {
        kn.l0.p(qVar, "handler");
        this.L.add(qVar);
        this.cachedPipeline = null;
    }

    public final void g0() {
        this.cachedPipeline = null;
        Iterator<T> it = this.K.iterator();
        while (it.hasNext()) {
            ((v) it.next()).g0();
        }
    }

    public final void h0(@os.l jn.l<? super v, l2> lVar) {
        kn.l0.p(lVar, "body");
        lVar.invoke(this);
    }

    @os.l
    public String toString() {
        v vVar = this.I;
        String string = vVar == null ? null : vVar.toString();
        if (string == null) {
            w wVar = this.J;
            return wVar instanceof o0 ? "/" : kn.l0.C("/", wVar);
        }
        if (this.J instanceof o0) {
            return jq.h0.Y2(string, el.b0.f4502a, false, 2, null) ? string : kn.l0.C(string, "/");
        }
        if (jq.h0.Y2(string, el.b0.f4502a, false, 2, null)) {
            return kn.l0.C(string, this.J);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) string);
        sb2.append(el.b0.f4502a);
        sb2.append(this.J);
        return sb2.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@os.m v vVar, @os.l w wVar, boolean z10) {
        super(z10);
        kn.l0.p(wVar, "selector");
        this.I = vVar;
        this.J = wVar;
        this.K = new ArrayList();
        this.L = new ArrayList<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Please use constructor with developmentMode parameter")
    public /* synthetic */ v(v vVar, w wVar) {
        this(vVar, wVar, false);
        kn.l0.p(wVar, "selector");
    }
}
