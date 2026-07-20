package r2;

import java.util.Arrays;
import kn.l0;
import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final a f14166i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14167j = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final byte[] f14168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte f14170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f14171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final short f14172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final byte[] f14173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f14174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f14175h;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public i(@os.l byte[] bArr, long j10, byte b10, byte b11, short s10, @os.m byte[] bArr2, long j11, long j12) {
        l0.p(bArr, "header");
        this.f14168a = bArr;
        this.f14169b = j10;
        this.f14170c = b10;
        this.f14171d = b11;
        this.f14172e = s10;
        this.f14173f = bArr2;
        this.f14174g = j11;
        this.f14175h = j12;
    }

    @os.l
    public final byte[] a() {
        return this.f14168a;
    }

    public final long b() {
        return this.f14169b;
    }

    public final byte c() {
        return this.f14170c;
    }

    public final byte d() {
        return this.f14171d;
    }

    public final short e() {
        return this.f14172e;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l0.g(i.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.bean.FileDataHeader");
        i iVar = (i) obj;
        if (!Arrays.equals(this.f14168a, iVar.f14168a) || this.f14169b != iVar.f14169b || this.f14170c != iVar.f14170c || this.f14171d != iVar.f14171d || this.f14172e != iVar.f14172e) {
            return false;
        }
        byte[] bArr = this.f14173f;
        if (bArr != null) {
            byte[] bArr2 = iVar.f14173f;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (iVar.f14173f != null) {
            return false;
        }
        return this.f14174g == iVar.f14174g && this.f14175h == iVar.f14175h;
    }

    @os.m
    public final byte[] f() {
        return this.f14173f;
    }

    public final long g() {
        return this.f14174g;
    }

    public final long h() {
        return this.f14175h;
    }

    public int hashCode() {
        int iHashCode = (((((((Long.hashCode(this.f14169b) + (Arrays.hashCode(this.f14168a) * 31)) * 31) + this.f14170c) * 31) + this.f14171d) * 31) + this.f14172e) * 31;
        byte[] bArr = this.f14173f;
        return Long.hashCode(this.f14175h) + ((Long.hashCode(this.f14174g) + ((iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31)) * 31);
    }

    @os.l
    public final i i(@os.l byte[] bArr, long j10, byte b10, byte b11, short s10, @os.m byte[] bArr2, long j11, long j12) {
        l0.p(bArr, "header");
        return new i(bArr, j10, b10, b11, s10, bArr2, j11, j12);
    }

    public final byte k() {
        return this.f14171d;
    }

    public final byte l() {
        return this.f14170c;
    }

    @os.m
    public final byte[] m() {
        return this.f14173f;
    }

    public final short n() {
        return this.f14172e;
    }

    public final long o() {
        return this.f14169b;
    }

    @os.l
    public final byte[] p() {
        return this.f14168a;
    }

    public final long q() {
        return this.f14175h;
    }

    public final long r() {
        return this.f14174g;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FileDataHeader(header=");
        sb2.append(Arrays.toString(this.f14168a));
        sb2.append(", fileId=");
        sb2.append(this.f14169b);
        sb2.append(", check=");
        sb2.append((int) this.f14170c);
        sb2.append(", algorithm=");
        sb2.append((int) this.f14171d);
        sb2.append(", checkLen=");
        sb2.append((int) this.f14172e);
        sb2.append(", checkCode=");
        sb2.append(Arrays.toString(this.f14173f));
        sb2.append(", offset=");
        sb2.append(this.f14174g);
        sb2.append(", length=");
        return k0.a(sb2, this.f14175h, ')');
    }

    public /* synthetic */ i(byte[] bArr, long j10, byte b10, byte b11, short s10, byte[] bArr2, long j11, long j12, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? new byte[]{65, 73, 82, 84} : bArr, j10, (i10 & 4) != 0 ? (byte) 0 : b10, (i10 & 8) != 0 ? (byte) 0 : b11, (i10 & 16) != 0 ? (short) 0 : s10, (i10 & 32) != 0 ? null : bArr2, (i10 & 64) != 0 ? 0L : j11, j12);
    }
}
