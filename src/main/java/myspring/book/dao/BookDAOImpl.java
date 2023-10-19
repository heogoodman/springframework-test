package myspring.book.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.book.dao.mapper.BookMapper;
import myspring.book.vo.BookVO;

@Repository("bookDAO") // 서비스에서 인젝션을 받기위한 이름 명칭
public class BookDAOImpl implements BookDAO{
		@Autowired
		BookMapper bookMapper;

		@Override
		public List<BookVO> selectAllBook() {
			return bookMapper.selectAllBook();
		}

		@Override
		public BookVO selectBook(int id) {
			return bookMapper.selectBook(id);
		}
		
		
}
