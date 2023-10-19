package myspring.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.book.dao.BookDAO;
import myspring.book.vo.BookVO;

@Service("bookService")  // 컨트롤러에서 인젝션주입 받기위한 이름 명칭
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookDAO; // 다오임플에서 어노테이션레파지토리 명칭정한걸 지금사용 지금까지 히카리CP부터 의존성받은 한뭉터기를 다시받는다

	@Override
	public List<BookVO> getAllBookList() {
		return bookDAO.selectAllBook();
	}

	@Override
	public BookVO getBookInfo(int id) {
		return bookDAO.selectBook(id);
	}

	
	
	

}
