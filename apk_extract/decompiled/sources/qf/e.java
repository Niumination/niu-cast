package qf;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SuspendLambda f9055b;

    public e(a hook, SuspendLambda suspendLambda) {
        Intrinsics.checkNotNullParameter(hook, "hook");
        this.f9054a = hook;
        this.f9055b = suspendLambda;
    }
}
