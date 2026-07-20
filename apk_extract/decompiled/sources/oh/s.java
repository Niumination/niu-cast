package oh;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f8519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f8520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8521d;
    public final boolean e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f8522g;

    public s(boolean z2, y yVar, byte[] bArr, boolean z3, boolean z5, boolean z10) {
        this.f8518a = z2;
        this.f8519b = yVar;
        this.f8520c = bArr;
        this.f8521d = z3;
        this.e = z5;
        this.f = z10;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        this.f8522g = byteBufferWrap;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Frame ");
        sb2.append(this.f8519b);
        sb2.append(" (fin=");
        sb2.append(this.f8518a);
        sb2.append(", buffer len = ");
        return a1.a.r(sb2, this.f8520c.length, ')');
    }
}
