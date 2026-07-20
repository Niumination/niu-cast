package xc;

import androidx.camera.video.internal.AudioSource;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.transsion.message.cast.audio.AudioOutputMonitor;
import com.transsion.message.cast.transfer.TransferServiceManager;
import com.transsion.message.cast.transfer.e.EAudioOutput;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements AudioOutputMonitor.Listener, CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f10917a;

    public /* synthetic */ b(Object obj) {
        this.f10917a = obj;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((AudioSource) this.f10917a).lambda$release$4(completer);
    }

    @Override // com.transsion.message.cast.audio.AudioOutputMonitor.Listener
    public void onAudioOutputChanged(EAudioOutput eAudioOutput) {
        TransferServiceManager.initialize$lambda$1((TransferServiceManager) this.f10917a, eAudioOutput);
    }
}
