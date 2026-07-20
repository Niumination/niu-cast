package ph;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.Surface;
import b9.r;
import com.transsion.hubsdk.api.window.TranScreenshotHardwareBuffer;
import java.util.List;
import vb.d;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    void a(d.InterfaceC0450d interfaceC0450d, int i10);

    int b();

    void c(d.b bVar);

    void d(r rVar);

    List<ComponentName> e(int i10);

    void f(d.c cVar, CharSequence charSequence);

    void g(d.InterfaceC0450d interfaceC0450d, int i10);

    void h(Context context, int i10, IBinder iBinder, int i11, f9.c.d dVar);

    void i(r rVar, Surface surface, d.a aVar);

    void j(d.b bVar);

    int k(int i10);

    void l(r rVar, Rect rect);

    TranScreenshotHardwareBuffer m(int i10, Rect rect);
}
