package kl;

import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun");


    @l
    public static final a Companion = new a();

    @l
    private final String value;

    public static final class a {
        public a() {
        }

        @l
        public final i a(int i10) {
            return i.values()[i10];
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:9:0x001f A[RETURN] */
        @l
        public final i b(@l String str) {
            i iVar;
            l0.p(str, "value");
            i[] iVarArrValues = i.values();
            int length = iVarArrValues.length;
            int i10 = 0;
            while (i10 < length) {
                iVar = iVarArrValues[i10];
                i10++;
                if (l0.g(iVar.getValue(), str)) {
                    if (iVar != null) {
                        return iVar;
                    }
                    throw new IllegalStateException(l0.C("Invalid day of week: ", str).toString());
                }
            }
            iVar = null;
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalStateException(l0.C("Invalid day of week: ", str).toString());
        }

        public a(w wVar) {
        }
    }

    i(String str) {
        this.value = str;
    }

    @l
    public final String getValue() {
        return this.value;
    }
}
