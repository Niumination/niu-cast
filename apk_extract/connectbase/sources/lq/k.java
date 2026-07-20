package lq;

import kn.l0;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public class k extends j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10261a;

        static {
            int[] iArr = new int[h.values().length];
            try {
                iArr[h.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[h.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[h.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[h.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[h.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f10261a = iArr;
        }
    }

    @f1(version = "1.5")
    @os.l
    public static final h f(char c10, boolean z10) {
        if (!z10) {
            if (c10 == 'D') {
                return h.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c10);
        }
        if (c10 == 'H') {
            return h.HOURS;
        }
        if (c10 == 'M') {
            return h.MINUTES;
        }
        if (c10 == 'S') {
            return h.SECONDS;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c10);
    }

    @f1(version = "1.5")
    @os.l
    public static final h g(@os.l String str) {
        l0.p(str, "shortName");
        int iHashCode = str.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && str.equals("us")) {
                                    return h.MICROSECONDS;
                                }
                            } else if (str.equals("ns")) {
                                return h.NANOSECONDS;
                            }
                        } else if (str.equals("ms")) {
                            return h.MILLISECONDS;
                        }
                    } else if (str.equals(p6.s.f13016a)) {
                        return h.SECONDS;
                    }
                } else if (str.equals(p6.m.f13003a)) {
                    return h.MINUTES;
                }
            } else if (str.equals("h")) {
                return h.HOURS;
            }
        } else if (str.equals("d")) {
            return h.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: ".concat(str));
    }

    @f1(version = "1.3")
    @os.l
    public static final String h(@os.l h hVar) {
        l0.p(hVar, "<this>");
        switch (a.f10261a[hVar.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return p6.s.f13016a;
            case 5:
                return p6.m.f13003a;
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new IllegalStateException(("Unknown unit: " + hVar).toString());
        }
    }
}
