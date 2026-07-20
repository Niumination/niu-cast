package k3;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class nd {
    public static final tg.a a(mg.a aVar) {
        tg.a aVar2;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Iterator it = CollectionsKt.toList(mg.e.a(aVar).c().keySet()).iterator();
        do {
            aVar2 = null;
            if (!it.hasNext()) {
                break;
            }
            zg.a aVar3 = (zg.a) it.next();
            zg.h hVarA = mg.e.a(aVar);
            Intrinsics.checkNotNull(aVar3, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            Object objD = hVarA.d(aVar3);
            if (objD instanceof tg.a) {
                aVar2 = (tg.a) objD;
            }
        } while (aVar2 == null);
        return aVar2 == null ? tg.a.f10217a : aVar2;
    }
}
