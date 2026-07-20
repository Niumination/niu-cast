package b9;

import android.graphics.Region;
import android.util.ArrayMap;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<a, b> f798a = new ArrayMap<>();

    public interface a {
        void a(Region region);
    }

    public class b implements ViewTreeObserver.OnComputeInternalInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f799a;

        public b(a aVar) {
            this.f799a = aVar;
        }

        public void a(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
            internalInsetsInfo.setTouchableInsets(3);
            this.f799a.a(internalInsetsInfo.touchableRegion);
        }
    }

    public void a(ViewTreeObserver viewTreeObserver, a aVar) {
        if (viewTreeObserver == null) {
            return;
        }
        b bVar = new b(aVar);
        this.f798a.put(aVar, bVar);
        viewTreeObserver.addOnComputeInternalInsetsListener(bVar);
    }

    public void b(ViewTreeObserver viewTreeObserver, a aVar) {
        b bVar = this.f798a.get(aVar);
        if (bVar == null || viewTreeObserver == null) {
            return;
        }
        viewTreeObserver.removeOnComputeInternalInsetsListener(bVar);
        this.f798a.remove(aVar);
    }
}
