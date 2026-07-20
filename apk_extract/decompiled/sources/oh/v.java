package oh;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8523a = new AtomicReference(t.HEADER0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8526d;
    public boolean e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f8530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f8531k;

    public final y a() {
        x xVar = y.Companion;
        int i8 = this.f8527g;
        xVar.getClass();
        y yVar = (i8 < 0 || i8 > y.maxOpcode) ? null : y.byOpcodeArray[i8];
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalStateException("Unsupported opcode " + Integer.toHexString(this.f8527g));
    }
}
