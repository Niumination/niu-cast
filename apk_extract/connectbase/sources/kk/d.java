package kk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.w;
import lm.t0;
import nm.h0;
import nm.k0;
import nm.y;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final c f9204e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final d f9205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final d f9206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final d f9207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final lk.a<t0<String, d>> f9208i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<String> f9212d;

    public static final class a extends n0 implements jn.l<t0<? extends String, ? extends d>, Integer> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Integer invoke(t0<? extends String, ? extends d> t0Var) {
            return invoke2((t0<String, d>) t0Var);
        }

        @os.l
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Integer invoke2(@os.l t0<String, d> t0Var) {
            l0.p(t0Var, "it");
            return Integer.valueOf(t0Var.getFirst().length());
        }
    }

    public static final class b extends n0 implements jn.p<t0<? extends String, ? extends d>, Integer, Character> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Character invoke(t0<? extends String, ? extends d> t0Var, Integer num) {
            return invoke((t0<String, d>) t0Var, num.intValue());
        }

        @os.l
        public final Character invoke(@os.l t0<String, d> t0Var, int i10) {
            l0.p(t0Var, "t");
            return Character.valueOf(t0Var.getFirst().charAt(i10));
        }
    }

    public static final class c {

        public static final class a extends n0 implements jn.p<Character, Integer, Boolean> {
            public static final a INSTANCE = new a();

            public a() {
                super(2);
            }

            @os.l
            public final Boolean invoke(char c10, int i10) {
                return Boolean.FALSE;
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Boolean invoke(Character ch2, Integer num) {
                return invoke(ch2.charValue(), num.intValue());
            }
        }

        public static final class b extends n0 implements jn.p<Character, Integer, Boolean> {
            public static final b INSTANCE = new b();

            public b() {
                super(2);
            }

            @os.l
            public final Boolean invoke(char c10, int i10) {
                return Boolean.FALSE;
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Boolean invoke(Character ch2, Integer num) {
                return invoke(ch2.charValue(), num.intValue());
            }
        }

        public c() {
        }

        @os.l
        public final d a() {
            return d.f9205f;
        }

        @os.l
        public final d b() {
            return d.f9206g;
        }

        @os.l
        public final d c() {
            return d.f9207h;
        }

        @os.m
        public final d d(@os.m CharSequence charSequence) {
            if (charSequence == null) {
                return null;
            }
            List listC = lk.a.c(d.f9208i, charSequence, 0, 0, true, a.INSTANCE, 6, null);
            return listC.size() == 1 ? (d) ((t0) listC.get(0)).getSecond() : e(charSequence);
        }

        public final d e(CharSequence charSequence) {
            int length = charSequence.length();
            d dVar = null;
            int i10 = 0;
            int i11 = 0;
            ArrayList arrayList = null;
            while (i10 < length) {
                do {
                    char cCharAt = charSequence.charAt(i10);
                    if (cCharAt != ' ' && cCharAt != ',') {
                        i11 = i10;
                        break;
                    }
                    i10++;
                } while (i10 < length);
                while (i10 < length) {
                    char cCharAt2 = charSequence.charAt(i10);
                    if (cCharAt2 == ' ' || cCharAt2 == ',') {
                        break;
                    }
                    i10++;
                }
                t0 t0Var = (t0) h0.k5(d.f9208i.b(charSequence, i11, i10, true, b.INSTANCE));
                if (t0Var == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(charSequence.subSequence(i11, i10).toString());
                } else if (dVar == null) {
                    dVar = (d) t0Var.getSecond();
                } else {
                    boolean z10 = true;
                    boolean z11 = dVar.f9209a || ((d) t0Var.getSecond()).f9209a;
                    boolean z12 = dVar.f9210b || ((d) t0Var.getSecond()).f9210b;
                    if (!dVar.f9211c && !((d) t0Var.getSecond()).f9211c) {
                        z10 = false;
                    }
                    dVar = new d(z11, z12, z10, k0.INSTANCE);
                }
            }
            if (dVar == null) {
                dVar = d.f9206g;
            }
            return arrayList == null ? dVar : new d(dVar.f9209a, dVar.f9210b, dVar.f9211c, arrayList);
        }

        public c(w wVar) {
        }
    }

    static {
        d dVar = new d(true, false, false, null, 14, null);
        f9205f = dVar;
        d dVar2 = new d(false, true, false, null, 13, null);
        f9206g = dVar2;
        d dVar3 = new d(false, false, true, null, 11, null);
        f9207h = dVar3;
        f9208i = lk.a.f10100b.b(y.O(new t0("close", dVar), new t0("keep-alive", dVar2), new t0("upgrade", dVar3)), a.INSTANCE, b.INSTANCE);
    }

    public d() {
        this(false, false, false, null, 15, null);
    }

    public final String e() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList(this.f9212d.size() + 3);
        if (this.f9209a) {
            arrayList.add("close");
        }
        if (this.f9210b) {
            arrayList.add("keep-alive");
        }
        if (this.f9211c) {
            arrayList.add("Upgrade");
        }
        if (!this.f9212d.isEmpty()) {
            arrayList.addAll(this.f9212d);
        }
        h0.j3(arrayList, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : null, (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null);
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (l0.g(l1.d(d.class), l1.f9319a.d(obj.getClass()))) {
                d dVar = (d) obj;
                return this.f9209a == dVar.f9209a && this.f9210b == dVar.f9210b && this.f9211c == dVar.f9211c && l0.g(this.f9212d, dVar.f9212d);
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f9209a;
    }

    @os.l
    public final List<String> g() {
        return this.f9212d;
    }

    public final boolean h() {
        return this.f9210b;
    }

    public int hashCode() {
        return this.f9212d.hashCode() + ((Boolean.hashCode(this.f9211c) + ((Boolean.hashCode(this.f9210b) + (Boolean.hashCode(this.f9209a) * 31)) * 31)) * 31);
    }

    public final boolean i() {
        return this.f9211c;
    }

    @os.l
    public String toString() {
        if (!this.f9212d.isEmpty()) {
            return e();
        }
        boolean z10 = this.f9209a;
        if (z10 && !this.f9210b && !this.f9211c) {
            return "close";
        }
        if (z10 || !this.f9210b || this.f9211c) {
            return (!z10 && this.f9210b && this.f9211c) ? "keep-alive, Upgrade" : e();
        }
        return "keep-alive";
    }

    public d(boolean z10, boolean z11, boolean z12, @os.l List<String> list) {
        l0.p(list, "extraOptions");
        this.f9209a = z10;
        this.f9210b = z11;
        this.f9211c = z12;
        this.f9212d = list;
    }

    public d(boolean z10, boolean z11, boolean z12, List list, int i10, w wVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? k0.INSTANCE : list);
    }
}
