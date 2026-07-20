package na;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f8131a = new ConcurrentHashMap();

    public static final void a(li.l lVar, Function1 onComplete) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        ConcurrentHashMap concurrentHashMap = f8131a;
        if (concurrentHashMap.contains(concurrentHashMap)) {
            return;
        }
        concurrentHashMap.put(lVar, onComplete);
    }

    public static final void b(li.j jVar, Object obj) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        if (!jVar.a()) {
            jVar.b(null);
            return;
        }
        jVar.resumeWith(Result.m159constructorimpl(obj));
        jVar.b(null);
        ConcurrentHashMap concurrentHashMap = f8131a;
        Function1 function1 = (Function1) concurrentHashMap.get(jVar);
        if (function1 != null) {
            function1.invoke(null);
        }
        concurrentHashMap.remove(jVar);
    }
}
