package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    /** 모든 책을 가져옴 */
    List<Book> getAllBooks();
    /** id로 1건을 조회 */
    Book getBookById(int id);
    /** 등록 */
    void insertBook(Book book);
    /** 업데이트 */
    void updateBook(Book book);
    /** 삭제 */
    void deleteBookById(int id);
}
