package ub;

import android.view.WindowManager;
import android.widget.Toast;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16247c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ue.b f16248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e9.b f16249b;

    public oh.b a(String str) {
        if (fc.b.b(str)) {
            e.f(f16247c, "TranThubToast");
            ue.b bVar = this.f16248a;
            if (bVar != null) {
                return bVar;
            }
            ue.b bVar2 = new ue.b();
            this.f16248a = bVar2;
            return bVar2;
        }
        e.f(f16247c, "TranAospToast");
        e9.b bVar3 = this.f16249b;
        if (bVar3 != null) {
            return bVar3;
        }
        e9.b bVar4 = new e9.b();
        this.f16249b = bVar4;
        return bVar4;
    }

    public WindowManager.LayoutParams b(Toast toast) {
        if (toast != null) {
            return a(fc.b.a.f6001u).a(toast);
        }
        throw new IllegalArgumentException("toast is null");
    }
}
