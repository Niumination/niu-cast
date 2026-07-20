package io.netty.handler.codec.serialization;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ClassResolver {
    Class<?> resolve(String str) throws ClassNotFoundException;
}
