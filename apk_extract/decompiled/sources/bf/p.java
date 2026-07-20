package bf;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.j2;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements j2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f1288b = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.y f1289a;

    public p(ze.y grpcContext) {
        Intrinsics.checkNotNullParameter(grpcContext, "grpcContext");
        this.f1289a = grpcContext;
    }

    public final void b(CoroutineContext context, Object obj) {
        ze.y oldState = (ze.y) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        this.f1289a.k(oldState);
    }

    public final Object c(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ze.y yVarC = this.f1289a.c();
        Intrinsics.checkNotNullExpressionValue(yVarC, "grpcContext.attach()");
        return yVarC;
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
        return f1288b;
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
