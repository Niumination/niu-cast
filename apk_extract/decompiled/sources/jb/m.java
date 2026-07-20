package jb;

import com.transsion.iotservice.multiscreen.pc.bean.SearchPageRequest;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageResponse;
import com.transsion.iotservice.multiscreen.pc.http.CloudInterface;
import com.transsion.iotservice.multiscreen.pc.http.RequestCallback;
import com.transsion.iotservice.multiscreen.pc.http.entity.BaseResponse;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ RequestCallback<SearchPageResponse> $callback;
    final /* synthetic */ SearchPageRequest $requestBody;
    final /* synthetic */ Map<String, String> $requestHeader;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Map<String, String> map, SearchPageRequest searchPageRequest, RequestCallback<SearchPageResponse> requestCallback, Continuation<? super m> continuation) {
        super(2, continuation);
        this.$requestHeader = map;
        this.$requestBody = searchPageRequest;
        this.$callback = requestCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m(this.$requestHeader, this.$requestBody, this.$callback, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BaseResponse baseResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            baseResponse = (BaseResponse) obj;
            if (baseResponse.isSuccess()) {
                RequestCallback.DefaultImpls.onResult$default(this.$callback, 0, baseResponse.getRet(), null, 4, null);
                return Unit.INSTANCE;
            }
            RequestCallback.DefaultImpls.onResult$default(this.$callback, 1, null, null, 4, null);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        o oVar = o.f6142b;
        this.label = 1;
        obj = oVar.d(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        Map<String, String> map = this.$requestHeader;
        SearchPageRequest searchPageRequest = this.$requestBody;
        this.label = 2;
        obj = ((CloudInterface) obj).querySearchPageTipText(map, searchPageRequest, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        baseResponse = (BaseResponse) obj;
        if (baseResponse.isSuccess()) {
            RequestCallback.DefaultImpls.onResult$default(this.$callback, 1, null, null, 4, null);
            return Unit.INSTANCE;
        }
        RequestCallback.DefaultImpls.onResult$default(this.$callback, 0, baseResponse.getRet(), null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((m) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
