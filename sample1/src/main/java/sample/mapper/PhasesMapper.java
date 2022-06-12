package sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sample.model.Phases;

@Mapper
public interface PhasesMapper {
	
	//　総件数
	Long count();
	
	//　一覧
	List<Phases> selectAll();
	
	//一件
	Phases selectByPrimaryKey(Long id);
	
	// 新規
	int insert(Phases record);
	
	// 更新
	int updateByPrimaryKey(Phases record);
	
	// 削除
	int deleteByPrimaryKey(Long id);

	

}
