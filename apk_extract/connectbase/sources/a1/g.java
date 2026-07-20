package a1;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class g extends j<Float> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float e(b<Float> bVar) {
        T t10 = this.f35c;
        if (t10 != 0) {
            return (Float) t10;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // a1.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float a(b<Float> bVar) {
        return Float.valueOf(e(bVar).floatValue() + z0.g.k(bVar.g().floatValue(), bVar.b().floatValue(), bVar.c()));
    }

    public g(@NonNull Float f10) {
        super(f10);
    }
}
