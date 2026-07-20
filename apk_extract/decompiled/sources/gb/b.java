package gb;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import k3.k1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    final /* synthetic */ Application $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Application application, Continuation<? super b> continuation) {
        super(2, continuation);
        this.$context = application;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM159constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Context context = h7.b.f5268a;
        Application context2 = this.$context;
        Intrinsics.checkNotNullParameter(context2, "context");
        h7.b.f5268a = context2.getApplicationContext();
        k1.a("TransAtomicSDKManager", "initImpl:ver=5d29e5d,buildTime=1110-141329");
        try {
            Result.Companion companion = Result.INSTANCE;
            h7.b.b();
            Context context3 = h7.b.f5268a;
            boolean z2 = true;
            h7.b.f5269b = Settings.Secure.getInt(context3 != null ? context3.getContentResolver() : null, "super_power_saving_mode", 0) == 1;
            Context context4 = h7.b.f5268a;
            if (Settings.Secure.getInt(context4 != null ? context4.getContentResolver() : null, "os_reboot_to_repair_mode", 0) != 1) {
                z2 = false;
            }
            h7.b.f5270c = z2;
            context2.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("super_power_saving_mode"), false, h7.b.e);
            context2.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("os_reboot_to_repair_mode"), false, h7.b.f5271d);
            objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        if (thM162exceptionOrNullimpl != null) {
            k1.b("TransAtomicSDKManager", "init observer failed:" + thM162exceptionOrNullimpl.getMessage());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
