package ei;

/* JADX INFO: loaded from: classes2.dex */
public class k extends a {
    @Override // ei.n
    public void a(Object obj) {
        if (obj instanceof Double) {
            Double d10 = (Double) obj;
            if (Double.isInfinite(d10.doubleValue()) || Double.isNaN(d10.doubleValue())) {
                c().r(d6.a.E);
                return;
            }
        }
        if (obj instanceof Float) {
            Float f10 = (Float) obj;
            if (Float.isInfinite(f10.floatValue()) || Float.isNaN(f10.floatValue())) {
                c().r(d6.a.E);
                return;
            }
        }
        c().r(obj.toString());
    }
}
