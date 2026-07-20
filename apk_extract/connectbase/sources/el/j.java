package el;

import fl.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class j extends IllegalStateException {
    public j() {
        super("Sessions are not yet ready: you are asking it to early before the Sessions feature.");
    }
}
