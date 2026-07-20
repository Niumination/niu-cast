package ll;

import fl.t0;
import ik.y0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import lm.z0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10145a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10146b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10147c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_removedRef");

    @l
    volatile /* synthetic */ Object _next = this;

    @l
    volatile /* synthetic */ Object _prev = this;

    @l
    private volatile /* synthetic */ Object _removedRef = null;

    @t0
    public static abstract class a extends ll.a {

        /* JADX INFO: renamed from: ll.e$a$a, reason: collision with other inner class name */
        public static final class C0266a extends ll.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @in.f
            @l
            public final e f10148a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @in.f
            @l
            public final ll.b<e> f10149b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @in.f
            @l
            public final a f10150c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0266a(@l e eVar, @l ll.b<? super e> bVar, @l a aVar) {
                l0.p(eVar, y0.b.f8223h);
                l0.p(bVar, "op");
                l0.p(aVar, "desc");
                this.f10148a = eVar;
                this.f10149b = bVar;
                this.f10150c = aVar;
            }

            @Override // ll.f
            @m
            public Object a(@m Object obj) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
                }
                e eVar = (e) obj;
                Object objG = this.f10150c.g(eVar, this.f10148a);
                if (objG == null) {
                    j.d.a(e.f10145a, eVar, this, this.f10149b.d() ? this.f10148a : this.f10149b);
                    return null;
                }
                if (objG == ll.d.f10143g) {
                    if (j.d.a(e.f10145a, eVar, this, this.f10148a.K())) {
                        eVar.B();
                    }
                } else {
                    this.f10149b.f(objG);
                    j.d.a(e.f10145a, eVar, this, this.f10148a);
                }
                return objG;
            }
        }

        @Override // ll.a
        public final void a(@l ll.b<?> bVar, @m Object obj) {
            l0.p(bVar, "op");
            boolean z10 = obj == null;
            e eVarE = e();
            if (eVarE == null) {
                if (z10) {
                    throw new IllegalStateException("Check failed.");
                }
                return;
            }
            e eVarF = f();
            if (eVarF == null) {
                if (z10) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                if (j.d.a(e.f10145a, eVarE, bVar, z10 ? j(eVarE, eVarF) : eVarF) && z10) {
                    d(eVarE, eVarF);
                }
            }
        }

        @Override // ll.a
        @m
        public final Object b(@l ll.b<?> bVar) {
            Object objA;
            l0.p(bVar, "op");
            while (true) {
                e eVarI = i(bVar);
                Object obj = eVarI._next;
                if (obj == bVar || bVar.d()) {
                    return null;
                }
                if (obj instanceof ll.f) {
                    ((ll.f) obj).a(eVarI);
                } else {
                    Object objC = c(eVarI, obj);
                    if (objC != null) {
                        return objC;
                    }
                    if (h(eVarI, obj)) {
                        continue;
                    } else {
                        C0266a c0266a = new C0266a((e) obj, bVar, this);
                        if (j.d.a(e.f10145a, eVarI, obj, c0266a) && (objA = c0266a.a(eVarI)) != ll.d.f10143g) {
                            return objA;
                        }
                    }
                }
            }
        }

        @m
        public Object c(@l e eVar, @l Object obj) {
            l0.p(eVar, "affected");
            l0.p(obj, y0.b.f8223h);
            return null;
        }

        public abstract void d(@l e eVar, @l e eVar2);

        @m
        public abstract e e();

        @m
        public abstract e f();

        @m
        public abstract Object g(@l e eVar, @l e eVar2);

        public boolean h(@l e eVar, @l Object obj) {
            l0.p(eVar, "affected");
            l0.p(obj, y0.b.f8223h);
            return false;
        }

        @l
        public e i(@l ll.f fVar) {
            l0.p(fVar, "op");
            e eVarE = e();
            l0.m(eVarE);
            return eVarE;
        }

        @l
        public abstract Object j(@l e eVar, @l e eVar2);
    }

    public static class b<T extends e> extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f10151c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_affectedNode");

        @l
        private volatile /* synthetic */ Object _affectedNode;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @l
        public final e f10152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @in.f
        @l
        public final T f10153b;

        public b(@l e eVar, @l T t10) {
            l0.p(eVar, "queue");
            l0.p(t10, "node");
            this.f10152a = eVar;
            this.f10153b = t10;
            if (t10._next != t10 || t10._prev != t10) {
                throw new IllegalStateException("Check failed.");
            }
            this._affectedNode = null;
        }

        @Override // ll.e.a
        public void d(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            this.f10153b.t(this.f10152a);
        }

        @Override // ll.e.a
        @m
        public final e e() {
            return (e) this._affectedNode;
        }

        @Override // ll.e.a
        @m
        public final e f() {
            return this.f10152a;
        }

        @Override // ll.e.a
        @m
        public Object g(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            j.d.a(f10151c, this, null, eVar);
            return null;
        }

        @Override // ll.e.a
        public boolean h(@l e eVar, @l Object obj) {
            l0.p(eVar, "affected");
            l0.p(obj, y0.b.f8223h);
            return obj != this.f10152a;
        }

        @Override // ll.e.a
        @l
        public final e i(@l ll.f fVar) {
            l0.p(fVar, "op");
            while (true) {
                e eVar = (e) this.f10152a._prev;
                Object obj = eVar._next;
                e eVar2 = this.f10152a;
                if (obj == eVar2 || obj == fVar) {
                    return eVar;
                }
                if (obj instanceof ll.f) {
                    ((ll.f) obj).a(eVar);
                } else {
                    e eVarN = eVar2.n(eVar, fVar);
                    if (eVarN != null) {
                        return eVarN;
                    }
                }
            }
        }

        @Override // ll.e.a
        @l
        public Object j(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            T t10 = this.f10153b;
            j.d.a(e.f10146b, t10, t10, eVar);
            T t11 = this.f10153b;
            j.d.a(e.f10145a, t11, t11, this.f10152a);
            return this.f10153b;
        }
    }

    @z0
    public static abstract class c extends ll.b<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @in.f
        @l
        public final e f10154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m
        @in.f
        public e f10155c;

        public c(@l e eVar) {
            l0.p(eVar, "newNode");
            this.f10154b = eVar;
        }

        @Override // ll.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(@l e eVar, @m Object obj) {
            l0.p(eVar, "affected");
            boolean z10 = obj == null;
            e eVar2 = z10 ? this.f10154b : this.f10155c;
            if (eVar2 != null && j.d.a(e.f10145a, eVar, this, eVar2) && z10) {
                e eVar3 = this.f10154b;
                e eVar4 = this.f10155c;
                l0.m(eVar4);
                eVar3.t(eVar4);
            }
        }
    }

    public static class d<T> extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f10156b = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_affectedNode");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f10157c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_originalNext");

        @l
        private volatile /* synthetic */ Object _affectedNode;

        @l
        private volatile /* synthetic */ Object _originalNext;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @l
        public final e f10158a;

        public d(@l e eVar) {
            l0.p(eVar, "queue");
            this.f10158a = eVar;
            this._affectedNode = null;
            this._originalNext = null;
        }

        public static /* synthetic */ void l() {
        }

        @Override // ll.e.a
        @m
        public Object c(@l e eVar, @l Object obj) {
            l0.p(eVar, "affected");
            l0.p(obj, y0.b.f8223h);
            if (eVar == this.f10158a) {
                return ll.d.h();
            }
            return null;
        }

        @Override // ll.e.a
        public final void d(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            eVar.u(eVar2);
        }

        @Override // ll.e.a
        @m
        public final e e() {
            return (e) this._affectedNode;
        }

        @Override // ll.e.a
        @m
        public final e f() {
            return (e) this._originalNext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ll.e.a
        @m
        public final Object g(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            if (eVar instanceof ll.c) {
                throw new IllegalStateException("Check failed.");
            }
            if (!m(eVar)) {
                return ll.d.f10143g;
            }
            j.d.a(f10156b, this, null, eVar);
            j.d.a(f10157c, this, null, eVar2);
            return null;
        }

        @Override // ll.e.a
        public final boolean h(@l e eVar, @l Object obj) {
            l0.p(eVar, "affected");
            l0.p(obj, y0.b.f8223h);
            if (!(obj instanceof g)) {
                return false;
            }
            eVar.B();
            return true;
        }

        @Override // ll.e.a
        @l
        public final e i(@l ll.f fVar) {
            l0.p(fVar, "op");
            return (e) this.f10158a.v();
        }

        @Override // ll.e.a
        @l
        public final Object j(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            return eVar2.K();
        }

        public final T k() {
            T t10 = (T) ((e) this._affectedNode);
            l0.m(t10);
            return t10;
        }

        public boolean m(T t10) {
            return true;
        }
    }

    /* JADX INFO: renamed from: ll.e$e, reason: collision with other inner class name */
    public static final class C0267e extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f10159b = AtomicReferenceFieldUpdater.newUpdater(C0267e.class, Object.class, "_originalNext");

        @l
        private volatile /* synthetic */ Object _originalNext = null;

        public C0267e() {
        }

        @Override // ll.e.a
        @m
        public Object c(@l e eVar, @l Object obj) {
            l0.p(eVar, "affected");
            l0.p(obj, y0.b.f8223h);
            if (obj instanceof g) {
                return ll.d.c();
            }
            return null;
        }

        @Override // ll.e.a
        public void d(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            e.this.u(eVar2);
        }

        @Override // ll.e.a
        @m
        public e e() {
            return e.this;
        }

        @Override // ll.e.a
        @m
        public e f() {
            return (e) this._originalNext;
        }

        @Override // ll.e.a
        @m
        public Object g(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            j.d.a(f10159b, this, null, eVar2);
            return null;
        }

        @Override // ll.e.a
        @l
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public g j(@l e eVar, @l e eVar2) {
            l0.p(eVar, "affected");
            l0.p(eVar2, y0.b.f8223h);
            return eVar2.K();
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ jn.a<Boolean> f10162e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(jn.a<Boolean> aVar) {
            super(e.this);
            this.f10162e = aVar;
        }

        @Override // ll.b
        @m
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object e(@l e eVar) {
            l0.p(eVar, "affected");
            if (this.f10162e.invoke().booleanValue()) {
                return null;
            }
            return ll.d.e();
        }
    }

    @l
    public final e A() {
        return ll.d.l(z());
    }

    @z0
    public final void B() {
        Object objV;
        e eVarF = F();
        e eVar = ((g) this._next).f10163a;
        while (true) {
            e eVar2 = null;
            while (true) {
                Object objV2 = eVar.v();
                if (objV2 instanceof g) {
                    eVar.F();
                    eVar = ((g) objV2).f10163a;
                } else {
                    objV = eVarF.v();
                    if (objV instanceof g) {
                        if (eVar2 != null) {
                            break;
                        } else {
                            eVarF = ll.d.l(eVarF._prev);
                        }
                    } else if (objV != this) {
                        e eVar3 = (e) objV;
                        if (eVar3 == eVar) {
                            return;
                        }
                        eVar2 = eVarF;
                        eVarF = eVar3;
                    } else if (j.d.a(f10145a, eVarF, this, eVar)) {
                        return;
                    }
                }
            }
            eVarF.F();
            j.d.a(f10145a, eVar2, eVarF, ((g) objV).f10163a);
            eVarF = eVar2;
        }
    }

    public final void C() {
        Object objV = v();
        g gVar = objV instanceof g ? (g) objV : null;
        if (gVar == null) {
            throw new IllegalStateException("Must be invoked on a removed node");
        }
        u(gVar.f10163a);
    }

    public final boolean D() {
        return v() instanceof g;
    }

    @z0
    @l
    public final c E(@l e eVar, @l jn.a<Boolean> aVar) {
        l0.p(eVar, "node");
        l0.p(aVar, "condition");
        return eVar.new f(aVar);
    }

    public final e F() {
        Object obj;
        do {
            obj = this._prev;
            if (obj instanceof g) {
                return ((g) obj).f10163a;
            }
        } while (!j.d.a(f10146b, this, obj, (obj == this ? r() : (e) obj).K()));
        return (e) obj;
    }

    public boolean G() {
        Object objV;
        e eVar;
        do {
            objV = v();
            if ((objV instanceof g) || objV == this) {
                return false;
            }
            eVar = (e) objV;
        } while (!j.d.a(f10145a, this, objV, eVar.K()));
        u(eVar);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, ll.e] */
    public final <T> T H() {
        while (true) {
            ?? r10 = (T) ((e) v());
            if (r10 == this) {
                return null;
            }
            l0.P();
            if (r10 == 0) {
                return null;
            }
            if (r10.G()) {
                return r10;
            }
            r10.B();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, ll.e] */
    public final <T> T I(jn.l<? super T, Boolean> lVar) {
        l0.p(lVar, "predicate");
        while (true) {
            e eVar = (e) v();
            if (eVar == this) {
                return null;
            }
            l0.P();
            if (eVar == 0) {
                return null;
            }
            if (lVar.invoke(eVar).booleanValue() || eVar.G()) {
                return eVar;
            }
            eVar.B();
        }
    }

    @m
    public final e J() {
        while (true) {
            e eVar = (e) v();
            if (eVar == this) {
                return null;
            }
            if (eVar.G()) {
                return eVar;
            }
            eVar.B();
        }
    }

    public final g K() {
        g gVar = (g) this._removedRef;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        f10147c.lazySet(this, gVar2);
        return gVar2;
    }

    @z0
    public final int L(@l e eVar, @l e eVar2, @l c cVar) {
        l0.p(eVar, "node");
        l0.p(eVar2, y0.b.f8223h);
        l0.p(cVar, "condAdd");
        f10146b.lazySet(eVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10145a;
        atomicReferenceFieldUpdater.lazySet(eVar, eVar2);
        cVar.f10155c = eVar2;
        if (j.d.a(atomicReferenceFieldUpdater, this, eVar2, cVar)) {
            return cVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void M(@l e eVar, @l e eVar2) {
        l0.p(eVar, "prev");
        l0.p(eVar2, y0.b.f8223h);
        if (eVar != this._prev) {
            throw new IllegalStateException("Check failed.");
        }
        if (eVar2 != this._next) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final void f(@l e eVar) {
        l0.p(eVar, "node");
        while (!((e) z()).j(eVar, this)) {
        }
    }

    public final boolean g(@l e eVar, @l jn.a<Boolean> aVar) {
        int iL;
        l0.p(eVar, "node");
        l0.p(aVar, "condition");
        f fVar = eVar.new f(aVar);
        do {
            iL = ((e) z()).L(eVar, this, fVar);
            if (iL == 1) {
                return true;
            }
        } while (iL != 2);
        return false;
    }

    public final boolean h(@l e eVar, @l jn.l<? super e, Boolean> lVar) {
        e eVar2;
        l0.p(eVar, "node");
        l0.p(lVar, "predicate");
        do {
            eVar2 = (e) z();
            if (!lVar.invoke(eVar2).booleanValue()) {
                return false;
            }
        } while (!eVar2.j(eVar, this));
        return true;
    }

    public final boolean i(@l e eVar, @l jn.l<? super e, Boolean> lVar, @l jn.a<Boolean> aVar) {
        int iL;
        l0.p(eVar, "node");
        l0.p(lVar, "predicate");
        l0.p(aVar, "condition");
        f fVar = eVar.new f(aVar);
        do {
            e eVar2 = (e) z();
            if (!lVar.invoke(eVar2).booleanValue()) {
                return false;
            }
            iL = eVar2.L(eVar, this, fVar);
            if (iL == 1) {
                return true;
            }
        } while (iL != 2);
        return false;
    }

    @z0
    public final boolean j(@l e eVar, @l e eVar2) {
        l0.p(eVar, "node");
        l0.p(eVar2, y0.b.f8223h);
        f10146b.lazySet(eVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10145a;
        atomicReferenceFieldUpdater.lazySet(eVar, eVar2);
        if (!j.d.a(atomicReferenceFieldUpdater, this, eVar2, eVar)) {
            return false;
        }
        eVar.t(eVar2);
        return true;
    }

    public final boolean l(@l e eVar) {
        l0.p(eVar, "node");
        f10146b.lazySet(eVar, this);
        f10145a.lazySet(eVar, this);
        while (v() == this) {
            if (j.d.a(f10145a, this, this, eVar)) {
                eVar.t(this);
                return true;
            }
        }
        return false;
    }

    public final e n(e eVar, ll.f fVar) {
        Object obj;
        while (true) {
            e eVar2 = null;
            while (true) {
                obj = eVar._next;
                if (obj == fVar) {
                    return eVar;
                }
                if (obj instanceof ll.f) {
                    ((ll.f) obj).a(eVar);
                } else if (!(obj instanceof g)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof g) {
                        return null;
                    }
                    if (obj != this) {
                        eVar2 = eVar;
                        eVar = (e) obj;
                    } else {
                        if (obj2 == eVar) {
                            return null;
                        }
                        if (j.d.a(f10146b, this, obj2, eVar) && !(eVar._prev instanceof g)) {
                            return null;
                        }
                    }
                } else {
                    if (eVar2 != null) {
                        break;
                    }
                    eVar = ll.d.l(eVar._prev);
                }
            }
            eVar.F();
            j.d.a(f10145a, eVar2, eVar, ((g) obj).f10163a);
            eVar = eVar2;
        }
    }

    @l
    public final <T extends e> b<T> o(@l T t10) {
        l0.p(t10, "node");
        return new b<>(this, t10);
    }

    @m
    public ll.a p() {
        if (v() instanceof g) {
            return null;
        }
        return new C0267e();
    }

    @l
    public final d<e> q() {
        return new d<>(this);
    }

    public final e r() {
        e eVarX = this;
        while (!(eVarX instanceof ll.c)) {
            eVarX = eVarX.x();
            if (eVarX == this) {
                throw new IllegalStateException("Cannot loop to this while looking for list head");
            }
        }
        return eVarX;
    }

    public final void t(e eVar) {
        Object obj;
        do {
            obj = eVar._prev;
            if ((obj instanceof g) || v() != eVar) {
                return;
            }
        } while (!j.d.a(f10146b, eVar, obj, this));
        if (v() instanceof g) {
            eVar.n((e) obj, null);
        }
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getClass().getSimpleName());
        sb2.append('@');
        sb2.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb2.toString();
    }

    public final void u(e eVar) {
        B();
        eVar.n(ll.d.l(this._prev), null);
    }

    @l
    public final Object v() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof ll.f)) {
                return obj;
            }
            ((ll.f) obj).a(this);
        }
    }

    @l
    public final e x() {
        return ll.d.l(v());
    }

    @l
    public final Object z() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof g) {
                return obj;
            }
            e eVar = (e) obj;
            if (eVar.v() == this) {
                return obj;
            }
            n(eVar, null);
        }
    }
}
