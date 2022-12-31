package com.example.drdypuser.Notice;

public class NoticePdfData {

    private String pdfTitle , downloadUrl;

    public NoticePdfData() {

    }

    public NoticePdfData(String pdfTitle, String downloadUrl) {
        this.pdfTitle = pdfTitle;
        this.downloadUrl = downloadUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
