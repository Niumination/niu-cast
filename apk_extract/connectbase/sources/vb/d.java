package vb;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.IBinder;
import android.view.Surface;
import b9.r;
import com.transsion.hubsdk.api.window.TranScreenshotHardwareBuffer;
import dc.e;
import java.util.List;
import ve.h;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16885c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f16886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f9.c f16887b;

    public interface a {
        void a();

        void b(int i10, Rect rect);

        void c();
    }

    public interface b {
        void a(int i10, boolean z10);
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: renamed from: vb.d$d, reason: collision with other inner class name */
    public interface InterfaceC0450d {
        void a(int i10, Region region, Region region2);
    }

    public void a(c cVar, CharSequence charSequence) {
        g(fc.b.a.f5986f).f(cVar, charSequence);
    }

    public void b(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("TranScrollCaptureResponseExt is null.");
        }
        f().d(rVar);
    }

    public TranScreenshotHardwareBuffer c(int i10, Rect rect) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("displayId is wrong");
        }
        return g(fc.b.a.f5991k).m(i10, rect);
    }

    public int d() {
        return g(fc.b.a.f6001u).b();
    }

    public int e(int i10) {
        return g(fc.b.a.f5999s).k(i10);
    }

    public final ph.c f() {
        f9.c cVar = this.f16887b;
        if (cVar != null) {
            return cVar;
        }
        f9.c cVar2 = new f9.c();
        this.f16887b = cVar2;
        return cVar2;
    }

    public ph.c g(String str) {
        if (fc.b.b(str)) {
            h hVar = this.f16886a;
            if (hVar != null) {
                return hVar;
            }
            h hVar2 = new h();
            this.f16886a = hVar2;
            return hVar2;
        }
        e.f(f16885c, "TranAospWindowManagerExtra");
        f9.c cVar = this.f16887b;
        if (cVar != null) {
            return cVar;
        }
        f9.c cVar2 = new f9.c();
        this.f16887b = cVar2;
        return cVar2;
    }

    public List<ComponentName> h(int i10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("displayId is wrong");
        }
        return g(fc.b.a.f5992l).e(i10);
    }

    public void i(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("parameter TranDisplayFoldListener is null!!!");
        }
        g(fc.b.a.f5989i).c(bVar);
    }

    public void j(InterfaceC0450d interfaceC0450d, int i10) {
        if (interfaceC0450d == null) {
            throw new NullPointerException("listener cannot be null !!!");
        }
        g(fc.b.a.f5985e).a(interfaceC0450d, i10);
    }

    public void k(r rVar, Rect rect) {
        if (rVar == null) {
            throw new IllegalArgumentException("TranScrollCaptureResponseExt is null.");
        }
        f().l(rVar, rect);
    }

    public void l(Context context, int i10, IBinder iBinder, int i11, f9.c.d dVar) {
        f().h(context, i10, iBinder, i11, dVar);
    }

    public void m(r rVar, Surface surface, a aVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("TranScrollCaptureResponseExt is null.");
        }
        if (surface == null) {
            throw new IllegalArgumentException("Surface is null.");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("ITranScrollCaptureCallbacks is null.");
        }
        f().i(rVar, surface, aVar);
    }

    public void n(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("parameter TranDisplayFoldListener is null!!!");
        }
        g(fc.b.a.f5989i).j(bVar);
    }

    public void o(InterfaceC0450d interfaceC0450d, int i10) {
        if (interfaceC0450d == null) {
            throw new NullPointerException("listener cannot be null !!!");
        }
        g(fc.b.a.f5985e).g(interfaceC0450d, i10);
    }
}
