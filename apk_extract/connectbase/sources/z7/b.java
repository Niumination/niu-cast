package z7;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21856c = "TranAospConnectivityManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConnectivityManager f21858b;

    public class a extends ConnectivityManager.OnStartTetheringCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0604b f21859a;

        public a(InterfaceC0604b interfaceC0604b) {
            this.f21859a = interfaceC0604b;
        }

        public void a() {
            InterfaceC0604b interfaceC0604b = this.f21859a;
            if (interfaceC0604b != null) {
                interfaceC0604b.b();
            }
        }

        public void b() {
            InterfaceC0604b interfaceC0604b = this.f21859a;
            if (interfaceC0604b != null) {
                interfaceC0604b.a();
            }
        }
    }

    /* JADX INFO: renamed from: z7.b$b, reason: collision with other inner class name */
    public interface InterfaceC0604b {
        void a();

        void b();
    }

    public b(Context context) {
        this.f21857a = context;
        if (this.f21858b == null) {
            this.f21858b = (ConnectivityManager) context.getSystemService("connectivity");
        }
    }

    @b.a({"MissingPermission"})
    public void a(int i10, boolean z10, InterfaceC0604b interfaceC0604b) {
        this.f21858b.startTethering(i10, z10, new a(interfaceC0604b));
    }
}
