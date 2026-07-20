package f7;

import android.content.Context;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5907e = "TranAospDeviceStateManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DeviceStateManager f5909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0139b f5910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public final DeviceStateManager.DeviceStateCallback f5911d = new a();

    public class a implements DeviceStateManager.DeviceStateCallback {
        public a() {
        }

        public void a(DeviceState deviceState) {
            if (b.this.f5910c != null) {
                b.this.f5910c.b(deviceState.getIdentifier());
            }
        }
    }

    /* JADX INFO: renamed from: f7.b$b, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0139b {
        void a(int i10);

        void b(int i10);

        void c(int[] iArr);
    }

    public b(Context context) {
        this.f5908a = context;
        this.f5909b = (DeviceStateManager) context.getSystemService(DeviceStateManager.class);
    }

    @Deprecated
    public void b(Executor executor, InterfaceC0139b interfaceC0139b) {
        this.f5910c = interfaceC0139b;
        this.f5909b.registerCallback(executor, this.f5911d);
    }

    @Deprecated
    public void c(InterfaceC0139b interfaceC0139b) {
        if (interfaceC0139b != null) {
            this.f5909b.unregisterCallback(this.f5911d);
        }
    }
}
