package ig;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    AudioRecord i();

    void j(List<Integer> list, int i10);

    void k(Context context, int i10, AudioFormat audioFormat);

    void release();
}
