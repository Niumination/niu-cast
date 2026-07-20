package yj;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.http2.Http2Headers;
import java.util.Arrays;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends k1.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d1 f20882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Http2Headers f20883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y2 f20884e;

    public c1(d1 d1Var, Http2Headers http2Headers, y2 y2Var) {
        this.f20882c = (d1) c1.h0.F(d1Var, "stream");
        this.f20883d = (Http2Headers) c1.h0.F(http2Headers, "headers");
        this.f20884e = y2Var;
    }

    public static c1 d(d1 d1Var, Http2Headers http2Headers) {
        return new c1(d1Var, http2Headers, null);
    }

    public static c1 e(d1 d1Var, Http2Headers http2Headers, y2 y2Var) {
        return new c1(d1Var, http2Headers, (y2) c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS));
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(c1.class)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return c1Var.f20882c.equals(this.f20882c) && c1Var.f20883d.equals(this.f20883d) && c1Var.f20884e.equals(this.f20884e);
    }

    public boolean f() {
        return this.f20884e != null;
    }

    public Http2Headers g() {
        return this.f20883d;
    }

    public y2 h() {
        return this.f20884e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20882c, this.f20884e});
    }

    public d1 i() {
        return this.f20882c;
    }

    public String toString() {
        return c1.class.getSimpleName() + "(stream=" + this.f20882c.id() + ", headers=" + this.f20883d + ", status=" + this.f20884e + ")";
    }
}
