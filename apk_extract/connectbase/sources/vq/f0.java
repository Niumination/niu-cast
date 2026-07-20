package vq;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kn.r1;
import nq.x2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final f0 f17837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f17838b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    @os.l
    public static final x2 f17839c;

    static {
        f0 f0Var = new f0();
        f17837a = f0Var;
        z0.d(g0.f17842a, true);
        f17839c = f0Var.a();
    }

    public final x2 a() {
        Object next;
        x2 x2VarF;
        try {
            List listC3 = gq.v.c3(gq.s.e(ServiceLoader.load(e0.class, e0.class.getClassLoader()).iterator()));
            Iterator it = listC3.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((e0) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((e0) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            e0 e0Var = (e0) next;
            if (e0Var != null && (x2VarF = g0.f(e0Var, listC3)) != null) {
                return x2VarF;
            }
            return g0.b(null, null, 3, null);
        } catch (Throwable th2) {
            return g0.b(th2, null, 2, null);
        }
    }
}
