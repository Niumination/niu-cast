package com.transsion.widgetslib.view.followsoft;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TranslateDeferringInsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2565c;

    public TranslateDeferringInsetsAnimationCallback(View view, int i10, int i11, int i12) {
        super(i12);
        this.f2564b = i11;
        this.f2563a = i10;
        this.f2565c = view;
        if ((i10 & i11) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        Insets insets = windowInsetsCompat.getInsets(this.f2564b);
        Insets insets2 = windowInsetsCompat.getInsets(this.f2563a);
        Insets insetsOf = Insets.of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
        int i10 = insetsOf.left;
        Insets insets3 = Insets.NONE;
        Insets insetsOf2 = Insets.of(Math.max(i10, insets3.left), Math.max(insetsOf.top, insets3.top), Math.max(insetsOf.right, insets3.right), Math.max(insetsOf.bottom, insets3.bottom));
        this.f2565c.setTranslationX(insetsOf2.left - insetsOf2.right);
        this.f2565c.setTranslationY(insetsOf2.top - insetsOf2.bottom);
        return windowInsetsCompat;
    }

    public TranslateDeferringInsetsAnimationCallback(View view, int i10, int i11) {
        this(view, i10, i11, 0);
    }
}
