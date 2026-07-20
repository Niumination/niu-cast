package b4;

import com.google.android.material.search.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f1200b;

    public /* synthetic */ c(SearchView searchView, int i8) {
        this.f1199a = i8;
        this.f1200b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f1199a;
        SearchView searchView = this.f1200b;
        switch (i8) {
            case 0:
                searchView.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 1:
                searchView.show();
                break;
            case 2:
                searchView.lambda$clearFocusAndHideKeyboard$9();
                break;
            default:
                searchView.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}
