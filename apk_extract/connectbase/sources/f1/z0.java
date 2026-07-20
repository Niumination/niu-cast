package f1;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public class z0 extends j3<Object, Object> {
    static final z0 INSTANCE = new z0();
    private static final long serialVersionUID = 0;

    public z0() {
        super(k3.of(), 0);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // f1.o3, f1.h, f1.v4, f1.j6
    public k3<Object, Collection<Object>> asMap() {
        return super.asMap();
    }
}
