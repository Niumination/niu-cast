package i4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class t2 extends k2 {
    private static final long serialVersionUID = 3;

    public t2(w2 w2Var, w2 w2Var2, h4.l lVar, h4.l lVar2, int i8, ConcurrentMap<Object, Object> concurrentMap) {
        super(w2Var, w2Var2, lVar, lVar2, i8, concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        ConcurrentMap<Object, Object> concurrentMapCreate;
        objectInputStream.defaultReadObject();
        i2 mapMaker = readMapMaker(objectInputStream);
        if (mapMaker.f5607a) {
            concurrentMapCreate = u3.create(mapMaker);
        } else {
            int i8 = mapMaker.f5608b;
            if (i8 == -1) {
                i8 = 16;
            }
            int i9 = mapMaker.f5609c;
            if (i9 == -1) {
                i9 = 4;
            }
            concurrentMapCreate = new ConcurrentHashMap<>(i8, 0.75f, i9);
        }
        this.delegate = concurrentMapCreate;
        readEntries(objectInputStream);
    }

    private Object readResolve() {
        return this.delegate;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        writeMapTo(objectOutputStream);
    }
}
