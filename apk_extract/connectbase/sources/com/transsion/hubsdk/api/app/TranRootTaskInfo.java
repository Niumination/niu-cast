package com.transsion.hubsdk.api.app;

import android.content.ComponentName;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranRootTaskInfo implements Parcelable {
    public static final Parcelable.Creator<TranRootTaskInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ComponentName f2203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f2204c = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f2205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[] f2206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect[] f2207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f2208g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2209i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2210n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2211p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2212v;

    public class a implements Parcelable.Creator<TranRootTaskInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranRootTaskInfo createFromParcel(Parcel parcel) {
            return new TranRootTaskInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranRootTaskInfo[] newArray(int i10) {
            return new TranRootTaskInfo[i10];
        }
    }

    public TranRootTaskInfo() {
    }

    public Rect a() {
        return this.f2204c;
    }

    public Rect[] b() {
        return this.f2207f;
    }

    public int[] c() {
        return this.f2205d;
    }

    public String[] d() {
        return this.f2206e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int[] e() {
        return this.f2208g;
    }

    public int f() {
        return this.f2210n;
    }

    public int g() {
        return this.f2212v;
    }

    public ComponentName h() {
        return this.f2203b;
    }

    public String i() {
        return this.f2202a;
    }

    public int j() {
        return this.f2211p;
    }

    public boolean k() {
        return this.f2209i;
    }

    public void l(Parcel parcel) {
        this.f2202a = parcel.readString();
        this.f2203b = ComponentName.readFromParcel(parcel);
        Parcelable.Creator creator = Rect.CREATOR;
        this.f2204c = (Rect) parcel.readTypedObject(creator);
        this.f2205d = parcel.createIntArray();
        this.f2206e = parcel.createStringArray();
        this.f2207f = (Rect[]) parcel.createTypedArray(creator);
        this.f2208g = parcel.createIntArray();
        this.f2209i = parcel.readInt() > 0;
        this.f2210n = parcel.readInt();
        this.f2211p = parcel.readInt();
        this.f2212v = parcel.readInt();
    }

    public void m(Rect rect) {
        this.f2204c = rect;
    }

    public void n(Rect[] rectArr) {
        this.f2207f = rectArr;
    }

    public void o(int[] iArr) {
        this.f2205d = iArr;
    }

    public void p(String[] strArr) {
        this.f2206e = strArr;
    }

    public void q(int[] iArr) {
        this.f2208g = iArr;
    }

    public void r(int i10) {
        this.f2210n = i10;
    }

    public void s(int i10) {
        this.f2212v = i10;
    }

    public void t(ComponentName componentName) {
        this.f2203b = componentName;
    }

    public void u(String str) {
        this.f2202a = str;
    }

    public void v(boolean z10) {
        this.f2209i = z10;
    }

    public void w(int i10) {
        this.f2211p = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        ComponentName.writeToParcel(this.f2203b, parcel);
        parcel.writeString(this.f2202a);
        parcel.writeTypedObject(this.f2204c, i10);
        parcel.writeIntArray(this.f2205d);
        parcel.writeStringArray(this.f2206e);
        parcel.writeTypedArray(this.f2207f, i10);
        parcel.writeIntArray(this.f2208g);
        parcel.writeInt(this.f2209i ? 1 : 0);
        parcel.writeInt(this.f2210n);
        parcel.writeInt(this.f2211p);
        parcel.writeInt(this.f2212v);
    }

    public TranRootTaskInfo(String str) {
        this.f2202a = str;
    }

    public TranRootTaskInfo(Parcel parcel) {
        l(parcel);
    }
}
