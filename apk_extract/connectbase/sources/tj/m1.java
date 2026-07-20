package tj;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 {

    public static class a extends Exception {
        private static final long serialVersionUID = 1;
        private final k1 problem;

        public a(k1 k1Var) {
            this.problem = k1Var;
        }

        public k1 problem() {
            return this.problem;
        }
    }

    public static class b implements Iterator<k1> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f15671n = "0123456789-";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f15672p = "0123456789eE+-.";

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final String f15673v = "$\"{}[]:=,+#`^?!@*&\\";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g1 f15674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reader f15675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedList<Integer> f15676c = new LinkedList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15677d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public sj.o f15678e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Queue<k1> f15679f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f15680g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f15681i;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public StringBuilder f15682a = new StringBuilder();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f15683b = false;

            public void a(int i10) {
                this.f15682a.appendCodePoint(i10);
            }

            public k1 b(k1 k1Var, sj.o oVar, int i10) {
                return b.d(k1Var) ? d(oVar, i10) : e(oVar, i10);
            }

            public final k1 c(sj.o oVar, int i10) {
                if (this.f15682a.length() <= 0) {
                    return null;
                }
                k1 k1VarD = this.f15683b ? n1.D(((g1) oVar).d(i10), this.f15682a.toString()) : n1.v(((g1) oVar).d(i10), this.f15682a.toString());
                this.f15682a.setLength(0);
                return k1VarD;
            }

            public final k1 d(sj.o oVar, int i10) {
                k1 k1VarC = c(oVar, i10);
                if (!this.f15683b) {
                    this.f15683b = true;
                }
                return k1VarC;
            }

            public final k1 e(sj.o oVar, int i10) {
                this.f15683b = false;
                return c(oVar, i10);
            }
        }

        public b(sj.o oVar, Reader reader, boolean z10) {
            g1 g1Var = (g1) oVar;
            this.f15674a = g1Var;
            this.f15675b = reader;
            this.f15681i = z10;
            this.f15678e = g1Var.d(1);
            LinkedList linkedList = new LinkedList();
            this.f15679f = linkedList;
            linkedList.add(n1.f15685a);
            this.f15680g = new a();
        }

        public static sj.o b(sj.o oVar, int i10) {
            return ((g1) oVar).d(i10);
        }

        public static boolean d(k1 k1Var) {
            return n1.n(k1Var) || (k1Var instanceof n1.f) || (k1Var instanceof n1.g);
        }

        public static boolean e(int i10) {
            return n.e(i10);
        }

        public static boolean f(int i10) {
            return i10 != 10 && n.e(i10);
        }

        public static sj.o g(sj.o oVar, int i10) {
            return ((g1) oVar).d(i10);
        }

        public static a p(sj.o oVar, String str) {
            return r(oVar, "", str, false, null);
        }

        public static a q(sj.o oVar, String str, String str2, Throwable th2) {
            return r(oVar, str, str2, false, th2);
        }

        public static a r(sj.o oVar, String str, String str2, boolean z10, Throwable th2) {
            if (str == null || str2 == null) {
                throw new sj.c.d("internal error, creating bad ProblemException");
            }
            return new a(n1.A(oVar, str, str2, z10, th2));
        }

        public final void A(int i10) {
            if (this.f15676c.size() > 2) {
                throw new sj.c.d("bug: putBack() three times, undesirable look-ahead");
            }
            this.f15676c.push(Integer.valueOf(i10));
        }

        public final void B() throws a {
            k1 k1VarU = u(this.f15680g);
            k1 k1VarB = this.f15680g.b(k1VarU, this.f15674a, this.f15677d);
            if (k1VarB != null) {
                this.f15679f.add(k1VarB);
            }
            this.f15679f.add(k1VarU);
        }

        public final boolean C(int i10) {
            if (i10 != -1 && this.f15681i) {
                if (i10 == 35) {
                    return true;
                }
                if (i10 == 47) {
                    int iJ = j();
                    A(iJ);
                    if (iJ == 47) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void c(StringBuilder sb2, StringBuilder sb3) throws a {
            int i10 = 0;
            while (true) {
                int iJ = j();
                if (iJ == 34) {
                    i10++;
                } else if (i10 >= 3) {
                    sb2.setLength(sb2.length() - 3);
                    A(iJ);
                    return;
                } else {
                    if (iJ == -1) {
                        throw k("End of input but triple-quoted string was still open");
                    }
                    if (iJ == 10) {
                        int i11 = this.f15677d + 1;
                        this.f15677d = i11;
                        this.f15678e = this.f15674a.d(i11);
                    }
                    i10 = 0;
                }
                sb2.appendCodePoint(iJ);
                sb3.appendCodePoint(iJ);
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public k1 next() {
            k1 k1VarRemove = this.f15679f.remove();
            if (this.f15679f.isEmpty() && k1VarRemove != n1.f15686b) {
                try {
                    B();
                } catch (a e10) {
                    this.f15679f.add(e10.problem());
                }
                if (this.f15679f.isEmpty()) {
                    throw new sj.c.d("bug: tokens queue should not be empty here");
                }
            }
            return k1VarRemove;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f15679f.isEmpty();
        }

        public final int i(a aVar) {
            while (true) {
                int iJ = j();
                if (iJ == -1) {
                    return -1;
                }
                if (!f(iJ)) {
                    return iJ;
                }
                aVar.a(iJ);
            }
        }

        public final int j() {
            if (!this.f15676c.isEmpty()) {
                return this.f15676c.pop().intValue();
            }
            try {
                return this.f15675b.read();
            } catch (IOException e10) {
                throw new sj.c.f(this.f15674a, "read error: " + e10.getMessage(), e10);
            }
        }

        public final a k(String str) {
            return m("", str, null);
        }

        public final a l(String str, String str2) {
            return m(str, str2, null);
        }

        public final a m(String str, String str2, Throwable th2) {
            return r(this.f15678e, str, str2, false, th2);
        }

        public final a n(String str, String str2, boolean z10) {
            return r(this.f15678e, str, str2, z10, null);
        }

        public final a o(String str, String str2, boolean z10, Throwable th2) {
            return r(this.f15678e, str, str2, z10, th2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Does not make sense to remove items from token stream");
        }

        public final k1 s(int i10) {
            boolean z10;
            int iJ;
            if (i10 != 47) {
                z10 = false;
            } else {
                if (j() != 47) {
                    throw new sj.c.d("called pullComment but // not seen");
                }
                z10 = true;
            }
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                iJ = j();
                if (iJ == -1 || iJ == 10) {
                    break;
                }
                sb2.appendCodePoint(iJ);
            }
            A(iJ);
            return z10 ? n1.s(this.f15678e, sb2.toString()) : n1.t(this.f15678e, sb2.toString());
        }

        public final void t(StringBuilder sb2, StringBuilder sb3) throws a {
            int iJ = j();
            if (iJ == -1) {
                throw k("End of input but backslash in string had nothing after it");
            }
            sb3.appendCodePoint(92);
            sb3.appendCodePoint(iJ);
            if (iJ == 34) {
                sb2.append('\"');
                return;
            }
            if (iJ == 47) {
                sb2.append(el.b0.f4502a);
                return;
            }
            if (iJ == 92) {
                sb2.append(rs.f.f14862d);
                return;
            }
            if (iJ == 98) {
                sb2.append('\b');
                return;
            }
            if (iJ == 102) {
                sb2.append('\f');
                return;
            }
            if (iJ == 110) {
                sb2.append('\n');
                return;
            }
            if (iJ == 114) {
                sb2.append(StringUtil.CARRIAGE_RETURN);
                return;
            }
            if (iJ == 116) {
                sb2.append('\t');
                return;
            }
            if (iJ != 117) {
                throw m(m1.b(iJ), String.format("backslash followed by '%s', this is not a valid escape sequence (quoted strings use JSON escaping, so use double-backslash \\\\ for literal backslash)", m1.b(iJ)), null);
            }
            char[] cArr = new char[4];
            for (int i10 = 0; i10 < 4; i10++) {
                int iJ2 = j();
                if (iJ2 == -1) {
                    throw k("End of input but expecting 4 hex digits for \\uXXXX escape");
                }
                cArr[i10] = (char) iJ2;
            }
            String str = new String(cArr);
            sb3.append(cArr);
            try {
                sb2.appendCodePoint(Integer.parseInt(str, 16));
            } catch (NumberFormatException e10) {
                throw m(str, String.format("Malformed hex digits after \\u escape in string: '%s'", str), e10);
            }
        }

        public final k1 u(a aVar) throws a {
            k1 k1VarX;
            k1 k1VarZ;
            int i10 = i(aVar);
            if (i10 == -1) {
                return n1.f15686b;
            }
            if (i10 == 10) {
                k1 k1VarX2 = n1.x(this.f15678e);
                int i11 = this.f15677d + 1;
                this.f15677d = i11;
                this.f15678e = this.f15674a.d(i11);
                return k1VarX2;
            }
            if (C(i10)) {
                k1VarZ = s(i10);
            } else {
                if (i10 == 34) {
                    k1VarX = x();
                } else if (i10 == 36) {
                    k1VarX = y();
                } else if (i10 == 58) {
                    k1VarX = n1.f15689e;
                } else if (i10 == 61) {
                    k1VarX = n1.f15688d;
                } else if (i10 == 91) {
                    k1VarX = n1.f15692h;
                } else if (i10 == 93) {
                    k1VarX = n1.f15693i;
                } else if (i10 == 123) {
                    k1VarX = n1.f15690f;
                } else if (i10 == 125) {
                    k1VarX = n1.f15691g;
                } else if (i10 != 43) {
                    k1VarX = i10 != 44 ? null : n1.f15687c;
                } else {
                    k1VarX = w();
                }
                if (k1VarX != null) {
                    k1VarZ = k1VarX;
                } else if (f15671n.indexOf(i10) >= 0) {
                    k1VarZ = v(i10);
                } else {
                    if (f15673v.indexOf(i10) >= 0) {
                        throw n(m1.b(i10), "Reserved character '" + m1.b(i10) + "' is not allowed outside quotes", true);
                    }
                    A(i10);
                    k1VarZ = z();
                }
            }
            if (k1VarZ != null) {
                return k1VarZ;
            }
            throw new sj.c.d("bug: failed to generate next token");
        }

        public final k1 v(int i10) throws a {
            StringBuilder sb2 = new StringBuilder();
            sb2.appendCodePoint(i10);
            int iJ = j();
            boolean z10 = false;
            while (iJ != -1 && f15672p.indexOf(iJ) >= 0) {
                if (iJ == 46 || iJ == 101 || iJ == 69) {
                    z10 = true;
                }
                sb2.appendCodePoint(iJ);
                iJ = j();
            }
            A(iJ);
            String string = sb2.toString();
            try {
                return z10 ? n1.u(this.f15678e, Double.parseDouble(string), string) : n1.y(this.f15678e, Long.parseLong(string), string);
            } catch (NumberFormatException unused) {
                for (char c10 : string.toCharArray()) {
                    if (f15673v.indexOf(c10) >= 0) {
                        throw n(m1.b(c10), "Reserved character '" + m1.b(c10) + "' is not allowed outside quotes", true);
                    }
                }
                return n1.D(this.f15678e, string);
            }
        }

        public final k1 w() throws a {
            int iJ = j();
            if (iJ == 61) {
                return n1.f15694j;
            }
            throw n(m1.b(iJ), "'+' not followed by =, '" + m1.b(iJ) + "' not allowed after '+'", true);
        }

        public final k1 x() throws a {
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            sb3.appendCodePoint(34);
            while (true) {
                int iJ = j();
                if (iJ == -1) {
                    throw k("End of input but string quote was still open");
                }
                if (iJ == 92) {
                    t(sb2, sb3);
                } else {
                    if (iJ == 34) {
                        sb3.appendCodePoint(iJ);
                        if (sb2.length() == 0) {
                            int iJ2 = j();
                            if (iJ2 == 34) {
                                sb3.appendCodePoint(iJ2);
                                c(sb2, sb3);
                            } else {
                                A(iJ2);
                            }
                        }
                        return n1.B(this.f15678e, sb2.toString(), sb3.toString());
                    }
                    if (n.d(iJ)) {
                        throw m(m1.b(iJ), "JSON does not allow unescaped " + m1.b(iJ) + " in quoted strings, use a backslash escape", null);
                    }
                    sb2.appendCodePoint(iJ);
                    sb3.appendCodePoint(iJ);
                }
            }
        }

        public final k1 y() throws a {
            sj.o oVar = this.f15678e;
            int iJ = j();
            boolean z10 = true;
            if (iJ != 123) {
                throw n(m1.b(iJ), "'$' not followed by {, '" + m1.b(iJ) + "' not allowed after '$'", true);
            }
            int iJ2 = j();
            if (iJ2 != 63) {
                A(iJ2);
                z10 = false;
            }
            a aVar = new a();
            ArrayList arrayList = new ArrayList();
            while (true) {
                k1 k1VarU = u(aVar);
                if (k1VarU == n1.f15691g) {
                    return new n1.e(oVar, z10, arrayList);
                }
                if (k1VarU == n1.f15686b) {
                    throw p(oVar, "Substitution ${ was not closed with a }");
                }
                k1 k1VarB = aVar.b(k1VarU, oVar, this.f15677d);
                if (k1VarB != null) {
                    arrayList.add(k1VarB);
                }
                arrayList.add(k1VarU);
            }
        }

        public final k1 z() {
            sj.o oVar = this.f15678e;
            StringBuilder sb2 = new StringBuilder();
            int iJ = j();
            while (iJ != -1 && f15673v.indexOf(iJ) < 0 && !n.e(iJ) && !C(iJ)) {
                sb2.appendCodePoint(iJ);
                if (sb2.length() == 4) {
                    String string = sb2.toString();
                    if (string.equals("true")) {
                        return n1.r(oVar, true);
                    }
                    if (string.equals(d6.a.E)) {
                        return n1.z(oVar);
                    }
                } else if (sb2.length() == 5 && sb2.toString().equals("false")) {
                    return n1.r(oVar, false);
                }
                iJ = j();
            }
            A(iJ);
            return n1.D(oVar, sb2.toString());
        }
    }

    public static String b(int i10) {
        if (i10 == 10) {
            return "newline";
        }
        if (i10 == 9) {
            return "tab";
        }
        if (i10 == -1) {
            return "end of file";
        }
        return n.d(i10) ? String.format("control character 0x%x", Integer.valueOf(i10)) : String.format("%c", Integer.valueOf(i10));
    }

    public static String c(Iterator<k1> it) {
        StringBuilder sb2 = new StringBuilder();
        while (it.hasNext()) {
            sb2.append(it.next().e());
        }
        return sb2.toString();
    }

    public static Iterator<k1> d(sj.o oVar, Reader reader, sj.v vVar) {
        return new b(oVar, reader, vVar != sj.v.JSON);
    }
}
