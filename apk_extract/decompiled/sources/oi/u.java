package oi;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f8562a;

    public u(Ref.ObjectRef objectRef) {
        this.f8562a = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        this.f8562a.element = obj;
        throw new pi.a(this);
    }
}
