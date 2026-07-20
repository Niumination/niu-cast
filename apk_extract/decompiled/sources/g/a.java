package g;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f5093b;

    public /* synthetic */ a(Toolbar toolbar, int i8) {
        this.f5092a = i8;
        this.f5093b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f5092a;
        Toolbar toolbar = this.f5093b;
        switch (i8) {
            case 0:
                toolbar.collapseActionView();
                break;
            default:
                toolbar.invalidateMenu();
                break;
        }
    }
}
