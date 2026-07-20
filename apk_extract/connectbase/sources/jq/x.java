package jq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1569#3,11:127\n1864#3,2:138\n1866#3:151\n1580#3:152\n766#3:155\n857#3,2:156\n1549#3:158\n1620#3,3:159\n1569#3,11:164\n1864#3,2:175\n1866#3:182\n1580#3:183\n1569#3,11:192\n1864#3,2:203\n1866#3:206\n1580#3:207\n151#4,6:144\n151#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n"})
public class x extends w {

    public static final class a extends kn.n0 implements jn.l<String, String> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l String str) {
            kn.l0.p(str, "line");
            return str;
        }
    }

    public static final class b extends kn.n0 implements jn.l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l String str) {
            kn.l0.p(str, "line");
            return j.c.a(new StringBuilder(), this.$indent, str);
        }
    }

    public static final class c extends kn.n0 implements jn.l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l String str) {
            kn.l0.p(str, "it");
            if (e0.S1(str)) {
                return str.length() < this.$indent.length() ? this.$indent : str;
            }
            return j.c.a(new StringBuilder(), this.$indent, str);
        }
    }

    public static final jn.l<String, String> g(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    public static final int h(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (!d.r(str.charAt(i10))) {
                if (i10 == -1) {
                    return str.length();
                }
                return i10;
            }
            i10++;
        }
        i10 = -1;
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }

    @os.l
    public static final String i(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "indent");
        return gq.v.e1(gq.v.k1(h0.I3(str), new c(str2)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    public static final String k(List<String> list, int i10, jn.l<? super String, String> lVar, jn.l<? super String, String> lVar2) {
        String strInvoke;
        int iJ = nm.y.J(list);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            String str = (String) obj;
            if ((i11 == 0 || i11 == iJ) && e0.S1(str)) {
                str = null;
            } else {
                String strInvoke2 = lVar2.invoke(str);
                if (strInvoke2 != null && (strInvoke = lVar.invoke(strInvoke2)) != null) {
                    str = strInvoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i11 = i12;
        }
        String string = ((StringBuilder) nm.h0.j3(arrayList, new StringBuilder(i10), (y5.a.f20716e0 & 2) != 0 ? ", " : "\n", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.l
    public static final String l(@os.l String str, @os.l String str2) {
        String strInvoke;
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "newIndent");
        List<String> listJ3 = h0.J3(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listJ3) {
            if (!e0.S1((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it.next())));
        }
        Integer num = (Integer) nm.h0.h4(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int size = (listJ3.size() * str2.length()) + str.length();
        jn.l<String, String> lVarG = g(str2);
        int iJ = nm.y.J(listJ3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listJ3) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            String str3 = (String) obj2;
            if ((i10 == 0 || i10 == iJ) && e0.S1(str3)) {
                str3 = null;
            } else {
                String strY6 = j0.y6(str3, iIntValue);
                if (strY6 != null && (strInvoke = lVarG.invoke(strY6)) != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i10 = i11;
        }
        String string = ((StringBuilder) nm.h0.j3(arrayList3, new StringBuilder(size), (y5.a.f20716e0 & 2) != 0 ? ", " : "\n", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String m(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "";
        }
        return l(str, str2);
    }

    @os.l
    public static final String n(@os.l String str, @os.l String str2, @os.l String str3) {
        int i10;
        String strInvoke;
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "newIndent");
        kn.l0.p(str3, "marginPrefix");
        if (e0.S1(str3)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> listJ3 = h0.J3(str);
        int size = (listJ3.size() * str2.length()) + str.length();
        jn.l<String, String> lVarG = g(str2);
        int iJ = nm.y.J(listJ3);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : listJ3) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                nm.y.Z();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i11 == 0 || i11 == iJ) && e0.S1(str4)) {
                str4 = null;
            } else {
                int length = str4.length();
                int i13 = 0;
                while (true) {
                    if (i13 >= length) {
                        i10 = -1;
                        break;
                    }
                    if (!d.r(str4.charAt(i13))) {
                        i10 = i13;
                        break;
                    }
                    i13++;
                }
                if (i10 != -1) {
                    int i14 = i10;
                    if (e0.r2(str4, str3, i10, false, 4, null)) {
                        int length2 = str3.length() + i14;
                        kn.l0.n(str4, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str4.substring(length2);
                        kn.l0.o(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (strInvoke = lVarG.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i11 = i12;
        }
        String string = ((StringBuilder) nm.h0.j3(arrayList, new StringBuilder(size), (y5.a.f20716e0 & 2) != 0 ? ", " : "\n", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String o(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "";
        }
        if ((i10 & 2) != 0) {
            str3 = "|";
        }
        return n(str, str2, str3);
    }

    @an.g
    @os.l
    public static String p(@os.l String str) {
        kn.l0.p(str, "<this>");
        return l(str, "");
    }

    @an.g
    @os.l
    public static final String q(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "marginPrefix");
        return n(str, "", str2);
    }

    public static /* synthetic */ String r(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return q(str, str2);
    }
}
