package com.transsion.widgetslib.view.followsoft;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TranslateDeferringInsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Insets f3256a;

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(null);
        boolean z2 = rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        if (z2 && rootWindowInsets != null) {
            Insets insets = rootWindowInsets.getInsets(0);
            Insets insets2 = rootWindowInsets.getInsets(0);
            Insets insetsOf = Insets.of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
            int i8 = insetsOf.left;
            Insets insets3 = Insets.NONE;
            this.f3256a = Insets.of(Math.max(i8, insets3.left), Math.max(insetsOf.top, insets3.top), Math.max(insetsOf.right, insets3.right), Math.max(insetsOf.bottom, insets3.bottom));
        }
        if (!z2) {
            throw null;
        }
        Insets insets4 = this.f3256a;
        int i9 = insets4.left;
        int i10 = insets4.right;
        throw null;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        Insets insets = windowInsetsCompat.getInsets(0);
        Insets insets2 = windowInsetsCompat.getInsets(0);
        Insets insetsOf = Insets.of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
        int i8 = insetsOf.left;
        Insets insets3 = Insets.NONE;
        Insets insetsOf2 = Insets.of(Math.max(i8, insets3.left), Math.max(insetsOf.top, insets3.top), Math.max(insetsOf.right, insets3.right), Math.max(insetsOf.bottom, insets3.bottom));
        this.f3256a = insetsOf2;
        int i9 = insetsOf2.left;
        throw null;
    }
}
