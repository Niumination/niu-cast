package b9;

import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public class b implements lh.b {
    @Override // lh.b
    public long a(Display display) {
        Object objJ = cc.a.j(cc.a.g(display.getClass(), "getAddress", new Class[0]), display, new Object[0]);
        return ((Long) cc.a.j(cc.a.g(objJ.getClass(), "getPhysicalDisplayId", new Class[0]), objJ, new Object[0])).longValue();
    }
}
