package q0;

import androidx.core.widget.ContentLoadingProgressBar;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f8929b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i8) {
        this.f8928a = i8;
        this.f8929b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f8928a;
        ContentLoadingProgressBar contentLoadingProgressBar = this.f8929b;
        switch (i8) {
            case 0:
                contentLoadingProgressBar.lambda$new$0();
                break;
            case 1:
                contentLoadingProgressBar.lambda$new$1();
                break;
            case 2:
                contentLoadingProgressBar.showOnUiThread();
                break;
            default:
                contentLoadingProgressBar.hideOnUiThread();
                break;
        }
    }
}
