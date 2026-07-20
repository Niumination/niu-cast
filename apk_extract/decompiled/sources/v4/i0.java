package v4;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final enum i0 extends m0 {
    public i0(String str, int i8) {
        super(str, i8, null);
    }

    @Override // v4.m0, v4.n0
    public Double readNumber(d5.b bVar) throws IOException {
        return Double.valueOf(bVar.nextDouble());
    }
}
