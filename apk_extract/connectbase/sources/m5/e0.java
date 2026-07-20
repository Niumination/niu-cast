package m5;

import androidx.annotation.Nullable;
import com.transsion.fileTransfer.ICancelSingleFileTransfer;
import com.transsion.fileTransfer.IConfirmId;
import com.transsion.fileTransfer.ICreateFileServersListener;
import com.transsion.fileTransfer.IFileRequestReceive;
import com.transsion.fileTransfer.IInterruptFile;
import com.transsion.fileTransfer.IPortListenedListener;
import com.transsion.fileTransfer.IReceiveFileFinish;
import com.transsion.fileTransfer.IRequestSendFile;
import com.transsion.fileTransfer.ISingleFileFinish;
import com.transsion.fileTransfer.ITransferProgress;
import com.transsion.fileTransfer.SourceJniMethod;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10419l = "FileTransferNativeProxy";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10420m = 10001;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10421n = 9542;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SourceJniMethod f10422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ITransferProgress f10423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ISingleFileFinish f10424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public IFileRequestReceive f10425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public IReceiveFileFinish f10426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public IInterruptFile f10427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ITransferProgress f10428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ISingleFileFinish f10429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IInterruptFile f10430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IFileRequestReceive f10431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IReceiveFileFinish f10432k;

    public class a implements ITransferProgress {
        public a() {
        }

        @Override // com.transsion.fileTransfer.ITransferProgress
        public void onProgress(String str, float f10) {
            ITransferProgress iTransferProgress = e0.this.f10423b;
            if (iTransferProgress != null) {
                iTransferProgress.onProgress(str, f10);
            }
        }
    }

    public class b implements ISingleFileFinish {
        public b() {
        }

        @Override // com.transsion.fileTransfer.ISingleFileFinish
        public void onFinish(String str) {
            ISingleFileFinish iSingleFileFinish = e0.this.f10424c;
            if (iSingleFileFinish != null) {
                iSingleFileFinish.onFinish(str);
            }
        }
    }

    public class c implements IInterruptFile {
        public c() {
        }

        @Override // com.transsion.fileTransfer.IInterruptFile
        public void onInterrupt(int i10, String str) {
            IInterruptFile iInterruptFile = e0.this.f10427f;
            if (iInterruptFile != null) {
                iInterruptFile.onInterrupt(i10, str);
            }
        }
    }

    public class d implements IFileRequestReceive {
        public d() {
        }

        @Override // com.transsion.fileTransfer.IFileRequestReceive
        public void onRequestReceive(String str, String str2) {
            IFileRequestReceive iFileRequestReceive = e0.this.f10425d;
            if (iFileRequestReceive != null) {
                iFileRequestReceive.onRequestReceive(str, str2);
            }
        }
    }

    public class e implements IReceiveFileFinish {
        public e() {
        }

        @Override // com.transsion.fileTransfer.IReceiveFileFinish
        public void finish() {
            IReceiveFileFinish iReceiveFileFinish = e0.this.f10426e;
            if (iReceiveFileFinish != null) {
                iReceiveFileFinish.finish();
            }
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e0 f10438a = new e0();
    }

    public static /* synthetic */ void B(IRequestSendFile iRequestSendFile, int i10, String str) {
        k4.m.b(f10419l, "requestSendFolder: code=" + i10 + ",sessionId:" + str);
        iRequestSendFile.onSuccess(i10, str);
    }

    public static /* synthetic */ void C(IRequestSendFile iRequestSendFile, int i10, String str) {
        k4.m.b(f10419l, "requestSendFile: code=" + i10 + ",sessionId:" + str);
        iRequestSendFile.onSuccess(i10, str);
    }

    public static e0 s() {
        return f.f10438a;
    }

    public static /* synthetic */ void u(ICancelSingleFileTransfer iCancelSingleFileTransfer, int i10) {
        k4.m.b(f10419l, "cancelFileTransfer: code=" + i10);
        iCancelSingleFileTransfer.onFinish(i10);
    }

    public static /* synthetic */ void w(IConfirmId iConfirmId, int i10, String str) {
        k4.m.b(f10419l, "confirmSessionsId:code=" + i10 + "-id:" + str);
        iConfirmId.onConfirmId(i10, str);
    }

    public static /* synthetic */ void y(i1 i1Var) {
        k4.m.b(f10419l, "file transfer ports start listener");
        i1Var.a(10001, f10421n);
    }

    public static /* synthetic */ void z(Runnable runnable, int i10, String str) {
        k4.m.b(f10419l, "createFileTransferServer:code=" + i10 + ";info=" + str);
        runnable.run();
    }

    public final /* synthetic */ void A(final i1 i1Var, final Runnable runnable) {
        this.f10422a.setProgressTransferListener(this.f10428g);
        this.f10422a.setFinishedTransferListener(this.f10429h);
        this.f10422a.setInterruptTransferListener(this.f10430i);
        this.f10422a.setRequestReceiveListener(this.f10431j);
        this.f10422a.setPassiveReceiveEmptyListener(this.f10432k);
        this.f10422a.openServerAndWaitClient(10001, f10421n, new IPortListenedListener() { // from class: m5.b0
            @Override // com.transsion.fileTransfer.IPortListenedListener
            public final void onSuccess() {
                e0.y(i1Var);
            }
        }, new ICreateFileServersListener() { // from class: m5.c0
            @Override // com.transsion.fileTransfer.ICreateFileServersListener
            public final void onSuccess(int i10, String str) {
                e0.z(runnable, i10, str);
            }
        });
    }

    public final /* synthetic */ void D(String str, String str2, final IRequestSendFile iRequestSendFile) {
        if (new File(str).isDirectory()) {
            this.f10422a.requestSendFolder(str, str2, new IRequestSendFile() { // from class: m5.y
                @Override // com.transsion.fileTransfer.IRequestSendFile
                public final void onSuccess(int i10, String str3) {
                    e0.B(iRequestSendFile, i10, str3);
                }
            });
        } else {
            this.f10422a.requestSendFile(str, str2, new IRequestSendFile() { // from class: m5.z
                @Override // com.transsion.fileTransfer.IRequestSendFile
                public final void onSuccess(int i10, String str3) {
                    e0.C(iRequestSendFile, i10, str3);
                }
            });
        }
    }

    public final void E() {
        this.f10423b = null;
        this.f10424c = null;
        this.f10425d = null;
        this.f10426e = null;
        this.f10427f = null;
    }

    public void F(final String str, final String str2, final IRequestSendFile iRequestSendFile) {
        i6.a.b.f7724a.a(new Runnable() { // from class: m5.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10413a.D(str, str2, iRequestSendFile);
            }
        });
    }

    public void G(IInterruptFile iInterruptFile) {
        this.f10427f = iInterruptFile;
    }

    public void H(IReceiveFileFinish iReceiveFileFinish) {
        this.f10426e = iReceiveFileFinish;
    }

    public void I(ITransferProgress iTransferProgress) {
        this.f10423b = iTransferProgress;
    }

    public void J(IFileRequestReceive iFileRequestReceive) {
        this.f10425d = iFileRequestReceive;
    }

    public void K(ISingleFileFinish iSingleFileFinish) {
        this.f10424c = iSingleFileFinish;
    }

    public void L() {
        E();
        this.f10422a.disconnectCleanup();
    }

    public void p(final String str, final ICancelSingleFileTransfer iCancelSingleFileTransfer) {
        i6.a.b.f7724a.a(new Runnable() { // from class: m5.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f10538a.v(str, iCancelSingleFileTransfer);
            }
        });
    }

    public void q(final String str, final IConfirmId iConfirmId) {
        i6.a.b.f7724a.a(new Runnable() { // from class: m5.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f10541a.x(str, iConfirmId);
            }
        });
    }

    public void r() {
        E();
        this.f10422a.disconnectCleanup();
    }

    public void t(final i1 i1Var, final Runnable runnable) {
        i6.a.b.f7724a.a(new Runnable() { // from class: m5.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f10557a.A(i1Var, runnable);
            }
        });
    }

    public final /* synthetic */ void v(String str, final ICancelSingleFileTransfer iCancelSingleFileTransfer) {
        this.f10422a.cancelFileTransfer(str, new ICancelSingleFileTransfer() { // from class: m5.a0
            @Override // com.transsion.fileTransfer.ICancelSingleFileTransfer
            public final void onFinish(int i10) {
                e0.u(iCancelSingleFileTransfer, i10);
            }
        });
    }

    public final /* synthetic */ void x(String str, final IConfirmId iConfirmId) {
        this.f10422a.confirmSessionsId(str, new IConfirmId() { // from class: m5.w
            @Override // com.transsion.fileTransfer.IConfirmId
            public final void onConfirmId(int i10, String str2) {
                e0.w(iConfirmId, i10, str2);
            }
        });
    }

    public e0() {
        this.f10428g = new a();
        this.f10429h = new b();
        this.f10430i = new c();
        this.f10431j = new d();
        this.f10432k = new e();
        this.f10422a = SourceJniMethod.getInstance();
    }
}
