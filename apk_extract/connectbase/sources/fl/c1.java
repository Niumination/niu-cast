package fl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import nq.c2;
import nq.l2;
import nq.z2;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f6019a = "SHA1PRNG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f6020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6021c = 30000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6022d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6023e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6024f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final pq.l<String> f6025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final nq.r0 f6026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final l2 f6027i;

    @xm.f(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {75}, m = "invokeSuspend", n = {"seedChannel", "previousRoundNonceList", "secureInstance", "weakRandom", "secureBytes", "weakBytes", "randomNonceList", "lastReseed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0"})
    public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super lm.l2>, Object> {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0083 A[Catch: all -> 0x0045, LOOP:2: B:14:0x0081->B:15:0x0083, LOOP_END, TryCatch #1 {all -> 0x0045, blocks: (B:6:0x002d, B:22:0x00d5, B:26:0x00fa, B:28:0x0109, B:13:0x0078, B:15:0x0083, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:40:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:18:0x0099 A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:6:0x002d, B:22:0x00d5, B:26:0x00fa, B:28:0x0109, B:13:0x0078, B:15:0x0083, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:40:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:19:0x00a7 A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:6:0x002d, B:22:0x00d5, B:26:0x00fa, B:28:0x0109, B:13:0x0078, B:15:0x0083, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:40:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:22:0x00d5 A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:6:0x002d, B:22:0x00d5, B:26:0x00fa, B:28:0x0109, B:13:0x0078, B:15:0x0083, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:40:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:25:0x00f8 A[LOOP:0: B:21:0x00d3->B:25:0x00f8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:28:0x0109 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #1 {all -> 0x0045, blocks: (B:6:0x002d, B:22:0x00d5, B:26:0x00fa, B:28:0x0109, B:13:0x0078, B:15:0x0083, B:16:0x008d, B:18:0x0099, B:20:0x00aa, B:19:0x00a7), top: B:40:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00f7 A[SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:5:0x000b
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fl.c1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    static {
        String property = System.getProperty("io.ktor.random.secure.random.provider");
        if (property == null) {
            property = "NativePRNGNonBlocking";
        }
        f6020b = property;
        f6025g = pq.o.d(1024, null, null, 6, null);
        nq.r0 r0Var = new nq.r0("nonce-generator");
        f6026h = r0Var;
        f6027i = nq.k.e(c2.f11831a, nq.k1.c().plus(z2.f11998a).plus(r0Var), nq.u0.LAZY, new a(null));
    }

    public static final void b() {
        f6027i.start();
    }

    public static final SecureRandom c(String str) {
        try {
            return SecureRandom.getInstance(str);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @os.l
    public static final pq.l<String> d() {
        return f6025g;
    }

    public static final SecureRandom e() {
        String str = f6020b;
        SecureRandom secureRandomC = c(str);
        if (secureRandomC != null) {
            return secureRandomC;
        }
        ps.b.j("io.ktor.util.random").warn(kn.l0.C(str, " is not found, fallback to SHA1PRNG"));
        SecureRandom secureRandomC2 = c(f6019a);
        if (secureRandomC2 != null) {
            return secureRandomC2;
        }
        throw new IllegalStateException("No SecureRandom implementation found");
    }
}
