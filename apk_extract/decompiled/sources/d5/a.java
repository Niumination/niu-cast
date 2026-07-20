package d5;

import java.io.IOException;
import x4.k;
import y4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends k {
    @Override // x4.k
    public final void promoteNameToValue(b bVar) throws IOException {
        if (bVar instanceof q) {
            ((q) bVar).promoteNameToValue();
            return;
        }
        int iC = bVar.f4293a;
        if (iC == 0) {
            iC = bVar.c();
        }
        if (iC == 13) {
            bVar.f4293a = 9;
        } else if (iC == 12) {
            bVar.f4293a = 8;
        } else {
            if (iC != 14) {
                throw bVar.unexpectedTokenError("a name");
            }
            bVar.f4293a = 10;
        }
    }
}
