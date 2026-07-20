package el;

import androidx.core.app.NotificationCompat;
import ik.y0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f4531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final un.d<S> f4532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final v f4533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final r<S> f4534d;

    public k(@os.l String str, @os.l un.d<S> dVar, @os.l v vVar, @os.l r<S> rVar) {
        l0.p(str, "name");
        l0.p(dVar, y0.a.f8215h);
        l0.p(vVar, NotificationCompat.CATEGORY_TRANSPORT);
        l0.p(rVar, "tracker");
        this.f4531a = str;
        this.f4532b = dVar;
        this.f4533c = vVar;
        this.f4534d = rVar;
    }

    @os.l
    public final String a() {
        return this.f4531a;
    }

    @os.l
    public final r<S> b() {
        return this.f4534d;
    }

    @os.l
    public final v c() {
        return this.f4533c;
    }

    @os.l
    public final un.d<S> d() {
        return this.f4532b;
    }

    @os.l
    public String toString() {
        return "SessionProvider(name = " + this.f4531a + ", type = " + this.f4532b + ", transport = " + this.f4533c + ", tracker = " + this.f4534d + ')';
    }
}
