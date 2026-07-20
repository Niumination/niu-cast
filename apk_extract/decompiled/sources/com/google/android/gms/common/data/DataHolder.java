package com.google.android.gms.common.data;

import a3.a;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @NonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new a(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f1830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CursorWindow[] f1832d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f1833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f1834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1835j = false;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i8, String[] strArr, CursorWindow[] cursorWindowArr, int i9, Bundle bundle) {
        this.f1829a = i8;
        this.f1830b = strArr;
        this.f1832d = cursorWindowArr;
        this.e = i9;
        this.f1833h = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f1835j) {
                    this.f1835j = true;
                    int i8 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f1832d;
                        if (i8 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i8].close();
                        i8++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z2;
        try {
            if (this.f1832d.length > 0) {
                synchronized (this) {
                    z2 = this.f1835j;
                }
                if (!z2) {
                    close();
                    Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
                }
            }
            super.finalize();
        } catch (Throwable th2) {
            super.finalize();
            throw th2;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.f(parcel, 1, this.f1830b);
        qd.g(parcel, 2, this.f1832d, i8);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.e);
        qd.a(parcel, 4, this.f1833h);
        qd.k(parcel, 1000, 4);
        parcel.writeInt(this.f1829a);
        qd.j(parcel, i9);
        if ((i8 & 1) != 0) {
            close();
        }
    }
}
