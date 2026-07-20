package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import gq.s;
import gq.v;
import in.i;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@i(name = "ViewTreeLifecycleOwner")
public final class ViewTreeLifecycleOwner {
    @m
    @i(name = "get")
    public static final LifecycleOwner get(@l View view) {
        l0.p(view, "<this>");
        return (LifecycleOwner) v.F0(v.p1(s.l(view, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.INSTANCE), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.INSTANCE));
    }

    @i(name = "set")
    public static final void set(@l View view, @m LifecycleOwner lifecycleOwner) {
        l0.p(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
