package cf;

import java.net.ServerSocket;
import k3.t8;
import ze.q0;
import ze.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f1646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServerSocket f1647b;

    public w(ServerSocket serverSocket) {
        this.f1647b = serverSocket;
        this.f1646a = r0.a(w.class, String.valueOf(serverSocket.getLocalSocketAddress()));
    }

    @Override // ze.q0
    public final r0 d() {
        return this.f1646a;
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.e("logId", this.f1646a.f11421c);
        aVarA.d(this.f1647b, "socket");
        return aVarA.toString();
    }
}
