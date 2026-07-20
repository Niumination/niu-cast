package fl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 {

    public static final class a extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        final /* synthetic */ boolean $keepEmpty;
        final /* synthetic */ jn.p<String, String, Boolean> $predicate;
        final /* synthetic */ p1 $this_appendFiltered;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z10, p1 p1Var, jn.p<? super String, ? super String, Boolean> pVar) {
            super(2);
            this.$keepEmpty = z10;
            this.$this_appendFiltered = p1Var;
            this.$predicate = pVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "value");
            List<String> list2 = list;
            ArrayList arrayList = new ArrayList(list.size());
            jn.p<String, String, Boolean> pVar = this.$predicate;
            for (Object obj : list2) {
                if (pVar.invoke(str, (String) obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            if (this.$keepEmpty || !arrayList.isEmpty()) {
                this.$this_appendFiltered.c(str, arrayList);
            }
        }
    }

    public static final class b extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        final /* synthetic */ jn.p<String, String, l2> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.p<? super String, ? super String, l2> pVar) {
            super(2);
            this.$block = pVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "items");
            jn.p<String, String, l2> pVar = this.$block;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                pVar.invoke(str, (String) it.next());
            }
        }
    }

    public static final boolean a(Set set, Set set2) {
        return kn.l0.g(set, set2);
    }

    @os.l
    public static final p1 c(@os.l p1 p1Var, @os.l p1 p1Var2) {
        kn.l0.p(p1Var, "<this>");
        kn.l0.p(p1Var2, "builder");
        Iterator<T> it = p1Var2.k().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            p1Var.c((String) entry.getKey(), (List) entry.getValue());
        }
        return p1Var;
    }

    public static final void d(@os.l p1 p1Var, @os.l o1 o1Var, boolean z10, @os.l jn.p<? super String, ? super String, Boolean> pVar) {
        kn.l0.p(p1Var, "<this>");
        kn.l0.p(o1Var, "source");
        kn.l0.p(pVar, "predicate");
        o1Var.e(new a(z10, p1Var, pVar));
    }

    public static /* synthetic */ void e(p1 p1Var, o1 o1Var, boolean z10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        d(p1Var, o1Var, z10, pVar);
    }

    public static final boolean f(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return kn.l0.g(set, set2);
    }

    public static final int g(Set<? extends Map.Entry<String, ? extends List<String>>> set, int i10) {
        return set.hashCode() + (i10 * 31);
    }

    @os.l
    public static final o1 h(@os.l o1 o1Var, boolean z10, @os.l jn.p<? super String, ? super String, Boolean> pVar) {
        kn.l0.p(o1Var, "<this>");
        kn.l0.p(pVar, "predicate");
        Set<Map.Entry<String, List<String>>> setEntries = o1Var.entries();
        Map oVar = o1Var.a() ? new o() : new LinkedHashMap(setEntries.size());
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(((List) entry.getValue()).size());
            for (Object obj : iterable) {
                if (pVar.invoke(entry.getKey(), (String) obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            if (z10 || !arrayList.isEmpty()) {
                oVar.put(entry.getKey(), arrayList);
            }
        }
        return new q1(o1Var.a(), oVar);
    }

    public static /* synthetic */ o1 i(o1 o1Var, boolean z10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(o1Var, z10, pVar);
    }

    @os.l
    public static final List<lm.t0<String, String>> j(@os.l o1 o1Var) {
        kn.l0.p(o1Var, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = o1Var.entries();
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
        return arrayList;
    }

    public static final void k(@os.l o1 o1Var, @os.l jn.p<? super String, ? super String, l2> pVar) {
        kn.l0.p(o1Var, "<this>");
        kn.l0.p(pVar, "block");
        o1Var.e(new b(pVar));
    }

    @os.l
    public static final Map<String, List<String>> l(@os.l o1 o1Var) {
        kn.l0.p(o1Var, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = o1Var.entries();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put((String) entry.getKey(), nm.h0.V5((Iterable) entry.getValue()));
        }
        return linkedHashMap;
    }

    @os.l
    public static final o1 m() {
        o1.f6082a.getClass();
        return o1.a.f6084b;
    }

    @os.l
    public static final o1 n(@os.l String str, @os.l String str2, boolean z10) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return new s1(z10, str, nm.x.k(str2));
    }

    @os.l
    public static final o1 o(@os.l String str, @os.l List<String> list, boolean z10) {
        kn.l0.p(str, "name");
        kn.l0.p(list, "values");
        return new s1(z10, str, list);
    }

    @os.l
    public static final o1 p(@os.l Map<String, ? extends Iterable<String>> map, boolean z10) {
        kn.l0.p(map, "map");
        int size = map.size();
        if (size == 1) {
            Map.Entry entry = (Map.Entry) nm.h0.f5(map.entrySet());
            return new s1(z10, (String) entry.getKey(), nm.h0.V5((Iterable) entry.getValue()));
        }
        Map oVar = z10 ? new o() : new LinkedHashMap(size);
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            oVar.put(entry2.getKey(), nm.h0.V5((Iterable) entry2.getValue()));
        }
        return new q1(z10, oVar);
    }

    @os.l
    public static final o1 q(@os.l lm.t0<String, ? extends List<String>>[] t0VarArr, boolean z10) {
        kn.l0.p(t0VarArr, "pairs");
        return new q1(z10, nm.d1.D0(nm.p.t(t0VarArr)));
    }

    public static /* synthetic */ o1 r(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return n(str, str2, z10);
    }

    public static /* synthetic */ o1 s(String str, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return o(str, list, z10);
    }

    public static /* synthetic */ o1 t(Map map, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return p(map, z10);
    }

    public static /* synthetic */ o1 u(lm.t0[] t0VarArr, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return q(t0VarArr, z10);
    }
}
