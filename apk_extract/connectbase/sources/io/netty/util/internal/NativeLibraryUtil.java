package io.netty.util.internal;

/* JADX INFO: loaded from: classes3.dex */
final class NativeLibraryUtil {
    private NativeLibraryUtil() {
    }

    public static void loadLibrary(String str, boolean z10) {
        if (z10) {
            System.load(str);
        } else {
            System.loadLibrary(str);
        }
    }
}
