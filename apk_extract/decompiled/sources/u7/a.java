package u7;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10400c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f10398a = LazyKt.lazy(new ob.c(13));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f10399b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final eb.d f10401d = new eb.d(1);

    public static void a(ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.checkNotNullParameter(networkCallback, "networkCallback");
        gc.a("NetWorkUtils", "registerNetWorkChangeCallBack");
        ConcurrentLinkedQueue concurrentLinkedQueue = f10399b;
        if (!concurrentLinkedQueue.contains(networkCallback)) {
            concurrentLinkedQueue.add(networkCallback);
        }
        if (f10400c) {
            gc.c("NetWorkUtils", "registerNetWorkChangeCallBack:already registered");
            return;
        }
        f10400c = true;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f10398a.getValue();
            if (connectivityManager != null) {
                connectivityManager.requestNetwork(new NetworkRequest.Builder().build(), f10401d);
            }
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("NetWorkUtils", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("NetWorkUtils"), e.getMessage(), e);
        }
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("NetWorkUtils", "tag");
        Intrinsics.checkNotNullParameter("reset", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("NetWorkUtils"), "reset");
        }
        f10399b.clear();
        if (f10400c) {
            f10400c = false;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) f10398a.getValue();
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(f10401d);
                }
            } catch (Exception e) {
                Intrinsics.checkNotNullParameter("NetWorkUtils", "tag");
                Intrinsics.checkNotNullParameter(e, "e");
                Log.e(gc.f6463b.concat("NetWorkUtils"), e.getMessage(), e);
            }
        }
    }
}
