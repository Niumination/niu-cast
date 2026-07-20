package nl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import fl.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import jn.q;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.u1;
import kn.x0;
import lm.l2;
import nm.h0;
import nm.k0;
import nm.y;
import nm.z;

/* JADX INFO: loaded from: classes2.dex */
public class e<TSubject, TContext> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f11581g;

    @os.l
    private volatile /* synthetic */ Object _interceptors;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final fl.c f11582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<Object> f11584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final qn.f f11585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final qn.f f11586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final qn.f f11587f;

    public static final class a implements qn.f<Object, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f11588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11589b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj) {
            this.f11589b = obj;
            this.f11588a = obj;
        }

        @Override // qn.f, qn.e
        public Integer a(@os.l Object obj, @os.l un.o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f11588a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l un.o<?> oVar, Integer num) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f11588a = num;
        }
    }

    public static final class b implements qn.f<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f11590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11591b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj) {
            this.f11591b = obj;
            this.f11590a = obj;
        }

        @Override // qn.f, qn.e
        public Boolean a(@os.l Object obj, @os.l un.o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f11590a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l un.o<?> oVar, Boolean bool) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f11590a = bool;
        }
    }

    public static final class c implements qn.f<Object, j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f11592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11593b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object obj) {
            this.f11593b = obj;
            this.f11592a = obj;
        }

        @Override // qn.f, qn.e
        public j a(@os.l Object obj, @os.l un.o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f11592a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l un.o<?> oVar, j jVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f11592a = jVar;
        }
    }

    static {
        un.l lVarK = l1.k(new x0(e.class, "interceptorsQuantity", "getInterceptorsQuantity()I", 0));
        x0 x0Var = new x0(e.class, "interceptorsListShared", "getInterceptorsListShared()Z", 0);
        m1 m1Var = l1.f9319a;
        f11581g = new un.o[]{lVarK, m1Var.i(x0Var), m1Var.i(new x0(e.class, "interceptorsListSharedPhase", "getInterceptorsListSharedPhase()Lio/ktor/util/pipeline/PipelinePhase;", 0))};
    }

    public e(@os.l j... jVarArr) {
        l0.p(jVarArr, "phases");
        this.f11582a = fl.e.a(true);
        this.f11584c = hl.a.a(Arrays.copyOf(jVarArr, jVarArr.length));
        this.f11585d = new a(0);
        this._interceptors = null;
        this.f11586e = new b(Boolean.FALSE);
        this.f11587f = new c(null);
    }

    @t0
    public static /* synthetic */ void B() {
    }

    public final boolean A() {
        return r() == 0;
    }

    public final void C(@os.l e<TSubject, TContext> eVar) {
        l0.p(eVar, TypedValues.TransitionType.S_FROM);
        if (i(eVar)) {
            return;
        }
        if (r() == 0) {
            I(eVar);
        } else {
            G();
        }
        List listY5 = h0.Y5(eVar.f11584c);
        while (!listY5.isEmpty()) {
            Iterator it = listY5.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                j jVar = next instanceof j ? (j) next : null;
                if (jVar == null) {
                    jVar = ((d) next).f11573a;
                }
                if (t(jVar)) {
                    it.remove();
                } else if (w(next, jVar)) {
                    it.remove();
                }
                if (next instanceof d) {
                    d dVar = (d) next;
                    if (!dVar.l()) {
                        d<TSubject, TContext> dVarJ = j(jVar);
                        l0.m(dVarJ);
                        dVar.d(dVarJ);
                        N(dVar.k() + r());
                    }
                }
            }
        }
    }

    public final void D(List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list) {
        this._interceptors = list;
        L(false);
        M(null);
    }

    @os.l
    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> F(@os.l j jVar) {
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        d<TSubject, TContext> dVarJ = j(jVar);
        List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> listO = dVarJ == null ? null : dVarJ.o();
        return listO == null ? k0.INSTANCE : listO;
    }

    public final void G() {
        this._interceptors = null;
        L(false);
        M(null);
    }

    public final void H(List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list) {
        this._interceptors = list;
    }

    public final void I(e<TSubject, TContext> eVar) {
        this._interceptors = eVar.O();
        L(true);
        M(null);
    }

    public final void J(d<TSubject, TContext> dVar) {
        this._interceptors = dVar.o();
        L(false);
        M(dVar.f11573a);
    }

    public final void L(boolean z10) {
        this.f11586e.b(this, f11581g[1], Boolean.valueOf(z10));
    }

    public final void M(j jVar) {
        this.f11587f.b(this, f11581g[2], jVar);
    }

    public final void N(int i10) {
        this.f11585d.b(this, f11581g[0], Integer.valueOf(i10));
    }

    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> O() {
        if (((List) this._interceptors) == null) {
            e();
        }
        L(true);
        List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> list = (List) this._interceptors;
        l0.m(list);
        return list;
    }

    public final boolean P(j jVar, q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object> qVar) {
        List list = (List) this._interceptors;
        if (this.f11584c.isEmpty() || list == null || o() || !u1.F(list)) {
            return false;
        }
        if (l0.g(p(), jVar)) {
            list.add(qVar);
            return true;
        }
        if (!l0.g(jVar, h0.p3(this.f11584c)) && k(jVar) != y.J(this.f11584c)) {
            return false;
        }
        d<TSubject, TContext> dVarJ = j(jVar);
        l0.m(dVarJ);
        dVarJ.b(qVar);
        list.add(qVar);
        return true;
    }

    public final void b(@os.l j jVar) {
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        if (t(jVar)) {
            return;
        }
        this.f11584c.add(jVar);
    }

    public void c() {
    }

    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> e() {
        int iJ;
        int iR = r();
        if (iR == 0) {
            k0 k0Var = k0.INSTANCE;
            D(k0Var);
            return k0Var;
        }
        List<Object> list = this.f11584c;
        int i10 = 0;
        if (iR == 1 && (iJ = y.J(list)) >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                Object obj = list.get(i11);
                d<TSubject, TContext> dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null && !dVar.l()) {
                    List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> listO = dVar.o();
                    J(dVar);
                    return listO;
                }
                if (i11 == iJ) {
                    break;
                }
                i11 = i12;
            }
        }
        List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> listA = hl.a.a(new q[0]);
        int iJ2 = y.J(list);
        if (iJ2 >= 0) {
            while (true) {
                int i13 = i10 + 1;
                Object obj2 = list.get(i10);
                d dVar2 = obj2 instanceof d ? (d) obj2 : null;
                if (dVar2 != null) {
                    dVar2.c(listA);
                }
                if (i10 == iJ2) {
                    break;
                }
                i10 = i13;
            }
        }
        D(listA);
        return listA;
    }

    public final h<TSubject> f(TContext tcontext, TSubject tsubject, um.g gVar) {
        return g.b(tcontext, O(), tsubject, gVar, m());
    }

    @os.m
    public final Object g(@os.l TContext tcontext, @os.l TSubject tsubject, @os.l um.d<? super TSubject> dVar) {
        return f(tcontext, tsubject, dVar.getContext()).b(tsubject, dVar);
    }

    public final boolean i(e<TSubject, TContext> eVar) {
        if (eVar.f11584c.isEmpty()) {
            return true;
        }
        int i10 = 0;
        if (!this.f11584c.isEmpty()) {
            return false;
        }
        List<Object> list = eVar.f11584c;
        int iJ = y.J(list);
        if (iJ >= 0) {
            while (true) {
                int i11 = i10 + 1;
                Object obj = list.get(i10);
                if (obj instanceof j) {
                    this.f11584c.add(obj);
                } else if (obj instanceof d) {
                    d dVar = (d) obj;
                    this.f11584c.add(new d(dVar.f11573a, dVar.f11574b, dVar.o()));
                }
                if (i10 == iJ) {
                    break;
                }
                i10 = i11;
            }
        }
        N(eVar.r() + r());
        I(eVar);
        return true;
    }

    public final d<TSubject, TContext> j(j jVar) {
        List<Object> list = this.f11584c;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            Object obj = list.get(i10);
            if (obj == jVar) {
                d<TSubject, TContext> dVar = new d<>(jVar, k.c.f11597a);
                list.set(i10, dVar);
                return dVar;
            }
            if (obj instanceof d) {
                d<TSubject, TContext> dVar2 = (d) obj;
                if (dVar2.f11573a == jVar) {
                    return dVar2;
                }
            }
            i10 = i11;
        }
        return null;
    }

    public final int k(j jVar) {
        List<Object> list = this.f11584c;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            Object obj = list.get(i10);
            if (obj == jVar || ((obj instanceof d) && ((d) obj).f11573a == jVar)) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    @os.l
    public final fl.c l() {
        return this.f11582a;
    }

    public boolean m() {
        return this.f11583b;
    }

    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> n() {
        return (List) this._interceptors;
    }

    public final boolean o() {
        return ((Boolean) this.f11586e.a(this, f11581g[1])).booleanValue();
    }

    public final j p() {
        return (j) this.f11587f.a(this, f11581g[2]);
    }

    public final int r() {
        return ((Number) this.f11585d.a(this, f11581g[0])).intValue();
    }

    @os.l
    public final List<j> s() {
        List<Object> list = this.f11584c;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (Object obj : list) {
            j jVar = obj instanceof j ? (j) obj : null;
            if (jVar == null) {
                d dVar = obj instanceof d ? (d) obj : null;
                j jVar2 = dVar != null ? dVar.f11573a : null;
                l0.m(jVar2);
                jVar = jVar2;
            }
            arrayList.add(jVar);
        }
        return arrayList;
    }

    public final boolean t(j jVar) {
        List<Object> list = this.f11584c;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            Object obj = list.get(i10);
            if (obj == jVar) {
                return true;
            }
            if ((obj instanceof d) && ((d) obj).f11573a == jVar) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    public final void u(@os.l j jVar, @os.l j jVar2) throws nl.c {
        l0.p(jVar, "reference");
        l0.p(jVar2, TypedValues.CycleType.S_WAVE_PHASE);
        if (t(jVar2)) {
            return;
        }
        int iK = k(jVar);
        if (iK == -1) {
            throw new nl.c("Phase " + jVar + " was not registered for this pipeline");
        }
        int i10 = iK + 1;
        int iJ = y.J(this.f11584c);
        if (i10 <= iJ) {
            while (true) {
                int i11 = i10 + 1;
                Object obj = this.f11584c.get(i10);
                d dVar = obj instanceof d ? (d) obj : null;
                k kVar = dVar == null ? null : dVar.f11574b;
                if (kVar == null) {
                    break;
                }
                k.a aVar = kVar instanceof k.a ? (k.a) kVar : null;
                j jVar3 = aVar != null ? aVar.f11595a : null;
                if (jVar3 != null && l0.g(jVar3, jVar)) {
                    iK = i10;
                }
                if (i10 == iJ) {
                    break;
                } else {
                    i10 = i11;
                }
            }
        }
        this.f11584c.add(iK + 1, new d(jVar2, new k.a(jVar)));
    }

    public final void v(@os.l j jVar, @os.l j jVar2) throws nl.c {
        l0.p(jVar, "reference");
        l0.p(jVar2, TypedValues.CycleType.S_WAVE_PHASE);
        if (t(jVar2)) {
            return;
        }
        int iK = k(jVar);
        if (iK != -1) {
            this.f11584c.add(iK, new d(jVar2, new k.b(jVar)));
            return;
        }
        throw new nl.c("Phase " + jVar + " was not registered for this pipeline");
    }

    public final boolean w(Object obj, j jVar) throws nl.c {
        Object obj2 = obj == jVar ? k.c.f11597a : ((d) obj).f11574b;
        if (obj2 instanceof k.c) {
            b(jVar);
            return true;
        }
        if (obj2 instanceof k.b) {
            k.b bVar = (k.b) obj2;
            if (t(bVar.f11596a)) {
                v(bVar.f11596a, jVar);
                return true;
            }
        }
        if (!(obj2 instanceof k.a)) {
            return false;
        }
        u(((k.a) obj2).f11595a, jVar);
        return true;
    }

    public final void x(@os.l j jVar, @os.l q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object> qVar) throws nl.c {
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        l0.p(qVar, "block");
        d<TSubject, TContext> dVarJ = j(jVar);
        if (dVarJ == null) {
            throw new nl.c("Phase " + jVar + " was not registered for this pipeline");
        }
        if (P(jVar, qVar)) {
            N(r() + 1);
            return;
        }
        dVarJ.b(qVar);
        N(r() + 1);
        G();
        c();
    }

    @os.l
    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> y() {
        List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> list = (List) this._interceptors;
        return list == null ? e() : list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@os.l j jVar, @os.l List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list) throws nl.c {
        this(jVar);
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        l0.p(list, "interceptors");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            x(jVar, (q) it.next());
        }
    }
}
