package fitness.service;  // 현재클래스가 패키지안에 포함되어있는지 정보

import java.util.ArrayList;
import java.util.List;

import fitness.vo.Fitness; // 사용하려는 클래스가 다른 패키지에 있을 때 

public class FitnessServiceImpl implements FitnessService{
	List<Fitness> list = new ArrayList<>();

	/**
	 * 전달받은 회원을 리스트에 저장
	 * @param fitness
	 * @return 등록 성공시 true, 아니면 false 반환
	 */
	public boolean insert(Fitness fitness) {
		return list.add(fitness);    // add -> boolean 반환 / 바로 return에 삽입
	}
	
	/**
	 * 전달받은 id값에 해당 하는 회원이 있는지 찾아서 반환
	 * @param id
	 * @return 찾으면 회원정보, 못찾으면 null을 반환
	 */
	public Fitness selectOne(int id) {
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getId() == id)    // list.get(i) - i번째 정보 전부 가져옴  -> .getId() - 그 중에서 id 정보 비교
				return list.get(i);
		}
		return null;
	}
	
	/**
	 * 전달받은 회원정보(fitness)에서 id에 해당하는 회원을 검색해서
	 * weight, height를 수정
	 * @param fitness
	 * @return 수정이 완료되면 true, 회원id가 없어서 수정을 못한경우 false
	 */
	public boolean update(Fitness fitness) {
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getId() == fitness.getId()) {
				list.get(i).setWeight(fitness.getWeight());    // .setWeight(수정하고자 하는 회원의 정보 꺼내서) 설정
				list.get(i).setHeight(fitness.getHeight());
				return true;
			}
		}

		return false;
	}
	
	/**
	 * 전달받은 id에 해당하는 회원의 정보를 찾아서 배열 내에서 삭제
	 * @param id
	 * @return 삭제가 완료되면 true, 회원id가 없어서 삭제를 못한 경우 false
	 */
	public boolean delete(int id) {
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getId() == id) {  // 탈퇴하려는 회원정보를 찾음
				list.remove(i);   // i번째의 것을 삭제 
				return true;
			}
		}
		return false;
	}

	/**
	 * 모든 회원의 정보를 반환
	 * @return
	 */
	public List<Fitness> selectAll() {
		return list;
	}
	
	/**
	 * 총 회원수를 반환
	 * @return
	 */
	public int getCount() {
		return list.size();
	}
}