package y4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bVar.beginArray();
        while (bVar.hasNext()) {
            try {
                arrayList.add(Integer.valueOf(bVar.nextInt()));
            } catch (NumberFormatException e) {
                throw new v4.a0(e);
            }
        }
        bVar.endArray();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i8 = 0; i8 < size; i8++) {
            atomicIntegerArray.set(i8, ((Integer) arrayList.get(i8)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
        dVar.beginArray();
        int length = atomicIntegerArray.length();
        for (int i8 = 0; i8 < length; i8++) {
            dVar.value(atomicIntegerArray.get(i8));
        }
        dVar.endArray();
    }
}
