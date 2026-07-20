package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    @SerializedName("deviceId")
    private String mDeviceId;

    public r() {
    }

    public String a() {
        String str = this.mDeviceId;
        return str == null ? "" : str;
    }

    public void b(String str) {
        this.mDeviceId = str;
    }

    public String toString() {
        return j.c.a(new StringBuilder("OpenApRequest{deviceId='"), this.mDeviceId, "'}");
    }

    public r(String str) {
        this.mDeviceId = str;
    }
}
