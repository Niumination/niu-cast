package nl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import jn.q;
import kn.l0;
import kn.l1;
import kn.u1;
import kn.w;
import kn.x0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class d<TSubject, Call> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j f11573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final k f11574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final qn.f f11575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final qn.f f11576d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f11571f = {l1.k(new x0(d.class, "interceptors", "getInterceptors()Ljava/util/List;", 0)), l1.f9319a.i(new x0(d.class, "shared", "getShared()Z", 0))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f11570e = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final List<Object> f11572g = hl.a.a(new Object[0]);

    public static final class a {
        public a() {
        }

        @os.l
        public final List<Object> a() {
            return d.f11572g;
        }

        public a(w wVar) {
        }
    }

    public static final class b implements qn.f<Object, List<q<? super f<TSubject, Call>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<q<? super f<TSubject, Call>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> f11577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11578b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj) {
            this.f11578b = obj;
            this.f11577a = obj;
        }

        @Override // qn.f, qn.e
        public List<q<? super f<TSubject, Call>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> a(@os.l Object obj, @os.l un.o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f11577a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l un.o<?> oVar, List<q<? super f<TSubject, Call>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f11577a = list;
        }
    }

    public static final class c implements qn.f<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f11579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11580b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object obj) {
            this.f11580b = obj;
            this.f11579a = obj;
        }

        @Override // qn.f, qn.e
        public Boolean a(@os.l Object obj, @os.l un.o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f11579a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l un.o<?> oVar, Boolean bool) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f11579a = bool;
        }
    }

    public d(@os.l j jVar, @os.l k kVar, @os.l List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> list) {
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        l0.p(kVar, "relation");
        l0.p(list, "interceptors");
        this.f11573a = jVar;
        this.f11574b = kVar;
        this.f11575c = new b(list);
        this.f11576d = new c(Boolean.TRUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@os.l q<? super f<TSubject, Call>, ? super TSubject, ? super um.d<? super l2>, ? extends Object> qVar) {
        l0.p(qVar, "interceptor");
        if (j()) {
            f();
        }
        g().add(qVar);
    }

    public final void c(@os.l List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> list) {
        l0.p(list, RtspHeaders.Values.DESTINATION);
        List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> listG = g();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(listG.size() + list.size());
        }
        int size = listG.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.add(listG.get(i10));
        }
    }

    public final void d(@os.l d<TSubject, Call> dVar) {
        l0.p(dVar, RtspHeaders.Values.DESTINATION);
        if (l()) {
            return;
        }
        if (dVar.l()) {
            dVar.m(o());
            dVar.n(true);
        } else {
            if (dVar.j()) {
                dVar.f();
            }
            c(dVar.g());
        }
    }

    @os.l
    public final List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> e() {
        List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> listA = hl.a.a(new q[0]);
        listA.addAll(g());
        return listA;
    }

    public final void f() {
        m(e());
        n(false);
    }

    public final List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> g() {
        return (List) this.f11575c.a(this, f11571f[0]);
    }

    @os.l
    public final j h() {
        return this.f11573a;
    }

    @os.l
    public final k i() {
        return this.f11574b;
    }

    public final boolean j() {
        return ((Boolean) this.f11576d.a(this, f11571f[1])).booleanValue();
    }

    public final int k() {
        return g().size();
    }

    public final boolean l() {
        return g().isEmpty();
    }

    public final void m(List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> list) {
        this.f11575c.b(this, f11571f[0], list);
    }

    public final void n(boolean z10) {
        this.f11576d.b(this, f11571f[1], Boolean.valueOf(z10));
    }

    @os.l
    public final List<q<f<TSubject, Call>, TSubject, um.d<? super l2>, Object>> o() {
        n(true);
        return g();
    }

    @os.l
    public String toString() {
        return "Phase `" + this.f11573a.f11594a + "`, " + k() + " handlers";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(@os.l j jVar, @os.l k kVar) {
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        l0.p(kVar, "relation");
        List<Object> list = f11572g;
        this(jVar, kVar, u1.g(list));
        if (!list.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified");
        }
    }
}
