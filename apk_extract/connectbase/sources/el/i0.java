package el;

import fl.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class i0 extends IllegalStateException {
    public i0() {
        super("It's too late to set session: response most likely already has been sent");
    }
}
