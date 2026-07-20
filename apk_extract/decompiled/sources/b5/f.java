package b5;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import v4.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f1209b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f1210a;

    public f(p0 p0Var) {
        this.f1210a = p0Var;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) {
        Date date = (Date) this.f1210a.read(bVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        this.f1210a.write(dVar, (Timestamp) obj);
    }
}
