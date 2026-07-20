package ze;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends m1 {
    public final o1 e;

    public n1(String str, boolean z2, o1 o1Var) {
        super(str, z2, o1Var);
        v8.g(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        this.e = o1Var;
    }

    @Override // ze.m1
    public final Object a(byte[] bArr) {
        return this.e.d(bArr);
    }

    @Override // ze.m1
    public final byte[] b(Object obj) {
        byte[] bArrMo1a = this.e.mo1a(obj);
        v8.i(bArrMo1a, "null marshaller.toAsciiString()");
        return bArrMo1a;
    }
}
