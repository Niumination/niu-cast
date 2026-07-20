package i4;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Collection f5603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c4 f5604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Collection f5605c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a4) {
            return asMap().equals(((a4) obj).asMap());
        }
        return false;
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
