package tj;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f15685a = k1.c(l1.START, "start of file", "");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k1 f15686b = k1.c(l1.END, "end of file", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k1 f15687c = k1.c(l1.COMMA, "','", ks.g.f9491d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k1 f15688d = k1.c(l1.EQUALS, "'='", "=");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k1 f15689e = k1.c(l1.COLON, "':'", ":");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k1 f15690f = k1.c(l1.OPEN_CURLY, "'{'", "{");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k1 f15691g = k1.c(l1.CLOSE_CURLY, "'}'", "}");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k1 f15692h = k1.c(l1.OPEN_SQUARE, "'['", "[");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k1 f15693i = k1.c(l1.CLOSE_SQUARE, "']'", "]");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k1 f15694j = k1.c(l1.PLUS_EQUALS, "'+='", "+=");

    public static abstract class a extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f15695e;

        /* JADX INFO: renamed from: tj.n1$a$a, reason: collision with other inner class name */
        public static final class C0403a extends a {
            public C0403a(sj.o oVar, String str) {
                super(oVar, str);
            }

            @Override // tj.k1
            public String e() {
                return "//" + this.f15695e;
            }
        }

        public static final class b extends a {
            public b(sj.o oVar, String str) {
                super(oVar, str);
            }

            @Override // tj.k1
            public String e() {
                return "#" + this.f15695e;
            }
        }

        public a(sj.o oVar, String str) {
            super(l1.COMMENT, oVar, null, null);
            this.f15695e = str;
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof a;
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            return super.equals(obj) && ((a) obj).f15695e.equals(this.f15695e);
        }

        public String h() {
            return this.f15695e;
        }

        @Override // tj.k1
        public int hashCode() {
            return s0.b.a(this.f15695e, (this.f15641a.hashCode() + 41) * 41, 41);
        }

        @Override // tj.k1
        public String toString() {
            return j.c.a(new StringBuilder("'#"), this.f15695e, "' (COMMENT)");
        }
    }

    public static class b extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f15696e;

        public b(sj.o oVar, String str) {
            super(l1.IGNORED_WHITESPACE, oVar, null, null);
            this.f15696e = str;
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof b;
        }

        @Override // tj.k1
        public String e() {
            return this.f15696e;
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            return super.equals(obj) && ((b) obj).f15696e.equals(this.f15696e);
        }

        @Override // tj.k1
        public int hashCode() {
            return this.f15696e.hashCode() + ((this.f15641a.hashCode() + 41) * 41);
        }

        @Override // tj.k1
        public String toString() {
            return j.c.a(new StringBuilder("'"), this.f15696e, "' (WHITESPACE)");
        }
    }

    public static class c extends k1 {
        public c(sj.o oVar) {
            super(l1.NEWLINE, oVar, null, null);
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof c;
        }

        @Override // tj.k1
        public String e() {
            return "\n";
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            return super.equals(obj) && ((c) obj).b() == b();
        }

        @Override // tj.k1
        public int hashCode() {
            return b() + ((this.f15641a.hashCode() + 41) * 41);
        }

        @Override // tj.k1
        public String toString() {
            return "'\\n'@" + b();
        }
    }

    public static class d extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f15697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f15698f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f15699g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Throwable f15700h;

        public d(sj.o oVar, String str, String str2, boolean z10, Throwable th2) {
            super(l1.PROBLEM, oVar, null, null);
            this.f15697e = str;
            this.f15698f = str2;
            this.f15699g = z10;
            this.f15700h = th2;
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof d;
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                d dVar = (d) obj;
                if (dVar.f15697e.equals(this.f15697e) && dVar.f15698f.equals(this.f15698f) && dVar.f15699g == this.f15699g && n.b(dVar.f15700h, this.f15700h)) {
                    return true;
                }
            }
            return false;
        }

        public Throwable g() {
            return this.f15700h;
        }

        public String h() {
            return this.f15698f;
        }

        @Override // tj.k1
        public int hashCode() {
            int iHashCode = (Boolean.valueOf(this.f15699g).hashCode() + s0.b.a(this.f15698f, s0.b.a(this.f15697e, (this.f15641a.hashCode() + 41) * 41, 41), 41)) * 41;
            Throwable th2 = this.f15700h;
            return th2 != null ? (th2.hashCode() + iHashCode) * 41 : iHashCode;
        }

        public boolean i() {
            return this.f15699g;
        }

        public String j() {
            return this.f15697e;
        }

        @Override // tj.k1
        public String toString() {
            StringBuilder sb2 = new StringBuilder("'");
            sb2.append(this.f15697e);
            sb2.append("' (");
            return j.c.a(sb2, this.f15698f, ")");
        }
    }

    public static class e extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f15701e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<k1> f15702f;

        public e(sj.o oVar, boolean z10, List<k1> list) {
            super(l1.SUBSTITUTION, oVar, null, null);
            this.f15701e = z10;
            this.f15702f = list;
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof e;
        }

        @Override // tj.k1
        public String e() {
            StringBuilder sb2 = new StringBuilder("${");
            sb2.append(this.f15701e ? "?" : "");
            sb2.append(m1.c(this.f15702f.iterator()));
            sb2.append("}");
            return sb2.toString();
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            return super.equals(obj) && ((e) obj).f15702f.equals(this.f15702f);
        }

        public boolean g() {
            return this.f15701e;
        }

        public List<k1> h() {
            return this.f15702f;
        }

        @Override // tj.k1
        public int hashCode() {
            return this.f15702f.hashCode() + ((this.f15641a.hashCode() + 41) * 41);
        }

        @Override // tj.k1
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Iterator<k1> it = this.f15702f.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().toString());
            }
            return "'${" + sb2.toString() + "}'";
        }
    }

    public static class f extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f15703e;

        public f(sj.o oVar, String str) {
            super(l1.UNQUOTED_TEXT, oVar, null, null);
            this.f15703e = str;
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof f;
        }

        @Override // tj.k1
        public String e() {
            return this.f15703e;
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            return super.equals(obj) && ((f) obj).f15703e.equals(this.f15703e);
        }

        public String g() {
            return this.f15703e;
        }

        @Override // tj.k1
        public int hashCode() {
            return this.f15703e.hashCode() + ((this.f15641a.hashCode() + 41) * 41);
        }

        @Override // tj.k1
        public String toString() {
            return j.c.a(new StringBuilder("'"), this.f15703e, "'");
        }
    }

    public static class g extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final tj.d f15704e;

        public g(tj.d dVar) {
            this(dVar, null);
        }

        @Override // tj.k1
        public boolean a(Object obj) {
            return obj instanceof g;
        }

        @Override // tj.k1
        public boolean equals(Object obj) {
            return super.equals(obj) && ((g) obj).f15704e.equals(this.f15704e);
        }

        public tj.d g() {
            return this.f15704e;
        }

        @Override // tj.k1
        public int hashCode() {
            return this.f15704e.hashCode() + ((this.f15641a.hashCode() + 41) * 41);
        }

        @Override // tj.k1
        public String toString() {
            if (g().resolveStatus() != y0.RESOLVED) {
                return "'<unresolved value>' (" + this.f15704e.valueType().name() + ")";
            }
            return "'" + g().unwrapped() + "' (" + this.f15704e.valueType().name() + ")";
        }

        public g(tj.d dVar, String str) {
            super(l1.VALUE, dVar.origin(), str, null);
            this.f15704e = dVar;
        }
    }

    public static k1 A(sj.o oVar, String str, String str2, boolean z10, Throwable th2) {
        return new d(oVar, str, str2, z10, th2);
    }

    public static k1 B(sj.o oVar, String str, String str2) {
        return new g(new g0.a(oVar, str), str2);
    }

    public static k1 C(sj.o oVar, boolean z10, List<k1> list) {
        return new e(oVar, z10, list);
    }

    public static k1 D(sj.o oVar, String str) {
        return new f(oVar, str);
    }

    public static k1 E(tj.d dVar) {
        return new g(dVar, null);
    }

    public static k1 F(tj.d dVar, String str) {
        return new g(dVar, str);
    }

    public static String a(k1 k1Var) {
        if (k1Var instanceof a) {
            return ((a) k1Var).h();
        }
        throw new sj.c.d("tried to get comment text from " + k1Var);
    }

    public static Throwable b(k1 k1Var) {
        if (k1Var instanceof d) {
            return ((d) k1Var).g();
        }
        throw new sj.c.d("tried to get problem cause from " + k1Var);
    }

    public static String c(k1 k1Var) {
        if (k1Var instanceof d) {
            return ((d) k1Var).h();
        }
        throw new sj.c.d("tried to get problem message from " + k1Var);
    }

    public static boolean d(k1 k1Var) {
        if (k1Var instanceof d) {
            return ((d) k1Var).i();
        }
        throw new sj.c.d("tried to get problem suggestQuotes from " + k1Var);
    }

    public static String e(k1 k1Var) {
        if (k1Var instanceof d) {
            return ((d) k1Var).j();
        }
        throw new sj.c.d("tried to get problem what from " + k1Var);
    }

    public static boolean f(k1 k1Var) {
        if (k1Var instanceof e) {
            return ((e) k1Var).g();
        }
        throw new sj.c.d("tried to get substitution optionality from " + k1Var);
    }

    public static List<k1> g(k1 k1Var) {
        if (k1Var instanceof e) {
            return ((e) k1Var).h();
        }
        throw new sj.c.d("tried to get substitution from " + k1Var);
    }

    public static String h(k1 k1Var) {
        if (k1Var instanceof f) {
            return ((f) k1Var).g();
        }
        throw new sj.c.d("tried to get unquoted text from " + k1Var);
    }

    public static tj.d i(k1 k1Var) {
        if (k1Var instanceof g) {
            return ((g) k1Var).g();
        }
        throw new sj.c.d("tried to get value of non-value token " + k1Var);
    }

    public static boolean j(k1 k1Var) {
        return k1Var instanceof a;
    }

    public static boolean k(k1 k1Var) {
        return k1Var instanceof b;
    }

    public static boolean l(k1 k1Var) {
        return k1Var instanceof c;
    }

    public static boolean m(k1 k1Var) {
        return k1Var instanceof d;
    }

    public static boolean n(k1 k1Var) {
        return k1Var instanceof e;
    }

    public static boolean o(k1 k1Var) {
        return k1Var instanceof f;
    }

    public static boolean p(k1 k1Var) {
        return k1Var instanceof g;
    }

    public static boolean q(k1 k1Var, sj.z zVar) {
        return (k1Var instanceof g) && i(k1Var).valueType() == zVar;
    }

    public static k1 r(sj.o oVar, boolean z10) {
        return new g(new tj.g(oVar, z10), "" + z10);
    }

    public static k1 s(sj.o oVar, String str) {
        return new a.C0403a(oVar, str);
    }

    public static k1 t(sj.o oVar, String str) {
        return new a.b(oVar, str);
    }

    public static k1 u(sj.o oVar, double d10, String str) {
        return new g(d0.newNumber(oVar, d10, str), str);
    }

    public static k1 v(sj.o oVar, String str) {
        return new b(oVar, str);
    }

    public static k1 w(sj.o oVar, int i10, String str) {
        return new g(d0.newNumber(oVar, i10, str), str);
    }

    public static k1 x(sj.o oVar) {
        return new c(oVar);
    }

    public static k1 y(sj.o oVar, long j10, String str) {
        return new g(d0.newNumber(oVar, j10, str), str);
    }

    public static k1 z(sj.o oVar) {
        return new g(new c0(oVar), d6.a.E);
    }
}
