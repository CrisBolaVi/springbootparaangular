package es.curso.springboot1.repositories;

import java.util.List;

public class PageResponse <T> { private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public PageResponse(List<T> content, int page, int size, long totalElements) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }
    
    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }
}


