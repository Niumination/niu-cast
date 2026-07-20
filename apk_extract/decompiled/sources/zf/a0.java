package zf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends IllegalArgumentException {
    private final String headerName;
    private final int position;

    public a0(String headerName, int i8) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        StringBuilder sb2 = new StringBuilder("Header name '");
        sb2.append(headerName);
        sb2.append("' contains illegal character '");
        sb2.append(headerName.charAt(i8));
        sb2.append("' (code ");
        super(a1.a.r(sb2, headerName.charAt(i8) & 255, ')'));
        this.headerName = headerName;
        this.position = i8;
    }

    public final String getHeaderName() {
        return this.headerName;
    }

    public final int getPosition() {
        return this.position;
    }
}
