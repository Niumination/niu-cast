package y4;

import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static final g DATE = new f(Date.class);
    private final Class<Date> dateClass;

    public g(Class<Date> cls) {
        this.dateClass = cls;
    }

    private v4.q0 createFactory(h hVar) {
        return n1.newFactory(this.dateClass, hVar);
    }

    public final v4.q0 createAdapterFactory(String str) {
        return createFactory(new h(this, str, 0));
    }

    public abstract Date deserialize(Date date);

    public final v4.q0 createAdapterFactory(int i8, int i9) {
        return createFactory(new h(this, i8, i9, 0));
    }
}
