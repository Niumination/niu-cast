package wi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f10788a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final void a(long j8, long j10, long j11) {
        if (j10 < 0 || j11 > j8) {
            throw new IndexOutOfBoundsException("startIndex (" + j10 + ") and endIndex (" + j11 + ") are not within the range [0..size(" + j8 + "))");
        }
        if (j10 <= j11) {
            return;
        }
        throw new IllegalArgumentException("startIndex (" + j10 + ") > endIndex (" + j11 + ')');
    }

    public static final void b(long j8, long j10, long j11) {
        if (j10 < 0 || j10 > j8 || j8 - j10 < j11 || j11 < 0) {
            throw new IllegalArgumentException("offset (" + j10 + ") and byteCount (" + j11 + ") are not within the range [0..size(" + j8 + "))");
        }
    }

    public static final int c(h hVar, byte b9, int i8, int i9) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        if (i8 < 0 || i8 >= hVar.b()) {
            throw new IllegalArgumentException(String.valueOf(i8).toString());
        }
        if (i8 > i9 || i9 > hVar.b()) {
            throw new IllegalArgumentException(String.valueOf(i9).toString());
        }
        int i10 = hVar.f10777b;
        while (i8 < i9) {
            if (hVar.f10776a[i10 + i8] == b9) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static final boolean d(h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        return hVar.b() == 0;
    }
}
