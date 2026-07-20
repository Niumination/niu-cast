package m3;

/* JADX INFO: loaded from: classes.dex */
public final class la {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof la)) {
            return false;
        }
        ((la) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 1269983555;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=vision-common, enableFirelog=true, firelogEventType=1}";
    }
}
