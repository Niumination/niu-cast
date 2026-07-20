package mg;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f8064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Continuation f8065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ClassLoader f8066c;

    public h(Continuation continuation, ClassLoader classLoader) {
        this.f8065b = continuation;
        this.f8066c = classLoader;
        this.f8064a = continuation.getContext();
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f8064a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Thread.currentThread().setContextClassLoader(this.f8066c);
        this.f8065b.resumeWith(obj);
    }
}
