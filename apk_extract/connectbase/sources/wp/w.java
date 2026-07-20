package wp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.g0;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.h0;
import nm.z;
import vp.c0;
import vp.e0;
import vp.f0;
import vp.n1;
import vp.q0;
import vp.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final w f19879a = new w();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a START = new c("START", 0);
        public static final a ACCEPT_NULL = new C0494a("ACCEPT_NULL", 1);
        public static final a UNKNOWN = new d("UNKNOWN", 2);
        public static final a NOT_NULL = new b("NOT_NULL", 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a[] f19880a = a();

        /* JADX INFO: renamed from: wp.w$a$a, reason: collision with other inner class name */
        public static final class C0494a extends a {
            public C0494a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // wp.w.a
            @os.l
            public a combine(@os.l n1 n1Var) {
                l0.p(n1Var, "nextType");
                return getResultNullability(n1Var);
            }
        }

        public static final class b extends a {
            public b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // wp.w.a
            @os.l
            public b combine(@os.l n1 n1Var) {
                l0.p(n1Var, "nextType");
                return this;
            }
        }

        public static final class c extends a {
            public c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // wp.w.a
            @os.l
            public a combine(@os.l n1 n1Var) {
                l0.p(n1Var, "nextType");
                return getResultNullability(n1Var);
            }
        }

        public static final class d extends a {
            public d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // wp.w.a
            @os.l
            public a combine(@os.l n1 n1Var) {
                l0.p(n1Var, "nextType");
                a resultNullability = getResultNullability(n1Var);
                return resultNullability == a.ACCEPT_NULL ? this : resultNullability;
            }
        }

        public a(String str, int i10) {
            super(str, i10);
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f19880a.clone();
        }

        @os.l
        public abstract a combine(@os.l n1 n1Var);

        @os.l
        public final a getResultNullability(@os.l n1 n1Var) {
            l0.p(n1Var, "<this>");
            if (n1Var.H0()) {
                return ACCEPT_NULL;
            }
            if ((n1Var instanceof vp.o) && (((vp.o) n1Var).f17724b instanceof u0)) {
                return NOT_NULL;
            }
            if (!(n1Var instanceof u0) && o.f19872a.a(n1Var)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }

        public a(String str, int i10, kn.w wVar) {
            super(str, i10);
        }
    }

    public static final class b extends n0 implements jn.a<String> {
        final /* synthetic */ Set<vp.n0> $inputTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends vp.n0> set) {
            super(0);
            this.$inputTypes = set;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return l0.C("This collections cannot be empty! input types: ", h0.m3(this.$inputTypes, null, null, null, 0, null, null, 63, null));
        }
    }

    public /* synthetic */ class c extends g0 implements jn.p<f0, f0, Boolean> {
        public c(Object obj) {
            super(2, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(w.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l f0 f0Var, @os.l f0 f0Var2) {
            l0.p(f0Var, "p0");
            l0.p(f0Var2, "p1");
            return Boolean.valueOf(((w) this.receiver).e(f0Var, f0Var2));
        }
    }

    public /* synthetic */ class d extends g0 implements jn.p<f0, f0, Boolean> {
        public d(Object obj) {
            super(2, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "equalTypes";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(m.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l f0 f0Var, @os.l f0 f0Var2) {
            l0.p(f0Var, "p0");
            l0.p(f0Var2, "p1");
            return Boolean.valueOf(((m) this.receiver).b(f0Var, f0Var2));
        }
    }

    public final Collection<vp.n0> b(Collection<? extends vp.n0> collection, jn.p<? super vp.n0, ? super vp.n0, Boolean> pVar) {
        ArrayList<vp.n0> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        l0.o(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            vp.n0 n0Var = (vp.n0) it.next();
            if (!arrayList.isEmpty()) {
                for (vp.n0 n0Var2 : arrayList) {
                    if (n0Var2 != n0Var) {
                        l0.o(n0Var2, "lower");
                        l0.o(n0Var, "upper");
                        if (pVar.invoke(n0Var2, n0Var).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @os.l
    public final vp.n0 c(@os.l List<? extends vp.n0> list) {
        l0.p(list, "types");
        list.size();
        ArrayList<vp.n0> arrayList = new ArrayList();
        for (vp.n0 n0Var : list) {
            if (n0Var.G0() instanceof e0) {
                Collection<f0> collectionA = n0Var.G0().a();
                l0.o(collectionA, "type.constructor.supertypes");
                Collection<f0> collection = collectionA;
                ArrayList arrayList2 = new ArrayList(z.b0(collection, 10));
                for (f0 f0Var : collection) {
                    l0.o(f0Var, "it");
                    vp.n0 n0VarD = c0.d(f0Var);
                    if (n0Var.H0()) {
                        n0VarD = n0VarD.N0(true);
                    }
                    arrayList2.add(n0VarD);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(n0Var);
            }
        }
        a aVarCombine = a.START;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarCombine = aVarCombine.combine((n1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (vp.n0 n0VarI : arrayList) {
            if (aVarCombine == a.NOT_NULL) {
                if (n0VarI instanceof i) {
                    n0VarI = q0.k((i) n0VarI);
                }
                n0VarI = q0.i(n0VarI, false, 1, null);
            }
            linkedHashSet.add(n0VarI);
        }
        return d(linkedHashSet);
    }

    public final vp.n0 d(Set<? extends vp.n0> set) {
        if (set.size() == 1) {
            return (vp.n0) h0.f5(set);
        }
        new b(set);
        Collection<vp.n0> collectionB = b(set, new c(this));
        collectionB.isEmpty();
        vp.n0 n0VarB = jp.n.f8780f.b(collectionB);
        if (n0VarB != null) {
            return n0VarB;
        }
        l.f19866b.getClass();
        Collection<vp.n0> collectionB2 = b(collectionB, new d(l.a.f19868b));
        collectionB2.isEmpty();
        return collectionB2.size() < 2 ? (vp.n0) h0.f5(collectionB2) : new e0(set).g();
    }

    public final boolean e(f0 f0Var, f0 f0Var2) {
        l.f19866b.getClass();
        m mVar = l.a.f19868b;
        return mVar.c(f0Var, f0Var2) && !mVar.c(f0Var2, f0Var);
    }
}
