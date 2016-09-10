package com.lody.virtual.service.am;

import android.content.ComponentName;
import android.content.Intent;

import com.lody.virtual.helper.proto.AppTaskInfo;

import java.util.ArrayList;

/**
 * @author Lody
 */

class TaskRecord {
    public int taskId;
    public int userId;
    public String affinity;
    public Intent taskRoot;
    public final ArrayList<ActivityRecord> activities = new ArrayList<>();

    TaskRecord(int taskId, int userId, String affinity, Intent intent) {
        this.taskId = taskId;
        this.userId = userId;
        this.affinity = affinity;
        this.taskRoot = intent;
    }

    AppTaskInfo getAppTaskInfo() {
        int len = activities.size();
        ComponentName top = len > 0 ? activities.get(len - 1).component : null;
        return new AppTaskInfo(taskId, taskRoot.getComponent(), top);
    }
}