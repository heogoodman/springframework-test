package dbConnect;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.book.dao.mapper.BookMapper;
import myspring.book.service.BookService;
import myspring.book.vo.BookVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-bean-book.xml") // xml빈설정파일 경로지정해주기
public class DbConnectTest {

		@Autowired
		DataSource dataSource; // sql껏 임포트
		
		@Autowired
		SqlSessionFactory sqlSessionFactory; // xml 파일, xml자바 파일 sqlmapconfig까지 설정완료후 테스트
		
		@Autowired
		SqlSession sqlSession;
		
		@Autowired
		BookMapper bookMapper; 
		
		@Autowired
		BookService bookService;
		
		@Test
		public void dataSourceTest() {
			System.out.println(dataSource.getClass().getName());
		}
		
		@Test
		public void sqlSessionFactoryTest() {
			System.out.println(sqlSessionFactory.getClass().getName());
			System.out.println(sqlSessionFactory.getConfiguration());
		}
		
		//customer book으로 잘바꿔주기 myspring.book 이부분
		
		@Test
		public void sqlSessionTest() {
			System.out.println(sqlSession.getClass().getName());
			sqlSession.selectList("myspring.book.dao.mapper.BookMapper.selectAllBook");
		}
		
		@Test
		public void bookMapperTest() {
			List<BookVO> list = bookMapper.selectAllBook();
			System.out.println("bookMapperTest : " + list); //콘솔창이랑 제이유닛 푸른색확인
		}
		
		@Test
		public void bookServiceTest() {
			List<BookVO> list = bookService.getAllBookList();
			System.out.println("bookServiceTest : " + list);
		}
		
		
		
}
