package ao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.l0;
import nm.h0;
import nm.z;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c f519a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Set<dp.b> f520b;

    static {
        Set<i> set = i.NUMBER_TYPES;
        ArrayList arrayList = new ArrayList(z.b0(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(k.c((i) it.next()));
        }
        dp.c cVarL = k.a.f585h.l();
        l0.o(cVarL, "string.toSafe()");
        List listF4 = h0.F4(arrayList, cVarL);
        dp.c cVarL2 = k.a.f589j.l();
        l0.o(cVarL2, "_boolean.toSafe()");
        List listF5 = h0.F4(listF4, cVarL2);
        dp.c cVarL3 = k.a.f607s.l();
        l0.o(cVarL3, "_enum.toSafe()");
        List listF6 = h0.F4(listF5, cVarL3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listF6.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(dp.b.m((dp.c) it2.next()));
        }
        f520b = linkedHashSet;
    }

    @os.l
    public final Set<dp.b> a() {
        return f520b;
    }

    @os.l
    public final Set<dp.b> b() {
        return f520b;
    }
}
