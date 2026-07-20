package dn;

import java.io.ByteArrayOutputStream;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ByteArrayOutputStream {
    public g(int i10) {
        super(i10);
    }

    @os.l
    public final byte[] b() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        l0.o(bArr, "buf");
        return bArr;
    }
}
