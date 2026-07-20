package fl;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
@in.g
public final class i0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final MessageDigest f6053a;

    public /* synthetic */ i0(MessageDigest messageDigest) {
        this.f6053a = messageDigest;
    }

    public static final /* synthetic */ i0 c(MessageDigest messageDigest) {
        return new i0(messageDigest);
    }

    @os.m
    public static Object d(MessageDigest messageDigest, @os.l um.d<? super byte[]> dVar) {
        byte[] bArrDigest = messageDigest.digest();
        kn.l0.o(bArrDigest, "delegate.digest()");
        return bArrDigest;
    }

    @os.l
    public static MessageDigest e(@os.l MessageDigest messageDigest) {
        kn.l0.p(messageDigest, "delegate");
        return messageDigest;
    }

    public static boolean f(MessageDigest messageDigest, Object obj) {
        return (obj instanceof i0) && kn.l0.g(messageDigest, ((i0) obj).f6053a);
    }

    public static final boolean g(MessageDigest messageDigest, MessageDigest messageDigest2) {
        return kn.l0.g(messageDigest, messageDigest2);
    }

    public static int i(MessageDigest messageDigest) {
        return messageDigest.hashCode();
    }

    public static void j(MessageDigest messageDigest, @os.l byte[] bArr) {
        kn.l0.p(messageDigest, "arg0");
        kn.l0.p(bArr, "bytes");
        messageDigest.update(bArr);
    }

    public static void k(MessageDigest messageDigest) {
        kn.l0.p(messageDigest, "arg0");
        messageDigest.reset();
    }

    public static String l(MessageDigest messageDigest) {
        return "DigestImpl(delegate=" + messageDigest + ')';
    }

    @Override // fl.h0
    public void a(@os.l byte[] bArr) {
        kn.l0.p(bArr, "bytes");
        j(this.f6053a, bArr);
    }

    @Override // fl.h0
    @os.m
    public Object b(@os.l um.d<? super byte[]> dVar) {
        return d(this.f6053a, dVar);
    }

    public boolean equals(Object obj) {
        return f(this.f6053a, obj);
    }

    @os.l
    public final MessageDigest h() {
        return this.f6053a;
    }

    public int hashCode() {
        return this.f6053a.hashCode();
    }

    public final /* synthetic */ MessageDigest m() {
        return this.f6053a;
    }

    @Override // fl.h0
    public void reset() {
        k(this.f6053a);
    }

    public String toString() {
        return l(this.f6053a);
    }
}
