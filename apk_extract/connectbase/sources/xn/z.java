package xn;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final ConcurrentMap<i0, WeakReference<jo.k>> f20437a = new ConcurrentHashMap();

    public static final void a() {
        f20437a.clear();
    }

    @os.l
    public static final jo.k b(@os.l Class<?> cls) {
        l0.p(cls, "<this>");
        ClassLoader classLoaderF = ko.d.f(cls);
        i0 i0Var = new i0(classLoaderF);
        ConcurrentMap<i0, WeakReference<jo.k>> concurrentMap = f20437a;
        WeakReference<jo.k> weakReference = concurrentMap.get(i0Var);
        if (weakReference != null) {
            jo.k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(i0Var, weakReference);
        }
        jo.k kVarA = jo.k.f8765c.a(classLoaderF);
        while (true) {
            try {
                ConcurrentMap<i0, WeakReference<jo.k>> concurrentMap2 = f20437a;
                WeakReference<jo.k> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(i0Var, new WeakReference<>(kVarA));
                if (weakReferencePutIfAbsent == null) {
                    i0Var.f20364c = null;
                    return kVarA;
                }
                jo.k kVar2 = weakReferencePutIfAbsent.get();
                if (kVar2 != null) {
                    i0Var.f20364c = null;
                    return kVar2;
                }
                concurrentMap2.remove(i0Var, weakReferencePutIfAbsent);
            } catch (Throwable th2) {
                i0Var.f20364c = null;
                throw th2;
            }
        }
    }
}
