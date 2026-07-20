package cm;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1670a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final bm.d<byte[]> f1671b = new C0070a();

    /* JADX INFO: renamed from: cm.a$a, reason: collision with other inner class name */
    public static final class C0070a extends bm.d<byte[]> {
        public C0070a() {
            super(128);
        }

        @Override // bm.d
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public final void t(@l byte[] bArr) {
            l0.p(bArr, "instance");
            if (bArr.length != 4096) {
                throw new IllegalArgumentException(c.a.a(new StringBuilder("Unable to recycle buffer of wrong size: "), bArr.length, " != 4096").toString());
            }
            super.t(bArr);
        }

        @Override // bm.d
        public byte[] n() {
            return new byte[4096];
        }

        @l
        public final byte[] y() {
            return new byte[4096];
        }
    }

    @l
    public static final bm.d<byte[]> a() {
        return f1671b;
    }
}
