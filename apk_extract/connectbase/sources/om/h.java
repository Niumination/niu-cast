package om;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import kn.w;
import nm.k0;
import nm.n1;
import nm.x;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
public final class h implements Externalizable {

    @l
    public static final a Companion = new a();
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    @l
    private Collection<?> collection;
    private final int tag;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public h() {
        this(k0.INSTANCE, 0);
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@l ObjectInput objectInput) throws IOException {
        List listA;
        l0.p(objectInput, "input");
        byte b10 = objectInput.readByte();
        int i10 = b10 & 1;
        if ((b10 & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b10) + n1.e.f11183c);
        }
        int i11 = objectInput.readInt();
        if (i11 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i11 + n1.e.f11183c);
        }
        int i12 = 0;
        if (i10 == 0) {
            b bVar = new b(i11);
            while (i12 < i11) {
                bVar.add(objectInput.readObject());
                i12++;
            }
            listA = x.a(bVar);
        } else {
            if (i10 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i10 + n1.e.f11183c);
            }
            j jVar = new j(i11);
            while (i12 < i11) {
                jVar.add(objectInput.readObject());
                i12++;
            }
            listA = n1.a(jVar);
        }
        this.collection = listA;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@l ObjectOutput objectOutput) throws IOException {
        l0.p(objectOutput, "output");
        objectOutput.writeByte(this.tag);
        objectOutput.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            objectOutput.writeObject(it.next());
        }
    }

    public h(@l Collection<?> collection, int i10) {
        l0.p(collection, "collection");
        this.collection = collection;
        this.tag = i10;
    }
}
