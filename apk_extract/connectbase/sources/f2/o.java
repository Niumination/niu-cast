package f2;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final o f5776a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f5777b = "AnimPlayer";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5778c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5779d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5780e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5781f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5782g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5783h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5784i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5785j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5786k = 10001;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5787l = 10002;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5788m = 10003;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5789n = 10004;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5790o = 10005;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5791p = 10006;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5792q = 10007;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5793r = 10008;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public static final String f5794s = "0x1 MediaExtractor exception";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static final String f5795t = "0x2 MediaCodec exception";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public static final String f5796u = "0x3 thread create fail";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final String f5797v = "0x4 render create fail";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final String f5798w = "0x5 parse config fail";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final String f5799x = "0x6 vapx fail";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final String f5800y = "0x7 file can't read";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final String f5801z = "0x8 hevc not support";

    public static /* synthetic */ String b(o oVar, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return oVar.a(i10, str);
    }

    @lm.k(message = "Compatible older version mp4")
    public static /* synthetic */ void c() {
    }

    @lm.k(message = "Compatible older version mp4")
    public static /* synthetic */ void d() {
    }

    @lm.k(message = "Compatible older version mp4")
    public static /* synthetic */ void e() {
    }

    @lm.k(message = "Compatible older version mp4")
    public static /* synthetic */ void f() {
    }

    @os.l
    public final String a(int i10, @os.m String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        switch (i10) {
            case 10001:
                str2 = f5794s;
                break;
            case f5787l /* 10002 */:
                str2 = f5795t;
                break;
            case f5788m /* 10003 */:
                str2 = f5796u;
                break;
            case f5789n /* 10004 */:
                str2 = f5797v;
                break;
            case f5790o /* 10005 */:
                str2 = f5798w;
                break;
            case f5791p /* 10006 */:
                str2 = f5799x;
                break;
            default:
                str2 = "unknown";
                break;
        }
        sb2.append(str2);
        sb2.append(' ');
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }
}
