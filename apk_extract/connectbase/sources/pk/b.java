package pk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jq.p;
import jq.r;
import kn.l0;
import ok.n;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final r f13167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final Map<String, List<Integer>> f13168b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@l r rVar, @l Map<String, ? extends List<Integer>> map) {
        l0.p(rVar, "expression");
        l0.p(map, "indexes");
        this.f13167a = rVar;
        this.f13168b = map;
    }

    @Override // ok.n
    public boolean a(@l String str) {
        l0.p(str, "input");
        return this.f13167a.matches(str);
    }

    @Override // ok.n
    @m
    public ok.m b(@l String str) {
        l0.p(str, "input");
        p pVarMatchEntire = this.f13167a.matchEntire(str);
        if (pVarMatchEntire == null || pVarMatchEntire.getValue().length() != str.length()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<Integer>> entry : this.f13168b.entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                ArrayList arrayList = new ArrayList();
                jq.m mVar = pVarMatchEntire.d().get(iIntValue);
                if (mVar != null) {
                    arrayList.add(mVar.f8861a);
                }
                if (!arrayList.isEmpty()) {
                    linkedHashMap.put(key, arrayList);
                }
            }
        }
        return new ok.m(linkedHashMap);
    }
}
