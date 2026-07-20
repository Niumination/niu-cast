package com.transsion.widgetslib.view.followsoft;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import dc.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RootViewDeferringInsetsCallback extends WindowInsetsAnimationCompat.Callback implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WindowInsetsCompat f2561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2562e;

    public RootViewDeferringInsetsCallback(int i10, int i11) {
        super(1);
        this.f2560c = null;
        this.f2561d = null;
        this.f2562e = false;
        this.f2558a = i10;
        this.f2559b = i11;
        if ((i10 & i11) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
    }

    public static int a(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int b(Resources resources) {
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", d.f3680k, "android"));
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i10;
        this.f2560c = view;
        this.f2561d = windowInsetsCompat;
        if (this.f2562e) {
            i10 = this.f2558a;
        } else {
            i10 = this.f2559b | this.f2558a;
        }
        Insets insets = windowInsetsCompat.getInsets(i10);
        if (insets.bottom <= a(48)) {
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        }
        return WindowInsetsCompat.CONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        View view;
        if (!this.f2562e || (windowInsetsAnimationCompat.getTypeMask() & this.f2559b) == 0) {
            return;
        }
        this.f2562e = false;
        WindowInsetsCompat windowInsetsCompat = this.f2561d;
        if (windowInsetsCompat == null || (view = this.f2560c) == null) {
            return;
        }
        ViewCompat.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        if ((windowInsetsAnimationCompat.getTypeMask() & this.f2559b) != 0) {
            this.f2562e = true;
        }
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        return windowInsetsCompat;
    }
}
