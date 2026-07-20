package y4;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) {
        return new AtomicBoolean(bVar.nextBoolean());
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        dVar.value(((AtomicBoolean) obj).get());
    }
}
