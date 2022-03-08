package com.linkedbear.spring.boot.threaddemo.mainsub;

/**
 * @author heqin
 */
public class RollBack {
    private boolean needRollBack;

    public RollBack(boolean needRollBack) {
        this.needRollBack = needRollBack;
    }

    public boolean isNeedRollBack() {
        return needRollBack;
    }

    public void setNeedRollBack(boolean needRollBack) {
        this.needRollBack = needRollBack;
    }
}
