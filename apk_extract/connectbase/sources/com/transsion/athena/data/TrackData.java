package com.transsion.athena.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;
import java.util.Set;
import k6.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y3.b;

/* JADX INFO: loaded from: classes2.dex */
public class TrackData implements Parcelable {
    public static final Parcelable.Creator<TrackData> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f1818d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1819e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1820f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f1821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1823c;

    public class a implements Parcelable.Creator<TrackData> {
        @Override // android.os.Parcelable.Creator
        public TrackData createFromParcel(Parcel parcel) {
            return new TrackData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackData[] newArray(int i10) {
            return new TrackData[i10];
        }
    }

    public TrackData() {
        this.f1822b = 0;
        this.f1823c = 1.0f;
        this.f1821a = new JSONObject();
    }

    public JSONObject a() {
        return this.f1821a;
    }

    public void b(float f10) {
        this.f1823c = f10;
    }

    public TrackData c(String str, double d10) {
        return d(str, d10, 0);
    }

    public TrackData d(String str, double d10, int i10) {
        String strA = m.a.a("_", str);
        if (i10 != 0) {
            this.f1822b = i10;
        }
        try {
            if (i10 == 0) {
                this.f1821a.put(strA, d10);
            } else {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f1821a.put(strA + "&append", d10);
                    }
                    return this;
                }
                this.f1821a.put(strA + "&add", d10);
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TrackData e(String str, int i10) {
        return f(str, i10, 0);
    }

    public TrackData f(String str, int i10, int i11) {
        String strA = m.a.a("_", str);
        if (i11 != 0) {
            this.f1822b = i11;
        }
        try {
            if (i11 == 0) {
                this.f1821a.put(strA, i10);
            } else {
                if (i11 != 1) {
                    if (i11 == 2) {
                        this.f1821a.put(strA + "&append", i10);
                    }
                    return this;
                }
                this.f1821a.put(strA + "&add", i10);
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public TrackData g(String str, long j10) {
        return h(str, j10, 0);
    }

    public TrackData h(String str, long j10, int i10) {
        String strA = m.a.a("_", str);
        if (i10 != 0) {
            this.f1822b = i10;
        }
        try {
            if (i10 == 0) {
                this.f1821a.put(strA, j10);
            } else {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f1821a.put(strA + "&append", j10);
                    }
                    return this;
                }
                this.f1821a.put(strA + "&add", j10);
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public TrackData i(String str, Bundle bundle) {
        return j(str, bundle, 0);
    }

    public TrackData j(String str, Bundle bundle, int i10) {
        if (bundle == null) {
            return this;
        }
        String strA = m.a.a("_", str);
        if (i10 != 0) {
            this.f1822b = i10;
        }
        Set<String> setKeySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            if (i10 == 0) {
                for (String str2 : setKeySet) {
                    if (bundle.get(str2) instanceof String) {
                        jSONObject.put("_" + str2, g.n0().a((String) bundle.get(str2)));
                    } else {
                        jSONObject.put("_" + str2, bundle.get(str2));
                    }
                }
                this.f1821a.put(strA, jSONObject);
            } else {
                if (i10 == 1) {
                    throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
                }
                if (i10 == 2) {
                    for (String str3 : setKeySet) {
                        if (bundle.get(str3) instanceof String) {
                            jSONObject.put("_" + str3, g.n0().a((String) bundle.get(str3)));
                        } else {
                            jSONObject.put("_" + str3, bundle.get(str3));
                        }
                    }
                    this.f1821a.put(strA + "&" + RtspHeaders.Values.APPEND, jSONObject);
                }
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public TrackData k(String str, Number number) {
        return l(str, number, 0);
    }

    public TrackData l(String str, Number number, int i10) {
        String strA = m.a.a("_", str);
        if (i10 != 0) {
            this.f1822b = i10;
        }
        try {
            if (i10 == 0) {
                this.f1821a.put(strA, number);
            } else {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f1821a.put(strA + "&append", number);
                    }
                    return this;
                }
                this.f1821a.put(strA + "&add", number);
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public TrackData m(String str, String str2) {
        if (str2 == null) {
            str2 = d6.a.E;
        }
        return n(str, str2, 0);
    }

    public TrackData n(String str, String str2, int i10) {
        String strA = m.a.a("_", str);
        if (i10 != 0) {
            this.f1822b = i10;
        }
        try {
            if (i10 == 0) {
                this.f1821a.put(strA, g.n0().a(str2));
            } else {
                if (i10 == 1) {
                    throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
                }
                if (i10 == 2) {
                    this.f1821a.put(strA + "&append", g.n0().a(str2));
                }
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public TrackData o(String str, List<Bundle> list) {
        String strA = m.a.a("_", str);
        try {
            JSONArray jSONArray = new JSONArray();
            for (Bundle bundle : list) {
                Set<String> setKeySet = bundle.keySet();
                JSONObject jSONObject = new JSONObject();
                for (String str2 : setKeySet) {
                    if (bundle.get(str2) instanceof String) {
                        jSONObject.put("_" + str2, g.n0().a((String) bundle.get(str2)));
                    } else {
                        jSONObject.put("_" + str2, bundle.get(str2));
                    }
                }
                jSONArray.put(jSONObject);
            }
            this.f1821a.put(strA, jSONArray);
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public TrackData p(String str, boolean z10) {
        return q(str, z10, 0);
    }

    public TrackData q(String str, boolean z10, int i10) {
        String strA = m.a.a("_", str);
        if (i10 != 0) {
            this.f1822b = i10;
        }
        try {
            if (i10 == 0) {
                this.f1821a.put(strA, z10);
            } else {
                if (i10 == 1) {
                    throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
                }
                if (i10 == 2) {
                    this.f1821a.put(strA + "&append", z10);
                }
            }
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
        return this;
    }

    public float r() {
        return this.f1823c;
    }

    public int s() {
        try {
            return this.f1821a.toString().getBytes().length + 4;
        } catch (Exception unused) {
            return 4;
        }
    }

    public int t() {
        return this.f1822b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1822b);
        parcel.writeString(this.f1821a.toString());
        parcel.writeFloat(this.f1823c);
    }

    public TrackData(Bundle bundle) {
        this.f1822b = 0;
        this.f1823c = 1.0f;
        this.f1821a = new JSONObject();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                m(str, String.valueOf(bundle.get(str)));
            }
        }
    }

    public TrackData(int i10, String str) {
        this.f1823c = 1.0f;
        this.f1822b = i10;
        try {
            if (TextUtils.isEmpty(str)) {
                this.f1821a = new JSONObject();
            } else {
                this.f1821a = new JSONObject(str);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public TrackData(int i10, JSONObject jSONObject) {
        this.f1823c = 1.0f;
        this.f1822b = i10;
        this.f1821a = jSONObject;
    }

    public TrackData(Parcel parcel) {
        this.f1822b = 0;
        this.f1823c = 1.0f;
        try {
            this.f1822b = parcel.readInt();
            this.f1821a = new JSONObject(parcel.readString());
            this.f1823c = parcel.readFloat();
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
