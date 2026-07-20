package q4;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13819d = "AudioPolicyManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m4.a f13821b = m4.a.C0275a.f10375a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioFormat f13822c;

    public b(Context context) {
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(44100).setEncoding(2).setChannelMask(12).build();
        this.f13822c = audioFormatBuild;
        m.e(f13819d, "AudioPolicyManager create");
        this.f13820a = context;
        this.f13821b.r(context, k4.a.c(context, w4.b.f17953b), audioFormatBuild);
    }

    public AudioRecord a() {
        return this.f13821b.i();
    }

    public void b() {
        m.e(f13819d, "AudioPolicy release");
        this.f13821b.y();
    }

    @b.a({"MissingPermission"})
    public void c(List<String> list) {
        m.e(f13819d, "updateAudioUid, packageList: " + list);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(k4.a.c(this.f13820a, it.next())));
        }
        this.f13821b.j(arrayList, k4.a.c(this.f13820a, w4.b.f17953b));
    }
}
