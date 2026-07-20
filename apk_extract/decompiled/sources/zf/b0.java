package zf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends IllegalArgumentException {
    private final String headerValue;
    private final int position;

    public b0(String headerValue, int i8) {
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        StringBuilder sb2 = new StringBuilder("Header value '");
        sb2.append(headerValue);
        sb2.append("' contains illegal character '");
        sb2.append(headerValue.charAt(i8));
        sb2.append("' (code ");
        super(a1.a.r(sb2, headerValue.charAt(i8) & 255, ')'));
        this.headerValue = headerValue;
        this.position = i8;
    }

    public final String getHeaderValue() {
        return this.headerValue;
    }

    public final int getPosition() {
        return this.position;
    }
}
