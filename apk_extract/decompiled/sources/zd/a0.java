package zd;

import android.text.Editable;
import android.text.TextWatcher;
import com.transsion.widgetslib.widget.SearchBar;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchBar f11277a;

    public a0(SearchBar searchBar) {
        this.f11277a = searchBar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        int i11 = SearchBar.H;
        SearchBar searchBar = this.f11277a;
        searchBar.c();
        searchBar.d();
    }
}
