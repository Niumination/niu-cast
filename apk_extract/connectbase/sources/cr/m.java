package cr;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.j
    public final MessageDigest f3439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.j
    public final Mac f3440c;

    public m(z zVar, String str) {
        super(zVar);
        try {
            this.f3439b = MessageDigest.getInstance(str);
            this.f3440c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static m d(z zVar, f fVar) {
        return new m(zVar, fVar, "HmacSHA1");
    }

    public static m h(z zVar, f fVar) {
        return new m(zVar, fVar, "HmacSHA256");
    }

    public static m k(z zVar, f fVar) {
        return new m(zVar, fVar, "HmacSHA512");
    }

    public static m n(z zVar) {
        return new m(zVar, "MD5");
    }

    public static m o(z zVar) {
        return new m(zVar, "SHA-1");
    }

    public static m p(z zVar) {
        return new m(zVar, "SHA-256");
    }

    public static m q(z zVar) {
        return new m(zVar, "SHA-512");
    }

    @Override // cr.h, cr.z
    public void Z0(c cVar, long j10) throws IOException {
        d0.b(cVar.f3404b, 0L, j10);
        w wVar = cVar.f3403a;
        long j11 = 0;
        while (j11 < j10) {
            int iMin = (int) Math.min(j10 - j11, wVar.f3488c - wVar.f3487b);
            MessageDigest messageDigest = this.f3439b;
            if (messageDigest != null) {
                messageDigest.update(wVar.f3486a, wVar.f3487b, iMin);
            } else {
                this.f3440c.update(wVar.f3486a, wVar.f3487b, iMin);
            }
            j11 += (long) iMin;
            wVar = wVar.f3491f;
        }
        super.Z0(cVar, j10);
    }

    public final f c() {
        MessageDigest messageDigest = this.f3439b;
        return f.of(messageDigest != null ? messageDigest.digest() : this.f3440c.doFinal());
    }

    public m(z zVar, f fVar, String str) {
        super(zVar);
        try {
            Mac mac = Mac.getInstance(str);
            this.f3440c = mac;
            mac.init(new SecretKeySpec(fVar.toByteArray(), str));
            this.f3439b = null;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
