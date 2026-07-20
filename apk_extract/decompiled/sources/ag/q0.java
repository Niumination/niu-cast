package ag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f783d;
    public final CharSequence e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(CharSequence version, int i8, CharSequence statusText, v headers, bg.c builder) {
        super(headers, builder);
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f782c = version;
        this.f783d = i8;
        this.e = statusText;
    }
}
