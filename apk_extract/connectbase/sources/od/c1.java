package od;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.media.ITranAudioSystem;

/* JADX INFO: loaded from: classes2.dex */
public class c1 implements ig.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12184a = "c1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ITranAudioSystem f12185b;

    public c1() {
        f12185b = ITranAudioSystem.Stub.asInterface(TranServiceManager.getServiceIBinder("audio_system"));
    }

    @Override // ig.e
    public int a(int i10, int i11) {
        try {
            return f12185b.setForceUse(i10, i11);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // ig.e
    public boolean b(int i10) {
        try {
            return f12185b.isSourceActive(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // ig.e
    public int c() {
        try {
            return f12185b.newAudioSessionId();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // ig.e
    public int d(int i10) {
        try {
            return f12185b.getForceUse(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // ig.e
    public String e(int i10) {
        try {
            return f12185b.getOutputDeviceName(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
