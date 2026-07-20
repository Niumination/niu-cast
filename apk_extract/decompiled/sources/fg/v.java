package fg;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends CancellationException {
    public v() {
        super("Closed selector");
    }
}
