package ig;

import hg.h;
import hg.t0;
import hg.v0;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import wi.k;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hg.c f5868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f5869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5871d;

    public e(hg.c suite, byte[] keyMaterial) {
        Intrinsics.checkNotNullParameter(suite, "suite");
        Intrinsics.checkNotNullParameter(keyMaterial, "keyMaterial");
        this.f5868a = suite;
        this.f5869b = keyMaterial;
    }

    @Override // ig.g
    public final t0 a(t0 record) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(record, "record");
        k kVar = record.f5381c;
        long jE = lh.a.e(kVar);
        long j8 = kVar.readLong();
        long j10 = this.f5870c;
        this.f5870c = 1 + j10;
        hg.c suite = this.f5868a;
        Cipher cipher = Cipher.getInstance(suite.e);
        Intrinsics.checkNotNull(cipher);
        byte[] bArr = this.f5869b;
        SecretKeySpec secretKeySpecB = h.b(suite, bArr);
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(suite, "suite");
        int i8 = (suite.f5346o * 2) + (suite.p * 2);
        int i9 = suite.f5338g;
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, i8 + i9, (i9 * 2) + i8);
        int i10 = suite.f5339h;
        byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, i10);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        b.a(j8, bArrCopyOf, i9);
        int i11 = suite.f5340i;
        cipher.init(2, secretKeySpecB, new GCMParameterSpec(i11 * 8, bArrCopyOf));
        int i12 = (((int) jE) - (i10 - i9)) - i11;
        if (i12 >= 65536) {
            throw new IllegalStateException(a1.a.o(i12, "Content size should fit in 2 bytes, actual: ").toString());
        }
        byte[] bArr2 = new byte[13];
        b.a(j10, bArr2, 0);
        v0 v0Var = record.f5379a;
        bArr2[8] = (byte) v0Var.getCode();
        bArr2[9] = 3;
        bArr2[10] = 3;
        b.b(bArr2, (short) i12);
        cipher.updateAAD(bArr2);
        return new t0(v0Var, record.f5380b, c.a(kVar, cipher, new ag.b(11)));
    }

    @Override // ig.g
    public final t0 b(t0 record) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(record, "record");
        v0 v0Var = record.f5379a;
        k kVar = record.f5381c;
        int iE = (int) lh.a.e(kVar);
        long j8 = this.f5871d;
        hg.c suite = this.f5868a;
        Cipher cipher = Cipher.getInstance(suite.e);
        Intrinsics.checkNotNull(cipher);
        byte[] bArr = this.f5869b;
        SecretKeySpec secretKeySpecA = h.a(suite, bArr);
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(suite, "suite");
        int i8 = (suite.f5346o * 2) + (suite.p * 2);
        int i9 = suite.f5338g;
        byte[] bArrCopyOf = Arrays.copyOf(ArraysKt.copyOfRange(bArr, i8, i8 + i9), suite.f5339h);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        b.a(j8, bArrCopyOf, i9);
        cipher.init(1, secretKeySpecA, new GCMParameterSpec(suite.f5340i * 8, bArrCopyOf));
        byte[] bArr2 = new byte[13];
        b.a(j8, bArr2, 0);
        bArr2[8] = (byte) v0Var.getCode();
        bArr2[9] = 3;
        bArr2[10] = 3;
        b.b(bArr2, (short) iE);
        cipher.updateAAD(bArr2);
        wi.a aVarA = c.a(kVar, cipher, new d(0, this.f5871d));
        this.f5871d++;
        return new t0(record.f5379a, aVarA);
    }
}
