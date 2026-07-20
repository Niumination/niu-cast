package v4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class o extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f10474b;

    public /* synthetic */ o(p0 p0Var, int i8) {
        this.f10473a = i8;
        this.f10474b = p0Var;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        switch (this.f10473a) {
            case 0:
                return new AtomicLong(((Number) this.f10474b.read(bVar)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                bVar.beginArray();
                while (bVar.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) this.f10474b.read(bVar)).longValue()));
                }
                bVar.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i8 = 0; i8 < size; i8++) {
                    atomicLongArray.set(i8, ((Long) arrayList.get(i8)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        switch (this.f10473a) {
            case 0:
                this.f10474b.write(dVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                dVar.beginArray();
                int length = atomicLongArray.length();
                for (int i8 = 0; i8 < length; i8++) {
                    this.f10474b.write(dVar, Long.valueOf(atomicLongArray.get(i8)));
                }
                dVar.endArray();
                break;
        }
    }
}
