package l3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends IOException {
    public d0() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public d0(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public d0(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
