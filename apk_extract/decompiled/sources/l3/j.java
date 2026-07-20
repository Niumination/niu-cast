package l3;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class j implements l, IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f7254b;

    public j(IBinder iBinder) {
        this.f7254b = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f7254b;
    }
}
