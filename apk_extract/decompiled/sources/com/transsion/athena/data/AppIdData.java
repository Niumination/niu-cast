package com.transsion.athena.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import m3.g0;
import org.json.JSONObject;
import s6.d;
import s8.b;
import t6.c;
import z6.a;

/* JADX INFO: loaded from: classes2.dex */
public class AppIdData implements Parcelable {
    public static final Parcelable.Creator<AppIdData> CREATOR = new b(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2316d;
    public ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2317h;

    public static AppIdData b(Context context, int i8) {
        AppIdData appIdData = new AppIdData();
        appIdData.f2313a = i8;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkgName", g0.o(context));
            jSONObject.put("versionSDK", "3.1.1.0");
            String str = d.f9538a;
            jSONObject.put("channel", (Object) null);
            jSONObject.put("installer", g0.l(context));
            jSONObject.put("versionName", g0.q(context));
            jSONObject.put("versionCode", String.valueOf(g0.p(context)));
            appIdData.f2314b = jSONObject.toString();
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = a.f11258a;
            a.c(Log.getStackTraceString(e));
        }
        return appIdData;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            sb2.append(((c) it.next()).toString());
        }
        return "AppIdData{appid=" + this.f2313a + ", baseInfo='" + this.f2314b + "', packetUid='" + this.f2315c + "', retryTimes=" + this.f2316d + ", serverUrl='" + this.f2317h + "', tidEventSets='" + ((Object) sb2) + "'}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2313a);
        parcel.writeString(this.f2314b);
    }
}
