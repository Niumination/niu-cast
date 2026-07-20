package pk;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jq.r;
import kl.f;
import kn.l0;
import nm.y;
import ok.e;
import ok.h;
import ok.i;
import ok.j;
import ok.k;
import ok.n;
import ok.q;
import ok.t;
import ok.u;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final void a(Map<String, List<Integer>> map, String str, int i10) {
        if (!map.containsKey(str)) {
            map.put(str, new ArrayList());
        }
        List<Integer> list = map.get(str);
        l0.m(list);
        list.add(Integer.valueOf(i10));
    }

    @l
    public static final n b(@l e eVar) {
        l0.p(eVar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return new b(new r(d(eVar, linkedHashMap, 0, false, 6, null).f13165a), linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final a c(e eVar, Map<String, List<Integer>> map, int i10, boolean z10) {
        char c10;
        if (eVar instanceof u) {
            return new a(r.Companion.c(((u) eVar).f12301a), 0, false, 6, null);
        }
        if (eVar instanceof ok.r) {
            return new a(((ok.r) eVar).f12299a, 0, false, 6, null);
        }
        if (eVar instanceof j) {
            j jVar = (j) eVar;
            a aVarD = d(jVar.f12294b, map, i10 + 1, false, 4, null);
            a(map, jVar.f12293a, i10);
            return new a(aVarD.f13165a, aVarD.f13166b, true);
        }
        if (eVar instanceof ok.c) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = z10 ? i10 + 1 : i10;
            int i12 = 0;
            for (Object obj : ((ok.c) eVar).a()) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    y.Z();
                }
                a aVarC = c((e) obj, map, i11, true);
                if (i12 != 0 && (eVar instanceof k)) {
                    sb2.append("|");
                }
                sb2.append(aVarC.f13165a);
                i11 += aVarC.f13166b;
                i12 = i13;
            }
            int i14 = i11 - i10;
            if (z10) {
                i14--;
            }
            String string = sb2.toString();
            l0.o(string, "expression.toString()");
            return new a(string, i14, z10);
        }
        if (eVar instanceof t) {
            if (eVar instanceof i) {
                c10 = '?';
            } else if (eVar instanceof h) {
                c10 = f.f9277j;
            } else {
                if (!(eVar instanceof ok.b)) {
                    throw new IllegalStateException(l0.C("Unsupported simple grammar element: ", eVar).toString());
                }
                c10 = '+';
            }
            a aVarC2 = c(((t) eVar).b(), map, i10, true);
            return new a(l0.C(aVarC2.f13165a, Character.valueOf(c10)), aVarC2.f13166b, false, 4, null);
        }
        if (eVar instanceof ok.a) {
            return new a("[" + r.Companion.c(((ok.a) eVar).f12288a) + ']', 0, false, 6, null);
        }
        if (!(eVar instanceof q)) {
            throw new IllegalStateException(l0.C("Unsupported grammar element: ", eVar).toString());
        }
        StringBuilder sb3 = new StringBuilder("[");
        q qVar = (q) eVar;
        sb3.append(qVar.f12297a);
        sb3.append('-');
        sb3.append(qVar.f12298b);
        sb3.append(']');
        return new a(sb3.toString(), 0, false, 6, null);
    }

    public static /* synthetic */ a d(e eVar, Map map, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return c(eVar, map, i10, z10);
    }
}
