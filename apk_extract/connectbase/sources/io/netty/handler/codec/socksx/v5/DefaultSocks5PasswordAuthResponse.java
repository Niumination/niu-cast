package io.netty.handler.codec.socksx.v5;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSocks5PasswordAuthResponse extends AbstractSocks5Message implements Socks5PasswordAuthResponse {
    private final Socks5PasswordAuthStatus status;

    public DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        this.status = (Socks5PasswordAuthStatus) ObjectUtil.checkNotNull(socks5PasswordAuthStatus, NotificationCompat.CATEGORY_STATUS);
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponse
    public Socks5PasswordAuthStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb2.append("(status: ");
        } else {
            sb2.append("(decoderResult: ");
            sb2.append(decoderResult);
            sb2.append(", status: ");
        }
        sb2.append(status());
        sb2.append(')');
        return sb2.toString();
    }
}
