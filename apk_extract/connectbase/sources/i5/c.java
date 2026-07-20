package i5;

import com.google.gson.annotations.SerializedName;
import d5.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements h<String> {

    @SerializedName("secure_window_list")
    private List<String> mDataList;

    @Override // d5.h
    public List<String> b() {
        return this.mDataList;
    }
}
