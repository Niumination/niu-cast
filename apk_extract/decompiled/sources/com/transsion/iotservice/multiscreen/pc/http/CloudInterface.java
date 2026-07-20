package com.transsion.iotservice.multiscreen.pc.http;

import androidx.constraintlayout.widget.ConstraintLayout;
import bk.a;
import bk.f;
import bk.j;
import bk.o;
import bk.t;
import bk.w;
import bk.y;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideRequest;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideResponse;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageRequest;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageResponse;
import com.transsion.iotservice.multiscreen.pc.http.entity.BaseResponse;
import com.transsion.iotservice.multiscreen.pc.http.entity.PhoneDataEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import zj.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\r\u001a\u00020\fH§@¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u0011\u001a\u00020\nH'¢\u0006\u0004\b\u0014\u0010\u0015J6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\r\u001a\u00020\u0016H§@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/CloudInterface;", "", "", "clientType", "dataVersion", "Lcom/transsion/iotservice/multiscreen/pc/http/entity/BaseResponse;", "Lcom/transsion/iotservice/multiscreen/pc/http/entity/PhoneDataEntity;", "getPhoneData", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "headers", "Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideRequest;", "data", "Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideResponse;", "queryFunctionGuideData", "(Ljava/util/Map;Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileUrl", "Lzj/c;", "Ldj/m0;", "downloadResource", "(Ljava/lang/String;)Lzj/c;", "Lcom/transsion/iotservice/multiscreen/pc/bean/SearchPageRequest;", "Lcom/transsion/iotservice/multiscreen/pc/bean/SearchPageResponse;", "querySearchPageTipText", "(Ljava/util/Map;Lcom/transsion/iotservice/multiscreen/pc/bean/SearchPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface CloudInterface {
    @w
    @f
    c downloadResource(@y String fileUrl);

    @f("/welife/appliance/pcconnect/phone/list")
    Object getPhoneData(@t("clientType") int i8, @t("dataVersion") int i9, Continuation<? super BaseResponse<PhoneDataEntity>> continuation);

    @o("/welife/appliance/pcconnect/function/guide/page")
    Object queryFunctionGuideData(@j Map<String, String> map, @a FunctionGuideRequest functionGuideRequest, Continuation<? super BaseResponse<FunctionGuideResponse>> continuation);

    @o("/welife/appliance/pcconnect/process/text")
    Object querySearchPageTipText(@j Map<String, String> map, @a SearchPageRequest searchPageRequest, Continuation<? super BaseResponse<SearchPageResponse>> continuation);
}
