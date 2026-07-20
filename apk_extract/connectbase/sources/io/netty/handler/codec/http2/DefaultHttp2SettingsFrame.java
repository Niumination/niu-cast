package io.netty.handler.codec.http2;

import com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2SettingsFrame implements Http2SettingsFrame {
    private final Http2Settings settings;

    public DefaultHttp2SettingsFrame(Http2Settings http2Settings) {
        this.settings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, TranSearchIndexablesProvider.f2243v);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Http2SettingsFrame) {
            return this.settings.equals(((Http2SettingsFrame) obj).settings());
        }
        return false;
    }

    public int hashCode() {
        return this.settings.hashCode();
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsFrame, io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "SETTINGS";
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsFrame
    public Http2Settings settings() {
        return this.settings;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(settings=" + this.settings + ')';
    }
}
