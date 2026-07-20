package li;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends t1 {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f7480h;

    public /* synthetic */ n(l lVar, int i8) {
        this.e = i8;
        this.f7480h = lVar;
    }

    @Override // li.t1
    public final boolean j() {
        switch (this.e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // li.t1
    public final void k(Throwable th2) {
        l lVar = this.f7480h;
        switch (this.e) {
            case 0:
                Throwable thQ = lVar.q(i());
                if (lVar.x()) {
                    Continuation continuation = lVar.f7467d;
                    Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
                    qi.f fVar = (qi.f) continuation;
                    fVar.getClass();
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qi.f.f9140j;
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        a8.a aVar = qi.g.f9145b;
                        if (Intrinsics.areEqual(obj, aVar)) {
                            if (atomicReferenceFieldUpdater.compareAndSet(fVar, aVar, thQ)) {
                                break;
                            }
                        } else if (obj instanceof Throwable) {
                            break;
                        } else if (atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        }
                    }
                }
                lVar.b(thQ);
                if (!lVar.x()) {
                    lVar.n();
                }
                break;
            default:
                Result.Companion companion = Result.INSTANCE;
                lVar.resumeWith(Result.m159constructorimpl(Unit.INSTANCE));
                break;
        }
    }
}
