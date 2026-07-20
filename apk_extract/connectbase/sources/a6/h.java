package a6;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f69a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f70a = new h();
    }

    public static h b() {
        return a.f70a;
    }

    public List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f69a) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public h() {
        this.f69a = Arrays.asList("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_NETWORK_STATE");
    }
}
