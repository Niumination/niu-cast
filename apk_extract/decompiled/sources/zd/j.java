package zd;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.transsion.widgetslib.widget.InvertArrowSpinner;
import com.transsion.widgetslib.widget.SearchBar;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f11290b;

    public /* synthetic */ j(ViewGroup viewGroup, int i8) {
        this.f11289a = i8;
        this.f11290b = viewGroup;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        ViewGroup viewGroup = this.f11290b;
        switch (this.f11289a) {
            case 0:
                ((InvertArrowSpinner) viewGroup).setSelection(i8);
                break;
            default:
                int i9 = SearchBar.H;
                ((SearchBar) viewGroup).getClass();
                break;
        }
    }
}
