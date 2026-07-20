package od;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import com.transsion.hubsdk.media.TranAudioPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a1 implements ig.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranAudioPolicy f12175a;

    public final TranAudioPolicy a() {
        TranAudioPolicy tranAudioPolicy = this.f12175a;
        if (tranAudioPolicy != null) {
            return tranAudioPolicy;
        }
        TranAudioPolicy tranAudioPolicy2 = new TranAudioPolicy();
        this.f12175a = tranAudioPolicy2;
        return tranAudioPolicy2;
    }

    @Override // ig.c
    public AudioRecord i() {
        return a().getAudioRecord();
    }

    @Override // ig.c
    public void j(List<Integer> list, int i10) {
        a().updateAudioUid(list, i10);
    }

    @Override // ig.c
    public void k(Context context, int i10, AudioFormat audioFormat) {
        a().init(context, i10, audioFormat);
    }

    @Override // ig.c
    public void release() {
        a().release();
    }
}
