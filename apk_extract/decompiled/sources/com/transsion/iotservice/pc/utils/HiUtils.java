package com.transsion.iotservice.pc.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import bb.s;
import com.transsion.iotservice.pc.bean.ThumbBean;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0004\b\u000b\u0010\tR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/transsion/iotservice/pc/utils/HiUtils;", "", "<init>", "()V", "", "Lcom/transsion/iotservice/pc/bean/ThumbBean;", "thumbBeans", "", "turnListToJson", "(Ljava/util/List;)Ljava/lang/String;", "pcpaths", "turnListToSend", "Lv4/q;", "sGson$delegate", "Lkotlin/Lazy;", "getSGson", "()Lv4/q;", "sGson", "filetransfersdk_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HiUtils {
    public static final HiUtils INSTANCE = new HiUtils();

    /* JADX INFO: renamed from: sGson$delegate, reason: from kotlin metadata */
    private static final Lazy sGson = LazyKt.lazy(new s(9));

    private HiUtils() {
    }

    private final q getSGson() {
        return (q) sGson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q sGson_delegate$lambda$0() {
        return new q();
    }

    public final String turnListToJson(List<ThumbBean> thumbBeans) {
        Intrinsics.checkNotNullParameter(thumbBeans, "thumbBeans");
        String json = getSGson().toJson(thumbBeans);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final String turnListToSend(List<String> pcpaths) {
        Intrinsics.checkNotNullParameter(pcpaths, "pcpaths");
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = pcpaths.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append("#");
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
