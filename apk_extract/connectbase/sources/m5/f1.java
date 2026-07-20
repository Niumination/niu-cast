package m5;

import com.transsion.fileTransfer.ICancelSingleFileTransfer;
import com.transsion.fileTransfer.IFileRequestReceive;
import com.transsion.fileTransfer.IInterruptFile;
import com.transsion.fileTransfer.IReceiveFileFinish;
import com.transsion.fileTransfer.IRequestSendFile;
import com.transsion.fileTransfer.ISingleFileFinish;
import com.transsion.fileTransfer.ITransferProgress;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class f1 extends m5.a implements h1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10441s = "FileTransferVersion3";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10442t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f10443u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f10444v = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10445j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10448m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IReceiveFileFinish f10449n = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final IFileRequestReceive f10450o = new IFileRequestReceive() { // from class: m5.b1
        @Override // com.transsion.fileTransfer.IFileRequestReceive
        public final void onRequestReceive(String str, String str2) {
            this.f10409a.I(str, str2);
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ITransferProgress f10451p = new ITransferProgress() { // from class: m5.c1
        @Override // com.transsion.fileTransfer.ITransferProgress
        public final void onProgress(String str, float f10) {
            this.f10411a.J(str, f10);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ISingleFileFinish f10452q = new ISingleFileFinish() { // from class: m5.d1
        @Override // com.transsion.fileTransfer.ISingleFileFinish
        public final void onFinish(String str) {
            this.f10417a.K(str);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final IInterruptFile f10453r = new IInterruptFile() { // from class: m5.e1
        @Override // com.transsion.fileTransfer.IInterruptFile
        public final void onInterrupt(int i10, String str) {
            this.f10439a.L(i10, str);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e0 f10446k = e0.f.f10438a;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k f10447l = k.a.f10477a;

    public class a implements IReceiveFileFinish {
        public a() {
        }

        @Override // com.transsion.fileTransfer.IReceiveFileFinish
        public void finish() {
            k4.m.b(f1.f10441s, "receiveFileDone:nowReceivePackageName=" + f1.this.f10445j);
            if (f1.this.f10447l.x()) {
                f1 f1Var = f1.this;
                f1Var.h(f1Var.f10445j);
            }
        }
    }

    public f1() {
        D();
    }

    private void D() {
        this.f10446k.I(this.f10451p);
        this.f10446k.K(this.f10452q);
        this.f10446k.G(this.f10453r);
        this.f10446k.J(this.f10450o);
        this.f10446k.H(this.f10449n);
    }

    public static /* synthetic */ void E(int i10) {
    }

    public static /* synthetic */ void G(String str) {
        File file = new File(str);
        if (!file.exists()) {
            k4.m.c(f10441s, str + "file no exist");
            return;
        }
        try {
            k4.m.b(f10441s, "delete cache file:" + str);
            file.delete();
        } catch (SecurityException e10) {
            k4.m.c(f10441s, "delete fail SecurityException:" + e10.getMessage());
        }
    }

    public static /* synthetic */ void q(int i10) {
    }

    public final void B(String str, String str2, String str3, int i10, int i11, int i12) {
        if (i12 == 0) {
            k(str, str2, i10, str3, i11);
            m0.a.f10496a.w(str2, str3, 0, i10);
            this.f10447l.T(str3);
            if (this.f10447l.y()) {
                c(str);
                return;
            }
            return;
        }
        g(str, str2, i10, str3, i11);
        m0.a.f10496a.w(str2, str3, 1, i10);
        this.f10447l.S(str3);
        if (this.f10447l.x()) {
            h(str);
        }
    }

    public final void C(final String str) {
        i6.a.b.f7724a.b(new Runnable() { // from class: m5.w0
            @Override // java.lang.Runnable
            public final void run() {
                f1.G(str);
            }
        });
    }

    public final /* synthetic */ void F(o1 o1Var, int i10) {
        C(o1Var.f());
    }

    public final /* synthetic */ void I(String str, String str2) {
        k4.m.b(f10441s, "confirm receive file id:" + str + ";path:" + str2);
        o1 o1VarQ = this.f10447l.q(str2);
        if (o1VarQ == null) {
            k4.m.c(f10441s, "Receive file save path no exist");
            C(str2);
            return;
        }
        k4.m.b(f10441s, "bind file id" + o1VarQ.b() + ";sdk id:" + str);
        o1VarQ.p(str);
        this.f10446k.q(str, new y0());
    }

    public final /* synthetic */ void J(String str, float f10) {
        o1 o1VarL = this.f10447l.l(str);
        if (o1VarL == null) {
            k4.m.c(f10441s, "progressTransferListener: fileTransferInfo is null by sessionId, id = " + str);
            return;
        }
        int iD = o1VarL.d();
        String strE = o1VarL.e();
        String strF = o1VarL.f();
        int iMin = Math.min((int) (100.0f * f10), 100);
        k4.m.b(f10441s, "progressTransferListener: progress=" + f10);
        k4.m.b(f10441s, "progressTransferListener: fileInfo=" + o1VarL);
        this.f10448m = o1VarL.i();
        if (iD == 0) {
            f(iMin, strF, strE, o1VarL.h(), o1VarL.b(), o1VarL.i());
        } else if (iD == 1) {
            a(iMin, strF, strE, o1VarL.h(), o1VarL.b(), o1VarL.i());
            this.f10445j = strE;
        }
    }

    public final /* synthetic */ void K(String str) {
        k4.m.b(f10441s, "finishedTransferListener:sessionId=" + str);
        o1 o1VarL = this.f10447l.l(str);
        if (o1VarL == null) {
            k4.m.c(f10441s, "finishedTransferListener: fileTransferInfo is null by sessionId, id = " + str);
            return;
        }
        k4.m.b(f10441s, "finishedTransferListener: file info:" + o1VarL);
        String strE = o1VarL.e();
        if (o1VarL.d() == 0) {
            i(o1VarL.h(), strE, o1VarL.b(), o1VarL.i());
            this.f10447l.T(o1VarL.b());
            if (this.f10447l.y()) {
                c(strE);
                return;
            }
            return;
        }
        if (o1VarL.d() == 1) {
            this.f10445j = strE;
            n(o1VarL.h(), strE, o1VarL.b(), o1VarL.i());
            this.f10447l.S(o1VarL.b());
            if (this.f10447l.x()) {
                h(strE);
            }
        }
    }

    public final /* synthetic */ void L(int i10, String str) {
        k4.m.b(f10441s, "interruptTransferListener code = " + i10 + ";sessionId = " + str);
        if (i10 != 2) {
            return;
        }
        k4.m.c(f10441s, "operate file fail");
        o1 o1VarL = this.f10447l.l(str);
        if (o1VarL != null) {
            B(o1VarL.e(), o1VarL.f(), o1VarL.b(), 4, o1VarL.i(), o1VarL.d());
            return;
        }
        k4.m.c(f10441s, "file no find, sdk id：" + str);
    }

    public final /* synthetic */ void M(String str, String str2, String str3, int i10, String str4) {
        if (i10 == 0) {
            this.f10447l.M(str, str4);
        } else {
            o1 o1VarS = this.f10447l.s(str);
            B(str2, str3, str, 2, o1VarS != null ? o1VarS.i() : 1, 0);
        }
    }

    @Override // m5.h1
    public void e() {
        this.f10446k.r();
    }

    @Override // m5.h1
    public void j(i1 i1Var, Runnable runnable) {
        k4.m.b(f10441s, "initFileTransfer into");
    }

    @Override // m5.h1
    public void l() {
        this.f10446k.L();
        Iterator it = new ArrayList(this.f10447l.P()).iterator();
        while (it.hasNext()) {
            C(((o1) it.next()).f());
        }
    }

    @Override // m5.h1
    public void m(String str, final String str2, int i10, final String str3, final String str4) {
        k4.m.b(f10441s, "file save path:" + str2 + ";file name:" + g1.m(str2) + ";fileId:" + str4);
        this.f10446k.F(str, str2, new IRequestSendFile() { // from class: m5.x0
            @Override // com.transsion.fileTransfer.IRequestSendFile
            public final void onSuccess(int i11, String str5) {
                this.f10560a.M(str4, str3, str2, i11, str5);
            }
        });
    }

    @Override // m5.h1
    public void o(int i10) {
        ArrayList<o1> arrayList = new ArrayList(this.f10447l.X());
        ArrayList<o1> arrayList2 = new ArrayList(this.f10447l.P());
        this.f10447l.k();
        this.f10447l.j();
        if (!arrayList.isEmpty()) {
            for (o1 o1Var : arrayList) {
                k4.m.b(f10441s, "cancelCurrentFileTransfer: Send file cancel and clean map");
                this.f10446k.p(o1Var.g(), new z0());
            }
        }
        if (!arrayList2.isEmpty()) {
            k4.m.b(f10441s, "cancelCurrentFileTransfer: Receive file cancel and clean map");
            for (final o1 o1Var2 : arrayList2) {
                this.f10446k.p(o1Var2.g(), new ICancelSingleFileTransfer() { // from class: m5.a1
                    @Override // com.transsion.fileTransfer.ICancelSingleFileTransfer
                    public final void onFinish(int i11) {
                        this.f10403a.F(o1Var2, i11);
                    }
                });
            }
        }
        if (i10 == 0) {
            m0.a.f10496a.A(this.f10448m);
        } else {
            if (i10 != 1) {
                return;
            }
            d(this.f10448m);
            p(this.f10448m);
        }
    }
}
