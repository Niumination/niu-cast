package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator<k1> f15636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final sj.v f15637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final sj.o f15638e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f15640g = "expecting a close parentheses ')' here, not: ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15634a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Stack<k1> f15635b = new Stack<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15639f = 0;

        public a(sj.v vVar, sj.o oVar, Iterator<k1> it) {
            this.f15636c = it;
            this.f15637d = vVar;
            this.f15638e = oVar;
        }

        public static boolean e(k1 k1Var) {
            return n1.o(k1Var) && n1.h(k1Var).equals("include");
        }

        public static boolean g(k1 k1Var) {
            if (!n1.o(k1Var)) {
                return false;
            }
            String strH = n1.h(k1Var);
            for (int i10 = 0; i10 < strH.length(); i10++) {
                if (!n.e(strH.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        public final String a(String str, String str2) {
            return b(null, this.f15639f > 0, str, str2);
        }

        public final String b(p0 p0Var, boolean z10, String str, String str2) {
            String str3;
            String strK = p0Var != null ? p0Var.k() : null;
            if (str.equals(n1.f15686b.toString())) {
                if (strK == null) {
                    return str2;
                }
                str3 = str2 + " (if you intended '" + strK + "' to be part of a value, instead of a key, try adding double quotes around the whole value";
            } else if (strK != null) {
                str3 = str2 + " (if you intended " + str + " to be part of the value for '" + strK + "', try enclosing the value in double quotes";
            } else {
                str3 = str2 + " (if you intended " + str + " to be part of a key or string value, try enclosing the key or value in double quotes";
            }
            return z10 ? j.a.a(str3, ", or you may be able to rename the file .properties rather than .conf)") : j.a.a(str3, ")");
        }

        public final boolean c(Collection<tj.a> collection) {
            boolean z10 = false;
            if (this.f15637d == sj.v.JSON) {
                k1 k1VarI = i(collection);
                if (k1VarI == n1.f15687c) {
                    collection.add(new b0(k1VarI));
                    return true;
                }
                u(k1VarI);
                return false;
            }
            k1 k1VarH = h();
            while (true) {
                if (!n1.k(k1VarH) && !g(k1VarH)) {
                    if (!(k1VarH instanceof n1.a)) {
                        if (!(k1VarH instanceof n1.c)) {
                            break;
                        }
                        this.f15634a++;
                        collection.add(new b0(k1VarH));
                        z10 = true;
                    } else {
                        collection.add(new s(k1VarH));
                    }
                } else {
                    collection.add(new b0(k1VarH));
                }
                k1VarH = h();
            }
            if (k1VarH == n1.f15687c) {
                collection.add(new b0(k1VarH));
                return true;
            }
            u(k1VarH);
            return z10;
        }

        public final b d(Collection<tj.a> collection) {
            b bVar = null;
            if (this.f15637d == sj.v.JSON) {
                return null;
            }
            ArrayList<tj.a> arrayList = new ArrayList();
            k1 k1VarI = i(collection);
            int i10 = 0;
            while (true) {
                if (n1.k(k1VarI)) {
                    arrayList.add(new b0(k1VarI));
                    k1VarI = h();
                } else {
                    if (!(k1VarI instanceof n1.g) && !(k1VarI instanceof n1.f) && !(k1VarI instanceof n1.e) && k1VarI != n1.f15690f && k1VarI != n1.f15692h) {
                        u(k1VarI);
                        if (i10 >= 2) {
                            for (int size = arrayList.size() - 1; size >= 0 && (arrayList.get(size) instanceof b0); size--) {
                                u(((b0) arrayList.get(size)).b());
                                arrayList.remove(size);
                            }
                            return new u(arrayList);
                        }
                        for (tj.a aVar : arrayList) {
                            if (aVar instanceof b) {
                                bVar = (b) aVar;
                            } else if (bVar == null) {
                                collection.add(aVar);
                            } else {
                                u((k1) new ArrayList(aVar.a()).get(0));
                            }
                        }
                        return bVar;
                    }
                    b bVarS = s(k1VarI);
                    i10++;
                    if (bVarS == null) {
                        throw new sj.c.d("no value");
                    }
                    arrayList.add(bVarS);
                    k1VarI = h();
                }
            }
        }

        public final boolean f(k1 k1Var) {
            if (this.f15637d == sj.v.JSON) {
                return k1Var == n1.f15689e;
            }
            return k1Var == n1.f15689e || k1Var == n1.f15688d || k1Var == n1.f15694j;
        }

        public final k1 h() {
            k1 k1VarT = t();
            if (this.f15637d == sj.v.JSON) {
                if (n1.o(k1VarT) && !g(k1VarT)) {
                    throw m("Token not allowed in valid JSON: '" + n1.h(k1VarT) + "'", null);
                }
                if (k1VarT instanceof n1.e) {
                    throw m("Substitutions (${} syntax) not allowed in JSON", null);
                }
            }
            return k1VarT;
        }

        public final k1 i(Collection<tj.a> collection) {
            k1 k1VarH;
            while (true) {
                k1VarH = h();
                if (!n1.k(k1VarH) && !(k1VarH instanceof n1.c) && !g(k1VarH)) {
                    if (!(k1VarH instanceof n1.a)) {
                        break;
                    }
                    collection.add(new s(k1VarH));
                } else {
                    collection.add(new b0(k1VarH));
                    if (k1VarH instanceof n1.c) {
                        this.f15634a = k1VarH.b() + 1;
                    }
                }
            }
            int iB = k1VarH.b();
            if (iB >= 0) {
                this.f15634a = iB;
            }
            return k1VarH;
        }

        public z j() {
            b bVarS;
            ArrayList arrayList = new ArrayList();
            k1 k1VarH = h();
            if (k1VarH != n1.f15685a) {
                throw new sj.c.d("token stream did not begin with START, had " + k1VarH);
            }
            k1 k1VarI = i(arrayList);
            boolean z10 = false;
            if (k1VarI == n1.f15690f || k1VarI == n1.f15692h) {
                bVarS = s(k1VarI);
            } else {
                if (this.f15637d == sj.v.JSON) {
                    if (k1VarI == n1.f15686b) {
                        throw m("Empty document", null);
                    }
                    throw m("Document must have an object or array at root, unexpected token: " + k1VarI, null);
                }
                u(k1VarI);
                bVarS = q(false);
                z10 = true;
            }
            if ((bVarS instanceof x) && z10) {
                arrayList.addAll(((t) bVarS).f15733a);
            } else {
                arrayList.add(bVarS);
            }
            k1 k1VarI2 = i(arrayList);
            if (k1VarI2 == n1.f15686b) {
                return z10 ? new z(Collections.singletonList(new x(arrayList)), this.f15638e) : new z(arrayList, this.f15638e);
            }
            throw m("Document has trailing tokens after first object or array: " + k1VarI2, null);
        }

        public final t k() {
            ArrayList arrayList = new ArrayList();
            k1 k1Var = n1.f15692h;
            arrayList.add(new b0(k1Var));
            b bVarD = d(arrayList);
            if (bVarD != null) {
                arrayList.add(bVarD);
            } else {
                k1 k1VarI = i(arrayList);
                if (k1VarI == n1.f15693i) {
                    arrayList.add(new b0(k1VarI));
                    return new r(arrayList);
                }
                if (!(k1VarI instanceof n1.g) && k1VarI != n1.f15690f && k1VarI != k1Var && !(k1VarI instanceof n1.f) && !(k1VarI instanceof n1.e)) {
                    throw m("List should have ] or a first element after the open [, instead had token: " + k1VarI + " (if you want " + k1VarI + " to be part of a string value, then double-quote it)", null);
                }
                arrayList.add(s(k1VarI));
            }
            while (c(arrayList)) {
                b bVarD2 = d(arrayList);
                if (bVarD2 != null) {
                    arrayList.add(bVarD2);
                } else {
                    k1 k1VarI2 = i(arrayList);
                    if ((k1VarI2 instanceof n1.g) || k1VarI2 == n1.f15690f || k1VarI2 == n1.f15692h || (k1VarI2 instanceof n1.f) || (k1VarI2 instanceof n1.e)) {
                        arrayList.add(s(k1VarI2));
                    } else {
                        if (this.f15637d == sj.v.JSON || k1VarI2 != n1.f15693i) {
                            throw m("List should have had new element after a comma, instead had token: " + k1VarI2 + " (if you want the comma or " + k1VarI2 + " to be part of a string value, then double-quote it)", null);
                        }
                        u(k1VarI2);
                    }
                }
            }
            k1 k1VarI3 = i(arrayList);
            if (k1VarI3 == n1.f15693i) {
                arrayList.add(new b0(k1VarI3));
                return new r(arrayList);
            }
            throw m("List should have ended with ] or had a comma, instead had token: " + k1VarI3 + " (if you want " + k1VarI3 + " to be part of a string value, then double-quote it)", null);
        }

        public final sj.c l(String str) {
            return m(str, null);
        }

        public final sj.c m(String str, Throwable th2) {
            return new sj.c.j(this.f15638e.d(this.f15634a), str, th2);
        }

        public final w n(ArrayList<tj.a> arrayList) {
            k1 k1VarI = i(arrayList);
            if (!n1.o(k1VarI)) {
                u(k1VarI);
                return o(arrayList, false);
            }
            String strH = n1.h(k1VarI);
            if (!strH.startsWith("required(")) {
                u(k1VarI);
                return o(arrayList, false);
            }
            String strReplaceFirst = strH.replaceFirst("required\\(", "");
            if (strReplaceFirst.length() > 0) {
                u(new n1.f(k1VarI.d(), strReplaceFirst));
            }
            arrayList.add(new b0(k1VarI));
            w wVarO = o(arrayList, true);
            k1 k1VarI2 = i(arrayList);
            if ((k1VarI2 instanceof n1.f) && n1.h(k1VarI2).equals(")")) {
                return wVarO;
            }
            throw m("expecting a close parentheses ')' here, not: " + k1VarI2, null);
        }

        public final w o(ArrayList<tj.a> arrayList, boolean z10) {
            o oVar;
            k1 k1VarI = i(arrayList);
            if (!n1.o(k1VarI)) {
                if (n1.q(k1VarI, sj.z.STRING)) {
                    arrayList.add(new a0(k1VarI));
                    return new w(arrayList, o.HEURISTIC, z10);
                }
                throw m("include keyword is not followed by a quoted string, but by: " + k1VarI, null);
            }
            String strH = n1.h(k1VarI);
            String str = "url(";
            if (strH.startsWith("url(")) {
                oVar = o.URL;
            } else {
                str = "file(";
                if (strH.startsWith("file(")) {
                    oVar = o.FILE;
                } else {
                    str = "classpath(";
                    if (!strH.startsWith("classpath(")) {
                        throw m("expecting include parameter to be quoted filename, file(), classpath(), or url(). No spaces are allowed before the open paren. Not expecting: " + k1VarI, null);
                    }
                    oVar = o.CLASSPATH;
                }
            }
            String strReplaceFirst = strH.replaceFirst("[^(]*\\(", "");
            if (strReplaceFirst.length() > 0) {
                u(new n1.f(k1VarI.d(), strReplaceFirst));
            }
            arrayList.add(new b0(k1VarI));
            k1 k1VarI2 = i(arrayList);
            if (!n1.q(k1VarI2, sj.z.STRING)) {
                throw m("expecting include " + str + ") parameter to be a quoted string, rather than: " + k1VarI2, null);
            }
            arrayList.add(new a0(k1VarI2));
            k1 k1VarI3 = i(arrayList);
            if (!(k1VarI3 instanceof n1.f) || !n1.h(k1VarI3).startsWith(")")) {
                throw m("expecting a close parentheses ')' here, not: " + k1VarI3, null);
            }
            String strSubstring = n1.h(k1VarI3).substring(1);
            if (strSubstring.length() > 0) {
                u(new n1.f(k1VarI3.d(), strSubstring));
            }
            return new w(arrayList, oVar, z10);
        }

        public final y p(k1 k1Var) {
            if (this.f15637d == sj.v.JSON) {
                if (n1.q(k1Var, sj.z.STRING)) {
                    return r0.j(Collections.singletonList(k1Var).iterator(), this.f15638e.d(this.f15634a));
                }
                throw m("Expecting close brace } or a field name here, got " + k1Var, null);
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                if (!n1.p(k1Var) && !(k1Var instanceof n1.f)) {
                    break;
                }
                arrayList.add(k1Var);
                k1Var = h();
            }
            if (!arrayList.isEmpty()) {
                u(k1Var);
                return r0.j(arrayList.iterator(), this.f15638e.d(this.f15634a));
            }
            throw m("expecting a close parentheses ')' here, not: " + k1Var, null);
        }

        public final t q(boolean z10) {
            boolean z11;
            b bVarD;
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            if (z10) {
                arrayList.add(new b0(n1.f15690f));
            }
            boolean z12 = false;
            boolean z13 = false;
            while (true) {
                k1 k1VarI = i(arrayList);
                k1 k1Var = n1.f15691g;
                if (k1VarI != k1Var) {
                    k1 k1Var2 = n1.f15686b;
                    if (k1VarI == k1Var2 && !z10) {
                        u(k1VarI);
                        break;
                    }
                    sj.v vVar = this.f15637d;
                    sj.v vVar2 = sj.v.JSON;
                    if (vVar == vVar2 || !e(k1VarI)) {
                        ArrayList arrayList2 = new ArrayList();
                        y yVarP = p(k1VarI);
                        arrayList2.add(yVarP);
                        k1 k1VarI2 = i(arrayList2);
                        if (this.f15637d == sj.v.CONF && k1VarI2 == n1.f15690f) {
                            bVarD = s(k1VarI2);
                            z11 = false;
                        } else {
                            if (!f(k1VarI2)) {
                                throw m(a(k1VarI2.toString(), "Key '" + yVarP.render() + "' may not be followed by token: " + k1VarI2), null);
                            }
                            arrayList2.add(new b0(k1VarI2));
                            if (k1VarI2 == n1.f15688d) {
                                this.f15639f++;
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            bVarD = d(arrayList2);
                            if (bVarD == null) {
                                bVarD = s(i(arrayList2));
                            }
                        }
                        arrayList2.add(bVarD);
                        if (z11) {
                            this.f15639f--;
                        }
                        p0 p0Var = yVarP.f15754a;
                        String str = p0Var.f15726a;
                        if (p0Var.f15727b == null) {
                            if (((Boolean) map.get(str)) != null && this.f15637d == vVar2) {
                                throw m("JSON does not allow duplicate fields: '" + str + "' was already seen", null);
                            }
                            map.put(str, Boolean.TRUE);
                        } else {
                            if (this.f15637d == vVar2) {
                                throw new sj.c.d("somehow got multi-element path in JSON mode");
                            }
                            map.put(str, Boolean.TRUE);
                        }
                        arrayList.add(new v(arrayList2));
                        z13 = z11;
                    } else {
                        ArrayList<tj.a> arrayList3 = new ArrayList<>();
                        arrayList3.add(new b0(k1VarI));
                        arrayList.add(n(arrayList3));
                    }
                    if (!c(arrayList)) {
                        k1 k1VarI3 = i(arrayList);
                        if (k1VarI3 == k1Var) {
                            if (!z10) {
                                throw m(b(null, z13, k1VarI3.toString(), "unbalanced close brace '}' with no open brace"), null);
                            }
                            arrayList.add(new b0(k1VarI3));
                            break;
                        }
                        if (z10) {
                            throw m(b(null, z13, k1VarI3.toString(), "Expecting close brace } or a comma, got " + k1VarI3), null);
                        }
                        if (k1VarI3 == k1Var2) {
                            u(k1VarI3);
                            break;
                        }
                        throw m(b(null, z13, k1VarI3.toString(), "Expecting end of input or a comma, got " + k1VarI3), null);
                    }
                    z12 = true;
                } else {
                    if (this.f15637d == sj.v.JSON && z12) {
                        throw m(a(k1VarI.toString(), "expecting a field name after a comma, got a close brace } instead"), null);
                    }
                    if (!z10) {
                        throw m(a(k1VarI.toString(), "unbalanced close brace '}' with no open brace"), null);
                    }
                    arrayList.add(new b0(k1Var));
                    break;
                }
            }
            return new x(arrayList);
        }

        public b r() {
            k1 k1VarH = h();
            if (k1VarH != n1.f15685a) {
                throw new sj.c.d("token stream did not begin with START, had " + k1VarH);
            }
            k1 k1VarH2 = h();
            if ((k1VarH2 instanceof n1.b) || (k1VarH2 instanceof n1.c) || g(k1VarH2) || (k1VarH2 instanceof n1.a)) {
                throw m("The value from withValueText cannot have leading or trailing newlines, whitespace, or comments", null);
            }
            k1 k1Var = n1.f15686b;
            if (k1VarH2 == k1Var) {
                throw m("Empty value", null);
            }
            if (this.f15637d == sj.v.JSON) {
                b bVarS = s(k1VarH2);
                if (h() == k1Var) {
                    return bVarS;
                }
                throw m("Parsing JSON and the value set in withValueText was either a concatenation or had trailing whitespace, newlines, or comments", null);
            }
            u(k1VarH2);
            b bVarD = d(new ArrayList());
            if (h() == k1Var) {
                return bVarD;
            }
            throw m("The value from withValueText cannot have leading or trailing newlines, whitespace, or comments", null);
        }

        public final b s(k1 k1Var) {
            b a0Var;
            int i10 = this.f15639f;
            if (n1.p(k1Var) || (k1Var instanceof n1.f) || (k1Var instanceof n1.e)) {
                a0Var = new a0(k1Var);
            } else if (k1Var == n1.f15690f) {
                a0Var = q(true);
            } else {
                if (k1Var != n1.f15692h) {
                    throw m(a(k1Var.toString(), "Expecting a value but got wrong token: " + k1Var), null);
                }
                a0Var = k();
            }
            if (this.f15639f == i10) {
                return a0Var;
            }
            throw new sj.c.d("Bug in config parser: unbalanced equals count");
        }

        public final k1 t() {
            return this.f15635b.isEmpty() ? this.f15636c.next() : this.f15635b.pop();
        }

        public final void u(k1 k1Var) {
            this.f15635b.push(k1Var);
        }
    }

    public static z a(Iterator<k1> it, sj.o oVar, sj.q qVar) {
        sj.v vVar = qVar.f15090a;
        if (vVar == null) {
            vVar = sj.v.CONF;
        }
        return new a(vVar, oVar, it).j();
    }

    public static b b(Iterator<k1> it, sj.o oVar, sj.q qVar) {
        sj.v vVar = qVar.f15090a;
        if (vVar == null) {
            vVar = sj.v.CONF;
        }
        return new a(vVar, oVar, it).r();
    }
}
