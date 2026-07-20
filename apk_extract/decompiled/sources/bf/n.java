package bf;

import java.util.logging.Logger;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import ze.f2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sj.a f1287a;

    static {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Logger logger = ze.y.f11473d;
        sj.a aVar = new sj.a("grpc-kotlin-coroutine-context", emptyCoroutineContext);
        Intrinsics.checkNotNullExpressionValue(aVar, "keyWithDefault(\"grpc-kot…\", EmptyCoroutineContext)");
        f1287a = aVar;
    }
}
