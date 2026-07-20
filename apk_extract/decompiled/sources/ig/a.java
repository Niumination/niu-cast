package ig;

import ag.d0;
import hg.h;
import hg.p0;
import hg.t0;
import hg.v0;
import java.io.EOFException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import m3.m6;
import wi.k;
import wi.o;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hg.c f5856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f5857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Cipher f5858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SecretKeySpec f5859d;
    public final Mac e;
    public final Cipher f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SecretKeySpec f5860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Mac f5861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5863j;

    public a(hg.c suite, byte[] keyMaterial) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(suite, "suite");
        Intrinsics.checkNotNullParameter(keyMaterial, "keyMaterial");
        this.f5856a = suite;
        this.f5857b = keyMaterial;
        Cipher cipher = Cipher.getInstance(suite.e);
        Intrinsics.checkNotNull(cipher);
        this.f5858c = cipher;
        this.f5859d = h.a(suite, keyMaterial);
        Mac mac = Mac.getInstance(suite.f5341j);
        Intrinsics.checkNotNull(mac);
        this.e = mac;
        Cipher cipher2 = Cipher.getInstance(suite.e);
        Intrinsics.checkNotNull(cipher2);
        this.f = cipher2;
        this.f5860g = h.b(suite, keyMaterial);
        Mac mac2 = Mac.getInstance(suite.f5341j);
        Intrinsics.checkNotNull(mac2);
        this.f5861h = mac2;
    }

    @Override // ig.g
    public final t0 a(t0 record) throws p0, InvalidKeyException, EOFException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(record, "record");
        k kVar = record.f5381c;
        hg.c suite = this.f5856a;
        byte[] bArrC = o.c(kVar, suite.f5338g);
        SecretKeySpec secretKeySpec = this.f5860g;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrC);
        Cipher cipher = this.f;
        cipher.init(2, secretKeySpec, ivParameterSpec);
        wi.a aVarA = c.a(kVar, cipher, new ag.b(11));
        Intrinsics.checkNotNullParameter(aVarA, "<this>");
        byte[] bArrD = o.d(aVarA, -1);
        int length = (bArrD.length - (bArrD[bArrD.length - 1] & UByte.MAX_VALUE)) - 1;
        int i8 = suite.p;
        int i9 = length - i8;
        int i10 = bArrD[bArrD.length - 1] & UByte.MAX_VALUE;
        int length2 = bArrD.length;
        while (length < length2) {
            int i11 = bArrD[length] & UByte.MAX_VALUE;
            if (i10 != i11) {
                throw new p0(o.d.f(i10, i11, "Padding invalid: expected ", ", actual "), null, 2, null);
            }
            length++;
        }
        Mac mac = this.f5861h;
        mac.reset();
        byte[] bArr = h.f5357a;
        byte[] bArr2 = this.f5857b;
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        Intrinsics.checkNotNullParameter(suite, "suite");
        mac.init(new SecretKeySpec(bArr2, i8, i8, suite.f5343l.getMacName()));
        byte[] bArr3 = new byte[13];
        b.a(this.f5862i, bArr3, 0);
        v0 v0Var = record.f5379a;
        bArr3[8] = (byte) v0Var.getCode();
        bArr3[9] = 3;
        bArr3[10] = 3;
        b.b(bArr3, (short) i9);
        this.f5862i++;
        mac.update(bArr3);
        mac.update(bArrD, 0, i9);
        byte[] bArrDoFinal = mac.doFinal();
        Intrinsics.checkNotNull(bArrDoFinal);
        if (!MessageDigest.isEqual(bArrDoFinal, ArraysKt.sliceArray(bArrD, RangesKt.until(i9, i8 + i9)))) {
            throw new p0("Failed to verify MAC content", null, 2, null);
        }
        wi.a aVar = new wi.a();
        lh.a.k(aVar, bArrD, 0, i9);
        return new t0(v0Var, record.f5380b, aVar);
    }

    @Override // ig.g
    public final t0 b(t0 record) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(record, "record");
        SecretKeySpec secretKeySpec = this.f5859d;
        hg.c suite = this.f5856a;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(m6.a(suite.f5338g));
        Cipher cipher = this.f5858c;
        cipher.init(1, secretKeySpec, ivParameterSpec);
        byte[] bArrB = o.b(record.f5381c);
        Mac mac = this.e;
        mac.reset();
        byte[] bArr = h.f5357a;
        byte[] bArr2 = this.f5857b;
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        Intrinsics.checkNotNullParameter(suite, "suite");
        mac.init(new SecretKeySpec(bArr2, 0, suite.p, suite.f5343l.getMacName()));
        byte[] bArr3 = new byte[13];
        b.a(this.f5863j, bArr3, 0);
        v0 v0Var = record.f5379a;
        bArr3[8] = (byte) v0Var.getCode();
        bArr3[9] = 3;
        bArr3[10] = 3;
        b.b(bArr3, (short) bArrB.length);
        this.f5863j++;
        mac.update(bArr3);
        byte[] bArrDoFinal = mac.doFinal(bArrB);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        wi.a aVar = new wi.a();
        lh.a.k(aVar, bArrB, 0, bArrB.length);
        lh.a.k(aVar, bArrDoFinal, 0, bArrDoFinal.length);
        byte blockSize = (byte) (cipher.getBlockSize() - ((lh.a.f(aVar) + 1) % cipher.getBlockSize()));
        int i8 = blockSize + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            aVar.s(blockSize);
        }
        return new t0(v0Var, c.a(aVar, cipher, new d0(this, 12)));
    }
}
