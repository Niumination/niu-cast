package jb;

import android.content.SharedPreferences;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideRequest;
import java.util.Map;
import java.util.UUID;
import k3.gc;
import k3.vb;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    final /* synthetic */ String $appVersion;
    final /* synthetic */ String $brand;
    final /* synthetic */ int $defaultVersion;
    final /* synthetic */ String $languageCode;
    final /* synthetic */ String $saveDirPath;
    int label;
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, String str, String str2, String str3, int i8, String str4, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = eVar;
        this.$appVersion = str;
        this.$brand = str2;
        this.$languageCode = str3;
        this.$defaultVersion = i8;
        this.$saveDirPath = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(this.this$0, this.$appVersion, this.$brand, this.$languageCode, this.$defaultVersion, this.$saveDirPath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.f6134b.getClass();
        Intrinsics.checkNotNullParameter("sp_check_update_time", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - sharedPreferences.getLong("sp_check_update_time", 0L);
        String strO = o.d.o("isCheckFunctionGuideResourceUpdate: ", jCurrentTimeMillis > 86400000, "AppSharedPreference", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("AppSharedPreference"), strO);
        }
        if (jCurrentTimeMillis <= 86400000) {
            Log.d("CacheDataSource", "checkFunctionGuideResourceUpdate: not check");
            return Unit.INSTANCE;
        }
        Map requestHeader = MapsKt.mapOf(TuplesKt.to("appVersion", this.$appVersion), TuplesKt.to("brand", this.$brand), TuplesKt.to("appName", "pcconnect"), TuplesKt.to("eDevId", "11122"), TuplesKt.to("transId", UUID.randomUUID().toString()));
        FunctionGuideRequest requestBody = new FunctionGuideRequest(this.$languageCode, 0);
        i2.h callback = new i2.h(this.this$0, this.$defaultVersion, this.$appVersion, this.$languageCode, this.$saveDirPath);
        Log.d("CacheDataSource", "checkFunctionGuideResourceUpdate: start");
        o oVar = o.f6142b;
        oVar.getClass();
        Intrinsics.checkNotNullParameter(requestHeader, "requestHeader");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Intrinsics.checkNotNullParameter(callback, "callback");
        l0.p(oVar, o.e, null, new l(requestHeader, requestBody, callback, null), 2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
