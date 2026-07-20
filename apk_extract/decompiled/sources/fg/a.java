package fg;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.spi.AbstractSelector;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import li.g0;
import ni.x;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends SuspendLambda implements Function2 {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [fg.a, kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.Closeable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        e eVar;
        AbstractSelector abstractSelector;
        Throwable th2;
        AbstractSelector abstractSelector2;
        ?? r7;
        AbstractSelector abstractSelector3;
        ?? r10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                AbstractSelector abstractSelectorOpenSelector = this.this$0.f5034a.openSelector();
                if (abstractSelectorOpenSelector == null) {
                    throw new IllegalStateException("openSelector() = null");
                }
                this.this$0.selectorRef = abstractSelectorOpenSelector;
                eVar = this.this$0;
                try {
                    n nVar = eVar.f5038h;
                    this.L$0 = abstractSelectorOpenSelector;
                    this.L$1 = eVar;
                    this.L$2 = abstractSelectorOpenSelector;
                    this.label = 1;
                    if (e.a(eVar, nVar, abstractSelectorOpenSelector, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AbstractSelector abstractSelector4 = abstractSelectorOpenSelector;
                    abstractSelector2 = abstractSelector4;
                    r10 = abstractSelector4;
                    eVar.closed = true;
                    eVar.f5038h.b();
                    eVar.selectorRef = null;
                    abstractSelector3 = abstractSelector2;
                    r7 = r10;
                } catch (Throwable th3) {
                    abstractSelector = abstractSelectorOpenSelector;
                    th2 = th3;
                    this = abstractSelector;
                    eVar.closed = true;
                    n nVar2 = eVar.f5038h;
                    nVar2.b();
                    e.A(abstractSelector, th2);
                    eVar.closed = true;
                    nVar2.b();
                    eVar.selectorRef = null;
                    abstractSelector3 = abstractSelector;
                    r7 = this;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                abstractSelector = (AbstractSelector) this.L$2;
                eVar = (e) this.L$1;
                this = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    abstractSelector2 = abstractSelector;
                    r10 = this;
                    eVar.closed = true;
                    eVar.f5038h.b();
                    eVar.selectorRef = null;
                    abstractSelector3 = abstractSelector2;
                    r7 = r10;
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        eVar.closed = true;
                        n nVar3 = eVar.f5038h;
                        nVar3.b();
                        e.A(abstractSelector, th2);
                        eVar.closed = true;
                        nVar3.b();
                        eVar.selectorRef = null;
                        abstractSelector3 = abstractSelector;
                        r7 = this;
                    } catch (Throwable th5) {
                        eVar.closed = true;
                        eVar.f5038h.b();
                        eVar.selectorRef = null;
                        e.A(abstractSelector, null);
                        throw th5;
                    }
                }
            }
            e.A(abstractSelector3, null);
            while (true) {
                s sVar = (s) eVar.f5038h.d();
                if (sVar == null) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(r7, null);
                    return Unit.INSTANCE;
                }
                e.t(sVar, new x("Failed to apply interest: selector closed"));
            }
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                CloseableKt.closeFinally(this, th6);
                throw th7;
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
