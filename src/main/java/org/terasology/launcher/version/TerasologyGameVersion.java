/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.launcher.version;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public final class TerasologyGameVersion implements Serializable {

    public static final int BUILD_VERSION_LATEST = -1;

    private static final long serialVersionUID = 2L;

    private Integer buildNumber;
    private GameJob job;
    private TerasologyGameVersionInfo gameVersionInfo;
    private File installationPath;
    private File gameJar;
    private List<String> changeLog;
    private Boolean successful;

    private boolean latest;

    public TerasologyGameVersion() {
    }

    public void copyTo(final TerasologyGameVersion gameVersion) {
        gameVersion.setBuildNumber(buildNumber);
        gameVersion.setJob(job);
        gameVersion.setGameVersionInfo(gameVersionInfo);
        gameVersion.setInstallationPath(installationPath);
        gameVersion.setGameJar(gameJar);
        gameVersion.setChangeLog(changeLog);
        gameVersion.setSuccessful(successful);
    }

    public boolean isInstalled() {
        return (installationPath != null) && (gameJar != null);
    }

    public Integer getBuildVersion() {
        if (latest) {
            return BUILD_VERSION_LATEST;
        }
        return buildNumber;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    void setBuildNumber(final Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public GameJob getJob() {
        return job;
    }

    void setJob(final GameJob job) {
        this.job = job;
    }

    public TerasologyGameVersionInfo getGameVersionInfo() {
        return gameVersionInfo;
    }

    void setGameVersionInfo(final TerasologyGameVersionInfo gameVersionInfo) {
        this.gameVersionInfo = gameVersionInfo;
    }

    public File getInstallationPath() {
        return installationPath;
    }

    void setInstallationPath(final File installationPath) {
        this.installationPath = installationPath;
    }

    public File getGameJar() {
        return gameJar;
    }

    void setGameJar(final File gameJar) {
        this.gameJar = gameJar;
    }

    public List<String> getChangeLog() {
        return changeLog;
    }

    void setChangeLog(final List<String> changeLog) {
        this.changeLog = changeLog;
    }

    public boolean isLatest() {
        return latest;
    }

    void setLatest(final boolean latest) {
        this.latest = latest;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    void setSuccessful(final Boolean successful) {
        this.successful = successful;
    }

    public String toString() {
        return this.getClass().getName() + "[" + job + ", " + buildNumber + ", latest=" + latest + ", successful=" + successful + ", installed=" + isInstalled() + "]";
    }
}
