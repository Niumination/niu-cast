package ng;

import ag.o0;
import jh.j0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends SuspendLambda implements Function2 {
    final /* synthetic */ o0 $request;
    final /* synthetic */ og.k $this_handleRequest;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(p pVar, o0 o0Var, og.k kVar, Continuation<? super f> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
        this.$request = o0Var;
        this.$this_handleRequest = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        f fVar = new f(this.this$0, this.$request, this.$this_handleRequest, continuation);
        fVar.L$0 = obj;
        return fVar;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        b bVar;
        b bVar2;
        b bVar3;
        r rVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            try {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        bVar3 = (b) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            rVar = bVar3.f8247d;
                            o0 o0Var = rVar.f8270d;
                            o0Var.f798b.e();
                            o0Var.f797a.e();
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            o0 o0Var2 = bVar3.f8247d.f8270d;
                            o0Var2.f798b.e();
                            o0Var2.f797a.e();
                            throw th;
                        }
                    }
                    bVar2 = (b) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        rVar = bVar2.f8247d;
                    } catch (Throwable th3) {
                        th = th3;
                        bVar = bVar2;
                        this.L$0 = bVar;
                        this.label = 3;
                        if (qg.h.f(bVar, th, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bVar3 = bVar;
                        rVar = bVar3.f8247d;
                    }
                    o0 o0Var3 = rVar.f8270d;
                    o0Var3.f798b.e();
                    o0Var3.f797a.e();
                    return Unit.INSTANCE;
                }
                b bVar4 = (b) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    bVar = bVar4;
                } catch (Throwable th4) {
                    th = th4;
                    bVar = bVar4;
                    this.L$0 = bVar;
                    this.label = 3;
                    if (qg.h.f(bVar, th, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bVar3 = bVar;
                    rVar = bVar3.f8247d;
                }
                this.L$0 = bVar;
                this.label = 3;
                if (qg.h.f(bVar, th, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar3 = bVar;
                rVar = bVar3.f8247d;
                o0 o0Var4 = rVar.f8270d;
                o0Var4.f798b.e();
                o0Var4.f797a.e();
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                th = th5;
                bVar3 = bVar;
                o0 o0Var5 = bVar3.f8247d.f8270d;
                o0Var5.f798b.e();
                o0Var5.f797a.e();
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        g0 g0Var = (g0) this.L$0;
        mg.a aVar = (mg.a) this.this$0.f.invoke();
        o0 o0Var6 = this.$request;
        og.k kVar = this.$this_handleRequest;
        jh.o oVar = kVar.f8471b;
        p pVar = this.this$0;
        bVar = bVar;
        b bVar5 = new b(aVar, o0Var6, oVar, kVar.f8472c, pVar.f8264g, pVar.f8265h, kVar.f8474h, kVar.f8473d, kVar.e, g0Var.getCoroutineContext());
        try {
            p pVar2 = this.this$0;
            j0 j0Var = this.$this_handleRequest.f8472c;
            this.L$0 = bVar;
            this.label = 1;
            if (p.a(pVar2, j0Var, bVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (Throwable th6) {
            th = th6;
            this.L$0 = bVar;
            this.label = 3;
            if (qg.h.f(bVar, th, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar3 = bVar;
            rVar = bVar3.f8247d;
        }
        e eVar = new e(this.this$0.f8262c, bVar, null);
        this.L$0 = bVar;
        this.label = 2;
        if (dh.c.a(eVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar2 = bVar;
        rVar = bVar2.f8247d;
        o0 o0Var7 = rVar.f8270d;
        o0Var7.f798b.e();
        o0Var7.f797a.e();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
