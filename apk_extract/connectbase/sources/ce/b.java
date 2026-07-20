package ce;

import android.content.ContentResolver;
import android.content.Context;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.provider.ITranSettings;
import com.transsion.hubsdk.provider.TranSettings;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b implements wg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1451c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranSettings f1452a = ITranSettings.Stub.asInterface(TranServiceManager.getServiceIBinder("settings_provider"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranSettings f1453b;

    @Override // wg.b
    public String a(ContentResolver contentResolver, String str, int i10) {
        return p().getSecureStringForUser(contentResolver, str, i10);
    }

    @Override // wg.b
    public int b(ContentResolver contentResolver, String str, int i10, int i11) {
        return p().getSecureIntForUser(contentResolver, str, i10, i11);
    }

    @Override // wg.b
    public boolean c(String str, int i10, int i11) {
        try {
            ITranSettings iTranSettings = this.f1452a;
            if (iTranSettings != null) {
                return iTranSettings.putSecureIntForUser(str, i10, i11);
            }
            return false;
        } catch (RemoteException unused) {
            e.c(f1451c, "putSecureIntForUser fail");
            return false;
        }
    }

    @Override // wg.b
    public float d(ContentResolver contentResolver, String str, float f10, int i10) {
        return p().getSystemFloatForUser(contentResolver, str, f10, i10);
    }

    @Override // wg.b
    public boolean e(String str, float f10, int i10) {
        try {
            ITranSettings iTranSettings = this.f1452a;
            if (iTranSettings != null) {
                return iTranSettings.putSystemFloatForUser(str, f10, i10);
            }
            return false;
        } catch (RemoteException unused) {
            e.c(f1451c, "putSystemFloatForUser fail");
            return false;
        }
    }

    @Override // wg.b
    public boolean f(String str, String str2, int i10) {
        try {
            ITranSettings iTranSettings = this.f1452a;
            if (iTranSettings != null) {
                return iTranSettings.putSecureStringForUser(str, str2, i10);
            }
            return false;
        } catch (RemoteException unused) {
            e.c(f1451c, "putSecureStringForUser fail");
            return false;
        }
    }

    @Override // wg.b
    public boolean g(Context context, String str, int i10) {
        return p().putSecureInt(context, str, i10);
    }

    @Override // wg.b
    public boolean h(ContentResolver contentResolver, String str, String str2, int i10) {
        return p().putSecureStringForUser(contentResolver, str, str2, i10);
    }

    @Override // wg.b
    public int i(String str, int i10, int i11) {
        try {
            ITranSettings iTranSettings = this.f1452a;
            if (iTranSettings != null) {
                return iTranSettings.getSecureIntForUser(str, i10, i11);
            }
        } catch (RemoteException unused) {
            e.c(f1451c, "getSecureIntForUser fail");
        }
        return i10;
    }

    @Override // wg.b
    public String j(String str, int i10) {
        try {
            ITranSettings iTranSettings = this.f1452a;
            if (iTranSettings != null) {
                return iTranSettings.getSecureStringForUser(str, i10);
            }
            return null;
        } catch (RemoteException unused) {
            e.c(f1451c, "getSecureStringForUser fail");
            return null;
        }
    }

    @Override // wg.b
    public boolean k(ContentResolver contentResolver, String str, int i10, int i11) {
        return p().putSecureIntForUser(contentResolver, str, i10, i11);
    }

    @Override // wg.b
    public boolean l(Context context, String str, int i10) {
        return p().putGlobalInt(context, str, i10);
    }

    @Override // wg.b
    public boolean m(ContentResolver contentResolver, String str, float f10, int i10) {
        return p().putSystemFloatForUser(contentResolver, str, f10, i10);
    }

    @Override // wg.b
    public long n(ContentResolver contentResolver, String str, long j10, int i10) {
        return p().getSystemLongForUser(contentResolver, str, j10, i10);
    }

    @Override // wg.b
    public float o(String str, float f10, int i10) {
        try {
            ITranSettings iTranSettings = this.f1452a;
            if (iTranSettings != null) {
                return iTranSettings.getSystemFloatForUser(str, f10, i10);
            }
        } catch (RemoteException unused) {
            e.c(f1451c, "getSystemFloatForUser fail");
        }
        return f10;
    }

    public final TranSettings p() {
        if (this.f1453b == null) {
            this.f1453b = new TranSettings();
        }
        return this.f1453b;
    }
}
