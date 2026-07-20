package ik;

import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {
    @os.l
    public static final List<x> a(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.f8070l);
        List<x> listE = str == null ? null : i0.e(str, false);
        return listE == null ? nm.k0.INSTANCE : listE;
    }

    @os.m
    public static final Charset b(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        i iVarH = h(l0Var);
        if (iVarH == null) {
            return null;
        }
        return k.a(iVarH);
    }

    @os.m
    public static final Charset c(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "<this>");
        i iVarI = i(m0Var);
        if (iVarI == null) {
            return null;
        }
        return k.a(iVarI);
    }

    @os.m
    @lm.k(level = lm.m.ERROR, message = "Use content with particular content type and charset instead")
    public static final l2 d(@os.l m0 m0Var, @os.l Charset charset) {
        kn.l0.p(m0Var, "<this>");
        kn.l0.p(charset, "charset");
        i iVarI = i(m0Var);
        if (iVarI == null) {
            return null;
        }
        j(m0Var, k.b(iVarI, charset));
        return l2.f10208a;
    }

    @os.m
    public static final Long e(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.f8080q);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    @os.m
    public static final Long f(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        String strL = c0VarB.l(j0.f8080q);
        if (strL == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(strL));
    }

    @lm.k(level = lm.m.ERROR, message = "Content-Length is controlled by underlying engine. Don't specify it explicitly.")
    public static final void g(@os.l m0 m0Var, int i10) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        c0VarB.v(j0.f8080q, String.valueOf(i10));
    }

    @os.m
    public static final i h(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.f8086t);
        if (str == null) {
            return null;
        }
        return i.f7981f.b(str);
    }

    @os.m
    public static final i i(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        String strL = c0VarB.l(j0.f8086t);
        if (strL == null) {
            return null;
        }
        return i.f7981f.b(strL);
    }

    public static final void j(@os.l m0 m0Var, @os.l i iVar) {
        kn.l0.p(m0Var, "<this>");
        kn.l0.p(iVar, y0.a.f8215h);
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        c0VarB.v(j0.f8086t, iVar.toString());
    }

    @os.l
    public static final List<l> k(@os.l m0 m0Var) {
        ArrayList arrayList;
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        List<String> listM = c0VarB.m(j0.f8083r0);
        if (listM == null) {
            arrayList = null;
        } else {
            List<String> list = listM;
            ArrayList arrayList2 = new ArrayList(nm.z.b0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(p.m((String) it.next()));
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? nm.k0.INSTANCE : arrayList;
    }

    @os.m
    public static final String l(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        return b0VarB.get(j0.A);
    }

    @os.m
    public static final String m(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        return c0VarB.l(j0.A);
    }

    public static final void n(@os.l m0 m0Var, @os.l String str) {
        kn.l0.p(m0Var, "<this>");
        kn.l0.p(str, "value");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        c0VarB.v(j0.K, str);
    }

    public static final void o(@os.l m0 m0Var, int i10) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        c0VarB.a(j0.f8070l, kn.l0.C("max-age=", Integer.valueOf(i10)));
    }

    @os.l
    public static final List<l> p(@os.l l0 l0Var) {
        ArrayList arrayList;
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        List<String> listB = b0VarB.b(j0.f8083r0);
        if (listB == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                nm.d0.r0(arrayList2, q((String) it.next()));
            }
            arrayList = new ArrayList(nm.z.b0(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList.add(p.m((String) it2.next()));
            }
        }
        return arrayList == null ? nm.k0.INSTANCE : arrayList;
    }

    @os.l
    public static final List<String> q(@os.l String str) {
        int i10;
        kn.l0.p(str, "<this>");
        int iO3 = jq.h0.o3(str, StringUtil.COMMA, 0, false, 6, null);
        if (iO3 == -1) {
            return nm.x.k(str);
        }
        ArrayList arrayList = new ArrayList();
        int iO4 = jq.h0.o3(str, fl.h.f6043c, iO3, false, 4, null);
        int iO5 = jq.h0.o3(str, ';', iO3, false, 4, null);
        int i11 = 0;
        while (i11 < str.length() && iO3 > 0) {
            if (iO4 < iO3) {
                iO4 = jq.h0.o3(str, fl.h.f6043c, iO3, false, 4, null);
            }
            int iO6 = jq.h0.o3(str, StringUtil.COMMA, iO3 + 1, false, 4, null);
            while (true) {
                i10 = iO3;
                iO3 = iO6;
                if (iO3 < 0 || iO3 >= iO4) {
                    break;
                }
                iO6 = jq.h0.o3(str, StringUtil.COMMA, iO3 + 1, false, 4, null);
            }
            if (iO5 < i10) {
                iO5 = jq.h0.o3(str, ';', i10, false, 4, null);
            }
            if (iO4 < 0) {
                String strSubstring = str.substring(i11);
                kn.l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                arrayList.add(strSubstring);
                return arrayList;
            }
            if (iO5 == -1 || iO5 > iO4) {
                String strSubstring2 = str.substring(i11, i10);
                kn.l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                i11 = i10 + 1;
            }
        }
        if (i11 < str.length()) {
            String strSubstring3 = str.substring(i11);
            kn.l0.o(strSubstring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(strSubstring3);
        }
        return arrayList;
    }

    public static final void r(@os.l m0 m0Var, @os.l String str) {
        kn.l0.p(m0Var, "<this>");
        kn.l0.p(str, t2.a.f15437d);
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        c0VarB.v(j0.f8099z0, str);
    }

    @os.m
    public static final List<String> s(@os.l l0 l0Var) {
        List listR4;
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.A0);
        ArrayList arrayList = null;
        if (str != null && (listR4 = jq.h0.R4(str, new String[]{ks.g.f9491d}, false, 0, 6, null)) != null) {
            List list = listR4;
            arrayList = new ArrayList(nm.z.b0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(jq.h0.C5((String) it.next()).toString());
            }
        }
        return arrayList;
    }

    @os.m
    public static final List<String> t(@os.l m0 m0Var) {
        List listR4;
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        String strL = c0VarB.l(j0.A0);
        ArrayList arrayList = null;
        if (strL != null && (listR4 = jq.h0.R4(strL, new String[]{ks.g.f9491d}, false, 0, 6, null)) != null) {
            List list = listR4;
            arrayList = new ArrayList(nm.z.b0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(jq.h0.C5((String) it.next()).toString());
            }
        }
        return arrayList;
    }
}
