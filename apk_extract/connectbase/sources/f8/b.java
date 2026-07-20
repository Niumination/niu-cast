package f8;

import android.content.Context;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.util.ArrayMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5924c = "TranAospStorageManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StorageManager f5925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<a, StorageEventListenerC0141b> f5926b = new ArrayMap<>();

    public interface a {
        void a(String str, String str2, String str3);

        void b(c cVar, int i10, int i11);
    }

    /* JADX INFO: renamed from: f8.b$b, reason: collision with other inner class name */
    public class StorageEventListenerC0141b extends StorageEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f5927a;

        public StorageEventListenerC0141b(a aVar) {
            this.f5927a = aVar;
        }

        public void a(String str, String str2, String str3) {
            this.f5927a.a(str, str2, str3);
        }

        public void b(VolumeInfo volumeInfo, int i10, int i11) {
            if (volumeInfo != null) {
                c cVar = b.this.new c(volumeInfo.getId(), volumeInfo.getType(), volumeInfo.getFsUuid(), volumeInfo.path);
                cVar.e(volumeInfo.getDescription());
                cVar.f(volumeInfo.state);
                this.f5927a.b(cVar, i10, i11);
            }
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f5932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5934f;

        public c(String str, int i10, String str2, String str3) {
            this.f5929a = str;
            this.f5930b = i10;
            this.f5931c = str2;
            this.f5932d = str3;
        }

        public String a() {
            return this.f5933e;
        }

        public String b() {
            return this.f5931c;
        }

        public String c() {
            return this.f5929a;
        }

        public int d() {
            return this.f5930b;
        }

        public void e(String str) {
            this.f5933e = str;
        }

        public void f(int i10) {
            this.f5934f = i10;
        }
    }

    public b(Context context) {
        this.f5925a = (StorageManager) context.getSystemService(StorageManager.class);
    }

    public void a(a aVar) {
        StorageEventListenerC0141b storageEventListenerC0141b = new StorageEventListenerC0141b(aVar);
        this.f5926b.put(aVar, storageEventListenerC0141b);
        this.f5925a.registerListener(storageEventListenerC0141b);
    }

    public void b(a aVar) {
        StorageEventListenerC0141b storageEventListenerC0141b = this.f5926b.get(aVar);
        if (storageEventListenerC0141b != null) {
            this.f5925a.unregisterListener(storageEventListenerC0141b);
            this.f5926b.remove(aVar);
        }
    }
}
