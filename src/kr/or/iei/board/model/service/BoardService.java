package kr.or.iei.board.model.service;

import java.util.HashMap;

import kr.or.iei.board.model.vo.Board;

public interface BoardService {

		/**
		 * @Author : jieun Kim
		 * @Date : 2021-12-23
		 * @subscription : 회원 공지사항 및 FAQ 게시글을 모두 가져오는 메소드
		 */
	HashMap<String, Object> memberNotice(int currentPage);

		/**
		 * @Author : jieun Kim
		 * @Date : 2021-12-25
		 * @subscription : 업체 공지사항 및 FAQ 게시글을 모두 가져오는 메소드
		 */
	HashMap<String, Object> companyNotice(int currentPage);

		/**
		 * @Author : jieun Kim
		 * @Date : 2021-12-27
		 * @subscription : 게시물 content를 보여주는 메소드
		 */
	Board boardView(int currentPage);

		/**
		 * @Author : jieun Kim
		 * @Date : 2021-12-27
		 * @subscription : 게시물을 키워드별 검색할 때 사용 하는 메소드
		 */
	HashMap<String, Object> selectSearchPost(int currentPage, String keyword, String type);

}
