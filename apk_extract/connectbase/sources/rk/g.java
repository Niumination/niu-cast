package rk;

import fl.t0;
import java.util.ArrayList;
import kn.w;
import nm.h0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public enum g {
    READ(1),
    WRITE(4),
    ACCEPT(16),
    CONNECT(8);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final int[] f14541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14542c;
    private final int flag;

    @os.l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g[] f14540a = values();

    public static final class a {
        public a() {
        }

        @os.l
        public final g[] a() {
            return g.f14540a;
        }

        @os.l
        public final int[] b() {
            return g.f14541b;
        }

        public final int c() {
            return g.f14542c;
        }

        public a(w wVar) {
        }
    }

    static {
        int i10 = 0;
        g[] gVarArrValues = values();
        ArrayList arrayList = new ArrayList(gVarArrValues.length);
        int length = gVarArrValues.length;
        while (i10 < length) {
            g gVar = gVarArrValues[i10];
            i10++;
            arrayList.add(Integer.valueOf(gVar.getFlag()));
        }
        f14541b = h0.U5(arrayList);
        f14542c = values().length;
    }

    g(int i10) {
        this.flag = i10;
    }

    public final int getFlag() {
        return this.flag;
    }
}
