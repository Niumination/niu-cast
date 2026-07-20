package mg;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends SuspendLambda implements Function1 {
    final /* synthetic */ hh.f $$this$intercept;
    final /* synthetic */ Function4<g, r, Object, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function2<Object, hh.f, g> $contextInit;
    final /* synthetic */ String $handlerName;
    final /* synthetic */ zg.a $key;
    final /* synthetic */ Object $pluginConfig;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public x(zg.a aVar, String str, Function4<g, ? super r, Object, ? super Continuation<? super Unit>, ? extends Object> function4, Function2<Object, ? super hh.f, g> function2, Object obj, hh.f fVar, Continuation<? super x> continuation) {
        super(1, continuation);
        this.$key = aVar;
        this.$handlerName = str;
        this.$block = function4;
        this.$contextInit = function2;
        this.$pluginConfig = obj;
        this.$$this$intercept = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new x(this.$key, this.$handlerName, this.$block, this.$contextInit, this.$pluginConfig, this.$$this$intercept, continuation);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to mg.x for r9v13 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mg.x.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((x) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
