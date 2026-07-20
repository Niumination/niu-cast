package tj;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static sj.o f15730a = g1.t("path parameter");

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f15731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15732b;

        public a(String str, boolean z10) {
            this.f15732b = z10;
            this.f15731a = new StringBuilder(str);
        }

        public String toString() {
            return "Element(" + this.f15731a.toString() + ks.g.f9491d + this.f15732b + ")";
        }
    }

    public static void a(List<a> list, boolean z10, String str) {
        int iIndexOf = z10 ? -1 : str.indexOf(46);
        a aVar = list.get(list.size() - 1);
        if (iIndexOf >= 0) {
            aVar.f15731a.append(str.substring(0, iIndexOf));
            list.add(new a("", false));
            a(list, false, str.substring(iIndexOf + 1));
        } else {
            aVar.f15731a.append(str);
            if (z10 && aVar.f15731a.length() == 0) {
                aVar.f15732b = true;
            }
        }
    }

    public static p0 b(p0 p0Var, String str, int i10) {
        int iLastIndexOf = str.lastIndexOf(46, i10 - 1);
        new ArrayList().add(n1.D(null, str));
        p0 p0Var2 = new p0(str.substring(iLastIndexOf + 1, i10), p0Var);
        return iLastIndexOf < 0 ? p0Var2 : b(p0Var2, str, iLastIndexOf);
    }

    public static boolean c(String str) {
        int length = str.length();
        if (str.isEmpty() || str.charAt(0) == '.' || str.charAt(length - 1) == '.') {
            return true;
        }
        boolean z10 = true;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_')) {
                z10 = false;
            } else if (cCharAt == '.') {
                if (z10) {
                    return true;
                }
                z10 = true;
            } else if (cCharAt != '-' || z10) {
                return true;
            }
        }
        return z10;
    }

    public static p0 d(String str) {
        p0 p0VarL = l(str);
        if (p0VarL != null) {
            return p0VarL;
        }
        StringReader stringReader = new StringReader(str);
        try {
            Iterator<k1> itD = m1.d(f15730a, stringReader, sj.v.CONF);
            itD.next();
            return f(itD, f15730a, str);
        } finally {
            stringReader.close();
        }
    }

    public static p0 e(Iterator<k1> it, sj.o oVar) {
        return g(it, oVar, null, null, sj.v.CONF);
    }

    public static p0 f(Iterator<k1> it, sj.o oVar, String str) {
        return g(it, oVar, str, null, sj.v.CONF);
    }

    public static p0 g(Iterator<k1> it, sj.o oVar, String str, ArrayList<k1> arrayList, sj.v vVar) {
        String strH;
        ArrayList<a> arrayList2 = new ArrayList();
        arrayList2.add(new a("", false));
        if (!it.hasNext()) {
            throw new sj.c.b(oVar, str, "Expecting a field name or path here, but got nothing");
        }
        while (it.hasNext()) {
            k1 next = it.next();
            if (arrayList != null) {
                arrayList.add(next);
            }
            if (!n1.k(next)) {
                if (n1.q(next, sj.z.STRING)) {
                    a(arrayList2, true, n1.i(next).transformToString());
                } else if (next != n1.f15686b) {
                    if (next instanceof n1.g) {
                        d dVarI = n1.i(next);
                        if (arrayList != null) {
                            arrayList.remove(arrayList.size() - 1);
                            arrayList.addAll(m(next, vVar));
                        }
                        strH = dVarI.transformToString();
                    } else {
                        if (!(next instanceof n1.f)) {
                            throw new sj.c.b(oVar, str, "Token not allowed in path expression: " + next + " (you can double-quote this token if you really want it here)");
                        }
                        if (arrayList != null) {
                            arrayList.remove(arrayList.size() - 1);
                            arrayList.addAll(m(next, vVar));
                        }
                        strH = n1.h(next);
                    }
                    a(arrayList2, false, strH);
                } else {
                    continue;
                }
            }
        }
        q0 q0Var = new q0();
        for (a aVar : arrayList2) {
            if (aVar.f15731a.length() == 0 && !aVar.f15732b) {
                throw new sj.c.b(oVar, str, "path has a leading, trailing, or two adjacent period '.' (use quoted \"\" empty string if you want an empty element)");
            }
            q0Var.a(aVar.f15731a.toString());
        }
        return q0Var.d();
    }

    public static y h(String str) {
        return i(str, sj.v.CONF);
    }

    public static y i(String str, sj.v vVar) {
        StringReader stringReader = new StringReader(str);
        try {
            Iterator<k1> itD = m1.d(f15730a, stringReader, vVar);
            itD.next();
            return k(itD, f15730a, str, vVar);
        } finally {
            stringReader.close();
        }
    }

    public static y j(Iterator<k1> it, sj.o oVar) {
        return k(it, oVar, null, sj.v.CONF);
    }

    public static y k(Iterator<k1> it, sj.o oVar, String str, sj.v vVar) {
        ArrayList arrayList = new ArrayList();
        return new y(g(it, oVar, str, arrayList, vVar), arrayList);
    }

    public static p0 l(String str) {
        String strO = n.o(str);
        if (c(strO)) {
            return null;
        }
        return b(null, strO, strO.length());
    }

    public static Collection<k1> m(k1 k1Var, sj.v vVar) {
        String strE = k1Var.e();
        if (strE.equals(".")) {
            return Collections.singletonList(k1Var);
        }
        String[] strArrSplit = strE.split("\\.");
        ArrayList arrayList = new ArrayList();
        for (String str : strArrSplit) {
            if (vVar == sj.v.CONF) {
                arrayList.add(n1.D(k1Var.d(), str));
            } else {
                arrayList.add(n1.B(k1Var.d(), str, "\"" + str + "\""));
            }
            arrayList.add(n1.D(k1Var.d(), "."));
        }
        if (strE.charAt(strE.length() - 1) != '.') {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }
}
