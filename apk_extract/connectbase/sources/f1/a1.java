package f1;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public class a1 extends u3<Object, Object> {
    static final a1 INSTANCE = new a1();
    private static final long serialVersionUID = 0;

    public a1() {
        super(k3.of(), 0, null);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // f1.o3, f1.h, f1.v4, f1.j6
    public k3<Object, Collection<Object>> asMap() {
        return super.asMap();
    }
}
