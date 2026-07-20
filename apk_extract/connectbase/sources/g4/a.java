package g4;

import androidx.core.app.NotificationCompat;
import com.transsion.backup.model.AlbumFile;
import com.transsion.backup.model.AlbumInfo;
import com.transsion.backup.model.AuthResult;
import com.transsion.backup.model.BackupMessage;
import com.transsion.backup.model.FileServerInfo;
import com.transsion.backup.model.PageData;
import d4.d;
import java.util.List;
import k4.m;
import kn.l0;
import nm.k0;
import os.l;
import v4.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f6407a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f6408b = "FileTransferProtocol";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final g f6409c;

    static {
        g gVarE = g.e();
        l0.o(gVarE, "getInstance(...)");
        f6409c = gVarE;
    }

    public static /* synthetic */ void f(a aVar, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        aVar.d(i10, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(a aVar, PageData pageData, List list, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = k0.INSTANCE;
        }
        aVar.g(pageData, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(a aVar, List list, List list2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list2 = k0.INSTANCE;
        }
        aVar.i(list, list2);
    }

    public final void a(int i10, int i11) {
        m.e("FileTransferProtocol", "backup");
        d(4, new FileServerInfo(i10, i11));
    }

    public final void b(int i10) {
        d(0, Integer.valueOf(i10));
    }

    public final void c(@l AuthResult authResult) {
        l0.p(authResult, "authResult");
        m.e("FileTransferProtocol", "sendBackupAuthResult: " + authResult);
        d(1, authResult);
    }

    public final void d(int i10, Object obj) {
        e(new BackupMessage<>(i10, obj));
    }

    public final void e(BackupMessage<?> backupMessage) {
        f6409c.t(d.a(backupMessage));
    }

    public final void g(@l PageData<AlbumFile> pageData, @l List<AlbumInfo> list) {
        l0.p(pageData, "pageData");
        l0.p(list, "albums");
        m.e("FileTransferProtocol", "syncAlbumData: data: " + pageData);
        d(2, d4.a.i(d4.a.e(pageData, list)));
    }

    public final void i(@l List<AlbumFile> list, @l List<AlbumInfo> list2) {
        l0.p(list, "data");
        l0.p(list2, "albums");
        m.e("FileTransferProtocol", "syncAlbumUpdateData: " + list + " albums:" + list2);
        d(3, d4.a.i(d4.a.h(list, list2, 0, 0, 6, null)));
    }

    public final void k(@l String str) {
        l0.p(str, NotificationCompat.CATEGORY_STATUS);
        m.e("FileTransferProtocol", "syncAutoAlbumStatus: data: " + str);
        d(9, str);
    }
}
