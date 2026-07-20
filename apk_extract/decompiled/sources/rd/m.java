package rd;

import com.transsion.widgetslib.view.damping.OSScrollbarLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSScrollbarLayout f9424b;

    public /* synthetic */ m(OSScrollbarLayout oSScrollbarLayout, int i8) {
        this.f9423a = i8;
        this.f9424b = oSScrollbarLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9423a) {
            case 0:
                OSScrollbarLayout oSScrollbarLayout = this.f9424b;
                oSScrollbarLayout.f3225k = oSScrollbarLayout.f3228n.getTop();
                oSScrollbarLayout.f3226l = oSScrollbarLayout.f3228n.getBottom();
                oSScrollbarLayout.f3229o.set(oSScrollbarLayout.f3228n.getLeft(), oSScrollbarLayout.f3225k, oSScrollbarLayout.f3228n.getRight(), oSScrollbarLayout.f3226l);
                break;
            default:
                OSScrollbarLayout oSScrollbarLayout2 = this.f9424b;
                OSScrollbarLayout.a(oSScrollbarLayout2.p);
                oSScrollbarLayout2.f();
                break;
        }
    }
}
