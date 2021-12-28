package kr.or.iei.review.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.contract.model.vo.Contract;
import kr.or.iei.review.model.vo.Review;

public interface ReviewService {

	/**
	 * @param currentPage 
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 27
	 * @return : HashMap<String, Object>
	 * @subscription : 업체에게 문의 요청한 이용 내역
	 */
	HashMap<String, Object> inqueryhistory(String userId, int currentPage);

	/**
	 * @param currentPage 
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 27
	 * @return : HashMap<String, Object>
	 * @subscription : 작성해야 할 리뷰 리스트
	 */
	HashMap<String, Object> review(String userId, int currentPage);
	
	/**
	 * @param currentPage 
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 27
	 * @return : HashMap<String, Object>
	 * @subscription : 작성된 리뷰 리스트 
	 */
	HashMap<String, Object> reviewWriteList(String userId, int currentPage);

	int insertReviewWrite(Review r);

	Review selectOneReview(int contractNo);

	int searchReviewNo(Review r);
	
	/**
	 * @param currentPage 
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 28
	 * @return : int
	 * @subscription : 리뷰 작성완료 누르면 clean_YN='Y' 로 바꾸기 
	 */
	int updateCleanYN(int contractNo, String userId);
	
	/**
	 * @param currentPage 
	 * @Author : Hyuna 
	 * @Date : 2021. 12. 28
	 * @return : int
	 * @subscription : 리뷰 수정
	 */
	int reviewContentUpdate(String content, int reviewNo);

	int reviewDelete(int reviewNo, String userId);


	HashMap<String, Object> ReviewAllList(String coId, int currentPage);

}
