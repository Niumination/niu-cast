package wa;

import android.os.storage.StorageVolume;
import android.util.ArrayMap;
import dc.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f18231d = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd.b f18232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f8.a f18233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap<a, String> f18234c = new ArrayMap<>();

    public interface a {
        void a(String str, String str2, String str3);

        void b(d dVar, int i10, int i11);
    }

    public d a(String str) {
        return d(fc.b.a.f5989i).h(str);
    }

    public String b(d dVar) {
        return d(fc.b.a.f5989i).i(dVar);
    }

    public long c() {
        return d(fc.b.a.f5988h).l();
    }

    public qg.a d(String str) {
        if (fc.b.b(str)) {
            e.f(f18231d, "TranThubStorageManager");
            wd.b bVar = this.f18232a;
            if (bVar != null) {
                return bVar;
            }
            wd.b bVar2 = new wd.b();
            this.f18232a = bVar2;
            return bVar2;
        }
        e.f(f18231d, "TranAospStorageManager");
        f8.a aVar = this.f18233b;
        if (aVar != null) {
            return aVar;
        }
        f8.a aVar2 = new f8.a();
        this.f18233b = aVar2;
        return aVar2;
    }

    public long e() {
        return d(fc.b.a.f5987g).b();
    }

    public StorageVolume[] f(int i10) {
        return d(fc.b.a.f5987g).g(i10);
    }

    public String[] g() {
        return d(fc.b.a.f5987g).j();
    }

    public String h(String str) {
        return d(fc.b.a.f5987g).a(str);
    }

    @yb.a(level = 0)
    public List<d> i() {
        return d(fc.b.a.f5981a).d();
    }

    public List<d> j() {
        return d(fc.b.a.f5999s).f();
    }

    public boolean k() {
        return d(fc.b.a.f5998r).k();
    }

    public void l(a aVar) {
        if (this.f18234c.containsKey(aVar)) {
            return;
        }
        this.f18234c.put(aVar, null);
        d(fc.b.a.f5985e).e(aVar);
    }

    public void m(a aVar) {
        if (this.f18234c.containsKey(aVar)) {
            this.f18234c.remove(aVar);
            d(fc.b.a.f5985e).c(aVar);
        }
    }
}
