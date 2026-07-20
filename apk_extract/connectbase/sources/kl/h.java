package kl;

import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public enum h {
    JANUARY("Jan"),
    FEBRUARY("Feb"),
    MARCH("Mar"),
    APRIL("Apr"),
    MAY("May"),
    JUNE("Jun"),
    JULY("Jul"),
    AUGUST("Aug"),
    SEPTEMBER("Sep"),
    OCTOBER("Oct"),
    NOVEMBER("Nov"),
    DECEMBER("Dec");


    @l
    public static final a Companion = new a();

    @l
    private final String value;

    public static final class a {
        public a() {
        }

        @l
        public final h a(int i10) {
            return h.values()[i10];
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:9:0x001f A[RETURN] */
        @l
        public final h b(@l String str) {
            h hVar;
            l0.p(str, "value");
            h[] hVarArrValues = h.values();
            int length = hVarArrValues.length;
            int i10 = 0;
            while (i10 < length) {
                hVar = hVarArrValues[i10];
                i10++;
                if (l0.g(hVar.getValue(), str)) {
                    if (hVar != null) {
                        return hVar;
                    }
                    throw new IllegalStateException(l0.C("Invalid month: ", str).toString());
                }
            }
            hVar = null;
            if (hVar != null) {
                return hVar;
            }
            throw new IllegalStateException(l0.C("Invalid month: ", str).toString());
        }

        public a(w wVar) {
        }
    }

    h(String str) {
        this.value = str;
    }

    @l
    public final String getValue() {
        return this.value;
    }
}
