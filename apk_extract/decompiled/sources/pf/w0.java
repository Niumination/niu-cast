package pf;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3 f8877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f8878b;

    public w0(Function3 interceptor, m1 nextSender) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        Intrinsics.checkNotNullParameter(nextSender, "nextSender");
        this.f8877a = interceptor;
        this.f8878b = nextSender;
    }

    @Override // pf.m1
    public final Object a(vf.c cVar, ContinuationImpl continuationImpl) {
        return this.f8877a.invoke(this.f8878b, cVar, continuationImpl);
    }
}
