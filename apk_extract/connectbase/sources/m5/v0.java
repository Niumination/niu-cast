package m5;

import com.transsion.fileTransfer.ICancelSingleFileTransfer;
import com.transsion.fileTransfer.IFileRequestReceive;
import com.transsion.fileTransfer.IInterruptFile;
import com.transsion.fileTransfer.IReceiveFileFinish;
import com.transsion.fileTransfer.IRequestSendFile;
import com.transsion.fileTransfer.ISingleFileFinish;
import com.transsion.fileTransfer.ITransferProgress;

/* JADX INFO: loaded from: classes2.dex */
public class v0 extends m5.a implements h1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10544s = "FileTransferVersion2";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10546k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10548m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IReceiveFileFinish f10549n = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final IFileRequestReceive f10550o = new IFileRequestReceive() { // from class: m5.r0
        @Override // com.transsion.fileTransfer.IFileRequestReceive
        public final void onRequestReceive(String str, String str2) {
            this.f10522a.C(str, str2);
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ITransferProgress f10551p = new ITransferProgress() { // from class: m5.s0
        @Override // com.transsion.fileTransfer.ITransferProgress
        public final void onProgress(String str, float f10) {
            this.f10536a.D(str, f10);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ISingleFileFinish f10552q = new ISingleFileFinish() { // from class: m5.t0
        @Override // com.transsion.fileTransfer.ISingleFileFinish
        public final void onFinish(String str) {
            this.f10537a.E(str);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final IInterruptFile f10553r = new u0();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e0 f10545j = e0.f.f10438a;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k f10547l = k.a.f10477a;

    public class a implements IReceiveFileFinish {
        public a() {
        }

        @Override // com.transsion.fileTransfer.IReceiveFileFinish
        public void finish() {
            k4.m.b(v0.f10544s, "receiveFileDone:nowReceivePackageName=" + v0.this.f10546k);
            if (v0.this.f10547l.v()) {
                v0 v0Var = v0.this;
                v0Var.h(v0Var.f10546k);
            }
        }
    }

    public v0() {
        z();
    }

    public static /* synthetic */ void F(int i10, String str) {
        k4.m.b(f10544s, "interruptTransferListener sessionId = " + str);
    }

    private void z() {
        this.f10545j.I(this.f10551p);
        this.f10545j.K(this.f10552q);
        this.f10545j.G(this.f10553r);
        this.f10545j.J(this.f10550o);
        this.f10545j.H(this.f10549n);
    }

    public final /* synthetic */ void A(String str, int i10) {
        this.f10547l.R(str);
    }

    public final /* synthetic */ void C(String str, String str2) {
        k4.m.b(f10544s, "confirm receive file id:" + str + ";path:" + str2);
        this.f10545j.q(str, new o0());
    }

    public final /* synthetic */ void D(String str, float f10) {
        o1 o1VarO = this.f10547l.o(str);
        if (o1VarO == null) {
            k4.m.c(f10544s, "progressTransferListener: fileTransferInfo is null by sessionId, id = " + str);
            return;
        }
        String strE = o1VarO.e();
        String strF = o1VarO.f();
        int i10 = (int) (100.0f * f10);
        k4.m.b(f10544s, "progressTransferListener: progress=" + f10);
        k4.m.b(f10544s, "progressTransferListener: fileInfo=" + o1VarO);
        if (o1VarO.d() == 0) {
            f(i10, strF, strE, o1VarO.h(), o1VarO.b(), o1VarO.i());
            this.f10548m = o1VarO.i();
        } else if (o1VarO.d() == 1) {
            a(i10, strF, strE, o1VarO.h(), o1VarO.b(), o1VarO.i());
            this.f10546k = strE;
        }
    }

    public final /* synthetic */ void E(String str) {
        k4.m.b(f10544s, "finishedTransferListener:sessionId=" + str);
        o1 o1VarO = this.f10547l.o(str);
        if (o1VarO == null) {
            k4.m.c(f10544s, "finishedTransferListener: fileTransferInfo is null by sessionId, id = " + str);
            return;
        }
        k4.m.b(f10544s, "finishedTransferListener:file info:" + o1VarO);
        String strE = o1VarO.e();
        this.f10547l.R(str);
        if (o1VarO.d() == 0) {
            i(o1VarO.h(), strE, o1VarO.b(), o1VarO.i());
            k4.m.b(f10544s, "mFileInfoContainer values size:" + this.f10547l.n().size());
            if (this.f10547l.w()) {
                c(strE);
                return;
            }
            return;
        }
        if (o1VarO.d() == 1) {
            this.f10546k = strE;
            n(o1VarO.h(), strE, o1VarO.b(), o1VarO.i());
            k4.m.b(f10544s, "mFileInfoContainer values size:" + this.f10547l.n().size());
            if (this.f10547l.v()) {
                h(strE);
            }
        }
    }

    public final /* synthetic */ void G(String str, String str2, String str3, String str4, int i10, String str5) {
        this.f10547l.h(str5, new o1(str, 0, str2, str3, str4));
    }

    @Override // m5.h1
    public void e() {
        this.f10545j.r();
    }

    @Override // m5.h1
    public void j(i1 i1Var, Runnable runnable) {
        k4.m.b(f10544s, "initFileTransfer into");
    }

    @Override // m5.h1
    public void l() {
        this.f10545j.L();
    }

    @Override // m5.h1
    public void m(final String str, final String str2, int i10, final String str3, String str4) {
        final String strM = g1.m(str2);
        k4.m.b(f10544s, "sendFile: save path:" + str2 + ";file name:" + strM + ";fileId:" + str4);
        this.f10545j.F(str, str2, new IRequestSendFile() { // from class: m5.p0
            @Override // com.transsion.fileTransfer.IRequestSendFile
            public final void onSuccess(int i11, String str5) {
                this.f10515a.G(str3, strM, str, str2, i11, str5);
            }
        });
    }

    @Override // m5.h1
    public void o(int i10) {
        if (!this.f10547l.u()) {
            for (final String str : this.f10547l.n()) {
                k4.m.b(f10544s, "cancelCurrentFileTransfer: Tccp map cancel file sdkId:" + str);
                this.f10545j.p(str, new ICancelSingleFileTransfer() { // from class: m5.q0
                    @Override // com.transsion.fileTransfer.ICancelSingleFileTransfer
                    public final void onFinish(int i11) {
                        this.f10520a.A(str, i11);
                    }
                });
            }
            this.f10547l.i();
        }
        if (i10 == 0) {
            m0.a.f10496a.A(this.f10548m);
        } else {
            if (i10 != 1) {
                return;
            }
            d(this.f10548m);
            p(this.f10548m);
        }
    }
}
