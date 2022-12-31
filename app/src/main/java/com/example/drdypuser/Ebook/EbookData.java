package com.example.drdypuser.Ebook;

public class EbookData {

    private String pdfTitle , downloadUrl;

    public EbookData() {

    }

    public EbookData(String pdfTitle, String downloadUrl) {
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
