package hh;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5401a;

    public f(Object context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5401a = context;
    }

    public abstract Object a(Object obj, ContinuationImpl continuationImpl);

    public abstract void b();

    public abstract Object d();

    public abstract Object e(Continuation continuation);

    public abstract Object f(Object obj, Continuation continuation);
}
