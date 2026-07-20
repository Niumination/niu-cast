package ta;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPSourceApi;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import x7.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10202a = new a();

    public static void a() {
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        a listener = f10202a;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("registerCapabilityListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "registerCapabilityListener");
        }
        f.f10882a.registerCapabilityLinstner(listener);
    }
}
