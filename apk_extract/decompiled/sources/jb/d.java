package jb;

import android.content.SharedPreferences;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageResponse;
import k3.vb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ int $defaultVersion;
    final /* synthetic */ SearchPageResponse $info;
    int label;
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchPageResponse searchPageResponse, int i8, e eVar, Continuation<? super d> continuation) {
        super(2, continuation);
        this.$info = searchPageResponse;
        this.$defaultVersion = i8;
        this.this$0 = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.$info, this.$defaultVersion, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$info.getVersion() <= this.$defaultVersion) {
            Log.d("CacheDataSource", "updateSearchPageResource: server version is not newer than default version");
            return Unit.INSTANCE;
        }
        this.this$0.f6134b.getClass();
        int iF = dc.b.f();
        if (iF >= this.$info.getVersion()) {
            Log.d("CacheDataSource", "updateSearchPageResource: server version is not newer than cache version");
            return Unit.INSTANCE;
        }
        this.this$0.f6134b.getClass();
        dc.b.b(iF);
        dc.b bVar = this.this$0.f6134b;
        int version = this.$info.getVersion();
        SearchPageResponse record = this.$info;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(record, "record");
        String value = na.b.b(record);
        String key = "sp_search_page_cache" + version;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferences = vb.f6684a;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, value);
        editorEdit.apply();
        dc.b bVar2 = this.this$0.f6134b;
        int version2 = this.$info.getVersion();
        bVar2.getClass();
        Intrinsics.checkNotNullParameter("sp_search_cache_version", "key");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
        editorEdit2.putInt("sp_search_cache_version", version2);
        editorEdit2.apply();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
