package wa;

import android.os.storage.StorageVolume;
import dc.e;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f18235c = "c";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f18236d = "storageVolume cannot be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd.c f18237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f8.c f18238b;

    public File a(StorageVolume storageVolume) {
        if (storageVolume != null) {
            return b(fc.b.a.f5987g).b(storageVolume);
        }
        throw new IllegalArgumentException(f18236d);
    }

    public qg.b b(String str) {
        if (fc.b.b(str)) {
            e.f(f18235c, "TranThubStorageVolume");
            wd.c cVar = this.f18237a;
            if (cVar != null) {
                return cVar;
            }
            wd.c cVar2 = new wd.c();
            this.f18237a = cVar2;
            return cVar2;
        }
        e.f(f18235c, "TranAospStorageVolume");
        f8.c cVar3 = this.f18238b;
        if (cVar3 != null) {
            return cVar3;
        }
        f8.c cVar4 = new f8.c();
        this.f18238b = cVar4;
        return cVar4;
    }

    public String c(StorageVolume storageVolume) {
        if (storageVolume != null) {
            return b(fc.b.a.f5987g).c(storageVolume);
        }
        throw new IllegalArgumentException(f18236d);
    }

    public boolean d(StorageVolume storageVolume) {
        if (storageVolume != null) {
            return b(fc.b.a.f5987g).a(storageVolume);
        }
        throw new IllegalArgumentException(f18236d);
    }
}
