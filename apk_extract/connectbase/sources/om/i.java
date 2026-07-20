package om;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kn.l0;
import kn.w;
import nm.c1;
import nm.d1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Externalizable {

    @l
    public static final a Companion = new a();
    private static final long serialVersionUID = 0;

    @l
    private Map<?, ?> map;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public i(@l Map<?, ?> map) {
        l0.p(map, "map");
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@l ObjectInput objectInput) throws IOException {
        l0.p(objectInput, "input");
        byte b10 = objectInput.readByte();
        if (b10 != 0) {
            throw new InvalidObjectException(h.a.a("Unsupported flags value: ", b10));
        }
        int i10 = objectInput.readInt();
        if (i10 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i10 + n1.e.f11183c);
        }
        d dVar = new d(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.put(objectInput.readObject(), objectInput.readObject());
        }
        this.map = c1.d(dVar);
    }

    @Override // java.io.Externalizable
    public void writeExternal(@l ObjectOutput objectOutput) throws IOException {
        l0.p(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }

    public i() {
        this(d1.z());
    }
}
