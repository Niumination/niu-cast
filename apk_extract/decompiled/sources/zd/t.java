package zd;

import com.transsion.widgetslib.widget.OsPressSmoothCornerDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OsPressSmoothCornerDrawable f11308b;

    public /* synthetic */ t(OsPressSmoothCornerDrawable osPressSmoothCornerDrawable, int i8) {
        this.f11307a = i8;
        this.f11308b = osPressSmoothCornerDrawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11307a) {
            case 0:
                this.f11308b.f3427c = null;
                break;
            default:
                this.f11308b.f3427c = null;
                break;
        }
    }
}
