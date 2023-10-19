package myspring.book.service;

import java.util.List;

import myspring.book.vo.BookVO;

public interface BookService {
	
	List<BookVO> getAllBookList();
	
	BookVO getBookInfo(int id);

}
