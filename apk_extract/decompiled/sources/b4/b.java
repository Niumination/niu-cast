package b4;

import android.view.View;
import com.google.android.material.search.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f1198b;

    public /* synthetic */ b(SearchView searchView, int i8) {
        this.f1197a = i8;
        this.f1198b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i8 = this.f1197a;
        SearchView searchView = this.f1198b;
        switch (i8) {
            case 0:
                searchView.lambda$setUpClearButton$2(view);
                break;
            case 1:
                searchView.lambda$setupWithSearchBar$7(view);
                break;
            default:
                searchView.lambda$setUpBackButton$1(view);
                break;
        }
    }
}
