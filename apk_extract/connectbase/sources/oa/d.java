package oa;

import android.media.AudioRecordingConfiguration;
import od.b1;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12127a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b1 f12128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static x7.e f12129c;

    public static ig.d b(String str) {
        if (fc.b.b(str)) {
            b1 b1Var = f12128b;
            if (b1Var != null) {
                return b1Var;
            }
            b1 b1Var2 = new b1();
            f12128b = b1Var2;
            return b1Var2;
        }
        x7.e eVar = f12129c;
        if (eVar != null) {
            return eVar;
        }
        x7.e eVar2 = new x7.e();
        f12129c = eVar2;
        return eVar2;
    }

    public static String c(AudioRecordingConfiguration audioRecordingConfiguration) {
        return b(fc.b.a.f5986f).a(audioRecordingConfiguration);
    }

    public String a(AudioRecordingConfiguration audioRecordingConfiguration) {
        return b(fc.b.a.f5984d).b(audioRecordingConfiguration);
    }
}
