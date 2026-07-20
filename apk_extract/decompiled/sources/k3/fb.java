package k3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class fb {
    public static ArrayList a(List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : protocols) {
            if (((dj.d0) obj) != dj.d0.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((dj.d0) it.next()).toString());
        }
        return arrayList2;
    }

    public static byte[] b(List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        qj.f fVar = new qj.f();
        for (String str : a(protocols)) {
            fVar.S(str.length());
            fVar.m0(str);
        }
        return fVar.m(fVar.f9195b);
    }

    public static boolean c() {
        return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
    }
}
