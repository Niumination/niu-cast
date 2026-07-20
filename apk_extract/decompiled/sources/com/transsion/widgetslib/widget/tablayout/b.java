package com.transsion.widgetslib.widget.tablayout;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f3729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f3730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f3731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3732d;
    public View e;
    public TabLayout f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TabLayout.TabView f3733g;

    @Nullable
    public BadgeDrawable getBadge() {
        return this.f3733g.getBadge();
    }

    @Nullable
    public CharSequence getContentDescription() {
        TabLayout.TabView tabView = this.f3733g;
        if (tabView == null) {
            return null;
        }
        return tabView.getContentDescription();
    }

    @Nullable
    public View getCustomView() {
        return this.e;
    }

    @Nullable
    public Drawable getIcon() {
        return this.f3729a;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge() {
        return this.f3733g.getOrCreateBadge();
    }

    public int getPosition() {
        return this.f3732d;
    }

    public int getTabLabelVisibility() {
        return 1;
    }

    @Nullable
    public Object getTag() {
        return null;
    }

    @Nullable
    public CharSequence getText() {
        return this.f3730b;
    }
}
