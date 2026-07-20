package yd;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.persistentdata.ITranPersistentDataBlockManager;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements sg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20820b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranPersistentDataBlockManager f20821a = ITranPersistentDataBlockManager.Stub.asInterface(TranServiceManager.getServiceIBinder("persistent_data_block_service"));

    @Override // sg.a
    public int a() {
        return ((Integer) new f().c(new f.b() { // from class: yd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f20819a.c();
            }
        }, "persistent_data_block_service")).intValue();
    }

    public final /* synthetic */ Object c() throws RemoteException {
        ITranPersistentDataBlockManager iTranPersistentDataBlockManager = this.f20821a;
        if (iTranPersistentDataBlockManager != null) {
            return Integer.valueOf(iTranPersistentDataBlockManager.getDataBlockSize());
        }
        return -1;
    }
}
