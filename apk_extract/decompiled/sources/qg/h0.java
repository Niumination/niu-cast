package qg;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements li.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ag.a f9074a;

    public h0(vj.b logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        ag.a logger2 = new ag.a(logger, 12);
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.f9074a = logger2;
    }

    @Override // li.c0
    public final void L(CoroutineContext context, Throwable exception) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ((exception instanceof CancellationException) || (exception instanceof IOException)) {
            return;
        }
        Object string = (li.f0) context.get(li.f0.f7449b);
        if (string == null) {
            string = context.toString();
        }
        ((vj.b) this.f9074a.f753b).error("Unhandled exception caught for " + string, exception);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return CoroutineContext.Element.DefaultImpls.fold(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return li.b0.f7433a;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }
}
