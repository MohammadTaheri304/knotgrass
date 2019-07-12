package io.zino.knotgrass.domain;

import com.google.common.hash.Hashing;
import org.bson.Document;

import java.nio.charset.StandardCharsets;

public class UnsignedBlockDO {

    private String uuid;
    private Long index;
    private Long createAt;

    private String preUuid;
    private String prehash;

    private String data;

    private String minerUuid;

    private Long nonce;

    public UnsignedBlockDO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getPreUuid() {
        return preUuid;
    }

    public void setPreUuid(String preUuid) {
        this.preUuid = preUuid;
    }

    public String getPrehash() {
        return prehash;
    }

    public void setPrehash(String prehash) {
        this.prehash = prehash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMinerUuid() {
        return minerUuid;
    }

    public void setMinerUuid(String minerUuid) {
        this.minerUuid = minerUuid;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "UnsignedBlockDO{" +
                "uuid='" + uuid + '\'' +
                ", index=" + index +
                ", createAt=" + createAt +
                ", preUuid='" + preUuid + '\'' +
                ", prehash='" + prehash + '\'' +
                ", data='" + data + '\'' +
                ", minerUuid='" + minerUuid + '\'' +
                ", nonce=" + nonce +
                '}';
    }
    public String computeHash() {
        return Hashing.sha256()
                .hashString(this.toString(), StandardCharsets.UTF_8)
                .toString();
    }
}
