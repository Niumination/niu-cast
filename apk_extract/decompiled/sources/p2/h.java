package p2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h extends g {
    public final byte[] e;

    public h(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.e = bArr;
    }

    @Override // p2.g
    public final byte[] l() {
        return this.e;
    }
}
