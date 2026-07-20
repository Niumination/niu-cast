package nb;

import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageRequest;
import df.m;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import jb.e;
import jb.f;
import jb.g;
import jb.o;
import k3.gc;
import k3.pb;
import k3.tb;
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
public final class c extends SuspendLambda implements Function2 {
    int label;

    public c(Continuation<? super c> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objB;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("PcModuleServiceLife", "tag");
            Intrinsics.checkNotNullParameter("updateLocalPhoneData", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PcModuleServiceLife"), "updateLocalPhoneData");
            }
            o oVar = o.f6142b;
            this.label = 1;
            oVar.getClass();
            Intrinsics.checkNotNullParameter("", "default");
            Intrinsics.checkNotNullParameter("model_id", "key");
            Intrinsics.checkNotNullParameter("", "defaultVal");
            SharedPreferences sharedPreferences = vb.f6684a;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences = null;
            }
            String string = sharedPreferences.getString("model_id", "");
            String str = string != null ? string : "";
            if (str.length() > 0) {
                String log = "updateLocalPhoneData, modelId=".concat(str);
                Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("PhoneDataRepository"), log);
                }
                objB = Unit.INSTANCE;
            } else {
                Intrinsics.checkNotNullParameter("latest_timestamp", "key");
                SharedPreferences sharedPreferences2 = vb.f6684a;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences2 = null;
                }
                long j8 = sharedPreferences2.getLong("latest_timestamp", 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z2 = jCurrentTimeMillis - j8 > 86400000;
                String log2 = "call getPhoneDataRemote, isOver24H:" + z2 + ", currentTimestamp:" + jCurrentTimeMillis + ", latestTimestamp:" + j8;
                Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PhoneDataRepository"), log2);
                }
                if (!z2 || (objB = oVar.b(this)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
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
        f fVar = f.f6135a;
        String saveDirPath = pb.a().getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(saveDirPath, "getAbsolutePath(...)");
        String languageCode = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(languageCode, "toString(...)");
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String brand = tb.a(BRAND);
        Intrinsics.checkNotNullParameter(saveDirPath, "saveDirPath");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter("1.3.1.227", "appVersion");
        Intrinsics.checkNotNullParameter(brand, "brand");
        e eVarA = f.a();
        g gVar = f.f6136b;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
            gVar = null;
        }
        gVar.getClass();
        eVarA.getClass();
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter("1.3.1.227", "appVersion");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(saveDirPath, "saveDirPath");
        l0.p(eVarA, null, null, new jb.a(eVarA, "1.3.1.227", brand, languageCode, 0, saveDirPath, null), 3);
        String languageCode2 = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(languageCode2, "toString(...)");
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String brand2 = tb.a(BRAND);
        Intrinsics.checkNotNullParameter(languageCode2, "languageCode");
        Intrinsics.checkNotNullParameter("1.3.1.227", "appVersion");
        Intrinsics.checkNotNullParameter(brand2, "brand");
        e eVarA2 = f.a();
        g gVar2 = f.f6136b;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
            gVar2 = null;
        }
        gVar2.getClass();
        eVarA2.getClass();
        Intrinsics.checkNotNullParameter(languageCode2, "languageCode");
        Intrinsics.checkNotNullParameter("1.3.1.227", "appVersion");
        Intrinsics.checkNotNullParameter(brand2, "brand");
        eVarA2.f6134b.getClass();
        Intrinsics.checkNotNullParameter("sp_search_check_update_time", "key");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences3 = null;
        }
        if (System.currentTimeMillis() - sharedPreferences3.getLong("sp_search_check_update_time", 0L) > 86400000) {
            Map requestHeader = MapsKt.mapOf(TuplesKt.to("appVersion", "1.3.1.227"), TuplesKt.to("brand", brand2), TuplesKt.to("appName", "pcconnect"), TuplesKt.to("eDevId", "11122"), TuplesKt.to("transId", UUID.randomUUID().toString()));
            SearchPageRequest requestBody = new SearchPageRequest(languageCode2, 0);
            m callback = new m(languageCode2, eVarA2, 0);
            o oVar2 = o.f6142b;
            oVar2.getClass();
            Intrinsics.checkNotNullParameter(requestHeader, "requestHeader");
            Intrinsics.checkNotNullParameter(requestBody, "requestBody");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
            Intrinsics.checkNotNullParameter("querySearchPageText", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("PhoneDataRepository"), "querySearchPageText");
            }
            l0.p(oVar2, o.e, null, new jb.m(requestHeader, requestBody, callback, null), 2);
        } else {
            Log.d("CacheDataSource", "checkFunctionGuideResourceUpdate: not check");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
