package ro;

import eo.t0;
import eo.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kn.l0;
import kn.n0;
import kn.w;
import lm.i0;
import nm.k0;
import nm.m0;
import no.o;
import uo.d0;
import uo.u;
import wo.n;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final u f14643n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public final h f14644o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final up.j<Set<String>> f14645p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public final up.h<a, eo.e> f14646q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final dp.f f14647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final uo.g f14648b;

        public a(@os.l dp.f fVar, @os.m uo.g gVar) {
            l0.p(fVar, "name");
            this.f14647a = fVar;
            this.f14648b = gVar;
        }

        @os.m
        public final uo.g a() {
            return this.f14648b;
        }

        @os.l
        public final dp.f b() {
            return this.f14647a;
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof a) && l0.g(this.f14647a, ((a) obj).f14647a);
        }

        public int hashCode() {
            return this.f14647a.hashCode();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final eo.e f14649a;

            public a(@os.l eo.e eVar) {
                l0.p(eVar, "descriptor");
                this.f14649a = eVar;
            }

            @os.l
            public final eo.e a() {
                return this.f14649a;
            }
        }

        /* JADX INFO: renamed from: ro.i$b$b, reason: collision with other inner class name */
        public static final class C0361b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public static final C0361b f14650a = new C0361b();
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public static final c f14651a = new c();
        }

        public b() {
        }

        public b(w wVar) {
        }
    }

    public static final class c extends n0 implements jn.l<a, eo.e> {
        final /* synthetic */ qo.h $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qo.h hVar) {
            super(1);
            this.$c = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0075  */
        @Override // jn.l
        @os.m
        public final eo.e invoke(@os.l a aVar) {
            byte[] bArr;
            l0.p(aVar, "request");
            dp.b bVar = new dp.b(i.this.f14644o.f7473e, aVar.f14647a);
            uo.g gVar = aVar.f14648b;
            n.a aVarB = gVar != null ? this.$c.f14088a.f14057c.b(gVar) : this.$c.f14088a.f14057c.a(bVar);
            p pVarA = aVarB == null ? null : aVarB.a();
            dp.b bVarF = pVarA == null ? null : pVarA.f();
            if (bVarF != null && (bVarF.l() || bVarF.f3808c)) {
                return null;
            }
            b bVarS = i.this.S(pVarA);
            if (bVarS instanceof b.a) {
                return ((b.a) bVarS).f14649a;
            }
            if (bVarS instanceof b.c) {
                return null;
            }
            if (!(bVarS instanceof b.C0361b)) {
                throw new i0();
            }
            uo.g gVarA = aVar.f14648b;
            if (gVarA == null) {
                o oVar = this.$c.f14088a.f14056b;
                if (aVarB != null) {
                    if (!(aVarB instanceof n.a.C0492a)) {
                        aVarB = null;
                    }
                    n.a.C0492a c0492a = (n.a.C0492a) aVarB;
                    if (c0492a == null) {
                        bArr = null;
                    } else {
                        bArr = c0492a.f19815a;
                    }
                } else {
                    bArr = null;
                }
                gVarA = oVar.a(new o.a(bVar, bArr, null, 4, null));
            }
            uo.g gVar2 = gVarA;
            if ((gVar2 == null ? null : gVar2.I()) != d0.BINARY) {
                dp.c cVarE = gVar2 == null ? null : gVar2.e();
                if (cVarE == null || cVarE.d() || !l0.g(cVarE.e(), i.this.f14644o.f7473e)) {
                    return null;
                }
                f fVar = new f(this.$c, i.this.f14644o, gVar2, null, 8, null);
                this.$c.f14088a.f14073s.a(fVar);
                return fVar;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar2 + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + wo.o.b(this.$c.f14088a.f14057c, gVar2) + "\nfindKotlinClass(ClassId) = " + wo.o.a(this.$c.f14088a.f14057c, bVar) + '\n');
        }
    }

    public static final class d extends n0 implements jn.a<Set<? extends String>> {
        final /* synthetic */ qo.h $c;
        final /* synthetic */ i this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(qo.h hVar, i iVar) {
            super(0);
            this.$c = hVar;
            this.this$0 = iVar;
        }

        @Override // jn.a
        @os.m
        public final Set<? extends String> invoke() {
            return this.$c.f14088a.f14056b.c(this.this$0.f14644o.f7473e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@os.l qo.h hVar, @os.l u uVar, @os.l h hVar2) {
        super(hVar);
        l0.p(hVar, "c");
        l0.p(uVar, "jPackage");
        l0.p(hVar2, "ownerDescriptor");
        this.f14643n = uVar;
        this.f14644o = hVar2;
        this.f14645p = hVar.f14088a.f14055a.g(new d(hVar, this));
        this.f14646q = hVar.f14088a.f14055a.f(new c(hVar));
    }

    @Override // ro.j
    public eo.m D() {
        return this.f14644o;
    }

    public final eo.e O(dp.f fVar, uo.g gVar) {
        if (!dp.h.f3824a.a(fVar)) {
            return null;
        }
        Set<String> setInvoke = this.f14645p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(fVar.b())) {
            return this.f14646q.invoke(new a(fVar, gVar));
        }
        return null;
    }

    @os.m
    public final eo.e P(@os.l uo.g gVar) {
        l0.p(gVar, "javaClass");
        return O(gVar.getName(), gVar);
    }

    @Override // op.i, op.k
    @os.m
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public eo.e f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return O(fVar, null);
    }

    @os.l
    public h R() {
        return this.f14644o;
    }

    public final b S(p pVar) {
        if (pVar == null) {
            return b.C0361b.f14650a;
        }
        if (pVar.b().f20438a != xo.a.EnumC0527a.CLASS) {
            return b.c.f14651a;
        }
        eo.e eVarL = this.f14653b.f14088a.f14058d.l(pVar);
        return eVarL != null ? new b.a(eVarL) : b.C0361b.f14650a;
    }

    @Override // ro.j, op.i, op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return k0.INSTANCE;
    }

    @Override // ro.j, op.i, op.k
    @os.l
    public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        op.d.a aVar = op.d.f12368c;
        aVar.getClass();
        int i10 = op.d.f12377l;
        aVar.getClass();
        if (!dVar.a(op.d.f12370e | i10)) {
            return k0.INSTANCE;
        }
        Collection<eo.m> collectionInvoke = this.f14655d.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            eo.m mVar = (eo.m) obj;
            if (mVar instanceof eo.e) {
                dp.f name = ((eo.e) mVar).getName();
                l0.o(name, "it.name");
                if (lVar.invoke(name).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> m(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        op.d.f12368c.getClass();
        if (!dVar.a(op.d.f12370e)) {
            return m0.INSTANCE;
        }
        Set<String> setInvoke = this.f14645p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(dp.f.k((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.f14643n;
        if (lVar == null) {
            lVar = eq.d.a();
        }
        Collection<uo.g> collectionU = uVar.u(lVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (uo.g gVar : collectionU) {
            dp.f name = gVar.I() == d0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> o(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        return m0.INSTANCE;
    }

    @Override // ro.j
    @os.l
    public ro.b q() {
        return ro.b.a.f14604a;
    }

    @Override // ro.j
    public void s(@os.l Collection<y0> collection, @os.l dp.f fVar) {
        l0.p(collection, "result");
        l0.p(fVar, "name");
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> u(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        return m0.INSTANCE;
    }
}
