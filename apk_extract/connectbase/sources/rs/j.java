package rs;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j implements ps.a, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // ps.a
    public String getName() {
        return this.name;
    }

    public Object readResolve() throws ObjectStreamException {
        return ps.b.j(getName());
    }
}
