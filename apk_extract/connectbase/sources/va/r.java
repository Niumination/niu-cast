package va;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f16834a = new HashMap<>();

    public String a(String str) {
        return this.f16834a.get(str);
    }

    public String b(String str, String str2) {
        String str3 = this.f16834a.get(str);
        return str3 == null ? str2 : str3;
    }

    public HashMap<String, String> c() {
        return this.f16834a;
    }

    public void d(HashMap<String, String> map) {
        this.f16834a = map;
    }

    public String toString() {
        return this.f16834a.toString();
    }
}
