package m1;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7580i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(List list, int i8) {
        super(list);
        this.f7580i = i8;
    }

    @Override // m1.e
    public final Object g(x1.a aVar, float f) {
        Object obj;
        switch (this.f7580i) {
            case 0:
                return Integer.valueOf(l(aVar, f));
            case 1:
                return Integer.valueOf(l(aVar, f));
            default:
                x1.c cVar = this.e;
                Object obj2 = aVar.f10807b;
                if (cVar == null) {
                    return (f != 1.0f || (obj = aVar.f10808c) == null) ? (p1.c) obj2 : (p1.c) obj;
                }
                Float f4 = aVar.f10811h;
                float fFloatValue = f4 == null ? Float.MAX_VALUE : f4.floatValue();
                p1.c cVar2 = (p1.c) obj2;
                Object obj3 = aVar.f10808c;
                return (p1.c) cVar.b(aVar.f10810g, fFloatValue, cVar2, obj3 == null ? cVar2 : (p1.c) obj3, f, d(), this.f7577d);
        }
    }

    public int l(x1.a aVar, float f) {
        Float f4;
        int i8;
        switch (this.f7580i) {
            case 0:
                if (aVar.f10807b == null || aVar.f10808c == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                x1.c cVar = this.e;
                Object obj = aVar.f10807b;
                if (cVar != null && (f4 = aVar.f10811h) != null) {
                    Integer num = (Integer) cVar.b(aVar.f10810g, f4.floatValue(), (Integer) obj, (Integer) aVar.f10808c, f, e(), this.f7577d);
                    if (num != null) {
                        return num.intValue();
                    }
                }
                return m3.l.c(w1.f.b(f, 0.0f, 1.0f), ((Integer) obj).intValue(), ((Integer) aVar.f10808c).intValue());
            default:
                Object obj2 = aVar.f10807b;
                if (obj2 == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                Object obj3 = aVar.f10808c;
                if (obj3 == null) {
                    if (aVar.f10814k == 784923401) {
                        aVar.f10814k = ((Integer) obj2).intValue();
                    }
                    i8 = aVar.f10814k;
                } else {
                    if (aVar.f10815l == 784923401) {
                        aVar.f10815l = ((Integer) obj3).intValue();
                    }
                    i8 = aVar.f10815l;
                }
                x1.c cVar2 = this.e;
                Object obj4 = aVar.f10807b;
                if (cVar2 != null) {
                    Integer num2 = (Integer) cVar2.b(aVar.f10810g, aVar.f10811h.floatValue(), (Integer) obj4, Integer.valueOf(i8), f, e(), this.f7577d);
                    if (num2 != null) {
                        return num2.intValue();
                    }
                }
                if (aVar.f10814k == 784923401) {
                    aVar.f10814k = ((Integer) obj4).intValue();
                }
                int i9 = aVar.f10814k;
                PointF pointF = w1.f.f10646a;
                return (int) ((f * (i8 - i9)) + i9);
        }
    }
}
