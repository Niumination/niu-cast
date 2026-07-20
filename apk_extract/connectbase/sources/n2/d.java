package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    @SerializedName(t2.a.f15437d)
    private String mContent;

    public d() {
    }

    public String a() {
        return this.mContent;
    }

    public void b(String str) {
        this.mContent = str;
    }

    public String toString() {
        return l.a.a(new StringBuilder("ClipboardContentRequest{content="), this.mContent, rs.f.f14860b);
    }

    public d(String str) {
        this.mContent = str;
    }
}
