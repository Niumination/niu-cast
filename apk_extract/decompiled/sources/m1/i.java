package m1;

/* JADX INFO: loaded from: classes.dex */
public final class i extends k {
    @Override // m1.e
    public final Object g(x1.a aVar, float f) {
        return Float.valueOf(m(aVar, f));
    }

    public final float l() {
        return m(b(), d());
    }

    public final float m(x1.a aVar, float f) {
        if (aVar.f10807b == null || aVar.f10808c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        x1.c cVar = this.e;
        Object obj = aVar.f10807b;
        if (cVar != null) {
            Float f4 = (Float) aVar.f10808c;
            float fE = e();
            float f10 = this.f7577d;
            Float f11 = (Float) cVar.b(aVar.f10810g, aVar.f10811h.floatValue(), (Float) obj, f4, f, fE, f10);
            if (f11 != null) {
                return f11.floatValue();
            }
        }
        if (aVar.f10812i == -3987645.8f) {
            aVar.f10812i = ((Float) obj).floatValue();
        }
        float f12 = aVar.f10812i;
        if (aVar.f10813j == -3987645.8f) {
            aVar.f10813j = ((Float) aVar.f10808c).floatValue();
        }
        return w1.f.e(f12, aVar.f10813j, f);
    }
}
