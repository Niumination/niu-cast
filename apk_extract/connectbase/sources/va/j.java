package va;

import android.content.Context;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16788c = "battery.capacity";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f16790b = bc.a.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerProfile f16789a = new PowerProfile(this.f16790b);

    public double a() {
        return this.f16789a.getAveragePower(f16788c);
    }
}
