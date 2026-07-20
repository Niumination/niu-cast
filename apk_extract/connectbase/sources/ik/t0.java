package ik;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    public static final class a extends kn.n0 implements jn.l<lm.t0<? extends String, ? extends String>, CharSequence> {
        final /* synthetic */ z1 $option;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z1 z1Var) {
            super(1);
            this.$option = z1Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ CharSequence invoke(lm.t0<? extends String, ? extends String> t0Var) {
            return invoke2((lm.t0<String, String>) t0Var);
        }

        @os.l
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(@os.l lm.t0<String, String> t0Var) {
            kn.l0.p(t0Var, "it");
            String strM = this.$option.getEncodeKey$ktor_http() ? e.m(t0Var.getFirst(), true) : t0Var.getFirst();
            if (t0Var.getSecond() == null) {
                return strM;
            }
            String strValueOf = String.valueOf(t0Var.getSecond());
            if (this.$option.getEncodeValue$ktor_http()) {
                strValueOf = e.o(strValueOf);
            }
            return strM + fl.h.f6043c + strValueOf;
        }
    }

    @os.l
    public static final String a(@os.l b1 b1Var) {
        kn.l0.p(b1Var, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = b1Var.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(nm.z.b0(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new lm.t0(entry.getKey(), (String) it2.next()));
            }
            nm.d0.r0(arrayList, arrayList2);
        }
        return c(arrayList, b1Var.c());
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ String b(List list) {
        kn.l0.p(list, "<this>");
        return c(list, z1.DEFAULT);
    }

    @os.l
    public static final String c(@os.l List<lm.t0<String, String>> list, @os.l z1 z1Var) throws IOException {
        kn.l0.p(list, "<this>");
        kn.l0.p(z1Var, "option");
        StringBuilder sb2 = new StringBuilder();
        h(list, sb2, z1Var);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String d(List list, z1 z1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z1Var = z1.DEFAULT;
        }
        return c(list, z1Var);
    }

    public static final void e(@os.l b1 b1Var, @os.l Appendable appendable) {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(appendable, "out");
        j(b1Var.entries(), appendable, b1Var.c());
    }

    public static final void f(@os.l c1 c1Var, @os.l Appendable appendable) {
        kn.l0.p(c1Var, "<this>");
        kn.l0.p(appendable, "out");
        j(c1Var.k(), appendable, c1Var.f7945d);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ void g(List list, Appendable appendable) throws IOException {
        kn.l0.p(list, "<this>");
        kn.l0.p(appendable, "out");
        h(list, appendable, z1.DEFAULT);
    }

    public static final void h(@os.l List<lm.t0<String, String>> list, @os.l Appendable appendable, @os.l z1 z1Var) throws IOException {
        kn.l0.p(list, "<this>");
        kn.l0.p(appendable, "out");
        kn.l0.p(z1Var, "option");
        nm.h0.j3(list, appendable, (y5.a.f20716e0 & 2) != 0 ? ", " : "&", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : new a(z1Var));
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ void i(Set set, Appendable appendable) throws IOException {
        kn.l0.p(set, "<this>");
        kn.l0.p(appendable, "out");
        j(set, appendable, z1.DEFAULT);
    }

    public static final void j(@os.l Set<? extends Map.Entry<String, ? extends List<String>>> set, @os.l Appendable appendable, @os.l z1 z1Var) throws IOException {
        List listK;
        kn.l0.p(set, "<this>");
        kn.l0.p(appendable, "out");
        kn.l0.p(z1Var, "option");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listK = nm.x.k(new lm.t0(str, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new lm.t0(str, (String) it2.next()));
                }
                listK = arrayList2;
            }
            nm.d0.r0(arrayList, listK);
        }
        h(arrayList, appendable, z1Var);
    }

    public static /* synthetic */ void k(List list, Appendable appendable, z1 z1Var, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            z1Var = z1.DEFAULT;
        }
        h(list, appendable, z1Var);
    }

    public static /* synthetic */ void l(Set set, Appendable appendable, z1 z1Var, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            z1Var = z1.DEFAULT;
        }
        j(set, appendable, z1Var);
    }

    @os.l
    public static final b1 m(@os.l String str, @os.l Charset charset, int i10) {
        Object next;
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "defaultEncoding");
        List<String> listR4 = jq.h0.R4(str, new String[]{"&"}, false, i10, 2, null);
        ArrayList<lm.t0> arrayList = new ArrayList(nm.z.b0(listR4, 10));
        for (String str2 : listR4) {
            arrayList.add(new lm.t0(jq.h0.v5(str2, "=", null, 2, null), jq.h0.l5(str2, "=", "")));
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kn.l0.g(((lm.t0) next).getFirst(), "_charset_"));
        lm.t0 t0Var = (lm.t0) next;
        String strP = t0Var == null ? null : (String) t0Var.getSecond();
        if (strP == null) {
            strP = rl.a.p(charset);
        }
        Charset charsetForName = Charset.forName(strP);
        b1.a aVar = b1.f7942c;
        c1 c1Var = new c1(0, null, 3, null);
        for (lm.t0 t0Var2 : arrayList) {
            String str3 = (String) t0Var2.component1();
            String str4 = (String) t0Var2.component2();
            kn.l0.o(charsetForName, "charset");
            c1Var.a(e.k(str3, 0, 0, false, charsetForName, 7, null), e.k(str4, 0, 0, false, charsetForName, 7, null));
        }
        return c1Var.f();
    }

    public static /* synthetic */ b1 n(String str, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = 1000;
        }
        return m(str, charset, i10);
    }
}
