package io.netty.handler.codec.socksx.v5;

/* JADX INFO: loaded from: classes3.dex */
public interface Socks5PasswordAuthRequest extends Socks5Message {
    String password();

    String username();
}
