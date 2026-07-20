package bf;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    private final CoroutineContext context;

    public a(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public CoroutineContext getContext() {
        return this.context;
    }
}
