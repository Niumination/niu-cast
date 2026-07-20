package rb;

import android.graphics.Insets;
import android.view.WindowInsetsAnimationController;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14425c = p.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.o f14426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.o f14427b;

    public lh.o a(String str) {
        if (fc.b.b(str)) {
            re.o oVar = this.f14426a;
            if (oVar != null) {
                return oVar;
            }
            re.o oVar2 = new re.o();
            this.f14426a = oVar2;
            return oVar2;
        }
        dc.e.f(f14425c, "TranAospWindowInsetsAnimationController");
        b9.o oVar3 = this.f14427b;
        if (oVar3 != null) {
            return oVar3;
        }
        b9.o oVar4 = new b9.o();
        this.f14427b = oVar4;
        return oVar4;
    }

    public void b(WindowInsetsAnimationController windowInsetsAnimationController, Insets insets, float f10, float f11, boolean z10, boolean z11) {
        if (windowInsetsAnimationController == null) {
            throw new IllegalArgumentException("controller cannot be null");
        }
        a(fc.b.a.F).a(windowInsetsAnimationController, insets, f10, f11, z10, z11);
    }
}
