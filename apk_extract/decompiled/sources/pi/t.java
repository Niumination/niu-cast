package pi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f8907a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EmptyCoroutineContext f8908b = EmptyCoroutineContext.INSTANCE;

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public final CoroutineContext get$context() {
        return f8908b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
    }
}
