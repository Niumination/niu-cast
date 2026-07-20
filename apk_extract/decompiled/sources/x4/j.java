package x4;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final int majorJavaVersion = determineMajorJavaVersion();

    private j() {
    }

    private static int determineMajorJavaVersion() {
        String property = System.getProperty("java.version");
        int dotted = parseDotted(property);
        if (dotted == -1) {
            dotted = extractBeginningInt(property);
        }
        if (dotted == -1) {
            return 6;
        }
        return dotted;
    }

    private static int extractBeginningInt(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i8 = 0; i8 < str.length(); i8++) {
                char cCharAt = str.charAt(i8);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb2.append(cCharAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }

    private static int parseDotted(String str) {
        try {
            String[] strArrSplit = str.split("[._]", 3);
            int i8 = Integer.parseInt(strArrSplit[0]);
            return (i8 != 1 || strArrSplit.length <= 1) ? i8 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
