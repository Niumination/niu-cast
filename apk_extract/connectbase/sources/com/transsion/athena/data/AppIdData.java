package com.transsion.athena.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import d6.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import s3.g;
import t3.c;
import y3.e;

/* JADX INFO: loaded from: classes2.dex */
public class AppIdData implements Parcelable {
    public static final Parcelable.Creator<AppIdData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c> f1816e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1817f;

    public class a implements Parcelable.Creator<AppIdData> {
        @Override // android.os.Parcelable.Creator
        public AppIdData createFromParcel(Parcel parcel) {
            return new AppIdData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AppIdData[] newArray(int i10) {
            return new AppIdData[i10];
        }
    }

    public AppIdData() {
    }

    public static AppIdData a(Context context, int i10) {
        AppIdData appIdData = new AppIdData();
        appIdData.f1812a = i10;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkgName", e.t(context));
            jSONObject.put("versionSDK", "3.1.1.1-sys");
            jSONObject.put("channel", g.D());
            jSONObject.put("installer", e.q(context));
            jSONObject.put("versionName", e.v(context));
            jSONObject.put("versionCode", String.valueOf(e.u(context)));
            appIdData.f1813b = jSONObject.toString();
        } catch (Exception e10) {
            b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
        }
        return appIdData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<c> it = this.f1816e.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
        }
        return "AppIdData{appid=" + this.f1812a + ", baseInfo='" + this.f1813b + "', packetUid='" + this.f1814c + "', retryTimes=" + this.f1815d + ", serverUrl='" + this.f1817f + "', tidEventSets='" + ((Object) sb2) + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1812a);
        parcel.writeString(this.f1813b);
    }

    public AppIdData(Parcel parcel) {
        this.f1812a = parcel.readInt();
        this.f1813b = parcel.readString();
    }
}
