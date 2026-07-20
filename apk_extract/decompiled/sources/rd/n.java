package rd;

import android.graphics.Rect;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements d8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSScrollbarLayout f9426b;

    public /* synthetic */ n(OSScrollbarLayout oSScrollbarLayout, int i8) {
        this.f9425a = i8;
        this.f9426b = oSScrollbarLayout;
    }

    @Override // d8.c
    public final void d(float f) {
        switch (this.f9425a) {
            case 0:
                OSScrollbarLayout oSScrollbarLayout = this.f9426b;
                e eVar = oSScrollbarLayout.f3228n;
                if (eVar != null) {
                    int i8 = (int) (oSScrollbarLayout.f3226l - f);
                    Rect rect = oSScrollbarLayout.f3229o;
                    rect.bottom = i8;
                    int i9 = oSScrollbarLayout.f3218a + oSScrollbarLayout.f3225k;
                    if (i8 <= i9) {
                        rect.bottom = i9;
                    }
                    eVar.layout(rect.left, rect.top, rect.right, rect.bottom);
                    break;
                }
                break;
            default:
                OSScrollbarLayout oSScrollbarLayout2 = this.f9426b;
                if (oSScrollbarLayout2.f3228n != null) {
                    oSScrollbarLayout2.j((int) Math.abs(f));
                    e eVar2 = oSScrollbarLayout2.f3228n;
                    Rect rect2 = oSScrollbarLayout2.f3229o;
                    eVar2.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
                    break;
                }
                break;
        }
    }
}
