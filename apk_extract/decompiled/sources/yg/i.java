package yg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import xg.s;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2<l, Continuation<? super Unit>, Object> $handler;
    final /* synthetic */ boolean $negotiateExtensions;
    final /* synthetic */ String $protocol;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(String str, boolean z2, Function2<? super l, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super i> continuation) {
        super(2, continuation);
        this.$protocol = str;
        this.$negotiateExtensions = z2;
        this.$handler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        i iVar = new i(this.$protocol, this.$negotiateExtensions, this.$handler, continuation);
        iVar.L$0 = obj;
        return iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            s sVar = (s) this.L$0;
            xg.r rVar = sVar.f10988a;
            String str = this.$protocol;
            boolean z2 = this.$negotiateExtensions;
            KType kTypeTypeOf = null;
            h hVar = new h(this.$handler, sVar, null);
            this.label = 1;
            n nVar = new n(rVar, str, z2, hVar);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(n.class);
            try {
                kTypeTypeOf = Reflection.typeOf(n.class);
            } catch (Throwable unused) {
            }
            Object objB = rVar.B(nVar, new ih.a(orCreateKotlinClass, kTypeTypeOf), this);
            if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objB = Unit.INSTANCE;
            }
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(s sVar, Continuation<? super Unit> continuation) {
        return ((i) create(sVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
