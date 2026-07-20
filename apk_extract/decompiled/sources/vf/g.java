package vf;

import java.util.Calendar;
import java.util.Locale;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import zf.t;
import zf.y;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f10573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ch.d f10574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f10575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f10576d;
    public final Object e;
    public final CoroutineContext f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ch.d f10577g;

    public g(z statusCode, ch.d requestTime, t headers, y version, Object body, CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.f10573a = statusCode;
        this.f10574b = requestTime;
        this.f10575c = headers;
        this.f10576d = version;
        this.e = body;
        this.f = callContext;
        Calendar calendar = Calendar.getInstance(ch.a.f1686a, Locale.ROOT);
        Intrinsics.checkNotNull(calendar);
        this.f10577g = ch.a.a(calendar, null);
    }

    public final String toString() {
        return "HttpResponseData=(statusCode=" + this.f10573a + ')';
    }
}
