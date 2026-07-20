package b2;

import java.sql.Timestamp;
import java.util.Date;
import v1.a0;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final y1.d.b<? extends Date> DATE_DATE_TYPE;
    public static final a0 DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final y1.d.b<? extends Date> TIMESTAMP_DATE_TYPE;
    public static final a0 TIMESTAMP_FACTORY;
    public static final a0 TIME_FACTORY;

    public class a extends y1.d.b<java.sql.Date> {
        public a(Class cls) {
            super(cls);
        }

        @Override // y1.d.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.sql.Date deserialize(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    public class b extends y1.d.b<Timestamp> {
        public b(Class cls) {
            super(cls);
        }

        @Override // y1.d.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timestamp deserialize(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        SUPPORTS_SQL_TYPES = z10;
        if (z10) {
            DATE_DATE_TYPE = new a(java.sql.Date.class);
            TIMESTAMP_DATE_TYPE = new b(Timestamp.class);
            DATE_FACTORY = b2.a.f715b;
            TIME_FACTORY = b2.b.f717b;
            TIMESTAMP_FACTORY = c.f719b;
            return;
        }
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
    }

    private d() {
    }
}
