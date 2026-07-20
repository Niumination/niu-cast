package be;

import android.preference.PreferenceFragment;
import android.widget.ListView;
import com.transsion.hubsdk.preference.TranPreferenceFragmentBridge;

/* JADX INFO: loaded from: classes2.dex */
public class a implements vg.a {
    @Override // vg.a
    public ListView a(PreferenceFragment preferenceFragment) {
        return new TranPreferenceFragmentBridge().getListView(preferenceFragment);
    }
}
