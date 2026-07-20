package com.transsion.athena.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.Set;
import org.json.JSONObject;
import s8.b;
import z6.a;

/* JADX INFO: loaded from: classes2.dex */
public class TrackData implements Parcelable {
    public static final Parcelable.Creator<TrackData> CREATOR = new b(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2319b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2320c = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f2318a = new JSONObject();

    public final void b(int i8, int i9, String str) {
        String strConcat = "_".concat(str);
        if (i9 != 0) {
            this.f2319b = i9;
        }
        JSONObject jSONObject = this.f2318a;
        try {
            if (i9 == 0) {
                jSONObject.put(strConcat, i8);
            } else if (i9 == 1) {
                jSONObject.put(strConcat + "&add", i8);
            } else {
                if (i9 != 2) {
                    return;
                }
                jSONObject.put(strConcat + "&append", i8);
            }
        } catch (Exception e) {
            a.c(Log.getStackTraceString(e));
        }
    }

    public final void d(int i8, String str, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String strConcat = "_".concat(str);
        if (i8 != 0) {
            this.f2319b = i8;
        }
        Set<String> setKeySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.f2318a;
        try {
            if (i8 == 0) {
                for (String str2 : setKeySet) {
                    if (bundle.get(str2) instanceof String) {
                        jSONObject.put("_" + str2, (String) bundle.get(str2));
                    } else {
                        jSONObject.put("_" + str2, bundle.get(str2));
                    }
                }
                jSONObject2.put(strConcat, jSONObject);
                return;
            }
            if (i8 == 1) {
                throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
            }
            if (i8 != 2) {
                return;
            }
            for (String str3 : setKeySet) {
                if (bundle.get(str3) instanceof String) {
                    jSONObject.put("_" + str3, (String) bundle.get(str3));
                } else {
                    jSONObject.put("_" + str3, bundle.get(str3));
                }
            }
            jSONObject2.put(strConcat + "&append", jSONObject);
        } catch (Exception e) {
            a.c(Log.getStackTraceString(e));
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(int i8, String str, String str2) {
        String strConcat = "_".concat(str);
        if (i8 != 0) {
            this.f2319b = i8;
        }
        JSONObject jSONObject = this.f2318a;
        try {
            if (i8 == 0) {
                jSONObject.put(strConcat, str2);
                return;
            }
            if (i8 == 1) {
                throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
            }
            if (i8 != 2) {
                return;
            }
            jSONObject.put(strConcat + "&append", str2);
        } catch (Exception e) {
            a.c(Log.getStackTraceString(e));
        }
    }

    public final void f(String str, long j8) {
        try {
            this.f2318a.put("_".concat(str), j8);
        } catch (Exception e) {
            a.c(Log.getStackTraceString(e));
        }
    }

    public final void g(String str, String str2) {
        if (str2 == null) {
            str2 = "null";
        }
        e(0, str, str2);
    }

    public final int h() {
        try {
            return this.f2318a.toString().getBytes().length + 4;
        } catch (Exception unused) {
            return 4;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2319b);
        parcel.writeString(this.f2318a.toString());
        parcel.writeFloat(this.f2320c);
    }
}
