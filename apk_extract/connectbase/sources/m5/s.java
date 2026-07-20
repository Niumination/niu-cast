package m5;

/* JADX INFO: loaded from: classes2.dex */
public class s implements h1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10523h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10524i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10525j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10526k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10527l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10528m = "FileTransferManager";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10529n = "server:send:";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h1 f10530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f10531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f10532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f10533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10534g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f10535a = new s();
    }

    public static s k() {
        return a.f10535a;
    }

    public static /* synthetic */ void q(h1 h1Var) {
        k4.m.b("FileTransferManager", "connect new transfer channel, to close old port listener");
        h1Var.e();
    }

    public static /* synthetic */ void t(int i10, int i11) {
        k4.m.b("FileTransferManager", "filePort:" + i10 + "; controlPort:" + i11);
    }

    @Override // m5.h1
    public void b() {
        k4.m.b("FileTransferManager", "reconnectFileChannel");
        h1 h1Var = this.f10530c;
        if (h1Var != null) {
            h1Var.b();
        }
    }

    @Override // m5.h1
    public void e() {
        k4.m.b("FileTransferManager", "disconnectCleanup");
        h1 h1Var = this.f10530c;
        if (h1Var != null) {
            h1Var.e();
        }
    }

    public synchronized String i() {
        StringBuilder sb2;
        sb2 = new StringBuilder(f10529n);
        int i10 = this.f10534g + 1;
        this.f10534g = i10;
        sb2.append(i10);
        return sb2.toString();
    }

    @Override // m5.h1
    public void j(i1 i1Var, Runnable runnable) {
        k4.m.b("FileTransferManager", "initFileTransfer");
        this.f10530c = new v0();
        final n1 n1Var = new n1();
        e0.f.f10438a.t(new i1() { // from class: m5.m
            @Override // m5.i1
            public final void a(int i10, int i11) {
                this.f10484a.p(i10, i11);
            }
        }, new Runnable() { // from class: m5.n
            @Override // java.lang.Runnable
            public final void run() {
                s.q(n1Var);
            }
        });
        n1Var.j(new i1() { // from class: m5.o
            @Override // m5.i1
            public final void a(int i10, int i11) {
                this.f10504a.r(i10, i11);
            }
        }, new Runnable() { // from class: m5.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f10513a.s(n1Var);
            }
        });
    }

    @Override // m5.h1
    public void l() {
        k4.m.b("FileTransferManager", "stopFileServer");
        this.f10534g = 0;
        m0.a.f10496a.x();
        h1 h1Var = this.f10530c;
        if (h1Var != null) {
            h1Var.l();
            w4.o1.a.f18113a.A();
        }
        k.a.f10477a.Q();
    }

    @Override // m5.h1
    public void m(String str, String str2, int i10, String str3, String str4) {
        if (this.f10530c == null) {
            k4.m.c("FileTransferManager", "file transfer no init");
            return;
        }
        k4.m.b("FileTransferManager", "sendFile:sendPath=" + str + "-savePath=" + str2 + "-transportMode=" + i10 + "-packageName=" + str3);
        w4.o1.a.f18113a.z(str, g1.d(str));
        this.f10530c.m(str, str2, i10, str3, str4);
    }

    public void n() {
        j(new q(), new r());
    }

    @Override // m5.h1
    public void o(int i10) {
        k4.m.b("FileTransferManager", "cancelCurrentFileTransfer");
        h1 h1Var = this.f10530c;
        if (h1Var != null) {
            h1Var.o(i10);
            w4.o1.a.f18113a.D();
        }
    }

    public final /* synthetic */ void p(int i10, int i11) {
        this.f10533f.e(i10);
        this.f10533f.d(i11);
        v(2);
    }

    public final /* synthetic */ void r(int i10, int i11) {
        k4.m.b("FileTransferManager", "old port ready");
        this.f10533f.f(i10);
        v(1);
    }

    public final void s(h1 h1Var) {
        k4.m.b("FileTransferManager", "connect old transfer channel, to close new ports listener");
        this.f10530c = h1Var;
        e0.f.f10438a.r();
    }

    public final void v(int i10) {
        k4.m.b("FileTransferManager", "channel version:" + i10);
        if (i10 == 1) {
            this.f10531d = true;
        } else if (i10 == 2) {
            this.f10532e = true;
        }
        if (this.f10531d && this.f10532e) {
            k4.m.b("FileTransferManager", "info:" + this.f10533f);
            m0.a.f10496a.v(this.f10533f);
            this.f10531d = false;
            this.f10532e = false;
        }
    }

    public void w(String str, o1 o1Var) {
        k4.m.b("FileTransferManager", "onSingleFileTransferStart: enter file info, fileInfo:" + o1Var);
        k.a.f10477a.h(str, o1Var);
    }

    public void x(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
            }
            this.f10530c = new f1();
        }
        this.f10530c = new n1();
        this.f10530c = new v0();
        this.f10530c = new f1();
    }

    public s() {
        this.f10531d = false;
        this.f10532e = false;
        this.f10533f = new b();
        this.f10534g = 0;
    }
}
