package hg;

import java.nio.charset.Charset;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f5357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f5358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f5359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f5360d;

    static {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "master secret".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        f5357a = bytes;
        byte[] bytes2 = "key expansion".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        f5358b = bytes2;
        byte[] bytes3 = "client finished".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        f5359c = bytes3;
        byte[] bytes4 = "server finished".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        f5360d = bytes4;
    }

    public static final SecretKeySpec a(c suite, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(suite, "suite");
        return new SecretKeySpec(bArr, suite.p * 2, suite.f5346o, StringsKt__StringsKt.substringBefore$default(suite.e, "/", (String) null, 2, (Object) null));
    }

    public static final SecretKeySpec b(c suite, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(suite, "suite");
        int i8 = suite.p * 2;
        int i9 = suite.f5346o;
        return new SecretKeySpec(bArr, i8 + i9, i9, StringsKt__StringsKt.substringBefore$default(suite.e, "/", (String) null, 2, (Object) null));
    }
}
