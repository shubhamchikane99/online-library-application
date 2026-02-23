package com.library.libraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.libraryapp.entity.BookCategoryReport;

@Repository
public interface BookCategoryReportRepository extends JpaRepository<BookCategoryReport, String> {

	@Query(value = " SELECT\r\n"
			+ "    UUID() AS id,\r\n"
			+ "    COUNT(DISTINCT b.id) AS book_count,\r\n"
			+ "    b.category,\r\n"
			+ "    IFNULL(assign.percentage,0) AS percentage\r\n"
			+ "FROM\r\n"
			+ "    book b LEFT JOIN(SELECT COUNT(DISTINCT ba.id) book_count, b1.category, ROUND(COUNT(ba.book_id) * 100.0 / (SELECT COUNT(*) FROM book_assign_to_user),2) AS percentage FROM  book_assign_to_user ba,  book b1 WHERE ba.book_id = b1.id\r\n"
			+ "GROUP BY b1.category) assign ON assign.category = b.category \r\n"
			+ "GROUP BY\r\n"
			+ "    b.category ", nativeQuery = true)
	List<BookCategoryReport> getCategoryReport();

}
