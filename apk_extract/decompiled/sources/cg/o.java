package cg;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import m3.y5;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zf.i f1683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f1684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f1685d;

    public o(String text, zf.i contentType, z zVar) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.f1682a = text;
        this.f1683b = contentType;
        this.f1684c = zVar;
        Charset charsetA = y5.a(contentType);
        this.f1685d = lh.a.i(text, charsetA == null ? Charsets.UTF_8 : charsetA);
    }

    @Override // cg.j
    public final Long a() {
        return Long.valueOf(this.f1685d.length);
    }

    @Override // cg.j
    public final zf.i b() {
        return this.f1683b;
    }

    @Override // cg.j
    public final z d() {
        return this.f1684c;
    }

    @Override // cg.f
    public final byte[] e() {
        return this.f1685d;
    }

    public final String toString() {
        return "TextContent[" + this.f1683b + "] \"" + StringsKt.take(this.f1682a, 30) + Typography.quote;
    }
}
