package af;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public enum y0 implements x0 {
    INSTANCE;

    @Override // af.x0
    public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
        return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
    }
}
