package pi;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f8888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8890c;

    public final d c() {
        d dVarD;
        synchronized (this) {
            try {
                d[] dVarArrE = this.f8888a;
                if (dVarArrE == null) {
                    dVarArrE = e();
                    this.f8888a = dVarArrE;
                } else if (this.f8889b >= dVarArrE.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrE, dVarArrE.length * 2);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    this.f8888a = (d[]) objArrCopyOf;
                    dVarArrE = (d[]) objArrCopyOf;
                }
                int i8 = this.f8890c;
                do {
                    dVarD = dVarArrE[i8];
                    if (dVarD == null) {
                        dVarD = d();
                        dVarArrE[i8] = dVarD;
                    }
                    i8++;
                    if (i8 >= dVarArrE.length) {
                        i8 = 0;
                    }
                    Intrinsics.checkNotNull(dVarD, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVarD.a(this));
                this.f8890c = i8;
                this.f8889b++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVarD;
    }

    public abstract d d();

    public abstract d[] e();

    public final void f(d dVar) {
        int i8;
        Continuation[] continuationArrB;
        synchronized (this) {
            try {
                int i9 = this.f8889b - 1;
                this.f8889b = i9;
                if (i9 == 0) {
                    this.f8890c = 0;
                }
                Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                continuationArrB = dVar.b(this);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (Continuation continuation : continuationArrB) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m159constructorimpl(Unit.INSTANCE));
            }
        }
    }
}
