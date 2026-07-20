package il;

import java.util.Iterator;
import kn.l0;
import kn.l1;
import kn.x0;
import os.l;
import os.m;
import pl.e0;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> implements Iterable<T>, ln.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f8272c = {l1.k(new x0(h.class, "head", "getHead$ktor_utils()Lio/ktor/util/collections/internal/ForwardListNode;", 0)), l1.f9319a.i(new x0(h.class, "tail", "getTail$ktor_utils()Lio/ktor/util/collections/internal/ForwardListNode;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final qn.f f8273a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final qn.f f8274b = new b(f());

    public static final class a implements qn.f<Object, e<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<T> f8275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8276b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj) {
            this.f8276b = obj;
            this.f8275a = obj;
        }

        @Override // qn.f, qn.e
        public e<T> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8275a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, e<T> eVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8275a = eVar;
        }
    }

    public static final class b implements qn.f<Object, e<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<T> f8277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8278b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj) {
            this.f8278b = obj;
            this.f8277a = obj;
        }

        @Override // qn.f, qn.e
        public e<T> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8277a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, e<T> eVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8277a = eVar;
        }
    }

    public h() {
        e0.a(this);
        j(new e<>(this, null, null, null));
        l(f());
    }

    @l
    public final e<T> a(@l T t10) {
        l0.p(t10, "value");
        e<T> eVarF = f();
        l0.m(eVarF);
        e<T> eVarD = eVarF.d(t10);
        if (l0.g(f(), g())) {
            l(eVarD);
        }
        return eVarD;
    }

    @l
    public final e<T> c(@l T t10) {
        l0.p(t10, "value");
        e<T> eVarG = g();
        l0.m(eVarG);
        l(eVarG.d(t10));
        e<T> eVarG2 = g();
        l0.m(eVarG2);
        return eVarG2;
    }

    @m
    public final e<T> e() {
        e<T> eVarF = f();
        l0.m(eVarF);
        return eVarF.b();
    }

    @m
    public final e<T> f() {
        return (e) this.f8273a.a(this, f8272c[0]);
    }

    @m
    public final e<T> g() {
        return (e) this.f8274b.a(this, f8272c[1]);
    }

    @m
    public final e<T> i() {
        if (l0.g(f(), g())) {
            return null;
        }
        return g();
    }

    @Override // java.lang.Iterable
    @l
    public Iterator<T> iterator() {
        e<T> eVarF = f();
        l0.m(eVarF);
        return new d(eVarF);
    }

    public final void j(@m e<T> eVar) {
        this.f8273a.b(this, f8272c[0], eVar);
    }

    public final void l(@m e<T> eVar) {
        this.f8274b.b(this, f8272c[1], eVar);
    }
}
