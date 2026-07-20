package oi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f8563a;

    public x(Ref.ObjectRef objectRef) {
        this.f8563a = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        Ref.ObjectRef objectRef = this.f8563a;
        if (objectRef.element != pi.c.f8895b) {
            throw new IllegalArgumentException("Flow has more than one element");
        }
        objectRef.element = obj;
        return Unit.INSTANCE;
    }
}
