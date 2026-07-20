package g8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import com.transsion.os.typeface.IFontManagerService;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6440e = "TranAospFontManagerExt";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UserHandle f6443c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IFontManagerService f6441a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ServiceConnection f6444d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f6441a = IFontManagerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f6441a = null;
        }
    }

    public b(Context context, UserHandle userHandle) {
        this.f6442b = context;
        this.f6443c = userHandle;
    }

    public boolean b() {
        if (this.f6441a != null) {
            return true;
        }
        ComponentName componentName = new ComponentName("com.transsion.os.typeface", "com.transsion.os.typeface.FontManagerService");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        return this.f6442b.bindServiceAsUser(intent, this.f6444d, 1, this.f6443c);
    }

    public int c(String str, String str2) {
        try {
            IFontManagerService iFontManagerService = this.f6441a;
            if (iFontManagerService != null) {
                return iFontManagerService.setDefaultTypeface(str, str2);
            }
            return 0;
        } catch (Exception e10) {
            e.a(f6440e, "setDefaultTypeface fail" + e10);
            return 0;
        }
    }

    public int d(ParcelFileDescriptor parcelFileDescriptor, String str) {
        try {
            IFontManagerService iFontManagerService = this.f6441a;
            if (iFontManagerService != null) {
                return iFontManagerService.setDefaultTypefaceFromParcelFileDescriptor(parcelFileDescriptor, str);
            }
            return 0;
        } catch (Exception e10) {
            e.a(f6440e, "setDefaultTypefaceFromParcelFileDescriptor fail" + e10);
            return 0;
        }
    }

    public void e() {
        if (this.f6441a != null) {
            this.f6441a = null;
            this.f6442b.unbindService(this.f6444d);
        }
    }
}
