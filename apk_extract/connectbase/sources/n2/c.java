package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    @SerializedName(t2.a.f15437d)
    private String mContent;

    public c() {
    }

    public String a() {
        return this.mContent;
    }

    public void b(String str) {
        this.mContent = str;
    }

    public String toString() {
        return j.c.a(new StringBuilder("ClipboardChangedRequest{content='"), this.mContent, "'}");
    }

    public c(String str) {
        this.mContent = str;
    }
}
