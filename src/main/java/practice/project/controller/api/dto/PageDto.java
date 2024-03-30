package practice.project.controller.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PageDto<T> {
    private int page;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean hasBefore;
    private boolean hasNext;

    private List<T> content;


    public static <T> PageDto<T> of(List<T> content, int page, int totalPages) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.content = content;
        pageDto.page = page;
        pageDto.totalPages = totalPages;
        pageDto.startPage = Math.floorDiv(page - 1, 5) * 5 + 1;
        pageDto.endPage = Math.min(pageDto.startPage + 4, totalPages);
        pageDto.hasBefore = pageDto.startPage > 1;
        pageDto.hasNext = totalPages > pageDto.endPage;
        return pageDto;
    }
}
