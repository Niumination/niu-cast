package b2;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import v1.a0;
import v1.e;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public class c extends z<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f719b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<Date> f720a;

    public class a implements a0 {
        @Override // v1.a0
        public <T> z<T> create(e eVar, c2.a<T> aVar) {
            if (aVar.getRawType() == Timestamp.class) {
                return new c(eVar.getAdapter(Date.class));
            }
            return null;
        }
    }

    public /* synthetic */ c(z zVar, a aVar) {
        this(zVar);
    }

    @Override // v1.z
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timestamp read(d2.a aVar) throws IOException {
        Date date = this.f720a.read(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // v1.z
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(d2.d dVar, Timestamp timestamp) throws IOException {
        this.f720a.write(dVar, timestamp);
    }

    public c(z<Date> zVar) {
        this.f720a = zVar;
    }
}
