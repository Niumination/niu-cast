package yj;

import io.netty.channel.unix.DomainSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import vj.x1;
import vj.y1;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class f1 extends y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20947a = "unix";

    public static String g(URI uri) {
        c1.h0.e(f20947a.equals(uri.getScheme()), "scheme must be unix");
        String path = uri.getPath();
        return path == null ? (String) c1.h0.F(uri.getSchemeSpecificPart(), "targetPath") : path;
    }

    @Override // vj.x1.d
    public String a() {
        return f20947a;
    }

    @Override // vj.y1
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(DomainSocketAddress.class);
    }

    @Override // vj.y1
    public boolean e() {
        return true;
    }

    @Override // vj.y1
    public int f() {
        return 3;
    }

    @Override // vj.x1.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e1 b(URI uri, x1.b bVar) {
        if (f20947a.equals(uri.getScheme())) {
            return new e1(uri.getAuthority(), g(uri));
        }
        return null;
    }
}
