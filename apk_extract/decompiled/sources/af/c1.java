package af;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends ze.u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f199a;

    static {
        boolean z2 = false;
        try {
            Class.forName("android.app.Application", false, c1.class.getClassLoader());
            z2 = true;
        } catch (Exception unused) {
        }
        f199a = z2;
    }

    @Override // ze.u1
    public Collection a() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // ze.u1
    public boolean b() {
        return true;
    }

    @Override // ze.u1
    public int c() {
        return 5;
    }
}
