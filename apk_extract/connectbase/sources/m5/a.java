package m5;

/* JADX INFO: loaded from: classes2.dex */
public class a implements j1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10395d = "DefaultProgressCallback";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10396e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10397f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10398g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10399h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10400i = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w4.c0 f10401c = w4.c0.b.f17991a;

    @Override // m5.j1
    public void a(int i10, String str, String str2, String str3, String str4, int i11) {
        k4.m.b(f10395d, "onReceiveFileProgress:file:" + str + ",progress=" + i10 + ",packageName:" + str2);
        v4.k.a.f16583a.o();
        this.f10401c.r0(str, i10, str2, str4, i11);
    }

    @Override // m5.j1
    public void c(String str) {
        k4.m.b(f10395d, "onSendFileDone:packageName=" + str);
        v4.k.a.f16583a.o();
        this.f10401c.w0(str);
        w4.o1.a.f18113a.x();
    }

    @Override // m5.j1
    public void d(int i10) {
        this.f10401c.v0(i10);
    }

    @Override // m5.j1
    public void f(int i10, String str, String str2, String str3, String str4, int i11) {
        k4.m.b(f10395d, " onSendFileProgress:file=" + str + ",progress=" + i10 + ",packageName" + str2);
        this.f10401c.x0(str, i10, str2, str4, i11);
    }

    @Override // m5.j1
    public void g(String str, String str2, int i10, String str3, int i11) {
        this.f10401c.t0(str, str2, i10, str3, i11);
    }

    @Override // m5.j1
    public void h(String str) {
        k4.m.b(f10395d, "onReceiveFileDone:" + str);
        v4.k.a.f16583a.o();
        this.f10401c.q0(str);
        w4.o1.a.f18113a.v();
    }

    @Override // m5.j1
    public void i(String str, String str2, String str3, int i10) {
        v4.k.a.f16583a.o();
        w4.o1.a.f18113a.y(str);
        this.f10401c.y0(str, str2, str3, i10);
    }

    @Override // m5.j1
    public void k(String str, String str2, int i10, String str3, int i11) {
        this.f10401c.z0(str, str2, i10, str3, i11);
    }

    @Override // m5.j1
    public void n(String str, String str2, String str3, int i10) {
        v4.k.a.f16583a.o();
        this.f10401c.s0(str, str2, str3, i10);
        w4.o1.a.f18113a.w(str);
    }

    @Override // m5.j1
    public void p(int i10) {
        this.f10401c.p0(i10);
    }
}
