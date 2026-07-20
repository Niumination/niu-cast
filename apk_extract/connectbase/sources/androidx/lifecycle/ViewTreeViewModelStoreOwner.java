package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import gq.s;
import gq.v;
import in.i;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@i(name = "ViewTreeViewModelStoreOwner")
public final class ViewTreeViewModelStoreOwner {
    @m
    @i(name = "get")
    public static final ViewModelStoreOwner get(@l View view) {
        l0.p(view, "<this>");
        return (ViewModelStoreOwner) v.F0(v.p1(s.l(view, ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1.INSTANCE), ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2.INSTANCE));
    }

    @i(name = "set")
    public static final void set(@l View view, @m ViewModelStoreOwner viewModelStoreOwner) {
        l0.p(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
