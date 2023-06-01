package com.finsurge.task46.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private Set<String> emailTo;
    private Set<String> emailCc;
    private Set<String> emailBcc;

    public Set<String> getEmailCc() {
        return emailCc;
    }

    public void setEmailCc(Set<String> emailCc) {
        this.emailCc = emailCc;
    }

    public Set<String> getEmailBcc() {
        return emailBcc;
    }

    public void setEmailBcc(Set<String> emailBcc) {
        this.emailBcc = emailBcc;
    }

    private String emailSub;
    private String emailmsg;
    public Set<String> getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(Set<String> emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailSub() {
        return emailSub;
    }

    public void setEmailSub(String emailSub) {
        this.emailSub = emailSub;
    }

    public String getEmailmsg() {
        return emailmsg;
    }

    public void setEmailmsg(String emailmsg) {
        this.emailmsg = emailmsg;
    }
}
