package bb;

import android.view.View;
import android.view.ViewGroup;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f807c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public be.b f808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l8.b f809b;

    public vg.b a(String str) {
        if (fc.b.b(str)) {
            e.f(f807c, "TranThubPreferenceFrameLayout");
            be.b bVar = this.f808a;
            if (bVar != null) {
                return bVar;
            }
            be.b bVar2 = new be.b();
            this.f808a = bVar2;
            return bVar2;
        }
        e.f(f807c, "TranThubPreferenceFrameLayout");
        l8.b bVar3 = this.f809b;
        if (bVar3 != null) {
            return bVar3;
        }
        l8.b bVar4 = new l8.b();
        this.f809b = bVar4;
        return bVar4;
    }

    public void b(ViewGroup viewGroup, View view, boolean z10) {
        if (viewGroup == null || view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        a(fc.b.a.f5989i).a(viewGroup, view, z10);
    }
}
