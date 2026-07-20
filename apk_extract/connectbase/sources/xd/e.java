package xd;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.typeface.ITranFontManagerService;
import ic.n0;
import n1.i;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class e implements rg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20151c = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20153b = bc.a.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranFontManagerService f20152a = ITranFontManagerService.Stub.asInterface(TranServiceManager.getServiceIBinder(i.f11251q));

    @Override // rg.a
    public void a() {
        new f(this.f20153b).c(new f.b() { // from class: xd.b
            @Override // zb.f.b
            public final Object run() {
                return this.f20146a.l();
            }
        }, i.f11251q);
    }

    @Override // rg.a
    public boolean b() {
        boolean zBooleanValue = ((Boolean) new f(this.f20153b).c(new f.b() { // from class: xd.c
            @Override // zb.f.b
            public final Object run() {
                return this.f20147a.i();
            }
        }, i.f11251q)).booleanValue();
        n0.a("bindFontManagerService isBind:", zBooleanValue, f20151c);
        return zBooleanValue;
    }

    @Override // rg.a
    public int c(final ParcelFileDescriptor parcelFileDescriptor, final String str) {
        int iIntValue = ((Integer) new f(this.f20153b).c(new f.b() { // from class: xd.d
            @Override // zb.f.b
            public final Object run() {
                return this.f20148a.k(parcelFileDescriptor, str);
            }
        }, i.f11251q)).intValue();
        dc.e.f(f20151c, "setDefaultTypefaceFromParcelFileDescriptor result:" + iIntValue);
        return iIntValue;
    }

    @Override // rg.a
    public int d(final String str, final String str2) {
        int iIntValue = ((Integer) new f(this.f20153b).c(new f.b() { // from class: xd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f20143a.j(str, str2);
            }
        }, i.f11251q)).intValue();
        dc.e.f(f20151c, "setDefaultTypeface result:" + iIntValue);
        return iIntValue;
    }

    public final /* synthetic */ Object i() throws RemoteException {
        ITranFontManagerService iTranFontManagerService = this.f20152a;
        return iTranFontManagerService != null ? Boolean.valueOf(iTranFontManagerService.bindFontManagerService()) : Boolean.FALSE;
    }

    public final /* synthetic */ Object j(String str, String str2) throws RemoteException {
        ITranFontManagerService iTranFontManagerService = this.f20152a;
        if (iTranFontManagerService != null) {
            return Integer.valueOf(iTranFontManagerService.setDefaultTypeface(str, str2));
        }
        return 0;
    }

    public final /* synthetic */ Object k(ParcelFileDescriptor parcelFileDescriptor, String str) throws RemoteException {
        ITranFontManagerService iTranFontManagerService = this.f20152a;
        if (iTranFontManagerService != null) {
            return Integer.valueOf(iTranFontManagerService.setDefaultTypefaceFromParcelFileDescriptor(parcelFileDescriptor, str));
        }
        return 0;
    }

    public final /* synthetic */ Object l() throws RemoteException {
        ITranFontManagerService iTranFontManagerService = this.f20152a;
        if (iTranFontManagerService == null) {
            return null;
        }
        iTranFontManagerService.unbindFontManagerService();
        return null;
    }
}
