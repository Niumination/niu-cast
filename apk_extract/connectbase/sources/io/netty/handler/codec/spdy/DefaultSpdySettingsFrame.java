package io.netty.handler.codec.spdy;

import h.a;
import io.netty.util.internal.StringUtil;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import n1.e;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSpdySettingsFrame implements SpdySettingsFrame {
    private boolean clear;
    private final Map<Integer, Setting> settingsMap = new TreeMap();

    public static final class Setting {
        private boolean persist;
        private boolean persisted;
        private int value;

        public Setting(int i10, boolean z10, boolean z11) {
            this.value = i10;
            this.persist = z10;
            this.persisted = z11;
        }

        public int getValue() {
            return this.value;
        }

        public boolean isPersist() {
            return this.persist;
        }

        public boolean isPersisted() {
            return this.persisted;
        }

        public void setPersist(boolean z10) {
            this.persist = z10;
        }

        public void setPersisted(boolean z10) {
            this.persisted = z10;
        }

        public void setValue(int i10) {
            this.value = i10;
        }
    }

    private void appendSettings(StringBuilder sb2) {
        for (Map.Entry<Integer, Setting> entry : getSettings()) {
            Setting value = entry.getValue();
            sb2.append("--> ");
            sb2.append(entry.getKey());
            sb2.append(e.f11184d);
            sb2.append(value.getValue());
            sb2.append(" (persist value: ");
            sb2.append(value.isPersist());
            sb2.append("; persisted: ");
            sb2.append(value.isPersisted());
            sb2.append(')');
            sb2.append(StringUtil.NEWLINE);
        }
    }

    private Set<Map.Entry<Integer, Setting>> getSettings() {
        return this.settingsMap.entrySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean clearPreviouslyPersistedSettings() {
        return this.clear;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public int getValue(int i10) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i10));
        if (setting != null) {
            return setting.getValue();
        }
        return -1;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public Set<Integer> ids() {
        return this.settingsMap.keySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersistValue(int i10) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i10));
        return setting != null && setting.isPersist();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersisted(int i10) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i10));
        return setting != null && setting.isPersisted();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isSet(int i10) {
        return this.settingsMap.containsKey(Integer.valueOf(i10));
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame removeValue(int i10) {
        this.settingsMap.remove(Integer.valueOf(i10));
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z10) {
        this.clear = z10;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersistValue(int i10, boolean z10) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i10));
        if (setting != null) {
            setting.setPersist(z10);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersisted(int i10, boolean z10) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i10));
        if (setting != null) {
            setting.setPersisted(z10);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i10, int i11) {
        return setValue(i10, i11, false, false);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb2.append(str);
        appendSettings(sb2);
        sb2.setLength(sb2.length() - str.length());
        return sb2.toString();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i10, int i11, boolean z10, boolean z11) {
        if (i10 < 0 || i10 > 16777215) {
            throw new IllegalArgumentException(a.a("Setting ID is not valid: ", i10));
        }
        Integer numValueOf = Integer.valueOf(i10);
        Setting setting = this.settingsMap.get(numValueOf);
        if (setting != null) {
            setting.setValue(i11);
            setting.setPersist(z10);
            setting.setPersisted(z11);
        } else {
            this.settingsMap.put(numValueOf, new Setting(i11, z10, z11));
        }
        return this;
    }
}
