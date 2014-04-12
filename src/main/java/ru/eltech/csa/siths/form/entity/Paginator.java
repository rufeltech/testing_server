package ru.eltech.csa.siths.form.entity;

public class Paginator {

	public static enum Type {
        PAGES_TOTAL_IS_LESSER_THAN_PAGES_TO_DISPLAY("PAGES_TOTAL_IS_LESSER_THAN_PAGES_TO_DISPLAY"),
        CURRENT_PAGE_IS_NOT_IN_BORDER_RANGE("CURRENT_PAGE_IS_NOT_IN_BORDER_RANGE"),
        CURRENT_PAGE_IS_IN_LEFT_BORDER_RANGE("CURRENT_PAGE_IS_IN_LEFT_BORDER_RANGE"),
        CURRENT_PAGE_IS_IN_RIGHT_BORDER_RANGE("CURRENT_PAGE_IS_IN_RIGHT_BORDER_RANGE");

        protected String value;

        Type(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }
    }

    protected byte resultsPerPage;
    protected long fromPageNumber;
    protected long toPageNumber;
    protected long currentPageNumber;
    protected Type paginatorType;

    public Paginator(byte resultsPerPage, long fromPageNumber, long toPageNumber, long currentPageNumber, Type paginatorType) {
        this.resultsPerPage = resultsPerPage;
        this.fromPageNumber = fromPageNumber;
        this.toPageNumber = toPageNumber;
        this.currentPageNumber = currentPageNumber;
        this.paginatorType = paginatorType;
    }

    public Paginator(long fromPageNumber, long toPageNumber, long currentPageNumber, Type paginatorType) {
        this( (byte)10, fromPageNumber, toPageNumber, currentPageNumber, paginatorType );
    }

    public byte getResultsPerPage() {
        return this.resultsPerPage;
    }

    public void setResultsPerPage(byte resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public long getFromPageNumber() {
        return this.fromPageNumber;
    }

    public void setFromPageNumber(long fromPageNumber) {
        this.fromPageNumber = fromPageNumber;
    }

    public long getToPageNumber() {
        return this.toPageNumber;
    }

    public void setToPageNumber(long toPageNumber) {
        this.toPageNumber = toPageNumber;
    }

    public long getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public void setCurrentPageNumber(long currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public Type getPaginatorType() {
        return this.paginatorType;
    }

    public void setPaginatorType(Type paginatorType) {
        this.paginatorType = paginatorType;
    }

}