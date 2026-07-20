package t3;

import androidx.annotation.NonNull;
import com.transsion.athena.data.TrackData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15443j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15444k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f15445l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f15447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f15448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f15452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TrackData f15454i;

    public String a() {
        return this.f15453h;
    }

    public String b() {
        return this.f15446a;
    }

    public JSONObject c() {
        return this.f15447b;
    }

    public JSONObject d() {
        return this.f15448c;
    }

    public long e() {
        return this.f15449d;
    }

    public TrackData f() {
        return this.f15454i;
    }

    public long g() {
        return this.f15452g;
    }

    public int h() {
        return this.f15450e;
    }

    public long i() {
        return this.f15451f;
    }

    public void j(String str) {
        this.f15453h = str;
    }

    public void k(String str) {
        this.f15446a = str;
    }

    public void l(JSONObject jSONObject) {
        this.f15447b = jSONObject;
    }

    public void m(JSONObject jSONObject) {
        this.f15448c = jSONObject;
    }

    public void n(long j10) {
        this.f15449d = j10;
    }

    public void o(TrackData trackData) {
        this.f15454i = trackData;
    }

    public void p(long j10) {
        this.f15452g = j10;
    }

    public void q(int i10) {
        this.f15450e = i10;
    }

    public void r(long j10) {
        this.f15451f = j10;
    }

    @NonNull
    public String toString() {
        return "tid = " + this.f15449d + ",event = " + this.f15447b.toString();
    }
}
