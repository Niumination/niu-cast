package v4;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class m extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10472a;

    public /* synthetic */ m(int i8) {
        this.f10472a = i8;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        switch (this.f10472a) {
            case 0:
                if (bVar.peek() != d5.c.NULL) {
                    return Double.valueOf(bVar.nextDouble());
                }
                bVar.nextNull();
                return null;
            case 1:
                if (bVar.peek() != d5.c.NULL) {
                    return Float.valueOf((float) bVar.nextDouble());
                }
                bVar.nextNull();
                return null;
            default:
                bVar.skipValue();
                return null;
        }
    }

    public String toString() {
        switch (this.f10472a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        switch (this.f10472a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    q.a(dDoubleValue);
                    dVar.value(dDoubleValue);
                } else {
                    dVar.nullValue();
                }
                break;
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    q.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    dVar.value(numberValueOf);
                } else {
                    dVar.nullValue();
                }
                break;
            default:
                dVar.nullValue();
                break;
        }
    }
}
