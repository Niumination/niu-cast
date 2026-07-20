package a4;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.transsion.athena.data.TrackData;
import java.util.ArrayList;
import k6.g;
import t3.d;
import y3.b;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 3)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackData f44a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f45b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f46c;

    public a(String str) {
        long jD = d.d();
        this.f46c = jD;
        if (jD == 0) {
            b.d("FAILED! You should init Athena first before track the event " + str);
        }
        this.f45b = str;
        this.f44a = new TrackData();
    }

    public final void a(String str, Bundle bundle) {
        if (bundle != null) {
            this.f44a.i(str, bundle);
        }
    }

    public final void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f44a.m(str, str2);
    }

    public final void c(String str, ArrayList<Bundle> arrayList) {
        if (arrayList != null) {
            this.f44a.o(str, arrayList);
        }
    }

    public a d(String str) {
        b("pid", str);
        return this;
    }

    public a e(Bundle bundle) {
        a("pparam", bundle);
        return this;
    }

    public a f(String str) {
        b("purl", str);
        return this;
    }

    public a g(String str) {
        b("burl", str);
        return this;
    }

    public a h(float f10) {
        if (f10 < 1.0E-4f || f10 > 1.0f) {
            b.d("samplingRate must be in range from 1.0E-4 to 1.0");
            return this;
        }
        this.f44a.b(f10);
        return this;
    }

    public a i(String str) {
        b("source", str);
        return this;
    }

    public a j(String str) {
        b("uuid", str);
        return this;
    }

    public void k() {
        g.j0(this.f46c).d1(this.f45b, this.f44a, this.f46c);
    }

    public a l(Bundle bundle, Bundle bundle2) {
        a("eparam", bundle);
        a("ext", bundle2);
        return this;
    }

    public a m(Bundle bundle, Bundle bundle2) {
        a("eparam", bundle);
        a("ext", bundle2);
        return this;
    }

    public a n(ArrayList<Bundle> arrayList, Bundle bundle) {
        c("eparam", arrayList);
        a("ext", bundle);
        return this;
    }

    public a o(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2) {
        c("eparam", arrayList);
        c("ext", arrayList2);
        return this;
    }

    public a p(long j10, long j11, int i10, Bundle bundle) {
        this.f44a.g("psts", j10);
        this.f44a.g("pets", j11);
        this.f44a.e("dph", i10);
        a("ext", bundle);
        return this;
    }

    public a(String str, int i10) {
        this.f46c = i10;
        this.f45b = str;
        this.f44a = new TrackData();
    }

    @Deprecated
    public a(String str, long j10) {
        this.f46c = j10;
        this.f45b = str;
        this.f44a = new TrackData();
    }
}
