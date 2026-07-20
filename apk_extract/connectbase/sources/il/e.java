package il;

import ik.y0;
import kn.l0;
import kn.l1;
import kn.x0;
import os.l;
import os.m;
import pl.e0;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f8251e = {l1.k(new x0(e.class, y0.b.f8223h, "getNext()Lio/ktor/util/collections/internal/ForwardListNode;", 0)), l1.f9319a.i(new x0(e.class, "previous", "getPrevious()Lio/ktor/util/collections/internal/ForwardListNode;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final h<T> f8252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final T f8253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final qn.f f8254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final qn.f f8255d;

    public static final class a implements qn.f<Object, e<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<T> f8256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8257b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj) {
            this.f8257b = obj;
            this.f8256a = obj;
        }

        @Override // qn.f, qn.e
        public e<T> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8256a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, e<T> eVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8256a = eVar;
        }
    }

    public static final class b implements qn.f<Object, e<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<T> f8258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8259b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj) {
            this.f8259b = obj;
            this.f8258a = obj;
        }

        @Override // qn.f, qn.e
        public e<T> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8258a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, e<T> eVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8258a = eVar;
        }
    }

    public e(@l h<T> hVar, @m e<T> eVar, @m T t10, @m e<T> eVar2) {
        l0.p(hVar, "list");
        this.f8252a = hVar;
        this.f8253b = t10;
        this.f8254c = new a(eVar);
        this.f8255d = new b(eVar2);
        e0.a(this);
    }

    @m
    public final T a() {
        return this.f8253b;
    }

    @m
    public final e<T> b() {
        return (e) this.f8254c.a(this, f8251e[0]);
    }

    @m
    public final e<T> c() {
        return (e) this.f8255d.a(this, f8251e[1]);
    }

    @l
    public final e<T> d(@l T t10) {
        l0.p(t10, "value");
        e<T> eVar = new e<>(this.f8252a, b(), t10, this);
        e<T> eVarB = b();
        if (eVarB != null) {
            eVarB.h(eVar);
        }
        g(eVar);
        return eVar;
    }

    public final void e() {
        e<T> eVarC = c();
        l0.m(eVarC);
        eVarC.f();
    }

    public final void f() {
        if (l0.g(b(), this.f8252a.g())) {
            this.f8252a.l(this);
        }
        e<T> eVarB = b();
        g(eVarB == null ? null : eVarB.b());
        e<T> eVarB2 = b();
        if (eVarB2 == null) {
            return;
        }
        eVarB2.h(this);
    }

    public final void g(@m e<T> eVar) {
        this.f8254c.b(this, f8251e[0], eVar);
    }

    public final void h(@m e<T> eVar) {
        this.f8255d.b(this, f8251e[1], eVar);
    }
}
