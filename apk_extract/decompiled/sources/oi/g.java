package oi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8544a;

    public g(h hVar) {
        this.f8544a = hVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, a8.a] */
    @Override // oi.h
    public final Object a(i iVar, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = pi.c.f8895b;
        Object objA = this.f8544a.a(new f(this, objectRef, iVar), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
