package cr;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageDigest f3441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Mac f3442c;

    public n(a0 a0Var, String str) {
        super(a0Var);
        try {
            this.f3441b = MessageDigest.getInstance(str);
            this.f3442c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static n d(a0 a0Var, f fVar) {
        return new n(a0Var, fVar, "HmacSHA1");
    }

    public static n h(a0 a0Var, f fVar) {
        return new n(a0Var, fVar, "HmacSHA256");
    }

    public static n k(a0 a0Var) {
        return new n(a0Var, "MD5");
    }

    public static n n(a0 a0Var) {
        return new n(a0Var, "SHA-1");
    }

    public static n o(a0 a0Var) {
        return new n(a0Var, "SHA-256");
    }

    @Override // cr.i, cr.a0
    public long Y0(c cVar, long j10) throws IOException {
        long jY0 = super.Y0(cVar, j10);
        if (jY0 != -1) {
            long j11 = cVar.f3404b;
            long j12 = j11 - jY0;
            w wVar = cVar.f3403a;
            while (j11 > j12) {
                wVar = wVar.f3492g;
                j11 -= (long) (wVar.f3488c - wVar.f3487b);
            }
            while (j11 < cVar.f3404b) {
                int i10 = (int) ((((long) wVar.f3487b) + j12) - j11);
                MessageDigest messageDigest = this.f3441b;
                if (messageDigest != null) {
                    messageDigest.update(wVar.f3486a, i10, wVar.f3488c - i10);
                } else {
                    this.f3442c.update(wVar.f3486a, i10, wVar.f3488c - i10);
                }
                j12 = ((long) (wVar.f3488c - wVar.f3487b)) + j11;
                wVar = wVar.f3491f;
                j11 = j12;
            }
        }
        return jY0;
    }

    public final f c() {
        MessageDigest messageDigest = this.f3441b;
        return f.of(messageDigest != null ? messageDigest.digest() : this.f3442c.doFinal());
    }

    public n(a0 a0Var, f fVar, String str) {
        super(a0Var);
        try {
            Mac mac = Mac.getInstance(str);
            this.f3442c = mac;
            mac.init(new SecretKeySpec(fVar.toByteArray(), str));
            this.f3441b = null;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
