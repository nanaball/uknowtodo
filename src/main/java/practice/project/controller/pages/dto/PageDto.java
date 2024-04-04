package practice.project.controller.pages.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PageDto<T> {
    private int page;
    private int totalElements;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean hasBefore;
    private boolean hasNext;

    private List<T> content;

    private int pageSize;

    public static <T> PageDto<T> of(List<T> content, int page, long totalElements, int pageSize) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.content = content;
        pageDto.page = page;
        pageDto.pageSize = pageSize;
        pageDto.totalElements = (int) totalElements;
        pageDto.totalPages = (int) Math.ceil((double) totalElements / pageSize);
        pageDto.startPage = Math.floorDiv(page - 1, 5) * 5 + 1;
        pageDto.endPage = Math.min(pageDto.startPage + 4, pageDto.totalPages);
        pageDto.hasBefore = pageDto.startPage > 1;
        pageDto.hasNext = pageDto.totalPages > pageDto.endPage;
        return pageDto;
    }
}
