package wd;

import android.os.storage.StorageVolume;
import com.transsion.hubsdk.os.storage.TranStorageVolume;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class c implements qg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranStorageVolume f18270a = null;

    @Override // qg.b
    public boolean a(StorageVolume storageVolume) {
        if (this.f18270a == null) {
            this.f18270a = new TranStorageVolume(storageVolume);
        }
        return this.f18270a.isRemovable();
    }

    @Override // qg.b
    public File b(StorageVolume storageVolume) {
        if (this.f18270a == null) {
            this.f18270a = new TranStorageVolume(storageVolume);
        }
        return this.f18270a.getPath();
    }

    @Override // qg.b
    public String c(StorageVolume storageVolume) {
        if (this.f18270a == null) {
            this.f18270a = new TranStorageVolume(storageVolume);
        }
        return this.f18270a.getState();
    }
}
