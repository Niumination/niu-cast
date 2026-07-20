package yj;

import io.netty.channel.Channel;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class w {

    public interface a extends s0.b {
        @Override // yj.s0.b
        b a(Channel channel);
    }

    public static final class b extends s0.c {
        public b(vj.v0.m mVar, Map<String, String> map) {
            super(mVar, map);
        }
    }

    public static void a(a aVar) {
        s0.b(aVar);
    }
}
