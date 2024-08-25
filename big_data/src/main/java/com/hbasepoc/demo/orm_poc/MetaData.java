package com.hbasepoc.demo.orm_poc;
import java.lang.reflect.Field;

public class MetaData {
    String assetType;
    long assetId;
    String walletAddress;
    Boolean isApproved;
    long assetInUsd;

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public void setAssetInUsd(long assetInUsd) {
        this.assetInUsd = assetInUsd;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getAssetType() {
        return assetType;
    }

    public long getAssetId() {
        return assetId;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public long getAssetInUsd() {
        return assetInUsd;
    }

    public String getWalletAddress() {
        return walletAddress;
    }
}
