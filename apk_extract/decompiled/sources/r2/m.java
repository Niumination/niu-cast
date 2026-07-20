package r2;

import com.google.android.gms.common.Feature;
import com.transsion.message.bank.MessageBank;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Feature f9352b;

    public /* synthetic */ m(a aVar, Feature feature) {
        this.f9351a = aVar;
        this.f9352b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            m mVar = (m) obj;
            if (u2.l.h(this.f9351a, mVar.f9351a) && u2.l.h(this.f9352b, mVar.f9352b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9351a, this.f9352b});
    }

    public final String toString() {
        u6.c cVar = new u6.c(this);
        cVar.q(this.f9351a, "key");
        cVar.q(this.f9352b, MessageBank.KEY_FEATURE);
        return cVar.toString();
    }
}
