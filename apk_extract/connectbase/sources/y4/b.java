package y4;

import android.os.RemoteException;
import k4.m;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20704a = "FileTransferProtocol";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20705a = new b();
    }

    public b() {
    }

    public static b b() {
        return a.f20705a;
    }

    public static /* synthetic */ l2 d(String str) throws RemoteException {
        m.e("FileTransferProtocol", "autoBackupState: " + str);
        a5.a.f47a.a(str);
        return null;
    }

    public void c() {
        m.e("FileTransferProtocol", "init");
        d dVar = new d();
        b4.a.f725a.q(dVar, dVar, new y4.a());
    }

    public void e() {
        b4.a.f725a.s();
    }

    public b(c cVar) {
    }
}
