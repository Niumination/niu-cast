package ik;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 {

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Long.valueOf(((tn.o) t10).f15921a), Long.valueOf(((tn.o) t11).f15921a));
        }
    }

    @os.l
    public static final List<tn.o> a(@os.l List<tn.o> list) {
        kn.l0.p(list, "<this>");
        List<tn.o> listU5 = nm.h0.u5(list, new a());
        ArrayList<tn.o> arrayList = new ArrayList(list.size());
        for (tn.o oVar : listU5) {
            if (arrayList.isEmpty()) {
                arrayList.add(oVar);
            } else if (((tn.o) nm.h0.p3(arrayList)).f15922b < oVar.f15921a - 1) {
                arrayList.add(oVar);
            } else {
                tn.o oVar2 = (tn.o) nm.h0.p3(arrayList);
                arrayList.set(nm.y.J(arrayList), new tn.o(oVar2.f15921a, Math.max(oVar2.f15922b, oVar.f15922b)));
            }
        }
        tn.o[] oVarArr = new tn.o[list.size()];
        for (tn.o oVar3 : arrayList) {
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                kn.l0.o(oVar3, "range");
                if (fl.k1.a(oVar3, list.get(i10))) {
                    oVarArr[i10] = oVar3;
                    break;
                }
                i10 = i11;
            }
        }
        return nm.r.Ta(oVarArr);
    }

    @os.m
    public static final k1 b(@os.l String str) {
        lm.t0 t0Var;
        g aVar;
        kn.l0.p(str, "rangeSpec");
        try {
            int iP3 = jq.h0.p3(str, "=", 0, false, 6, null);
            if (iP3 == -1) {
                return null;
            }
            String strSubstring = str.substring(0, iP3);
            kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = str.substring(iP3 + 1);
            kn.l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            lm.t0 t0Var2 = new lm.t0(strSubstring, strSubstring2);
            String str2 = (String) t0Var2.component1();
            List<String> listQ4 = jq.h0.Q4((String) t0Var2.component2(), new char[]{StringUtil.COMMA}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(nm.z.b0(listQ4, 10));
            for (String str3 : listQ4) {
                if (jq.e0.s2(str3, "-", false, 2, null)) {
                    aVar = new g.b(Long.parseLong(jq.h0.a4(str3, "-")));
                } else {
                    int iP4 = jq.h0.p3(str3, "-", 0, false, 6, null);
                    if (iP4 == -1) {
                        t0Var = new lm.t0("", "");
                    } else {
                        String strSubstring3 = str3.substring(0, iP4);
                        kn.l0.o(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        String strSubstring4 = str3.substring(iP4 + 1);
                        kn.l0.o(strSubstring4, "this as java.lang.String).substring(startIndex)");
                        t0Var = new lm.t0(strSubstring3, strSubstring4);
                    }
                    String str4 = (String) t0Var.component1();
                    String str5 = (String) t0Var.component2();
                    aVar = str5.length() > 0 ? new g.a(Long.parseLong(str4), Long.parseLong(str5)) : new g.c(Long.parseLong(str4));
                }
                arrayList.add(aVar);
            }
            if (!arrayList.isEmpty() && str2.length() != 0) {
                k1 k1Var = new k1(str2, arrayList);
                if (k1.h(k1Var, null, 1, null)) {
                    return k1Var;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @os.l
    public static final List<tn.o> c(@os.l List<? extends g> list, long j10) {
        tn.o oVarF2;
        kn.l0.p(list, "<this>");
        List<? extends g> list2 = list;
        ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
        for (g gVar : list2) {
            if (gVar instanceof g.a) {
                g.a aVar = (g.a) gVar;
                oVarF2 = new tn.o(aVar.f7975a, tn.u.C(aVar.f7976b, j10 - 1));
            } else if (gVar instanceof g.c) {
                oVarF2 = tn.u.f2(((g.c) gVar).f7978a, j10);
            } else {
                if (!(gVar instanceof g.b)) {
                    throw new lm.i0();
                }
                oVarF2 = tn.u.f2(tn.u.v(j10 - ((g.b) gVar).f7977a, 0L), j10);
            }
            arrayList.add(oVarF2);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((tn.o) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
