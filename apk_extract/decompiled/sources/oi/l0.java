package oi;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends pi.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8559a = new AtomicReference(null);

    @Override // pi.d
    public final boolean a(pi.b bVar) {
        AtomicReference atomicReference = this.f8559a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(j.f8555b);
        return true;
    }

    @Override // pi.d
    public final Continuation[] b(pi.b bVar) {
        this.f8559a.set(null);
        return pi.c.f8894a;
    }

    public final Object c(j0 j0Var) {
        li.l lVar = new li.l(1, IntrinsicsKt.intercepted(j0Var));
        lVar.s();
        if (!this.f8559a.compareAndSet(j.f8555b, lVar)) {
            Result.Companion companion = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(Unit.INSTANCE));
        }
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(j0Var);
        }
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }
}
