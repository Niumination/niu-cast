package x7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.transsion.os.audio.AudioModeHelper;
import com.transsion.os.audio.IAudioModeChangeListener;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioManager f20110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap<d, C0499b> f20111c = new ArrayMap<>();

    public class a extends IAudioModeChangeListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f20112a;

        public a(c cVar) {
            this.f20112a = cVar;
        }

        public void a(int i10, String str) throws RemoteException {
            c cVar = this.f20112a;
            if (cVar != null) {
                cVar.a(i10, str);
            }
        }
    }

    /* JADX INFO: renamed from: x7.b$b, reason: collision with other inner class name */
    public class C0499b extends AudioManager.VolumeGroupCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f20114a;

        public C0499b(d dVar) {
            this.f20114a = dVar;
        }

        public void a(int i10, int i11) {
            d dVar = this.f20114a;
            if (dVar != null) {
                dVar.a(i10, i11);
            }
        }
    }

    public interface c {
        void a(int i10, String str);
    }

    public interface d {
        void a(int i10, int i11);
    }

    public b(Context context) {
        this.f20109a = context;
    }

    public void a(String str, c cVar) {
        a aVar = new a(cVar);
        try {
            this.f20109a.createPackageContext(str, 3);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        AudioModeHelper.getInstance().registerAudioModeChangeListeners(aVar, this.f20109a);
    }

    public void b(d dVar) {
        if (this.f20110b == null) {
            this.f20110b = (AudioManager) this.f20109a.getSystemService("audio");
        }
        C0499b c0499b = new C0499b(dVar);
        this.f20111c.put(dVar, c0499b);
        this.f20110b.registerVolumeGroupCallback(new Executor() { // from class: h0.c
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }, c0499b);
    }

    public void c(String str) {
        try {
            this.f20109a.createPackageContext(str, 3);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        AudioModeHelper.getInstance().unregisterAudioModeChangeListeners(this.f20109a);
    }

    public void d(d dVar) {
        if (this.f20110b == null) {
            this.f20110b = (AudioManager) this.f20109a.getSystemService("audio");
        }
        C0499b c0499b = this.f20111c.get(dVar);
        if (c0499b != null) {
            this.f20110b.unregisterVolumeGroupCallback(c0499b);
        }
        this.f20111c.remove(dVar);
    }
}
