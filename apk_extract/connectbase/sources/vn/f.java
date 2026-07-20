package vn;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.f1;
import lm.r1;
import nm.d1;
import nm.x;
import nm.z;
import os.l;
import os.m;
import un.n;
import un.p;
import un.q;
import un.r;
import un.s;
import vp.f0;
import vp.h1;
import vp.o1;
import xn.k;
import xn.v;
import xn.y;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "KClasses")
public final class f {

    public static final class a<N> implements eq.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<N> f17600a = new a<>();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // eq.b.d
        @l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<s> a(s sVar) {
            un.g gVarI = sVar.i();
            jn.a aVar = null;
            Object[] objArr = 0;
            un.d dVar = gVarI instanceof un.d ? (un.d) gVarI : null;
            if (dVar == null) {
                throw new y(l0.C("Supertype not a class: ", sVar));
            }
            List<s> listA = dVar.a();
            if (sVar.n().isEmpty()) {
                return listA;
            }
            h1 h1VarF = h1.f(((v) sVar).f20427a);
            List<s> list = listA;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            for (s sVar2 : list) {
                f0 f0VarP = h1VarF.p(((v) sVar2).f20427a, o1.INVARIANT);
                if (f0VarP == null) {
                    throw new y("Type substitution failed: " + sVar2 + " (" + sVar + ')');
                }
                arrayList.add(new v(f0VarP, aVar, 2, objArr == true ? 1 : 0));
            }
            return arrayList;
        }
    }

    public static final class b extends eq.b.f<s, s> {
        @Override // eq.b.AbstractC0107b, eq.b.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(@l s sVar) {
            l0.p(sVar, "current");
            ((LinkedList) this.f4660a).add(sVar);
            return true;
        }
    }

    public static final class c extends n0 implements jn.a<Type> {
        final /* synthetic */ un.d<?> $this_defaultType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(un.d<?> dVar) {
            super(0);
            this.$this_defaultType = dVar;
        }

        @Override // jn.a
        @l
        public final Type invoke() {
            return ((xn.h) this.$this_defaultType).f20337d;
        }
    }

    public static final class e extends n0 implements jn.l<un.d<?>, Boolean> {
        final /* synthetic */ un.d<?> $base;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(un.d<?> dVar) {
            super(1);
            this.$base = dVar;
        }

        @Override // jn.l
        public final Boolean invoke(un.d<?> dVar) {
            return Boolean.valueOf(l0.g(dVar, this.$base));
        }
    }

    /* JADX INFO: renamed from: vn.f$f, reason: collision with other inner class name */
    public static final class C0458f implements eq.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l f17601a;

        public C0458f(jn.l lVar) {
            this.f17601a = lVar;
        }

        @Override // eq.b.d
        public final /* synthetic */ Iterable a(Object obj) {
            return (Iterable) this.f17601a.invoke(obj);
        }
    }

    @l
    public static final Collection<un.i<?>> A(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionH = ((xn.h) dVar).f20338e.invoke().h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionH) {
            xn.f fVar = (xn.f) obj;
            if (Q(fVar) && (fVar instanceof un.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void B(un.d dVar) {
    }

    @l
    public static final <T> Collection<r<T, ?, ?>> C(@l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionH = ((xn.h) dVar).f20338e.invoke().h();
        ArrayList arrayList = new ArrayList();
        for (T t10 : collectionH) {
            xn.f fVar = (xn.f) t10;
            if (Q(fVar) && (fVar instanceof r)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void D(un.d dVar) {
    }

    @l
    public static final Collection<un.i<?>> E(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionH = ((xn.h) dVar).f20338e.invoke().h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionH) {
            xn.f fVar = (xn.f) obj;
            if (R(fVar) && (fVar instanceof un.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void F(un.d dVar) {
    }

    @l
    public static final <T> Collection<q<T, ?>> G(@l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionH = ((xn.h) dVar).f20338e.invoke().h();
        ArrayList arrayList = new ArrayList();
        for (T t10 : collectionH) {
            xn.f fVar = (xn.f) t10;
            if (R(fVar) && (fVar instanceof q)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void H(un.d dVar) {
    }

    @m
    public static final <T> un.i<T> I(@l un.d<T> dVar) {
        T next;
        l0.p(dVar, "<this>");
        Iterator<T> it = ((xn.h) dVar).g().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((eo.l) ((k) ((un.i) next)).L()).b0()) {
                return (un.i) next;
            }
        }
        next = null;
        return (un.i) next;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void J(un.d dVar) {
    }

    @l
    public static final Collection<un.i<?>> K(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionI = ((xn.h) dVar).f20338e.invoke().i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionI) {
            if (obj instanceof un.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void L(un.d dVar) {
    }

    @l
    public static final Collection<p<?>> M(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionI = ((xn.h) dVar).f20338e.invoke().i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionI) {
            xn.f fVar = (xn.f) obj;
            if (R(fVar) && (fVar instanceof p)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void N(un.d dVar) {
    }

    @l
    public static final List<un.d<?>> O(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        List<s> listA = dVar.a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            un.g gVarI = ((s) it.next()).i();
            un.d dVar2 = gVarI instanceof un.d ? (un.d) gVarI : null;
            if (dVar2 != null) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void P(un.d dVar) {
    }

    public static final boolean Q(xn.f<?> fVar) {
        return fVar.L().R() != null;
    }

    public static final boolean R(xn.f<?> fVar) {
        return !Q(fVar);
    }

    @f1(version = "1.1")
    public static final boolean S(@l un.d<?> dVar, @l un.d<?> dVar2) {
        l0.p(dVar, "<this>");
        l0.p(dVar2, "base");
        if (!l0.g(dVar, dVar2)) {
            Boolean boolE = eq.b.e(x.k(dVar), new C0458f(new kn.f1() { // from class: vn.f.d
                @Override // un.q
                @m
                public Object get(@m Object obj) {
                    return f.O((un.d) obj);
                }

                @Override // kn.q, un.c
                @l
                public String getName() {
                    return "superclasses";
                }

                @Override // kn.q
                @l
                public un.h getOwner() {
                    return l1.h(f.class, "kotlin-reflection");
                }

                @Override // kn.q
                @l
                public String getSignature() {
                    return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
                }
            }), new e(dVar2));
            l0.o(boolE, "base: KClass<*>): Boolea…erclasses) { it == base }");
            if (!boolE.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.1")
    public static final boolean T(@l un.d<?> dVar, @l un.d<?> dVar2) {
        l0.p(dVar, "<this>");
        l0.p(dVar2, "derived");
        return S(dVar2, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @f1(version = "1.1")
    public static final <T> T U(@l un.d<T> dVar, @m Object obj) {
        l0.p(dVar, "<this>");
        if (!dVar.r(obj)) {
            return null;
        }
        if (obj != 0) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.1")
    @l
    public static final <T> T a(@l un.d<T> dVar, @m Object obj) {
        l0.p(dVar, "<this>");
        if (!dVar.r(obj)) {
            throw new r1(l0.C("Value cannot be cast to ", dVar.v()));
        }
        if (obj != 0) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
    }

    @f1(version = "1.1")
    @l
    public static final <T> T b(@l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Iterator<T> it = dVar.g().iterator();
        T t10 = null;
        boolean z10 = false;
        T t11 = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z10) {
                    break;
                }
                t10 = t11;
                break;
            }
            T next = it.next();
            List<n> parameters = ((un.i) next).getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator<T> it2 = parameters.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((n) it2.next()).z()) {
                        }
                    }
                }
            }
            if (z10) {
                break;
            }
            z10 = true;
            t11 = next;
        }
        un.i iVar = (un.i) t10;
        if (iVar != null) {
            return (T) iVar.callBy(d1.z());
        }
        throw new IllegalArgumentException(l0.C("Class should have a single no-arg constructor: ", dVar));
    }

    @l
    public static final Collection<un.d<?>> c(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<s> collectionE = e(dVar);
        ArrayList arrayList = new ArrayList(z.b0(collectionE, 10));
        for (s sVar : collectionE) {
            un.g gVarI = sVar.i();
            un.d dVar2 = gVarI instanceof un.d ? (un.d) gVarI : null;
            if (dVar2 == null) {
                throw new y(l0.C("Supertype not a class: ", sVar));
            }
            arrayList.add(dVar2);
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void d(un.d dVar) {
    }

    @l
    public static final Collection<s> e(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Object objC = eq.b.c(dVar.a(), a.f17600a, new eq.b.h(), new b());
        l0.o(objC, "dfs(\n        supertypes,…        }\n        }\n    )");
        return (Collection) objC;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void f(un.d dVar) {
    }

    @m
    public static final un.d<?> g(@l un.d<?> dVar) {
        Object next;
        l0.p(dVar, "<this>");
        Iterator<T> it = dVar.e().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((xn.h) ((un.d) next)).y().a0()) {
                return (un.d) next;
            }
        }
        next = null;
        return (un.d) next;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void h(un.d dVar) {
    }

    @m
    public static final Object i(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        un.d<?> dVarG = g(dVar);
        if (dVarG == null) {
            return null;
        }
        return dVarG.h();
    }

    @f1(version = "1.1")
    public static /* synthetic */ void j(un.d dVar) {
    }

    @l
    public static final Collection<un.i<?>> k(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionL = ((xn.h) dVar).f20338e.invoke().l();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionL) {
            if (obj instanceof un.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void l(un.d dVar) {
    }

    @l
    public static final Collection<un.i<?>> m(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionM = ((xn.h) dVar).f20338e.invoke().m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionM) {
            xn.f fVar = (xn.f) obj;
            if (Q(fVar) && (fVar instanceof un.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void n(un.d dVar) {
    }

    @l
    public static final <T> Collection<r<T, ?, ?>> o(@l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionM = ((xn.h) dVar).f20338e.invoke().m();
        ArrayList arrayList = new ArrayList();
        for (T t10 : collectionM) {
            xn.f fVar = (xn.f) t10;
            if (Q(fVar) && (fVar instanceof r)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void p(un.d dVar) {
    }

    @l
    public static final Collection<un.i<?>> q(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionM = ((xn.h) dVar).f20338e.invoke().m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionM) {
            xn.f fVar = (xn.f) obj;
            if (R(fVar) && (fVar instanceof un.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void r(un.d dVar) {
    }

    @l
    public static final <T> Collection<q<T, ?>> s(@l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Collection<xn.f<?>> collectionM = ((xn.h) dVar).f20338e.invoke().m();
        ArrayList arrayList = new ArrayList();
        for (T t10 : collectionM) {
            xn.f fVar = (xn.f) t10;
            if (R(fVar) && (fVar instanceof q)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void t(un.d dVar) {
    }

    @l
    public static final Collection<un.c<?>> u(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        return ((xn.h) dVar).f20338e.invoke().l();
    }

    @f1(version = "1.1")
    public static /* synthetic */ void v(un.d dVar) {
    }

    @l
    public static final s w(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        vp.n0 n0VarQ = ((xn.h) dVar).y().q();
        l0.o(n0VarQ, "this as KClassImpl<*>).descriptor.defaultType");
        return new v(n0VarQ, new c(dVar));
    }

    @f1(version = "1.1")
    @lm.k(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    public static /* synthetic */ void x(un.d dVar) {
    }

    @l
    public static final Collection<un.i<?>> y(@l un.d<?> dVar) {
        l0.p(dVar, "<this>");
        Collection<un.c<?>> collectionD = dVar.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionD) {
            if (obj instanceof un.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void z(un.d dVar) {
    }
}
