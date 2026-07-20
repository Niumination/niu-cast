package de;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.content.res.ITranAssetManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements xg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3702b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAssetManager f3703a = ITranAssetManager.Stub.asInterface(TranServiceManager.getServiceIBinder("asset_manager"));

    @Override // xg.a
    public int a(final String str) {
        int iIntValue = ((Integer) new f().c(new f.b() { // from class: de.a
            @Override // zb.f.b
            public final Object run() {
                return this.f3700a.c(str);
            }
        }, "asset_manager")).intValue();
        e.a(f3702b, "addAssetPath result:" + iIntValue);
        return iIntValue;
    }

    public final /* synthetic */ Object c(String str) throws RemoteException {
        ITranAssetManager iTranAssetManager = this.f3703a;
        if (iTranAssetManager != null) {
            return Integer.valueOf(iTranAssetManager.addAssetPath(str));
        }
        return 0;
    }

    @VisibleForTesting
    public void d(ITranAssetManager iTranAssetManager) {
        this.f3703a = iTranAssetManager;
    }
}
