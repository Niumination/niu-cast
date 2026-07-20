package ze;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class k1 extends m1 {
    public final l1 e;

    public k1(String str, l1 l1Var) {
        super(str, false, l1Var);
        v8.g(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        v8.i(l1Var, "marshaller");
        this.e = l1Var;
    }

    @Override // ze.m1
    public final Object a(byte[] bArr) {
        return this.e.c(new String(bArr, h4.f.f5247a));
    }

    @Override // ze.m1
    public final byte[] b(Object obj) {
        String strA = this.e.a(obj);
        v8.i(strA, "null marshaller.toAsciiString()");
        return strA.getBytes(h4.f.f5247a);
    }
}
