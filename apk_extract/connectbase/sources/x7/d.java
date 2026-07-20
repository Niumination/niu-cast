package x7;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ig.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f20116a = cc.a.a("com.transsion.hubsdk.media.TranAudioPolicy");

    @Override // ig.c
    public AudioRecord i() {
        Class cls = f20116a;
        if (cls == null) {
            return null;
        }
        return (AudioRecord) cc.a.j(cc.a.g(cls, "getAudioRecord", new Class[0]), f20116a, new Object[0]);
    }

    @Override // ig.c
    public void j(List<Integer> list, int i10) {
        Class cls = f20116a;
        if (cls == null) {
            return;
        }
        cc.a.j(cc.a.g(cls, "updateAudioUid", List.class, Integer.TYPE), f20116a, list, Integer.valueOf(i10));
    }

    @Override // ig.c
    public void k(Context context, int i10, AudioFormat audioFormat) {
        Class cls = f20116a;
        if (cls == null) {
            return;
        }
        cc.a.j(cc.a.g(cls, "init", Context.class, Integer.TYPE, AudioFormat.class), f20116a, context, Integer.valueOf(i10), audioFormat);
    }

    @Override // ig.c
    public void release() {
        Class cls = f20116a;
        if (cls == null) {
            return;
        }
        cc.a.j(cc.a.g(cls, "release", new Class[0]), f20116a, new Object[0]);
    }
}
