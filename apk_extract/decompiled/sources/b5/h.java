package b5;

import java.sql.Date;
import java.sql.Timestamp;
import v4.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final y4.g DATE_DATE_TYPE;
    public static final q0 DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final y4.g TIMESTAMP_DATE_TYPE;
    public static final q0 TIMESTAMP_FACTORY;
    public static final q0 TIME_FACTORY;

    static {
        boolean z2;
        try {
            Class.forName("java.sql.Date");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        SUPPORTS_SQL_TYPES = z2;
        if (z2) {
            DATE_DATE_TYPE = new g(Date.class, 0);
            TIMESTAMP_DATE_TYPE = new g(Timestamp.class, 1);
            DATE_FACTORY = b.f1205b;
            TIME_FACTORY = d.f1207b;
            TIMESTAMP_FACTORY = f.f1209b;
            return;
        }
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
    }

    private h() {
    }
}
