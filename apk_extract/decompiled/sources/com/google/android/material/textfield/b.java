package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f2262b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i8) {
        this.f2261a = i8;
        this.f2262b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        int i8 = this.f2261a;
        EndIconDelegate endIconDelegate = this.f2262b;
        switch (i8) {
            case 0:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$new$1(view, z2);
                break;
            default:
                ((DropdownMenuEndIconDelegate) endIconDelegate).lambda$new$1(view, z2);
                break;
        }
    }
}
