package com.google.android.material.resources;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public static void setShouldLoadFontSynchronously(boolean z10) {
        shouldLoadFontSynchronously = z10;
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }
}
