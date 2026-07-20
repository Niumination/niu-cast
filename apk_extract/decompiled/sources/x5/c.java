package x5;

import android.util.Log;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import o4.u;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements q3.c, o4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c f10864a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ c f10865b = new c();

    @Override // o4.c
    public Object a(u uVar) {
        Set setC = uVar.c(b.class);
        c cVar = new c();
        new HashMap();
        new HashMap();
        Iterator it = setC.iterator();
        if (!it.hasNext()) {
            return cVar;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // q3.c
    public void b(Exception exc) {
        tc.d dVar = MobileVisionBase.e;
        if (Log.isLoggable((String) dVar.f10209a, 6)) {
            Log.e("MobileVisionBase", dVar.l("Error preloading model resource"), exc);
        }
    }
}
