package androidx.savedstate;

import android.view.View;
import gq.s;
import gq.v;
import in.i;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@i(name = "ViewTreeSavedStateRegistryOwner")
public final class ViewTreeSavedStateRegistryOwner {
    @m
    @i(name = "get")
    public static final SavedStateRegistryOwner get(@l View view) {
        l0.p(view, "<this>");
        return (SavedStateRegistryOwner) v.F0(v.p1(s.l(view, ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1.INSTANCE), ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2.INSTANCE));
    }

    @i(name = "set")
    public static final void set(@l View view, @m SavedStateRegistryOwner savedStateRegistryOwner) {
        l0.p(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
