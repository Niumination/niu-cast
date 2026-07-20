package y4;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) {
        try {
            return new AtomicInteger(bVar.nextInt());
        } catch (NumberFormatException e) {
            throw new v4.a0(e);
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        dVar.value(((AtomicInteger) obj).get());
    }
}
