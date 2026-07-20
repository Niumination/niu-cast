package nq;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f11973a = "kotlinx.coroutines.debug";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f11974b = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f11975c = "auto";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f11976d = "on";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final String f11977e = "off";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f11978f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f11979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f11980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final AtomicLong f11981i;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0.equals(nq.w0.f11976d) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = vq.y0.b(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2f
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3a
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L31
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L27
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L44
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L2f
        L27:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L2f:
            r0 = r2
            goto L61
        L31:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L42
        L3a:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L42:
            r0 = r1
            goto L61
        L44:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.<init>(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L61:
            nq.w0.f11979g = r0
            if (r0 == 0) goto L6e
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = vq.z0.d(r0, r1)
            if (r0 == 0) goto L6e
            goto L6f
        L6e:
            r1 = r2
        L6f:
            nq.w0.f11980h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            nq.w0.f11981i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: nq.w0.<clinit>():void");
    }

    @an.f
    public static final void a(jn.a<Boolean> aVar) {
    }

    public static final boolean b() {
        return f11978f;
    }

    @os.l
    public static final AtomicLong c() {
        return f11981i;
    }

    public static final boolean d() {
        return f11979g;
    }

    public static final boolean e() {
        return f11980h;
    }

    @lm.z0
    public static /* synthetic */ void f() {
    }

    public static final void g() {
        f11981i.set(0L);
    }
}
