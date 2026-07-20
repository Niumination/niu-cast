package rb;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14394c = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.g f14395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.f f14396b;

    public Object a(Object obj) {
        return b(fc.b.a.f5988h).a(obj);
    }

    public lh.g b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14394c, "TranThubScrollCaptureResponse");
            re.g gVar = this.f14395a;
            if (gVar != null) {
                return gVar;
            }
            re.g gVar2 = new re.g();
            this.f14395a = gVar2;
            return gVar2;
        }
        dc.e.f(f14394c, "TranAospPhysical");
        b9.f fVar = this.f14396b;
        if (fVar != null) {
            return fVar;
        }
        b9.f fVar2 = new b9.f();
        this.f14396b = fVar2;
        return fVar2;
    }
}
