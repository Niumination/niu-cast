package j3;

import af.f6;
import af.l1;
import android.content.Context;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpScreenLockRequestBean;
import eb.l2;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class z implements f6, f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z f6092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f6093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static z f6094c;

    public static Context a() {
        return f6093b;
    }

    public static void c() {
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        if (tCCPHandshakeSocketServer != null) {
            tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getLOCKSCREEN_TCCP(), new TccpScreenLockRequestBean(false));
        }
    }

    @Override // af.f6
    public Object b() {
        return Executors.newCachedThreadPool(l1.f("grpc-okhttp-%d"));
    }

    @Override // af.f6
    public void f(Object obj) {
        ((ExecutorService) ((Executor) obj)).shutdown();
    }

    @Override // f8.b
    public void onInitFail() {
    }

    @Override // f8.b
    public void onInitSuccess(Map map) {
    }
}
