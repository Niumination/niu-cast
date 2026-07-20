package wj;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends vj.y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18691a = "dns";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f18692b = vj.x2.d(g0.class.getClassLoader());

    @Override // vj.x1.d
    public String a() {
        return f18691a;
    }

    @Override // vj.x1.d
    public vj.x1 b(URI uri, vj.x1.b bVar) {
        if (!f18691a.equals(uri.getScheme())) {
            return null;
        }
        String str = (String) c1.h0.F(uri.getPath(), "targetPath");
        c1.h0.y(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new f0(uri.getAuthority(), str.substring(1), bVar, v0.K, new c1.o0(), f18692b);
    }

    @Override // vj.y1
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // vj.y1
    public boolean e() {
        return true;
    }

    @Override // vj.y1
    public int f() {
        return 5;
    }
}
