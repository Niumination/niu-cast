package ik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Double.valueOf(((x) t11).f8202c), Double.valueOf(((x) t10).f8202c));
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f8045a;

        public b(Comparator comparator) {
            this.f8045a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f8045a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            i.c cVar = i.f7981f;
            i iVarB = cVar.b(((x) t10).f8200a);
            int i10 = kn.l0.g(iVarB.f7983d, "*") ? 2 : 0;
            if (kn.l0.g(iVarB.f7984e, "*")) {
                i10++;
            }
            Integer numValueOf = Integer.valueOf(i10);
            i iVarB2 = cVar.b(((x) t11).f8200a);
            int i11 = kn.l0.g(iVarB2.f7983d, "*") ? 2 : 0;
            if (kn.l0.g(iVarB2.f7984e, "*")) {
                i11++;
            }
            return rm.g.l(numValueOf, Integer.valueOf(i11));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f8046a;

        public c(Comparator comparator) {
            this.f8046a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f8046a.compare(t10, t11);
            return iCompare != 0 ? iCompare : rm.g.l(Integer.valueOf(((x) t11).f8201b.size()), Integer.valueOf(((x) t10).f8201b.size()));
        }
    }

    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Double.valueOf(((x) t11).f8202c), Double.valueOf(((x) t10).f8202c));
        }
    }

    public static final class e extends kn.n0 implements jn.a<ArrayList<x>> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final ArrayList<x> invoke() {
            return new ArrayList<>();
        }
    }

    public static final class f extends kn.n0 implements jn.a<ArrayList<y>> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final ArrayList<y> invoke() {
            return new ArrayList<>();
        }
    }

    public static final boolean a(String str, int i10) {
        int i11 = i10 + 1;
        while (i11 < str.length() && str.charAt(i11) == ' ') {
            i11++;
        }
        return i11 == str.length() || str.charAt(i11) == ';';
    }

    @os.l
    public static final List<x> b(@os.m String str) {
        return nm.h0.u5(e(str, false), new c(new b(new a())));
    }

    @os.l
    public static final List<x> c(@os.m String str) {
        return nm.h0.u5(e(str, false), new d());
    }

    @os.l
    public static final List<x> d(@os.m String str) {
        return e(str, false);
    }

    @os.l
    public static final List<x> e(@os.m String str, boolean z10) {
        if (str == null) {
            return nm.k0.INSTANCE;
        }
        lm.d0 d0VarC = lm.f0.c(lm.h0.NONE, e.INSTANCE);
        int iF = 0;
        while (iF <= jq.h0.g3(str)) {
            iF = f(str, iF, d0VarC, z10);
        }
        return m(d0VarC);
    }

    public static final int f(String str, int i10, lm.d0<? extends ArrayList<x>> d0Var, boolean z10) {
        lm.d0 d0VarC = lm.f0.c(lm.h0.NONE, f.INSTANCE);
        Integer numValueOf = z10 ? Integer.valueOf(i10) : null;
        int iG = i10;
        while (iG <= jq.h0.g3(str)) {
            char cCharAt = str.charAt(iG);
            if (cCharAt == ',') {
                d0Var.getValue().add(new x(k(str, i10, numValueOf == null ? iG : numValueOf.intValue()), m(d0VarC)));
                return iG + 1;
            }
            if (cCharAt == ';') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(iG);
                }
                iG = g(str, iG + 1, d0VarC);
            } else {
                iG = z10 ? g(str, iG, d0VarC) : iG + 1;
            }
        }
        d0Var.getValue().add(new x(k(str, i10, numValueOf == null ? iG : numValueOf.intValue()), m(d0VarC)));
        return iG;
    }

    public static final int g(String str, int i10, lm.d0<? extends ArrayList<y>> d0Var) {
        int i11 = i10;
        while (i11 <= jq.h0.g3(str)) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '=') {
                lm.t0<Integer, String> t0VarI = i(str, i11 + 1);
                int iIntValue = t0VarI.component1().intValue();
                h(d0Var, str, i10, i11, t0VarI.component2());
                return iIntValue;
            }
            if (cCharAt == ';' || cCharAt == ',') {
                h(d0Var, str, i10, i11, "");
                return i11;
            }
            i11++;
        }
        h(d0Var, str, i10, i11, "");
        return i11;
    }

    public static final void h(lm.d0<? extends ArrayList<y>> d0Var, String str, int i10, int i11, String str2) {
        String strK = k(str, i10, i11);
        if (strK.length() == 0) {
            return;
        }
        d0Var.getValue().add(new y(strK, str2));
    }

    public static final lm.t0<Integer, String> i(String str, int i10) {
        if (str.length() == i10) {
            return new lm.t0<>(Integer.valueOf(i10), "");
        }
        if (str.charAt(i10) == '\"') {
            return j(str, i10 + 1);
        }
        int i11 = i10;
        while (i11 <= jq.h0.g3(str)) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == ';' || cCharAt == ',') {
                return new lm.t0<>(Integer.valueOf(i11), k(str, i10, i11));
            }
            i11++;
        }
        return new lm.t0<>(Integer.valueOf(i11), k(str, i10, i11));
    }

    public static final lm.t0<Integer, String> j(String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        while (i10 <= jq.h0.g3(str)) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"' && a(str, i10)) {
                Integer numValueOf = Integer.valueOf(i10 + 1);
                String string = sb2.toString();
                kn.l0.o(string, "builder.toString()");
                return new lm.t0<>(numValueOf, string);
            }
            if (cCharAt != '\\' || i10 >= jq.h0.g3(str) - 2) {
                sb2.append(cCharAt);
                i10++;
            } else {
                sb2.append(str.charAt(i10 + 1));
                i10 += 2;
            }
        }
        Integer numValueOf2 = Integer.valueOf(i10);
        String string2 = sb2.toString();
        kn.l0.o(string2, "builder.toString()");
        return new lm.t0<>(numValueOf2, "\"" + string2);
    }

    public static final String k(String str, int i10, int i11) {
        String strSubstring = str.substring(i10, i11);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return jq.h0.C5(strSubstring).toString();
    }

    @os.l
    public static final List<y> l(@os.l Iterable<lm.t0<String, String>> iterable) {
        kn.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable, 10));
        for (lm.t0<String, String> t0Var : iterable) {
            arrayList.add(new y(t0Var.getFirst(), t0Var.getSecond()));
        }
        return arrayList;
    }

    public static final <T> List<T> m(lm.d0<? extends List<? extends T>> d0Var) {
        return d0Var.isInitialized() ? d0Var.getValue() : nm.k0.INSTANCE;
    }
}
