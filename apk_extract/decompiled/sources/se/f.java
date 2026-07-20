package se;

import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface f {
    boolean e(NearDevice nearDevice, com.welink.protocol.nfbd.z zVar, Function1 function1);

    boolean f(NearDevice nearDevice, com.welink.protocol.nfbd.z zVar, ConnectRequest connectRequest, r6 r6Var);

    boolean h(NearDevice nearDevice, com.welink.protocol.nfbd.z zVar);

    boolean i(NearDevice nearDevice, com.welink.protocol.nfbd.z zVar, g5 g5Var, Function1 function1);

    boolean j(NearDevice nearDevice, com.welink.protocol.nfbd.z zVar, int i8, int i9, r6 r6Var);
}
