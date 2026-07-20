package androidx.activity;

import android.view.View;
import gq.s;
import gq.v;
import in.i;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@i(name = "ViewTreeOnBackPressedDispatcherOwner")
public final class ViewTreeOnBackPressedDispatcherOwner {
    @m
    @i(name = "get")
    public static final OnBackPressedDispatcherOwner get(@l View view) {
        l0.p(view, "<this>");
        return (OnBackPressedDispatcherOwner) v.F0(v.p1(s.l(view, ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1.INSTANCE), ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.INSTANCE));
    }

    @i(name = "set")
    public static final void set(@l View view, @l OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        l0.p(view, "<this>");
        l0.p(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
