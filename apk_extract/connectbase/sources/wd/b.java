package wd;

import android.os.RemoteException;
import android.os.storage.StorageVolume;
import android.util.ArrayMap;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.storage.ITranStorageEventListener;
import com.transsion.hubsdk.os.storage.ITranStorageManager;
import com.transsion.hubsdk.os.storage.TranDiskInfo;
import com.transsion.hubsdk.os.storage.TranVolumeInfo;
import dc.e;
import java.util.ArrayList;
import java.util.List;
import wa.d;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements qg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f18265c = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<wa.b.a, a> f18267b = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranStorageManager f18266a = ITranStorageManager.Stub.asInterface(TranServiceManager.getServiceIBinder("storage_manager"));

    public class a extends ITranStorageEventListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wa.b.a f18268a;

        public a(wa.b.a aVar) {
            this.f18268a = aVar;
        }

        public void a(String str, String str2, String str3) {
            this.f18268a.a(str, str2, str3);
        }

        public void b(TranVolumeInfo tranVolumeInfo, int i10, int i11) {
            if (tranVolumeInfo != null) {
                d dVar = new d(tranVolumeInfo.getId(), tranVolumeInfo.getType(), tranVolumeInfo.getFsUuid(), tranVolumeInfo.path);
                dVar.l(tranVolumeInfo.getDescription());
                dVar.p(tranVolumeInfo.getState());
                this.f18268a.b(dVar, i10, i11);
            }
        }
    }

    @Override // qg.a
    public String a(String str) {
        try {
            ITranStorageManager iTranStorageManager = this.f18266a;
            if (iTranStorageManager != null) {
                return iTranStorageManager.getVolumeState(str);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getVolumeState fail ", e10, f18265c);
            return null;
        }
    }

    @Override // qg.a
    public long b() {
        long jLongValue = ((Long) new f().c(new f.b() { // from class: wd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f18264a.n();
            }
        }, "storage_manager")).longValue();
        e.f(f18265c, "getStorageLowBytes result:" + jLongValue);
        return jLongValue;
    }

    @Override // qg.a
    public void c(wa.b.a aVar) {
        a aVar2 = this.f18267b.get(aVar);
        if (aVar2 != null) {
            try {
                this.f18266a.unregisterListener(aVar2);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        this.f18267b.remove(aVar);
    }

    @Override // qg.a
    public List<d> d() {
        List<TranVolumeInfo> volumes;
        ITranStorageManager iTranStorageManager = this.f18266a;
        if (iTranStorageManager == null) {
            return null;
        }
        try {
            volumes = iTranStorageManager.getVolumes();
        } catch (RemoteException e10) {
            j7.b.a("getVolumes:", e10, f18265c);
            volumes = null;
        }
        if (volumes == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TranVolumeInfo tranVolumeInfo : volumes) {
            d dVar = new d(tranVolumeInfo.getId(), tranVolumeInfo.getType(), tranVolumeInfo.getFsUuid(), tranVolumeInfo.path);
            dVar.l(tranVolumeInfo.getDescription());
            dVar.p(tranVolumeInfo.getState());
            TranDiskInfo disk = tranVolumeInfo.getDisk();
            e.f("TranStorageManager", "diskInfo = " + disk);
            if (disk != null) {
                dVar.m(new wa.a(disk.id, disk.flags));
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    @Override // qg.a
    public void e(wa.b.a aVar) {
        a aVar2 = new a(aVar);
        this.f18267b.put(aVar, aVar2);
        try {
            this.f18266a.registerListener(aVar2);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // qg.a
    public List<d> f() {
        List<TranVolumeInfo> volumes;
        ITranStorageManager iTranStorageManager = this.f18266a;
        if (iTranStorageManager == null) {
            return null;
        }
        try {
            volumes = iTranStorageManager.getVolumes();
        } catch (RemoteException e10) {
            j7.b.a("getVolumes:", e10, f18265c);
            volumes = null;
        }
        if (volumes == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TranVolumeInfo tranVolumeInfo : volumes) {
            arrayList.add(new d(tranVolumeInfo.id, tranVolumeInfo.getType(), tranVolumeInfo.getMountFlags()));
        }
        return arrayList;
    }

    @Override // qg.a
    public StorageVolume[] g(int i10) {
        try {
            return this.f18266a.getVolumeList(i10, bc.a.a().getOpPackageName(), 0);
        } catch (RemoteException e10) {
            j7.b.a("getVolumeList fail ", e10, f18265c);
            return null;
        }
    }

    @Override // qg.a
    public d h(String str) {
        return null;
    }

    @Override // qg.a
    public String i(d dVar) {
        return null;
    }

    @Override // qg.a
    public String[] j() {
        try {
            return this.f18266a.getVolumePaths();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // qg.a
    public boolean k() {
        e.a(f18265c, "isFileEncryptedNativeOrEmulated");
        ITranStorageManager iTranStorageManager = this.f18266a;
        if (iTranStorageManager != null) {
            try {
                return iTranStorageManager.isFileEncryptedNativeOrEmulated();
            } catch (RemoteException e10) {
                e.d(f18265c, "isFileEncryptedNativeOrEmulated", e10);
            }
        }
        return false;
    }

    @Override // qg.a
    public long l() {
        try {
            return this.f18266a.getPrimaryStorageSize();
        } catch (RemoteException e10) {
            e.f(f18265c, "getPrimaryStorageSize error: " + e10);
            return 0L;
        }
    }

    public final /* synthetic */ Object n() throws RemoteException {
        ITranStorageManager iTranStorageManager = this.f18266a;
        if (iTranStorageManager != null) {
            return Long.valueOf(iTranStorageManager.getStorageLowBytes());
        }
        return 119L;
    }

    @VisibleForTesting
    public void o(ITranStorageManager iTranStorageManager) {
        this.f18266a = iTranStorageManager;
    }
}
