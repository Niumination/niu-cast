package o5;

import android.content.SharedPreferences;
import com.transsion.connectx.mirror.source.SourceApplication;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12097c = "filterSourceFile";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12098d = "isFirst";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12099e = "LocalFilterPackageList";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f12100f = Arrays.asList("android", "com.transsion.connectx.source");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f12101b;

    public k() {
        SharedPreferences sharedPreferences = SourceApplication.b().getSharedPreferences(f12097c, 0);
        this.f12101b = sharedPreferences;
        if (sharedPreferences.getBoolean(f12098d, true)) {
            SharedPreferences.Editor editorEdit = this.f12101b.edit();
            editorEdit.putBoolean(f12098d, false);
            editorEdit.putStringSet(f12099e, new HashSet(f12100f));
            editorEdit.apply();
        }
        d();
    }

    @Override // o5.i
    public void a(String str) {
        SharedPreferences.Editor editorEdit = this.f12101b.edit();
        HashSet hashSet = new HashSet(this.f12101b.getStringSet(f12099e, new HashSet()));
        hashSet.add(str);
        editorEdit.putStringSet(f12099e, hashSet);
        editorEdit.apply();
        d();
    }

    @Override // o5.i
    public void b(String str) {
        SharedPreferences sharedPreferences = SourceApplication.b().getSharedPreferences(f12097c, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(f12099e, new HashSet()));
        hashSet.remove(str);
        editorEdit.putStringSet(f12099e, hashSet);
        editorEdit.apply();
        d();
    }

    @Override // o5.i
    public void d() {
        this.f12096a = this.f12101b.getStringSet(f12099e, new HashSet(f12100f));
    }
}
