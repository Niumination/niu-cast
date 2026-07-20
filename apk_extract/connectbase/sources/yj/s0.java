package yj;

import f1.k3;
import io.netty.channel.Channel;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f21292a = new d();

    public interface b {
        @gm.j
        c a(Channel channel);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.j
        public final vj.v0.m f21293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k3<String, String> f21294b;

        public c(vj.v0.m mVar, Map<String, String> map) {
            map.getClass();
            this.f21293a = mVar;
            this.f21294b = k3.copyOf((Map) map);
        }
    }

    public static final class d implements b {
        public d() {
        }

        @Override // yj.s0.b
        public c a(Channel channel) {
            return null;
        }

        public d(a aVar) {
        }
    }

    public static c a(Channel channel) {
        return f21292a.a(channel);
    }

    public static void b(b bVar) {
        bVar.getClass();
        f21292a = bVar;
    }
}
