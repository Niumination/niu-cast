package m5;

import android.app.usage.StorageStatsManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.sdk.FileInfo;
import com.transsion.connectx.sdk.FileInfoSyncRequest;
import com.transsion.connectx.sdk.FileInfoSyncRequestContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class m0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10485f = "FileTransferProtocol";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10486g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10487h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10488i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10489j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10490k = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w4.c0 f10491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f10493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StorageStatsManager f10494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f10495e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m0 f10496a = new m0();
    }

    public static m0 k() {
        return a.f10496a;
    }

    public void A(int i10) {
        k4.m.b("FileTransferProtocol", "syncServerCancelFileTransfer into");
        v4.g.e().L(i10);
    }

    public void f(final int i10) {
        this.f10495e.postAtFrontOfQueue(new Runnable() { // from class: m5.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10468a.q(i10);
            }
        });
    }

    public final void g(boolean z10, String str) {
        if (z10) {
            String parent = new File(str).getParent();
            if (parent == null) {
                k4.m.e("FileTransferProtocol", "checkFolderPath: file no parent");
                return;
            }
            File file = new File(parent);
            if (file.exists()) {
                return;
            }
            k4.m.c("FileTransferProtocol", "checkFolderPath: file save folder no exist, create result:" + file.mkdirs());
        }
    }

    public void h(List<String> list, String str, boolean z10, String str2, String str3) {
        k4.m.b("FileTransferProtocol", "confirmReceiveFile:path=" + str + "filePackageName=" + str2 + ";fileId:" + str3);
        if (TextUtils.isEmpty(str)) {
            k4.m.c("FileTransferProtocol", "confirmReceiveFile:save path is null");
            return;
        }
        if (!z10) {
            k4.m.c("FileTransferProtocol", "confirmReceiveFile:refuse receive file");
            this.f10492b.T(str3);
        }
        int i10 = !z10 ? 1 : 0;
        g(z10, str);
        this.f10492b.J(str3, str);
        v4.g.e().c(new n2.e(i10, list, str, str2, str3));
        w4.o1.a.f18113a.n(i10, list.size());
    }

    @NonNull
    public final List<n2.l0.a> i(@Nullable FileInfoSyncRequestContent fileInfoSyncRequestContent) {
        ArrayList arrayList = new ArrayList();
        if (fileInfoSyncRequestContent == null) {
            k4.m.c("FileTransferProtocol", "convertDragEventToResourceList dragEvent == null");
            return arrayList;
        }
        k4.m.e("FileTransferProtocol", "convertDragEventToResourceList dragEvent=" + fileInfoSyncRequestContent);
        Iterator<FileInfo> it = fileInfoSyncRequestContent.getContents().iterator();
        while (it.hasNext()) {
            arrayList.add(j(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public final n2.l0.a j(@NonNull FileInfo fileInfo) {
        return new n2.l0.a(fileInfo.getId(), fileInfo.getUri(), fileInfo.getThumbnail(), fileInfo.getName(), fileInfo.getFormat(), fileInfo.getType(), fileInfo.getFileSize());
    }

    public final String l(String str) {
        String strA = a6.f.a();
        if (TextUtils.isEmpty(str)) {
            return this.f10491a.F(strA) ? strA : "";
        }
        if (this.f10491a.F(str)) {
            return str;
        }
        return this.f10491a.F(strA) ? strA : "";
    }

    public void m(final n2.q qVar) {
        this.f10495e.post(new Runnable() { // from class: m5.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10471a.r(qVar);
            }
        });
    }

    public void n(@NonNull final p2.b bVar) {
        this.f10495e.post(new Runnable() { // from class: m5.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10478a.s(bVar);
            }
        });
    }

    public void o(final n2.l0 l0Var, final String str) {
        this.f10495e.post(new Runnable() { // from class: m5.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10481a.t(l0Var, str);
            }
        });
    }

    public void p(final n2.v vVar) {
        this.f10492b.z(vVar.c(), o1.j(vVar, ""));
        this.f10495e.post(new Runnable() { // from class: m5.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10455a.u(vVar);
            }
        });
    }

    public final void q(int i10) {
        s.a.f10535a.o(i10);
        this.f10495e.removeCallbacksAndMessages(null);
    }

    public final /* synthetic */ void r(n2.q qVar) {
        k4.m.e("FileTransferProtocol", "handleFileTransferFailNotify:" + qVar);
        if (TextUtils.isEmpty(qVar.a())) {
            k4.m.c("FileTransferProtocol", "handleFileTransferFailNotify: file id is empty");
            return;
        }
        o1 o1VarS = qVar.c() == 0 ? this.f10492b.s(qVar.a()) : null;
        if (qVar.c() == 1) {
            o1VarS = this.f10492b.p(qVar.a());
        }
        if (o1VarS == null) {
            k4.m.c("FileTransferProtocol", "handleFileTransferFailNotify: file info is null");
            return;
        }
        if (qVar.c() == 0) {
            k4.m.b("FileTransferProtocol", "handleFileTransferFailNotify: notify send file transfer fail");
            this.f10491a.z0(o1VarS.e(), o1VarS.f(), qVar.d(), qVar.a(), o1VarS.i());
            this.f10492b.T(qVar.a());
            if (this.f10492b.y()) {
                this.f10491a.w0(o1VarS.e());
                return;
            }
            return;
        }
        k4.m.b("FileTransferProtocol", "handleFileTransferFailNotify: notify receive file transfer fail");
        this.f10491a.t0(o1VarS.e(), o1VarS.f(), qVar.d(), qVar.a(), o1VarS.i());
        this.f10492b.S(qVar.a());
        if (this.f10492b.x()) {
            this.f10491a.q0(o1VarS.e());
        }
    }

    public final void s(p2.b bVar) {
        k4.m.b("FileTransferProtocol", "handleOnPeerConfirmFileTask response:" + bVar);
        String strD = bVar.a().d();
        if (TextUtils.isEmpty(strD)) {
            k4.m.e("FileTransferProtocol", "handleOnPeerConfirmFileTask:not explicit any handler app");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n2.l0.a> it = bVar.a().a().iterator();
        while (it.hasNext()) {
            arrayList.add(k4.j.a.f8962a.g(it.next()));
        }
        if (bVar.b() == 2) {
            k4.m.b("FileTransferProtocol", "handleOnPeerConfirmFileTask peer decline task, clear queue task");
            k.a.f10477a.U((Set) bVar.a().a().stream().map(new h0()).collect(Collectors.toSet()));
        }
        this.f10491a.o0(strD, bVar.b(), bVar.a().c(), arrayList);
    }

    public final void t(n2.l0 l0Var, String str) {
        if (l0Var == null || l0Var.a() == null || l0Var.a().isEmpty()) {
            k4.m.c("FileTransferProtocol", "handlePeerRequestReceiveFile,param is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            k4.m.e("FileTransferProtocol", "handlePeerRequestReceiveFile:not explicit any handler app");
            return;
        }
        if (b6.a.f744b.equals(str)) {
            k4.m.c("FileTransferProtocol", "handlePeerRequestReceiveFile:target on source-service,not implement yet");
            return;
        }
        long jB = l0Var.b();
        if (l0Var.a().isEmpty() || l0Var.a().get(0) == null) {
            k4.m.c("FileTransferProtocol", "handlePeerRequestReceiveFile:request no file content");
            return;
        }
        n2.l0.a aVar = l0Var.a().get(0);
        k4.m.b("FileTransferProtocol", "Sink save disk free size:" + jB);
        if (!g1.k(jB, aVar.g())) {
            k4.m.c("FileTransferProtocol", "Client storage space not enough");
            this.f10492b.T(aVar.c());
            w(l0Var.e(), aVar.c(), 0, 0);
            this.f10491a.z0(str, aVar.g(), 0, aVar.c(), l0Var.f());
            if (this.f10492b.y()) {
                this.f10491a.w0(str);
                return;
            }
            return;
        }
        for (n2.l0.a aVar2 : l0Var.a()) {
            k4.m.b("FileTransferProtocol", "handlePeerRequestReceiveFile id:" + aVar.c());
            String strC = aVar.c();
            if (TextUtils.isEmpty(strC)) {
                strC = UUID.randomUUID().toString();
            }
            this.f10493c.put(strC, l0Var.e());
            k.a.f10477a.L(strC, l0Var.e());
            this.f10491a.m0(str, aVar2.g(), strC, l0Var.f());
        }
    }

    public final void u(n2.v vVar) {
        String strR0 = w4.l1.h.f18073a.r0(vVar);
        if (strR0 == null) {
            k4.m.c("FileTransferProtocol", "Target package name is null");
            this.f10492b.T(vVar.c());
            w(vVar.a(), vVar.c(), 1, 6);
            return;
        }
        k4.m.e("FileTransferProtocol", "handlePeerRequestSendFile:" + vVar + ks.g.f9491d + strR0);
        if (!g1.l(this.f10494d, vVar.b())) {
            k4.m.c("FileTransferProtocol", "Server storage space not enough");
            this.f10492b.T(vVar.c());
            w(vVar.a(), vVar.c(), 1, 1);
            return;
        }
        String strL = l(strR0);
        k4.m.e("FileTransferProtocol", "passOnPackageName:" + strL);
        if (TextUtils.isEmpty(strL)) {
            k4.m.c("FileTransferProtocol", "registerPackageName is empty");
            w(vVar.a(), vVar.c(), 1, 6);
            return;
        }
        k4.m.b("FileTransferProtocol", "handlePeerRequestSendFile id:" + vVar.c());
        this.f10492b.I(vVar.c(), strL);
        this.f10491a.l0(strL, vVar.b(), vVar.a(), strR0, vVar.c(), vVar.e());
        w4.o1.a.f18113a.t(vVar.a(), vVar.b());
    }

    public void v(b bVar) {
        v4.g.e().f(bVar.c(), bVar.b(), bVar.a(), Arrays.asList(1, 2, 3));
    }

    public void w(String str, String str2, int i10, int i11) {
        v4.g.e().g(str, str2, i10, i11);
    }

    public void x() {
        this.f10495e.removeCallbacksAndMessages(null);
    }

    public void y(List<String> list, int i10, String str, String str2) {
        String strF;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(g1.d(it.next())));
        }
        o1 o1VarS = this.f10492b.s(str2);
        if (o1VarS != null) {
            k4.m.b("FileTransferProtocol", "requestSendFileToPeer fileInfo no null");
            strF = o1VarS.f();
        } else {
            strF = "";
        }
        if (TextUtils.isEmpty(strF)) {
            strF = this.f10493c.get(str2);
            this.f10493c.remove(str2);
        }
        String str3 = strF;
        k4.m.b("FileTransferProtocol", "requestSendFileToPeer:savePath=" + str3);
        v4.g.e().G(list, i10, arrayList, str, str3, str2);
    }

    public void z(@NonNull FileInfoSyncRequest fileInfoSyncRequest) {
        for (FileInfo fileInfo : fileInfoSyncRequest.getFileInfo()) {
            if (TextUtils.isEmpty(fileInfo.getId())) {
                k4.m.b("FileTransferProtocol", "file id is null, generate id");
                fileInfo.setId(s.a.f10535a.i());
            }
            k.a.f10477a.A(fileInfo.getId(), o1.a(fileInfo, fileInfoSyncRequest.getType(), fileInfoSyncRequest.getPackageName()));
        }
        FileInfoSyncRequestContent fileInfoSyncRequestContent = new FileInfoSyncRequestContent(fileInfoSyncRequest.getType(), fileInfoSyncRequest.getFileInfo(), fileInfoSyncRequest.getPackageName());
        k4.m.b("FileTransferProtocol", "transferInfo=" + fileInfoSyncRequestContent);
        List<n2.l0.a> listI = i(fileInfoSyncRequestContent);
        if (listI.isEmpty()) {
            k4.m.c("FileTransferProtocol", "sendFileInfoSyncRequest: content is empty");
        } else {
            v4.g.e().N(fileInfoSyncRequestContent.getType(), fileInfoSyncRequestContent.getPackageName(), listI);
        }
    }

    public m0() {
        this.f10491a = w4.c0.b.f17991a;
        this.f10492b = k.a.f10477a;
        this.f10493c = new ConcurrentHashMap<>();
        this.f10494d = (StorageStatsManager) SourceApplication.b().getSystemService(StorageStatsManager.class);
        HandlerThread handlerThread = new HandlerThread("file");
        handlerThread.start();
        this.f10495e = new Handler(handlerThread.getLooper());
    }
}
