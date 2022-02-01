package com.github.minigithub.dto;

import java.util.Date;

import com.github.minigithub.model.Commit;
import com.github.minigithub.model.User;

import lombok.Data;

@Data
public class CommitDTO {

    private Long id;
    private Date dateTime;
    private String logMessage;
    private String hash;
    private Long commiterId;
    private Long branchId;

    public CommitDTO(Commit commit) {
        this.id = commit.getId();
        this.dateTime = commit.getDateTime();
        this.logMessage = commit.getLogMessage();
        this.hash = commit.getHash();
        this.commiterId = commit.getCommiter().getId();
        this.branchId = commit.getBranch().getId();
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Long getBranchId(){
        return branchId;
    }

    public Long getCommiterId() {
        return commiterId;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public String getHash() {
        return hash;
    }

    public void setId(Long id){
        this.id = id;
    }

}