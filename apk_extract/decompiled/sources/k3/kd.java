package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class kd {
    public static final sf.d a(kf.c originCall, jh.o content) {
        Intrinsics.checkNotNullParameter(originCall, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        jf.d client = originCall.f6855a;
        zf.r responseHeaders = originCall.e().a();
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(originCall, "originCall");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        return new sf.d(client, new ag.a(content, 16), originCall, responseHeaders);
    }
}
