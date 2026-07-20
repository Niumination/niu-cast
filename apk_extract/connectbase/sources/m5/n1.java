package m5;

import com.transsion.aiotlink.ICloseFileServersListener;
import com.transsion.aiotlink.ISourceFileStateListener;
import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.aiotlink.NativeLinkManager;

/* JADX INFO: loaded from: classes2.dex */
public class n1 extends m5.a implements h1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10498l = "OldFileTransfer";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10499m = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NativeLinkManager f10500j = NativeLinkManager.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ISourceFileStateListener f10501k = new b();

    public class a implements IStreamDataListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f10502a;

        public a(n1 n1Var, Runnable runnable) {
            this.f10502a = runnable;
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            this.f10502a.run();
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(byte[] bArr, int i10, int i11) {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
        }
    }

    public class b implements ISourceFileStateListener {
        public b() {
        }

        @Override // com.transsion.aiotlink.ISourceFileStateListener
        public void onReceiveFileDone(String str) {
            n1.this.h(str);
        }

        @Override // com.transsion.aiotlink.ISourceFileStateListener
        public void onReceiveFileProgress(int i10, String str, String str2, String str3) {
            n1.this.a(i10, str, str3, str2, "", 1);
        }

        @Override // com.transsion.aiotlink.ISourceFileStateListener
        public void onSendFileDone(String str) {
            n1.this.c(str);
        }

        @Override // com.transsion.aiotlink.ISourceFileStateListener
        public void onSendFileProgress(int i10, String str, String str2, String str3) {
            n1.this.f(i10, str, str3, str2, "", 1);
        }
    }

    public static void t(int i10, int i11) {
        k4.m.b(f10498l, "reconnectFileChannel port ready");
        m0.a.f10496a.v(new m5.b(i10, 0, 0));
    }

    @Override // m5.h1
    public void b() {
        this.f10500j.closeFileServerCallback(new ICloseFileServersListener() { // from class: m5.k1
            @Override // com.transsion.aiotlink.ICloseFileServersListener
            public final void onCloseCallback(int i10, String str) {
                this.f10480a.v(i10, str);
            }
        });
    }

    @Override // m5.h1
    public void e() {
        this.f10500j.closeFileServer();
    }

    @Override // m5.h1
    public void j(i1 i1Var, Runnable runnable) {
        String strB = g1.b();
        k4.m.b(f10498l, "default save path:" + strB);
        this.f10500j.createFileServer(k4.f.f8947o, new a(this, runnable));
        i1Var.a(k4.f.f8947o, 0);
        this.f10500j.setFileSavePath(strB);
        this.f10500j.setFileTransferConfig(1, 0, 0);
        this.f10500j.setFileStatusListener(this.f10501k);
        this.f10500j.qosType(0);
    }

    @Override // m5.h1
    public void l() {
        NativeLinkManager nativeLinkManager = this.f10500j;
        if (nativeLinkManager != null) {
            nativeLinkManager.cancelReceiveCurrentFile();
            this.f10500j.closeFileServer();
        }
    }

    @Override // m5.h1
    public void m(String str, String str2, int i10, String str3, String str4) {
        this.f10500j.setFileSendPath(str, str2, 0, str3);
    }

    @Override // m5.h1
    public void o(int i10) {
        v4.g.e().a();
        this.f10500j.cancelReceiveCurrentFile();
    }

    public final /* synthetic */ void v(int i10, String str) {
        if (i10 == 0) {
            k4.m.b(f10498l, str);
            j(new l1(), new m1());
        }
    }
}
