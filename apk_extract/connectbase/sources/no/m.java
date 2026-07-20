package no;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final m f11762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final HashMap<dp.c, dp.c> f11763b;

    static {
        m mVar = new m();
        f11762a = mVar;
        f11763b = new HashMap<>();
        mVar.c(ao.k.a.Y, mVar.a("java.util.ArrayList", "java.util.LinkedList"));
        mVar.c(ao.k.a.f572a0, mVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        mVar.c(ao.k.a.f574b0, mVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        mVar.c(new dp.c("java.util.function.Function"), mVar.a("java.util.function.UnaryOperator"));
        mVar.c(new dp.c("java.util.function.BiFunction"), mVar.a("java.util.function.BinaryOperator"));
    }

    public final List<dp.c> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            arrayList.add(new dp.c(str));
        }
        return arrayList;
    }

    @os.m
    public final dp.c b(@os.l dp.c cVar) {
        l0.p(cVar, "classFqName");
        return f11763b.get(cVar);
    }

    public final void c(dp.c cVar, List<dp.c> list) {
        HashMap<dp.c, dp.c> map = f11763b;
        for (Object obj : list) {
            map.put((dp.c) obj, cVar);
        }
    }
}
