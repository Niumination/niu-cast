package n5;

import af.d6;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import ck.b;
import ck.i;
import e8.d;
import fk.g;
import java.net.Socket;
import k3.o9;
import k3.v8;
import u6.e;
import ze.a2;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b, y9.a, l2.a, e {
    @Override // l2.a
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // y9.a
    public Intent b(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        return (Intent) o9.e(application, o9.d(application.getClass(), "registerReceiverAsUser", BroadcastReceiver.class, UserHandle.class, IntentFilter.class, String.class, Handler.class), broadcastReceiver, z8.a.f11265a, intentFilter, null, handler);
    }

    @Override // y9.a
    public void c(Application application, Intent intent) {
        o9.e(application, o9.d(application.getClass(), "startActivityAsUser", Intent.class, UserHandle.class), intent, z8.a.f11265a);
    }

    @Override // ek.g
    public Object call(Object obj) {
        i iVar = (i) obj;
        g gVar = new g(iVar);
        iVar.f1736a.a(gVar);
        return gVar;
    }

    public i1.b d(Socket socket, ze.b bVar) {
        n6.a aVarA = bVar.a();
        aVarA.j(ze.i.f11362b, socket.getLocalSocketAddress());
        aVarA.j(ze.i.f11361a, socket.getRemoteSocketAddress());
        aVarA.j(d6.f221a, a2.NONE);
        ze.b bVarG = aVarA.g();
        i1.b bVar2 = new i1.b();
        v8.i(socket, "socket");
        bVar2.f5527a = socket;
        v8.i(bVarG, "attributes");
        bVar2.f5528b = bVarG;
        return bVar2;
    }

    @Override // u6.e
    public void e(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString("v", (String) obj);
        e8.g.f4735b.a(new d("cleanupEvents_oom", bundle));
    }
}
