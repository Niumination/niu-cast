package a1;

/* JADX INFO: loaded from: classes.dex */
public class h extends j<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    public Integer e(b<Integer> bVar) {
        T t10 = this.f35c;
        if (t10 != 0) {
            return (Integer) t10;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // a1.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Integer a(b<Integer> bVar) {
        return Integer.valueOf(e(bVar).intValue() + z0.g.l(bVar.g().intValue(), bVar.b().intValue(), bVar.c()));
    }
}
