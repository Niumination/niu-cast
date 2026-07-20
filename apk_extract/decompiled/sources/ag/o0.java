package ag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zf.x f775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f776d;
    public final CharSequence e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(zf.x method, CharSequence uri, CharSequence version, v headers, bg.c builder) {
        super(headers, builder);
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f775c = method;
        this.f776d = uri;
        this.e = version;
    }
}
