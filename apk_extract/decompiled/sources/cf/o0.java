package cf;

import com.transsion.core.pool.TranssionPoolExecutor;
import java.io.IOException;
import java.util.Map;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1606d;

    public o0(x6.c cVar, String str, int i8, s6.c cVar2) {
        this.f1606d = cVar;
        this.f1604b = str;
        this.f1603a = i8;
        this.f1605c = cVar2;
    }

    public static void c(l0 l0Var, Runnable runnable) {
        if (!l0Var.a()) {
            runnable.run();
        } else {
            v8.n(l0Var.f1585b == null, "pending data notification already requested");
            l0Var.f1585b = runnable;
        }
    }

    public void a(boolean z2, l0 l0Var, qj.f fVar, boolean z3) {
        v8.i(fVar, TranssionPoolExecutor.DEFAULT_SOURCE_EXECUTOR_NAME);
        int iMin = Math.min(l0Var.f1587d, ((l0) l0Var.f1589h.f1606d).f1587d);
        boolean zA = l0Var.a();
        int i8 = (int) fVar.f9195b;
        if (zA || iMin < i8) {
            if (!zA && iMin > 0) {
                l0Var.c(iMin, fVar, false);
            }
            l0Var.f1584a.k0(fVar, (int) fVar.f9195b);
            l0Var.f1588g = z2 | l0Var.f1588g;
        } else {
            l0Var.c(i8, fVar, z2);
        }
        if (z3) {
            try {
                ((e) this.f1605c).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean b(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "Invalid initial window size: "));
        }
        int i9 = i8 - this.f1603a;
        this.f1603a = i8;
        for (l0 l0Var : ((m0) this.f1604b).e()) {
            l0Var.b(i9);
        }
        return i9 > 0;
    }

    public void d(l0 l0Var, int i8) {
        if (l0Var == null) {
            ((l0) this.f1606d).b(i8);
            e();
            return;
        }
        l0Var.b(i8);
        n0 n0Var = new n0();
        l0Var.d(Math.min(l0Var.f1587d, ((l0) l0Var.f1589h.f1606d).f1587d), n0Var);
        if (n0Var.f1602a > 0) {
            try {
                ((e) this.f1605c).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public void e() {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f1604b
            cf.m0 r0 = (cf.m0) r0
            cf.l0[] r1 = r0.e()
            java.util.List r2 = java.util.Arrays.asList(r1)
            java.util.Collections.shuffle(r2)
            java.lang.Object r2 = r13.f1606d
            cf.l0 r2 = (cf.l0) r2
            int r2 = r2.f1587d
            int r3 = r1.length
        L16:
            r4 = 0
            if (r3 <= 0) goto L6a
            if (r2 <= 0) goto L6a
            float r5 = (float) r2
            float r6 = (float) r3
            float r5 = r5 / r6
            double r5 = (double) r5
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            r6 = r4
            r7 = r6
        L26:
            if (r7 >= r3) goto L68
            if (r2 <= 0) goto L68
            r8 = r1[r7]
            int r9 = r8.f1587d
            qj.f r10 = r8.f1584a
            long r11 = r10.f9195b
            int r11 = (int) r11
            int r9 = java.lang.Math.min(r9, r11)
            int r9 = java.lang.Math.max(r4, r9)
            int r11 = r8.e
            int r9 = r9 - r11
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.min(r2, r9)
            if (r9 <= 0) goto L4e
            int r11 = r8.e
            int r11 = r11 + r9
            r8.e = r11
            int r2 = r2 - r9
        L4e:
            int r9 = r8.f1587d
            long r10 = r10.f9195b
            int r10 = (int) r10
            int r9 = java.lang.Math.min(r9, r10)
            int r9 = java.lang.Math.max(r4, r9)
            int r10 = r8.e
            int r9 = r9 - r10
            if (r9 <= 0) goto L65
            int r9 = r6 + 1
            r1[r6] = r8
            r6 = r9
        L65:
            int r7 = r7 + 1
            goto L26
        L68:
            r3 = r6
            goto L16
        L6a:
            cf.n0 r1 = new cf.n0
            r1.<init>()
            cf.l0[] r0 = r0.e()
            int r2 = r0.length
            r3 = r4
        L75:
            if (r3 >= r2) goto L83
            r5 = r0[r3]
            int r6 = r5.e
            r5.d(r6, r1)
            r5.e = r4
            int r3 = r3 + 1
            goto L75
        L83:
            int r0 = r1.f1602a
            if (r0 <= 0) goto L96
            java.lang.Object r13 = r13.f1605c     // Catch: java.io.IOException -> L8f
            cf.e r13 = (cf.e) r13     // Catch: java.io.IOException -> L8f
            r13.flush()     // Catch: java.io.IOException -> L8f
            goto L96
        L8f:
            r13 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r13)
            throw r0
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.o0.e():void");
    }

    @Override // f8.b
    public void onInitFail() {
    }

    @Override // f8.b
    public void onInitSuccess(Map map) {
        String string = map.toString();
        s6.c cVar = (s6.c) this.f1605c;
        ((x6.c) this.f1606d).getClass();
        x6.c.o((String) this.f1604b, this.f1603a, cVar, string);
    }

    public o0(m0 m0Var, e eVar) {
        this.f1604b = m0Var;
        this.f1605c = eVar;
        this.f1603a = 65535;
        this.f1606d = new l0(this, 0, 65535, null);
    }
}
