package je;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.telephony.ITranMtkTelephonyExManager;

/* JADX INFO: loaded from: classes2.dex */
public class e implements dh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranMtkTelephonyExManager f8682a = ITranMtkTelephonyExManager.Stub.asInterface(TranServiceManager.getServiceIBinder("phoneEx"));

    @Override // dh.b
    public boolean a(final int i10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: je.d
            @Override // zb.f.b
            public final Object run() {
                return this.f8680a.i(i10);
            }
        }, "phoneEx")).booleanValue();
    }

    @Override // dh.b
    public String b(final int i10) {
        return (String) new zb.f().c(new zb.f.b() { // from class: je.c
            @Override // zb.f.b
            public final Object run() {
                return this.f8678a.h(i10);
            }
        }, "phoneEx");
    }

    @Override // dh.b
    public int[] c(final int i10) {
        return (int[]) new zb.f().c(new zb.f.b() { // from class: je.b
            @Override // zb.f.b
            public final Object run() {
                return this.f8676a.g(i10);
            }
        }, "phoneEx");
    }

    public final /* synthetic */ Object g(int i10) throws RemoteException {
        ITranMtkTelephonyExManager iTranMtkTelephonyExManager = this.f8682a;
        if (iTranMtkTelephonyExManager != null) {
            return iTranMtkTelephonyExManager.getAdnStorageInfo(i10);
        }
        return null;
    }

    public final /* synthetic */ Object h(int i10) throws RemoteException {
        ITranMtkTelephonyExManager iTranMtkTelephonyExManager = this.f8682a;
        if (iTranMtkTelephonyExManager != null) {
            return iTranMtkTelephonyExManager.getIccCardType(i10);
        }
        return null;
    }

    public final /* synthetic */ Object i(int i10) throws RemoteException {
        ITranMtkTelephonyExManager iTranMtkTelephonyExManager = this.f8682a;
        return iTranMtkTelephonyExManager != null ? Boolean.valueOf(iTranMtkTelephonyExManager.isPhbReady(i10)) : Boolean.FALSE;
    }
}
