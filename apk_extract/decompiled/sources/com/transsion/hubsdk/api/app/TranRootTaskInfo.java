package com.transsion.hubsdk.api.app;

import android.content.ComponentName;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TranRootTaskInfo implements Parcelable {
    public static final Parcelable.Creator<TranRootTaskInfo> CREATOR = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ComponentName f2340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f2341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f2342d;
    public String[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect[] f2343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f2344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2348m;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        ComponentName.writeToParcel(this.f2340b, parcel);
        parcel.writeString(this.f2339a);
        parcel.writeTypedObject(this.f2341c, i8);
        parcel.writeIntArray(this.f2342d);
        parcel.writeStringArray(this.e);
        parcel.writeTypedArray(this.f2343h, i8);
        parcel.writeIntArray(this.f2344i);
        parcel.writeInt(this.f2345j ? 1 : 0);
        parcel.writeInt(this.f2346k);
        parcel.writeInt(this.f2347l);
        parcel.writeInt(this.f2348m);
    }
}
