package mk;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public enum k {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);


    @os.l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final k[] f10799b;
    private final boolean controlFrame;
    private final int opcode;

    public static final class a {
        public a() {
        }

        @os.m
        public final k a(int i10) {
            if (i10 < 0 || i10 > k.f10798a) {
                return null;
            }
            return k.f10799b[i10];
        }

        public a(kn.w wVar) {
        }
    }

    static {
        k kVar;
        k[] kVarArrValues = values();
        if (kVarArrValues.length == 0) {
            kVar = null;
        } else {
            kVar = kVarArrValues[0];
            int iWe = nm.r.we(kVarArrValues);
            if (iWe != 0) {
                int opcode = kVar.getOpcode();
                if (1 <= iWe) {
                    int i10 = 1;
                    while (true) {
                        int i11 = i10 + 1;
                        k kVar2 = kVarArrValues[i10];
                        int opcode2 = kVar2.getOpcode();
                        if (opcode < opcode2) {
                            kVar = kVar2;
                            opcode = opcode2;
                        }
                        if (i10 == iWe) {
                            break;
                        } else {
                            i10 = i11;
                        }
                    }
                }
            }
        }
        l0.m(kVar);
        int i12 = kVar.opcode;
        f10798a = i12;
        int i13 = i12 + 1;
        k[] kVarArr = new k[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            k[] kVarArrValues2 = values();
            int length = kVarArrValues2.length;
            int i15 = 0;
            boolean z10 = false;
            k kVar3 = null;
            while (true) {
                if (i15 >= length) {
                    if (z10) {
                        break;
                    }
                } else {
                    k kVar4 = kVarArrValues2[i15];
                    i15++;
                    if (kVar4.getOpcode() == i14) {
                        if (!z10) {
                            z10 = true;
                            kVar3 = kVar4;
                        }
                    }
                }
                kVar3 = null;
                break;
            }
            kVarArr[i14] = kVar3;
        }
        f10799b = kVarArr;
    }

    k(boolean z10, int i10) {
        this.controlFrame = z10;
        this.opcode = i10;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }
}
