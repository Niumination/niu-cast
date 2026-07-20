package androidx.activity;

import androidx.lifecycle.PausingDispatcherKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.activity.ComponentActivity$onBackPressedDispatcher$2$2$1", f = "ComponentActivity.kt", i = {}, l = {644}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentActivity$onBackPressedDispatcher$2$2$1 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedDispatcher $dispatcher;
    int label;
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: renamed from: androidx.activity.ComponentActivity$onBackPressedDispatcher$2$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.activity.ComponentActivity$onBackPressedDispatcher$2$2$1$1", f = "ComponentActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnBackPressedDispatcher $dispatcher;
        int label;
        final /* synthetic */ ComponentActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$dispatcher = onBackPressedDispatcher;
            this.this$0 = componentActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$dispatcher, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$dispatcher.setOnBackInvokedDispatcher(ComponentActivity.Api33Impl.INSTANCE.getOnBackInvokedDispatcher(this.this$0));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentActivity$onBackPressedDispatcher$2$2$1(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher, Continuation<? super ComponentActivity$onBackPressedDispatcher$2$2$1> continuation) {
        super(2, continuation);
        this.this$0 = componentActivity;
        this.$dispatcher = onBackPressedDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComponentActivity$onBackPressedDispatcher$2$2$1(this.this$0, this.$dispatcher, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            ComponentActivity componentActivity = this.this$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$dispatcher, componentActivity, null);
            this.label = 1;
            if (PausingDispatcherKt.whenCreated(componentActivity, anonymousClass1, this) == coroutine_suspended) {
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
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((ComponentActivity$onBackPressedDispatcher$2$2$1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
