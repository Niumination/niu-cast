package u0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f16077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f16078b;

    public c(float[] fArr, int[] iArr) {
        this.f16077a = fArr;
        this.f16078b = iArr;
    }

    public int[] a() {
        return this.f16078b;
    }

    public float[] b() {
        return this.f16077a;
    }

    public int c() {
        return this.f16078b.length;
    }

    public void d(c cVar, c cVar2, float f10) {
        if (cVar.f16078b.length != cVar2.f16078b.length) {
            StringBuilder sb2 = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
            sb2.append(cVar.f16078b.length);
            sb2.append(" vs ");
            throw new IllegalArgumentException(c.a.a(sb2, cVar2.f16078b.length, ")"));
        }
        for (int i10 = 0; i10 < cVar.f16078b.length; i10++) {
            this.f16077a[i10] = z0.g.k(cVar.f16077a[i10], cVar2.f16077a[i10], f10);
            this.f16078b[i10] = z0.b.c(f10, cVar.f16078b[i10], cVar2.f16078b[i10]);
        }
    }
}
