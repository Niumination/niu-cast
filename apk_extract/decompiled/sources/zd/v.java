package zd;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.widgetslib.widget.SearchBar;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchBar f11311a;

    public v(SearchBar searchBar) {
        this.f11311a = searchBar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i8, KeyEvent keyEvent) {
        int i9 = SearchBar.H;
        SearchBar searchBar = this.f11311a;
        ((InputMethodManager) searchBar.getContext().getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD)).hideSoftInputFromWindow(searchBar.getWindowToken(), 0);
        return true;
    }
}
