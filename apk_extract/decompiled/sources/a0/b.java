package a0;

import androidx.camera.video.internal.encoder.EncoderCallback;
import androidx.camera.video.internal.encoder.EncoderImpl;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.c0;
import com.welink.protocol.nfbd.y;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import se.d4;
import se.f1;
import se.h4;
import se.i2;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(Object obj, int i8, String str, Throwable th2, int i9) {
        this.f5a = i9;
        this.e = obj;
        this.f6b = i8;
        this.f7c = str;
        this.f8d = th2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5a) {
            case 0:
                EncoderImpl.lambda$notifyError$10((EncoderCallback) this.e, this.f6b, (String) this.f7c, (Throwable) this.f8d);
                return;
            case 1:
                ((EncoderImpl) this.e).lambda$handleEncodeError$9(this.f6b, (String) this.f7c, (Throwable) this.f8d);
                return;
            case 2:
                ((f1) ((Pair) this.e).getSecond()).c((LanNetworkInfo) this.f7c, (NearDevice) this.f8d, this.f6b);
                return;
            case 3:
                h4 h4Var = (h4) this.e;
                i2 i2Var = (i2) this.f7c;
                ka.d dVar = (ka.d) this.f8d;
                int i8 = this.f6b;
                ConcurrentHashMap.KeySetView executorListenerPairs = h4Var.f9767j;
                Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
                synchronized (executorListenerPairs) {
                    try {
                        ConcurrentHashMap.KeySetView<Pair> executorListenerPairs2 = h4Var.f9767j;
                        Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                        for (Pair pair : executorListenerPairs2) {
                            ((Executor) pair.getFirst()).execute(new d4(pair, 0));
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                h4Var.B(i2Var, dVar, i8);
                return;
            default:
                NearDevice nearDeviceU = (NearDevice) this.e;
                y yVar = (y) this.f7c;
                DeviceInfo deviceInfo = (DeviceInfo) this.f8d;
                int i9 = this.f6b;
                we.h.h("SmartConnectWrapper", "Notify connectFailed");
                if (nearDeviceU == null) {
                    nearDeviceU = yVar.v(deviceInfo);
                }
                if (deviceInfo == null && nearDeviceU == null) {
                    nearDeviceU = yVar.u();
                }
                if (nearDeviceU == null) {
                    we.h.c("SmartConnectWrapper", "Current Connecting Device is null, ignore", null);
                    return;
                }
                se.e eVar = yVar.f4201o;
                if (eVar != null) {
                    eVar.q(nearDeviceU, i9);
                }
                c0 c0Var = yVar.f4191c;
                if (c0Var != null) {
                    c0Var.b(nearDeviceU);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i8, int i9) {
        this.f5a = i9;
        this.e = obj;
        this.f7c = obj2;
        this.f8d = obj3;
        this.f6b = i8;
    }
}
