package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    /** 도서 ID */
    private int id;
    /** 제목 */
    private String title;
    /** 저자 */
    private String author;
    /** 책과 출판사의 일대일 관계 */
    private Publisher publisher;
    /** 책과 리뷰의 일대다 관계 */
    private List<Review> reviews;
}
