package b9;

import android.graphics.Region;
import android.util.ArrayMap;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class n implements lh.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<rb.q.a, a> f782b = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f781a = new s();

    public class a implements s.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rb.q.a f783a;

        public a(rb.q.a aVar) {
            this.f783a = aVar;
        }

        @Override // b9.s.a
        public void a(Region region) {
            this.f783a.a(region);
        }
    }

    @Override // lh.n
    public void a(ViewTreeObserver viewTreeObserver, rb.q.a aVar) {
        a aVar2 = new a(aVar);
        this.f782b.put(aVar, aVar2);
        this.f781a.a(viewTreeObserver, aVar2);
    }

    @Override // lh.n
    public void b(ViewTreeObserver viewTreeObserver, rb.q.a aVar) {
        a aVar2 = this.f782b.get(aVar);
        if (aVar2 != null) {
            this.f781a.b(viewTreeObserver, aVar2);
            this.f782b.remove(aVar);
        }
    }
}
