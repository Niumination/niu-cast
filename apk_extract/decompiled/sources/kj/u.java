package kj;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public static int a(int i8, int i9, int i10) throws IOException {
        if ((i9 & 8) != 0) {
            i8--;
        }
        if (i10 <= i8) {
            return i8 - i10;
        }
        throw new IOException(o.d.f(i10, i8, "PROTOCOL_ERROR padding ", " > remaining length "));
    }
}
