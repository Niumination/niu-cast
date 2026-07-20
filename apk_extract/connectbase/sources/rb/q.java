package rb;

import android.graphics.Region;
import android.util.ArrayMap;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14422c = "q";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b9.n f14423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<a, String> f14424b = new ArrayMap<>();

    public interface a {
        void a(Region region);
    }

    @yb.a(level = 1)
    public void a(ViewTreeObserver viewTreeObserver, a aVar) {
        if (this.f14424b.containsKey(aVar)) {
            return;
        }
        this.f14424b.put(aVar, null);
        b().a(viewTreeObserver, aVar);
    }

    public lh.n b() {
        dc.e.f(f14422c, "TranAospViewTreeObserver");
        b9.n nVar = this.f14423a;
        if (nVar != null) {
            return nVar;
        }
        b9.n nVar2 = new b9.n();
        this.f14423a = nVar2;
        return nVar2;
    }

    @yb.a(level = 1)
    public void c(ViewTreeObserver viewTreeObserver, a aVar) {
        if (this.f14424b.containsKey(aVar)) {
            this.f14424b.remove(aVar);
            b().b(viewTreeObserver, aVar);
        }
    }
}
