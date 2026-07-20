package a7;

import com.transsion.athena.data.TrackData;
import e8.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f41b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f42c = new TrackData();

    public a(String str, int i8) {
        this.f41b = i8;
        this.f40a = str;
    }

    public void a() {
        long j8 = this.f41b;
        b.n(j8).o(this.f40a, (TrackData) this.f42c, j8);
    }
}
