package b5;

import java.sql.Timestamp;
import java.util.Date;
import v4.p0;
import v4.q;
import v4.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements q0 {
    @Override // v4.q0
    public final p0 create(q qVar, c5.a aVar) {
        if (aVar.getRawType() == Timestamp.class) {
            return new f(qVar.getAdapter(Date.class));
        }
        return null;
    }
}
