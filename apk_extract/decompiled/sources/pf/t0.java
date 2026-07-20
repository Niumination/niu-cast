package pf;

import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m3.e6;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends IOException implements li.x {
    private final Long timeoutMillis;
    private final String url;

    public t0(vf.c request) {
        Intrinsics.checkNotNullParameter(request, "request");
        zf.j0 j0Var = request.f10557a;
        j0Var.a();
        StringBuilder sb2 = new StringBuilder(256);
        e6.a(j0Var, sb2);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        z0 key = z0.f8882a;
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = (Map) request.f.d(mf.j.f8037a);
        a1 a1Var = (a1) (map != null ? map.get(key) : null);
        this(string, a1Var != null ? a1Var.f8822a : null, null, 4, null);
    }

    @Override // li.x
    public t0 createCopy() {
        return new t0(this.url, this.timeoutMillis, getCause());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public t0(vf.d request) {
        Intrinsics.checkNotNullParameter(request, "request");
        zf.r0 r0Var = request.f10561a;
        a1 a1Var = (a1) request.a();
        Long l4 = a1Var != null ? a1Var.f8822a : null;
        this(r0Var.f, l4, null, 4, null);
    }

    public /* synthetic */ t0(String str, Long l4, Throwable th2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l4, (i8 & 4) != 0 ? null : th2);
    }

    public t0(String url, Long l4, Throwable th2) {
        Intrinsics.checkNotNullParameter(url, "url");
        StringBuilder sb2 = new StringBuilder("Request timeout has expired [url=");
        sb2.append(url);
        sb2.append(", request_timeout=");
        sb2.append(l4 == null ? EnvironmentCompat.MEDIA_UNKNOWN : l4);
        sb2.append(" ms]");
        super(sb2.toString(), th2);
        this.url = url;
        this.timeoutMillis = l4;
    }
}
