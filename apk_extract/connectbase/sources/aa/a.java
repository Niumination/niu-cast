package aa;

import android.graphics.Region;
import android.os.IBinder;
import android.view.InputEvent;
import android.view.KeyEvent;
import bd.g;
import fc.b;
import j7.c;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f193b;

    public uf.a a(String str) {
        if (b.b(str)) {
            g gVar = this.f192a;
            if (gVar != null) {
                return gVar;
            }
            g gVar2 = new g();
            this.f192a = gVar2;
            return gVar2;
        }
        c cVar = this.f193b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f193b = cVar2;
        return cVar2;
    }

    public boolean b(InputEvent inputEvent, int i10) {
        return a(b.a.f5989i).c(inputEvent, i10);
    }

    public rb.a c(String str, int i10, rb.b bVar) {
        return a(b.a.f5983c).d(str, i10, bVar);
    }

    public void d(sb.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("registerStylusKeyListener() parameter listener must not be null");
        }
        a(b.a.f5994n).b(bVar);
    }

    public void e(boolean z10) {
        a(b.a.f6006z).h(z10);
    }

    public void f(IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            throw new NullPointerException("parameter inputChannelToken must not be null");
        }
        a(b.a.f6006z).g(iBinder, z10);
    }

    public void g(KeyEvent keyEvent) {
        if (fc.a.g()) {
            a(b.a.H).a(keyEvent);
        }
    }

    public void h(sb.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("unregisterStylusKeyListener() parameter listener must not be null");
        }
        a(b.a.f5994n).f(bVar);
    }

    public void i(IBinder iBinder, Region region) {
        if (iBinder == null || region == null) {
            throw new NullPointerException("parameters must not be null");
        }
        a(b.a.f6006z).e(iBinder, region);
    }
}
