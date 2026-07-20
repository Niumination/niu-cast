package i4;

import java.util.Objects;
import k3.g9;

/* JADX INFO: loaded from: classes.dex */
public final class l1 extends g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k4 f5633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5634b = false;

    public l1(int i8) {
        k4 k4Var = new k4();
        k4Var.e(i8);
        this.f5633a = k4Var;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:18:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0036 -> B:9:0x001d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:7:0x000c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final void b(int r7, java.lang.Object r8) {
        /*
            r6 = this;
            i4.k4 r0 = r6.f5633a
            java.util.Objects.requireNonNull(r0)
            if (r7 != 0) goto L8
            return
        L8:
            boolean r0 = r6.f5634b
            if (r0 == 0) goto L3b
            i4.k4 r0 = new i4.k4
            i4.k4 r1 = r6.f5633a
            r0.<init>()
            int r2 = r1.f5624c
            r0.e(r2)
            int r2 = r1.f5624c
            r3 = -1
            if (r2 != 0) goto L1f
        L1d:
            r2 = r3
            goto L20
        L1f:
            r2 = 0
        L20:
            if (r2 == r3) goto L39
            int r4 = r1.f5624c
            k3.v8.h(r2, r4)
            java.lang.Object[] r4 = r1.f5622a
            r4 = r4[r2]
            int r5 = r1.c(r2)
            r0.f(r5, r4)
            int r2 = r2 + 1
            int r4 = r1.f5624c
            if (r2 >= r4) goto L1d
            goto L20
        L39:
            r6.f5633a = r0
        L3b:
            r0 = 0
            r6.f5634b = r0
            r8.getClass()
            i4.k4 r6 = r6.f5633a
            int r0 = r6.b(r8)
            int r0 = r0 + r7
            r6.f(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.l1.b(int, java.lang.Object):void");
    }

    public final o1 c() {
        Objects.requireNonNull(this.f5633a);
        if (this.f5633a.f5624c == 0) {
            return o1.of();
        }
        this.f5634b = true;
        return new y4(this.f5633a);
    }
}
