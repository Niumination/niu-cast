package db;

import dc.e;
import de.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3660c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3661d = "path should not be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f3662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n8.a f3663b;

    public int a(String str) {
        if (str != null) {
            return b(fc.b.a.f5989i).a(str);
        }
        throw new IllegalArgumentException(f3661d);
    }

    public xg.a b(String str) {
        if (fc.b.b(str)) {
            e.f(f3660c, "TranThubAssetManager");
            b bVar = this.f3662a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f3662a = bVar2;
            return bVar2;
        }
        e.f(f3660c, "TranAospAssetManager");
        n8.a aVar = this.f3663b;
        if (aVar != null) {
            return aVar;
        }
        n8.a aVar2 = new n8.a();
        this.f3663b = aVar2;
        return aVar2;
    }
}
