package fl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Map<String, List<String>> f6088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6089c;

    public static final class a extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        public a() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "values");
            p1.this.c(str, list);
        }
    }

    public static final class b extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        public b() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "values");
            p1.this.e(str, list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p1() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public final void a(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        y(str2);
        j(str, 1).add(str2);
    }

    public final void b(@os.l o1 o1Var) {
        kn.l0.p(o1Var, "stringValues");
        o1Var.e(new a());
    }

    public final void c(@os.l String str, @os.l Iterable<String> iterable) {
        kn.l0.p(str, "name");
        kn.l0.p(iterable, "values");
        Collection collection = iterable instanceof Collection ? (Collection) iterable : null;
        List<String> listJ = j(str, collection == null ? 2 : collection.size());
        for (String str2 : iterable) {
            y(str2);
            listJ.add(str2);
        }
    }

    public final void d(@os.l o1 o1Var) {
        kn.l0.p(o1Var, "stringValues");
        o1Var.e(new b());
    }

    public final void e(@os.l String str, @os.l Iterable<String> iterable) {
        kn.l0.p(str, "name");
        kn.l0.p(iterable, "values");
        List<String> list = this.f6088b.get(str);
        Set setA6 = list == null ? null : nm.h0.a6(list);
        if (setA6 == null) {
            setA6 = nm.m0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : iterable) {
            if (!setA6.contains(str2)) {
                arrayList.add(str2);
            }
        }
        c(str, arrayList);
    }

    @os.l
    public o1 f() {
        if (this.f6089c) {
            throw new IllegalArgumentException("ValueMapBuilder can only build a single ValueMap");
        }
        this.f6089c = true;
        return new q1(this.f6087a, this.f6088b);
    }

    public final void g() {
        this.f6088b.clear();
    }

    public final boolean h(@os.l String str) {
        kn.l0.p(str, "name");
        return this.f6088b.containsKey(str);
    }

    public final boolean i(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        List<String> list = this.f6088b.get(str);
        if (list == null) {
            return false;
        }
        return list.contains(str2);
    }

    public final List<String> j(String str, int i10) {
        if (this.f6089c) {
            throw new IllegalStateException("Cannot modify a builder after build() function already invoked. Make sure you call build() last.");
        }
        List<String> list = this.f6088b.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(i10);
        x(str);
        this.f6088b.put(str, arrayList);
        return arrayList;
    }

    @os.l
    public final Set<Map.Entry<String, List<String>>> k() {
        return s.a(this.f6088b.entrySet());
    }

    @os.m
    public final String l(@os.l String str) {
        kn.l0.p(str, "name");
        List<String> listM = m(str);
        if (listM == null) {
            return null;
        }
        return (String) nm.h0.G2(listM);
    }

    @os.m
    public final List<String> m(@os.l String str) {
        kn.l0.p(str, "name");
        return this.f6088b.get(str);
    }

    public final boolean n() {
        return this.f6089c;
    }

    public final boolean o() {
        return this.f6087a;
    }

    @os.l
    public final Map<String, List<String>> p() {
        return this.f6088b;
    }

    public final boolean q() {
        return this.f6088b.isEmpty();
    }

    @os.l
    public final Set<String> r() {
        return this.f6088b.keySet();
    }

    public final void s(@os.l String str) {
        kn.l0.p(str, "name");
        this.f6088b.remove(str);
    }

    public final boolean t(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        List<String> list = this.f6088b.get(str);
        if (list == null) {
            return false;
        }
        return list.remove(str2);
    }

    public final void u() {
        Map<String, List<String>> map = this.f6088b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            s((String) ((Map.Entry) it.next()).getKey());
        }
    }

    public final void v(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        y(str2);
        List<String> listJ = j(str, 1);
        listJ.clear();
        listJ.add(str2);
    }

    public final void w(boolean z10) {
        this.f6089c = z10;
    }

    public void x(@os.l String str) {
        kn.l0.p(str, "name");
    }

    public void y(@os.l String str) {
        kn.l0.p(str, "value");
    }

    public p1(boolean z10, int i10) {
        this.f6087a = z10;
        this.f6088b = z10 ? new o<>() : new LinkedHashMap<>(i10);
    }

    public /* synthetic */ p1(boolean z10, int i10, int i11, kn.w wVar) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? 8 : i10);
    }
}
